package com.ionix.ionix.repository;

import org.springframework.stereotype.Repository;

import com.ionix.ionix.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

	public Usuario findByEmail(String email);
}
