package com.tienda.ecommerce.service;
import com.tienda.ecommerce.entity.Cliente;
import com.tienda.ecommerce.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public List<Cliente> findAll() { return repository.findAll(); }

    public Cliente save(Cliente entity) {
        return repository.save(entity);
    }
}