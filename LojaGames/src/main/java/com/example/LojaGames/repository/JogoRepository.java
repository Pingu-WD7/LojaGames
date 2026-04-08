package com.example.LojaGames.repository;

import com.example.LojaGames.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository <Jogo, Long> {
    List<Jogo>findBynomeContainingIgnoreCase(String nome);
}
