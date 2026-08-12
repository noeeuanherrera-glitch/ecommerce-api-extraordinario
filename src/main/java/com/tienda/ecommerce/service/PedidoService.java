package com.tienda.ecommerce.service;

import com.tienda.ecommerce.entity.Pedido;
import com.tienda.ecommerce.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository repository;

    public List<Pedido> findAll() { return repository.findAll(); }
    public Optional<Pedido> findById(Integer id) { return repository.findById(id); }

    public Pedido save(Pedido entity) {
        if (entity.getArticulos() != null) {
            entity.getArticulos().forEach(a -> a.setPedido(entity));
        }
        return repository.save(entity);
    }

    public boolean deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}