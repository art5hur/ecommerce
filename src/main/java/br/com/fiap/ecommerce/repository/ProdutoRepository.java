package br.com.fiap.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.ecommerce.model.Produto;

@Repository
public interface ProdutoRepository 
	extends JpaRepository<Produto, Long> {
}
