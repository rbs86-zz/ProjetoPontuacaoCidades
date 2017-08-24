package com.projeto.pontuacaocidades;

import com.projeto.pontuacaocidades.remote.*;
import org.apache.axis.AxisFault;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PontuacaocidadesApplicationTests {

    private static final String URL = "http://wsteste.devedp.com.br/Master/CidadeServico.svc";

    private ICidadeServico servico;

    @Before
    public void init() throws MalformedURLException, AxisFault {
        URL url = new URL(URL);
        CidadeServico cs = new CidadeServicoLocator();
        this.servico = new WsTesteWebServiceCidadeServico_basicHttpBindingStub(url, cs);
    }

    @Test
    public void buscaTodasCidadesComNomeExatoTest() throws RemoteException {
        Cidade[] cidades = this.servico.buscaTodasCidades();
    }
}
