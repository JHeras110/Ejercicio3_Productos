package com.example.services;

import java.util.List;

import com.example.model.Producto;

/**
 * Interfaz que hace de intermediario entre el controlador y el servicio
 * @See {@link com.example.controller.ProductosController}
 * @see com.example.services.ProductosServiceImpl
 */
public interface ProductosService {
 
    List<Producto> getProductos();
    double getPrecio(String nombre);
    void setStock(Producto producto);
}
