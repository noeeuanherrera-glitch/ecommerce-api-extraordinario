package com.tienda.ecommerce.service;

import com.tienda.ecommerce.entity.Marca;
import com.tienda.ecommerce.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarcaService {
    private final MarcaRepository repository;

    public List<Marca> findAll() { return repository.findAll(); }
    public Optional<Marca> findById(Integer id) { return repository.findById(id); }
    public Marca save(Marca entity) { return repository.save(entity); }

    public boolean deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}