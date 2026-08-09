package com.tienda.ecommerce.service;

import com.tienda.ecommerce.entity.Prenda;
import com.tienda.ecommerce.repository.PrendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrendaService {

    private final PrendaRepository repository;

    public List<Prenda> findAll() {
        return repository.findAll();
    }

    public Optional<Prenda> findById(Integer id) {
        return repository.findById(id);
    }

    public Prenda save(Prenda entity) {
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