package com.example.LojaGames.service;

import com.example.LojaGames.model.Jogo;
import com.example.LojaGames.repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    private final JogoRepository repository;

    public JogoService(JogoRepository repository){
        this.repository = repository;
    }
    public Jogo salvar(Jogo jogo){
        return repository.save(jogo);
    }
    public void deletar(Long id){
        repository.deleteById(id);
    }
    public List<Jogo> listar(){
        return repository.findAll();
    }
    public Jogo atulizar(Long id, Jogo jogo){
        buscarPorId(id);
        jogo.setId(id);
        return repository.save(jogo);
    }
    public Jogo buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException(" Jogo n encontrado"));
    }
    public List<Jogo> buscarPorNome(String nome){
        return repository.findByNomeContainingIgnoreCase(nome);
    }
}
