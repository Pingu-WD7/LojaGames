package com.example.LojaGames.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "E necessario um nome!")
    private String nome;


    @NotNull(message = "O valor n pode ser nulo")
    @Positive(message = "O valor deve ser positivo")
    private Double preco;

    @NotBlank
    private String categoria;

    @NotNull
    @Column (unique = true)
    private int codigoAtivacao;

    public Jogo(){}
}
