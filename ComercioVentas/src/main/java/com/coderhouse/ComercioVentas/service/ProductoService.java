package com.coderhouse.ComercioVentas.service;

import com.coderhouse.ComercioVentas.Model.Producto;
import com.coderhouse.ComercioVentas.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    
    // Crear Producto
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
