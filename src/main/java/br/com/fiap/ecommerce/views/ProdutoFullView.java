package br.com.fiap.ecommerce.views;


import org.springframework.beans.factory.annotation.Value;


public interface ProdutoFullView {
    String getNome();
    Long getId();
    
    @Value("#{target.id + '/' + target.nome}")
    String getDescricao();

    
}
