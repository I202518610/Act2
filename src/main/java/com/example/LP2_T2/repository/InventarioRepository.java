package com.example.LP2_T2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LP2_T2.model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Integer>{

	List<Inventario> findAllByOrderByNumeroDesc();
}
