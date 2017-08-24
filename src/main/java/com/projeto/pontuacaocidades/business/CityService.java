package com.projeto.pontuacaocidades.business;

import com.projeto.pontuacaocidades.remote.Cidade;
import org.apache.axis.AxisFault;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

public interface CityService {

    List<Cidade> buscaCidadesPorNome(String nomeCidade) throws RemoteException, MalformedURLException;
}
