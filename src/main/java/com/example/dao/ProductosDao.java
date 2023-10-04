package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Producto;

/**
 * Interfaz que nos ayuda a mapear el objeto con el que vamos a trabajar
 */
public interface ProductosDao extends JpaRepository<Producto, Integer>{
    
}
