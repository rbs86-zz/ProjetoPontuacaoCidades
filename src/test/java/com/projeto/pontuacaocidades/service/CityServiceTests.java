package com.projeto.pontuacaocidades.service;

import com.projeto.pontuacaocidades.business.CityService;
import com.projeto.pontuacaocidades.dao.CityDAO;
import com.projeto.pontuacaocidades.remote.Cidade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTests {

    @Autowired
    @InjectMocks
    private CityService cityService;

    @Mock
    private CityDAO cityDAO;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void buscaTodasCidadesComNomeExatoTest() throws RemoteException, MalformedURLException {
        String nomeCidade = "Barueri";
        Cidade[] cidades = {new Cidade("São Paulo", "Barueri"), new Cidade("São Paulo", "Campinas")};

        Mockito.when(this.cityDAO.buscaCidadesPorNome()).thenReturn(cidades);
        List<Cidade> cidadeList = this.cityService.buscaCidadesPorNome(nomeCidade, null);

        assertEquals(1, cidadeList.size());
        assertEquals("Barueri", cidadeList.get(0).getNome());
    }

    @Test
    public void buscaTodasCidadesComNomeEEstadoTest() throws RemoteException, MalformedURLException {
        String nomeCidade = "Barueri";
        String nomeEstado = "São Paulo";
        Cidade[] cidades = {new Cidade("São Paulo", "Barueri"), new Cidade("São Paulo", "Campinas")};

        Mockito.when(this.cityDAO.buscaCidadesPorNome()).thenReturn(cidades);
        List<Cidade> cidadeList = this.cityService.buscaCidadesPorNome(nomeCidade, null);
        assertEquals(1, cidadeList.size());
        assertEquals("Barueri", cidadeList.get(0).getNome());
    }

    @Test
    public void buscaTodasCidadesComNomeEEstadoErradoTest() throws RemoteException, MalformedURLException {
        String nomeCidade = "Barueri";
        String nomeEstado = "Minas Gerais";

        Cidade[] cidades = {new Cidade("São Paulo", "Barueri"), new Cidade("São Paulo", "Campinas")};
        Mockito.when(this.cityDAO.buscaCidadesPorNome()).thenReturn(cidades);
        List<Cidade> cidadeList = this.cityService.buscaCidadesPorNome(nomeCidade, nomeEstado);
        assertEquals(0, cidadeList.size());
    }

    @Test
    public void buscaTodasCidadesComNomeExatoMinusculoTest() throws RemoteException, MalformedURLException {
        String nomeCidade = "barueri";
        Cidade[] cidades = {new Cidade("São Paulo", "Barueri"), new Cidade("São Paulo", "Campinas")};

        Mockito.when(this.cityDAO.buscaCidadesPorNome()).thenReturn(cidades);
        List<Cidade> cidadeList = this.cityService.buscaCidadesPorNome(nomeCidade, null);
        assertEquals(1, cidadeList.size());
        assertEquals("Barueri", cidadeList.get(0).getNome());
    }

    @Test
    public void buscaTodasCidadesNomeParcialTest() throws RemoteException, MalformedURLException {
        String nomeCidade = "Bar";
        Cidade[] cidades = {new Cidade("São Paulo", "Barueri"), new Cidade("Minas Gerais", "Barreiro"), new
                Cidade("São Paulo", "Campinas")};

        Mockito.when(this.cityDAO.buscaCidadesPorNome()).thenReturn(cidades);
        List<Cidade> cidadeList = this.cityService.buscaCidadesPorNome(nomeCidade, null);
        assertEquals(2, cidadeList.size());
        cidadeList.forEach(c -> c.getNome().toUpperCase().contains(nomeCidade.toUpperCase()));
    }

    @Test
    public void buscaTodasCidadesSemResultadosTest() throws RemoteException, MalformedURLException {
        String nomeCidade = "zzzzzzz";
        Cidade[] cidades = {new Cidade("São Paulo", "Barueri"), new Cidade("São Paulo", "Campinas")};

        Mockito.when(this.cityDAO.buscaCidadesPorNome()).thenReturn(cidades);
        List<Cidade> cidadeList = this.cityService.buscaCidadesPorNome(nomeCidade, null);
        assertTrue(cidadeList.isEmpty());
    }

    @Test
    public void verPontuacaoTest() throws RemoteException, MalformedURLException {
        String nomeCidade = "Barueri";
        String nomeEstado = "São Paulo";

        ArgumentCaptor<Cidade> captor = ArgumentCaptor.forClass(Cidade.class);
        Mockito.when(this.cityDAO.buscaPontos(captor.capture())).thenReturn(50000);

        this.cityService.buscaPontos(nomeCidade, nomeEstado);
        assertEquals(nomeCidade, captor.getValue().getNome());
        assertEquals(nomeEstado, captor.getValue().getEstado());
    }
}
