package com.tienda.ecommerce.service;

import com.tienda.ecommerce.entity.ArticuloPedido;
import com.tienda.ecommerce.repository.ArticuloPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticuloPedidoService {
    private final ArticuloPedidoRepository repository;

    public List<ArticuloPedido> findAll() { return repository.findAll(); }
    public Optional<ArticuloPedido> findById(Integer id) { return repository.findById(id); }
    public ArticuloPedido save(ArticuloPedido entity) { return repository.save(entity); }

    public boolean deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}