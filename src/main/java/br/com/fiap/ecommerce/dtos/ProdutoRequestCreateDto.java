package br.com.fiap.ecommerce.dtos;

import org.springframework.web.bind.annotation.PostMapping;

public class ProdutoRequestCreateDto {
    private String nome;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
