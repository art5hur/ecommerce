package br.com.fiap.ecommerce.views;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;


public interface ProdutoFullView {
    String getNome();
    Long getId();
    
    @Value("#{target.id + '/' + target.nome}")
    String getDescricao();

    BigDecimal getValor();

    @Value("#{target.valor * 1.15}")
    String getResultado();
    
}
