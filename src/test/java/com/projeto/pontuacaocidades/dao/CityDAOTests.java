package com.projeto.pontuacaocidades.dao;

import com.projeto.pontuacaocidades.remote.Cidade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityDAOTests {

    private CityDAO cityDAO = new CityDAOImpl();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void buscaTodasCidadesComNomeExatoTest() throws RemoteException, MalformedURLException {
        String nomeCidade = "Barueri";
        Cidade[] cidadeList = this.cityDAO.buscaCidadesPorNome();
        assertEquals(9714, cidadeList.length);
    }

    @Test
    public void verPontuacaoTest() throws RemoteException, MalformedURLException {
        String nomeCidade = "Barueri";
        String nomeEstado = "São Paulo";
        Cidade cidade = new Cidade(nomeEstado, nomeCidade);
        Integer quantidadePontos = this.cityDAO.buscaPontos(cidade);
        assertEquals(Integer.valueOf(500000), quantidadePontos);
    }
}
