package com.tienda.ecommerce.service;
import com.tienda.ecommerce.entity.Pedido;
import com.tienda.ecommerce.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository repository;

    public List<Pedido> findAll() { return repository.findAll(); }

    public Pedido save(Pedido entity) {
        if(entity instanceof com.tienda.ecommerce.entity.Pedido) {
            com.tienda.ecommerce.entity.Pedido p = (com.tienda.ecommerce.entity.Pedido) entity;
            if(p.getArticulos() != null) {
                p.getArticulos().forEach(a -> a.setPedido(p));
            }
        }
        return repository.save(entity);
    }
}