package com.tienda.ecommerce.service;

import com.tienda.ecommerce.entity.Cliente;
import com.tienda.ecommerce.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public List<Cliente> findAll() { return repository.findAll(); }
    public Optional<Cliente> findById(Integer id) { return repository.findById(id); }
    public Cliente save(Cliente entity) { return repository.save(entity); }

    public boolean deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}