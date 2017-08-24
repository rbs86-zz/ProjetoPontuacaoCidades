package com.projeto.pontuacaocidades.dao;

import com.projeto.pontuacaocidades.remote.*;
import org.apache.axis.AxisFault;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

@Component
public class CityDAOImpl implements CityDAO {

    private static final String URL = "http://wsteste.devedp.com.br/Master/CidadeServico.svc";

    @Override
    public Cidade[] buscaCidadesPorNome() throws RemoteException,
            MalformedURLException {
        ICidadeServico cidadeServico = getCidadeServico();
        return cidadeServico.buscaTodasCidades();
    }

    @Override
    public Integer buscaPontos(Cidade cidade) throws MalformedURLException, RemoteException {
        ICidadeServico cidadeServico = getCidadeServico();
        return cidadeServico.buscaPontos(cidade);
    }

    private ICidadeServico getCidadeServico() throws MalformedURLException, AxisFault {
        URL url = new URL(URL);
        CidadeServico cs = new CidadeServicoLocator();
        return new WsTesteWebServiceCidadeServico_basicHttpBindingStub(url, cs);
    }
}
