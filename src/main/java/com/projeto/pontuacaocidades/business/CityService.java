package com.projeto.pontuacaocidades.business;

import com.projeto.pontuacaocidades.remote.Cidade;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

public interface CityService {
    public List<Cidade> buscaCidadesPorNome(String nomeCidade, String nomeEstado) throws RemoteException,
            MalformedURLException;
    public Integer buscaPontos(String nomeCidade, String nomeEstado) throws MalformedURLException, RemoteException;
}
