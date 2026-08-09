package com.tienda.ecommerce.service;
import com.tienda.ecommerce.entity.Marca;
import com.tienda.ecommerce.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaService {
    private final MarcaRepository repository;

    public List<Marca> findAll() { return repository.findAll(); }

    public Marca save(Marca entity) {
        return repository.save(entity);
    }
}