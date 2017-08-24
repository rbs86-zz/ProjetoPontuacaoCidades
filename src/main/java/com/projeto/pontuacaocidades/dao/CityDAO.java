package com.projeto.pontuacaocidades.dao;

import com.projeto.pontuacaocidades.remote.Cidade;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public interface CityDAO {
    public Cidade[] buscaCidadesPorNome() throws RemoteException, MalformedURLException;

    public Integer buscaPontos(Cidade cidade) throws MalformedURLException, RemoteException;
}
