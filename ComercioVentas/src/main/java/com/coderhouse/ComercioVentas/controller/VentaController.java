package com.coderhouse.ComercioVentas.controller;

import com.coderhouse.ComercioVentas.service.VentaService;
import com.coderhouse.ComercioVentas.Model.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> obtenerTodasLasVentas() {
        return ventaService.obtenerTodasLasVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable Long id) {
        Optional<Venta> venta = ventaService.obtenerVentaPorId(id);
        return venta.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.guardarVenta(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        Optional<Venta> ventaExistente = ventaService.obtenerVentaPorId(id);
        if (ventaExistente.isPresent()) {
            venta.setId(id);
            Venta ventaActualizada = ventaService.guardarVenta(venta);
            return ResponseEntity.ok(ventaActualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
        return ResponseEntity.noContent().build();
    }
}
