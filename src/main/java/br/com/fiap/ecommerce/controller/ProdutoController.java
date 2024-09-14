package br.com.fiap.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.dtos.ProdutoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ProdutoResponseDto;
import br.com.fiap.ecommerce.model.Produto;
import br.com.fiap.ecommerce.service.ProdutoService;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired //Injestão de independência
    private ProdutoService produtoService;
    
    @GetMapping
    public List<ProdutoResponseDto> list (){
        
        List<Produto> produtos = produtoService.list();
        return null;
    }

   @PostMapping
    public ProdutoResponseDto create (ProdutoRequestCreateDto dto) {
        return null;
    }

}
