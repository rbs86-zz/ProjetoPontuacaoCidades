package com.projeto.pontuacaocidades.business;

import com.projeto.pontuacaocidades.dao.CityDAO;
import com.projeto.pontuacaocidades.remote.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;

    @Override
    public List<Cidade> buscaCidadesPorNome(String nomeCidade, String nomeEstado) throws RemoteException,
            MalformedURLException {
        Cidade[] cidades = cityDAO.buscaCidadesPorNome();

        String estado = nomeEstado == null ? "" : nomeEstado;
        Predicate<Cidade> predicate = c -> c.getNome().toUpperCase().contains(nomeCidade.toUpperCase())
                && c.getEstado().toUpperCase().contains(estado.toUpperCase());
        return Arrays.stream(cidades).filter(predicate).collect(Collectors.toList());
    }

    @Override
    public Integer buscaPontos(String nomeCidade, String nomeEstado) throws MalformedURLException, RemoteException {
        return cityDAO.buscaPontos(new Cidade(nomeEstado, nomeCidade));
    }
}
