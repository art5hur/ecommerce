package br.com.fiap.ecommerce.service;

import br.com.fiap.ecommerce.model.ItemPedido;
import br.com.fiap.ecommerce.model.Pedido;
import br.com.fiap.ecommerce.repository.ItemPedidoRepository;
import br.com.fiap.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {
    
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> list() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido save(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public boolean existsById(Long id) {        
        return itemPedidoRepository.existsById(id);
    }

    public void delete(Long id) {
        itemPedidoRepository.deleteById(id);
    }

    public Optional<ItemPedido> findById(Long id) {
        return itemPedidoRepository.findById(id);
    }

   
}
