package com.tienda.ecommerce.controller;
import com.tienda.ecommerce.dto.ClienteDTO;
import com.tienda.ecommerce.entity.Cliente;
import com.tienda.ecommerce.mapper.ClienteMapper;
import com.tienda.ecommerce.service.ClienteService;
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
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService service;
    private final ClienteMapper mapper;

    @Operation(summary = "Obtener todos", responses = { @ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente") })
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        return ResponseEntity.ok(service.findAll().stream().map(mapper::toDTO).collect(Collectors.toList()));
    }

    @Operation(summary = "Crear nuevo", responses = { @ApiResponse(responseCode = "201", description = "Creado exitosamente") })
    @PostMapping
    public ResponseEntity<ClienteDTO> create(@org.springframework.web.bind.annotation.RequestBody ClienteDTO dto) {
        Cliente saved = service.save(mapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(saved));
    }
}