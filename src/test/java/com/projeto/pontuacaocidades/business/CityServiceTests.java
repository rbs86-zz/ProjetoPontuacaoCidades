package com.projeto.pontuacaocidades.business;

import static org.junit.Assert.*;

import com.projeto.pontuacaocidades.business.core.CityServiceImpl;
import com.projeto.pontuacaocidades.remote.*;
import org.apache.axis.AxisFault;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTests {

    @InjectMocks
    private CityService cityService = new CityServiceImpl();

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void buscaTodasCidadesComNomeExatoTest() throws RemoteException, MalformedURLException {
        String nomeCidade = "Barueri";
        List<Cidade> cidadeList = this.cityService.buscaCidadesPorNome(nomeCidade);
        assertEquals(1, cidadeList.size());
        assertEquals("Barueri", cidadeList.get(0).getNome());
    }

    @Test
    public void buscaTodasCidadesComNomeExatoMinusculoTest() throws RemoteException, MalformedURLException {
        String nomeCidade = "barueri";
        List<Cidade> cidadeList = this.cityService.buscaCidadesPorNome(nomeCidade);
        assertEquals(1, cidadeList.size());
        assertEquals("Barueri", cidadeList.get(0).getNome());
    }

    @Test
    public void buscaTodasCidadesNomeParcialTest() throws RemoteException, MalformedURLException {
        String nomeCidade = "Bar";
        List<Cidade> cidadeList = this.cityService.buscaCidadesPorNome(nomeCidade);
        assertEquals(249, cidadeList.size());
        cidadeList.forEach(c -> c.getNome().toUpperCase().contains(nomeCidade.toUpperCase()));
    }
    
    @Test
    public void buscaTodasCidadesSemResultadosTest() throws RemoteException, MalformedURLException {
    	String nomeCidade = "zzzzzzz";
    	List<Cidade> cidadeList = this.cityService.buscaCidadesPorNome(nomeCidade);
    	assertTrue(cidadeList.isEmpty());
    }
    
    @Test
    public void verPontuacaoTest() throws RemoteException, MalformedURLException {
    	String nomeCidade = "Barueri";
    	String nomeEstado = "São Paulo";
    	Cidade cidade = new Cidade(nomeEstado, nomeCidade);
    	Integer quantidadePontos = this.cityService.buscaPontos(cidade);
    	assertEquals(Integer.valueOf(500000), quantidadePontos);
    }
}
