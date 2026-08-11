package com.tienda.ecommerce.controller;
import com.tienda.ecommerce.dto.ArticuloPedidoDTO;
import com.tienda.ecommerce.entity.ArticuloPedido;
import com.tienda.ecommerce.mapper.ArticuloPedidoMapper;
import com.tienda.ecommerce.service.ArticuloPedidoService;
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
@RequestMapping("/api/articulopedidos")
@RequiredArgsConstructor
public class ArticuloPedidoController {
    private final ArticuloPedidoService service;
    private final ArticuloPedidoMapper mapper;

    @Operation(summary = "Obtener todos", responses = { @ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente") })
    @GetMapping
    public ResponseEntity<List<ArticuloPedidoDTO>> getAll() {
        return ResponseEntity.ok(service.findAll().stream().map(mapper::toDTO).collect(Collectors.toList()));
    }

    @Operation(summary = "Crear nuevo", responses = { @ApiResponse(responseCode = "201", description = "Creado exitosamente") })
    @PostMapping
    public ResponseEntity<ArticuloPedidoDTO> create(@org.springframework.web.bind.annotation.RequestBody ArticuloPedidoDTO dto) {
        ArticuloPedido saved = service.save(mapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(saved));
    }
}