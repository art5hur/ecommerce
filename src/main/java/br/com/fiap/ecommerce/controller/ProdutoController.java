package br.com.fiap.ecommerce.controller;


import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.dtos.ProdutoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ProdutoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.ProdutoResponseDto;
import br.com.fiap.ecommerce.model.Produto;
import br.com.fiap.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoResponseDto> list() {
        List<ProdutoResponseDto> dtos = produtoService.list()
            .stream()
            .map(e -> new ProdutoResponseDto().toDto(e))
            .toList();
        
        return dtos;
     
    }

    @PostMapping
    public ProdutoResponseDto create(@RequestBody ProdutoRequestCreateDto dto) {
        Produto produto = dto.toModel();
        Produto saved = produtoService.save(produto);
        return new ProdutoResponseDto().toDto(saved);
    }

    @PutMapping("{id}")
    public ProdutoResponseDto update(
                        @PathVariable Long id, 
                        @RequestBody ProdutoRequestUpdateDto dto) {
        if (! produtoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        return new ProdutoResponseDto().toDto(
            produtoService.save(dto.toModel(id))
        );        
    
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! produtoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        produtoService.delete(id);
    }

    @GetMapping("{id}")
    public ProdutoResponseDto findById(@PathVariable Long id) {
        
        return produtoService
        .findById(id)
        .map(e -> new ProdutoResponseDto().toDto(e))
        .orElseThrow(() -> new RuntimeException("Id inexistente"));
    }

}
