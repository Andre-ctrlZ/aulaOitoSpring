package com.example.aulaOitoSpring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Insira um email valido!")
    private String email;

    @NotBlank(message = "A senha é obrigatória!")
    @Size(min = 3, message = "A senha precisa conter no mínimo 3 caracteres.")
    private String senha;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O email é obrigatório") @Email(message = "Insira um email valido!") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O email é obrigatório") @Email(message = "Insira um email valido!") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A senha é obrigatória!") @Size(min = 3, message = "A senha precisa conter no mínimo 3 caracteres.") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é obrigatória!") @Size(min = 3, message = "A senha precisa conter no mínimo 3 caracteres.") String senha) {
        this.senha = senha;
    }

}
