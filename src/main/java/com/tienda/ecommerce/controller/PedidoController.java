package com.tienda.ecommerce.controller;
import com.tienda.ecommerce.dto.PedidoDTO;
import com.tienda.ecommerce.entity.Pedido;
import com.tienda.ecommerce.mapper.PedidoMapper;
import com.tienda.ecommerce.service.PedidoService;
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
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService service;
    private final PedidoMapper mapper;

    @Operation(summary = "Obtener todos", responses = { @ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente") })
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAll() {
        return ResponseEntity.ok(service.findAll().stream().map(mapper::toDTO).collect(Collectors.toList()));
    }

    @Operation(summary = "Crear nuevo", responses = { @ApiResponse(responseCode = "201", description = "Creado exitosamente") })
    @PostMapping
    public ResponseEntity<PedidoDTO> create(@org.springframework.web.bind.annotation.RequestBody PedidoDTO dto) {
        Pedido saved = service.save(mapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(saved));
    }
}