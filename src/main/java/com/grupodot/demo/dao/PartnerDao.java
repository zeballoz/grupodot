package com.grupodot.demo.dao;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.grupodot.demo.entidades.Partner;


@Transactional
public interface PartnerDao extends  CrudRepository<Partner,Long>, Serializable{
	
	@Query("select p from Partner p where p.montoMaximo >= :monto order by p.tasa asc")
	public  List<Partner> obtenerTasaInteresMasBaja(@Param("monto") double monto);

	
}

