package com.example.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Producto;
import com.example.services.ProductosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Controlador que se encarga de Mapear y dirigir todas las urls del Proyecto
 */
@RestController
public class ProductosController {
    
    @Autowired
    ProductosService service;

    /**
     * Devuelve un listado con todos los productos
     * 
     * @return
     */
    @GetMapping(value="productos")
    public List<Producto> getProductos() {
        return service.getProductos();
    }
    
    /**
     * Devuelve el precio del nombre del producto que recibe
     * 
     * @param nombre
     * @return
     */
    @GetMapping(value="producto/{nombre}")
    public double getPrecio(@PathVariable("nombre") String nombre){
        return service.getPrecio(nombre);
    }

    /**
     * Recibe la informacion de un Producto actualizada despues de hacer un Pedido
     * 
     * @param producto
     */
    @PutMapping(value = "producto")
    public void setStock(@RequestBody Producto producto){
        service.setStock(producto);
    }
    
}
