package com.example.LojaGames.controller;

import com.example.LojaGames.model.Jogo;
import com.example.LojaGames.service.JogoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/LojaGames")
public class JogoController {
    private JogoService service;

    public JogoController(JogoService service){
        this.service = service;
    }
    @GetMapping
    public List<Jogo> listar(){
        return service.listar();
    }
    @PostMapping
    public Jogo salvar(@RequestBody @Valid Jogo jogo){
        return service.salvar(jogo);
    }
    @GetMapping("/{id}")
    public Jogo buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Jogo atulizar(@PathVariable Long id,@RequestBody @Valid Jogo jogo){
        return service.atulizar(id, jogo);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
    @GetMapping("/buscar")
    public List<Jogo> buscarPorNome(@RequestParam String nome){
        return service.buscarPorNome(nome);
    }
}
