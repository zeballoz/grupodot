package com.grupodot.demo.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.grupodot.demo.entidades.Partner;

public interface PartnerService {
	
	public Iterable<Partner> findAll();
	
	public Page<Partner> findAll(Pageable pageable);
	
	public Optional<Partner> finById(long id);
	
	public Partner save(Partner partner);
	
	public void deleteById(long id);
	
	public Optional<Partner> obtenerTasaInteresMasBaja(double monto);

}
