package br.com.fiap.ecommerce.dtos;

import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.model.Produto;

public class ProdutoRequestCreateDto {
    private String nome;

    private static final ModelMapper modelMapper = new ModelMapper();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto toModel(){
        
        return modelMapper.map(this, Produto.class);
           
    }
    
}
