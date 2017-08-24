package com.projeto.pontuacaocidades.business.core;

import com.projeto.pontuacaocidades.business.CityService;
import com.projeto.pontuacaocidades.remote.*;

import org.apache.axis.AxisFault;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private static final String URL = "http://wsteste.devedp.com.br/Master/CidadeServico.svc";

    @Override
    public List<Cidade> buscaCidadesPorNome(String nomeCidade) throws RemoteException, MalformedURLException {
        URL url = new URL(URL);
        CidadeServico cs = new CidadeServicoLocator();
        ICidadeServico cidadeServico = new WsTesteWebServiceCidadeServico_basicHttpBindingStub(url, cs);
        Cidade[] cidades = cidadeServico.buscaTodasCidades();
        return Arrays.stream(cidades).filter(c -> c.getNome().toUpperCase().contains(nomeCidade.toUpperCase())).collect(Collectors.toList());
    }

	@Override
	public Integer buscaPontos(Cidade cidade) throws MalformedURLException, RemoteException {
		URL url = new URL(URL);
		CidadeServico cs = new CidadeServicoLocator();
		ICidadeServico cidadeServico = new WsTesteWebServiceCidadeServico_basicHttpBindingStub(url, cs);
		return cidadeServico.buscaPontos(cidade);
	}
}
