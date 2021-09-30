package com.grupodot.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.grupodot.demo.entidades.Consulta;

@Transactional
public interface ConsultaDao extends JpaRepository<Consulta, Long>, Serializable {
	
	
}
