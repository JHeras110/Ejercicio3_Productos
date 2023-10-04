package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProductosDao;
import com.example.exceptions.NombreNoEncontradoException;
import com.example.exceptions.ProductoVacioException;
import com.example.model.Producto;

/**
 * Servicio que se encarga de la logica del proyecto y el intercambio de 
 * informacion con la BBDD
 */
@Service
public class ProductosServiceImpl implements ProductosService{

    @Autowired
    ProductosDao dao;

    /**
     * Metodo que devueve un listado de todos los Productos
     */
    @Override
    public List<Producto> getProductos() {
        return dao.findAll();
    }

    /**
     * Metodo que recibe un String nomre y lo busca en la BBDD
     * para devolvernos un Double con el precio
     */
    @Override
    public double getPrecio(String nombre) {
        List<Producto> productos = dao.findAll();
        double precio = 0;
        boolean comprobar = false;
            
        for (Producto productoDeLaLista : productos) {
            if(productoDeLaLista.getNombre().equalsIgnoreCase(nombre)){
                precio = productoDeLaLista.getPrecio();
                comprobar = true;
                break;
            }
        }

        if(!comprobar){
            throw new NombreNoEncontradoException("El producto: '" + nombre + "', no coincide con ningún producto en la base de datos.");
        }

        return precio;
    }

    /**
     * Recibe un producto actualizado y lo sobreescribe en la BBDD
     */
    @Override
    public void setStock(Producto producto){
        if (producto.getNombre()==null) {
            throw new ProductoVacioException("El producto que ha llegado esta vacio");
        }
        dao.save(producto);
    }
    
}
