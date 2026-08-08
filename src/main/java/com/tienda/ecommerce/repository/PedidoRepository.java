package com.tienda.ecommerce.repository;
import com.tienda.ecommerce.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {}