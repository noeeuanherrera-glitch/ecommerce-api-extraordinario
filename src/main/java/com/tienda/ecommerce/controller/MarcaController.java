package com.tienda.ecommerce.controller;
import com.tienda.ecommerce.dto.MarcaDTO;
import com.tienda.ecommerce.entity.Marca;
import com.tienda.ecommerce.mapper.MarcaMapper;
import com.tienda.ecommerce.service.MarcaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/marcas")
@RequiredArgsConstructor
public class MarcaController {
    private final MarcaService service;
    private final MarcaMapper mapper;

    @Operation(summary = "Obtener todos", responses = { @ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente") })
    @GetMapping
    public ResponseEntity<List<MarcaDTO>> getAll() {
        return ResponseEntity.ok(service.findAll().stream().map(mapper::toDTO).collect(Collectors.toList()));
    }

    @Operation(summary = "Crear nuevo", responses = { @ApiResponse(responseCode = "201", description = "Creado exitosamente") })
    @PostMapping
    public ResponseEntity<MarcaDTO> create(@org.springframework.web.bind.annotation.RequestBody MarcaDTO dto) {
        Marca saved = service.save(mapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(saved));
    }
}