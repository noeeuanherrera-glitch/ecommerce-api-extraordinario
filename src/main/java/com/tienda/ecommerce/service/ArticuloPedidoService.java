package com.tienda.ecommerce.service;
import com.tienda.ecommerce.entity.ArticuloPedido;
import com.tienda.ecommerce.repository.ArticuloPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticuloPedidoService {
    private final ArticuloPedidoRepository repository;

    public List<ArticuloPedido> findAll() { return repository.findAll(); }

    public ArticuloPedido save(ArticuloPedido entity) {
        return repository.save(entity);
    }
}