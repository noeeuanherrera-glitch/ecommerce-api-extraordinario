package com.tienda.ecommerce.repository;
import com.tienda.ecommerce.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {}