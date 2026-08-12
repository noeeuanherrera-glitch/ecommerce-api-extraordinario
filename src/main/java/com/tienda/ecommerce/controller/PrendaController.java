package com.tienda.ecommerce.controller;

import com.tienda.ecommerce.entity.Prenda;
import com.tienda.ecommerce.service.PrendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prendas")
@RequiredArgsConstructor
@Tag(name = "Prendas", description = "Endpoints para la gestión de prendas")
public class PrendaController {

    private final PrendaService service;

    @GetMapping
    @Operation(summary = "Obtener todas las prendas")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito")
    public ResponseEntity<List<Prenda>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una prenda por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prenda encontrada"),
            @ApiResponse(responseCode = "404", description = "Prenda no encontrada")
    })
    public ResponseEntity<Prenda> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear una nueva prenda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Prenda creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    public ResponseEntity<Prenda> create(
            @RequestBody(
                    description = "Estructura JSON para crear una prenda",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = Prenda.class),
                            examples = @ExampleObject(
                                    value = "{\"nombre\": \"Playera Deportiva\", \"precio\": 499.99}"
                            )
                    )
            )
            @org.springframework.web.bind.annotation.RequestBody Prenda prenda
    ) {
        Prenda nuevaPrenda = service.save(prenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPrenda);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una prenda por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Prenda eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Prenda no encontrada")
    })
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}