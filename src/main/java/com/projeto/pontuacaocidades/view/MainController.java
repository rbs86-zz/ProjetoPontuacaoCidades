package com.projeto.pontuacaocidades.view;

import com.projeto.pontuacaocidades.business.CityService;
import com.projeto.pontuacaocidades.remote.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

@RestController
@RequestMapping("ws")
public class MainController {

    @Autowired
    private CityService cityService;

    @GetMapping("buscaCidade")
    public List<Cidade> buscaCidadesPorNome(@RequestParam(value = "nomeCidade", required = true) String nomeCidade,
                                            @RequestParam(value = "nomeEstado", required = false) String nomeEstado)
            throws RemoteException, MalformedURLException {
        return this.cityService.buscaCidadesPorNome(nomeCidade, nomeEstado);
    }

    @PostMapping("buscaPontos")
    public Integer buscaCidadesPorPontos(String nome, String estado) throws RemoteException, MalformedURLException {
        return this.cityService.buscaPontos(nome, estado);
    }
}
