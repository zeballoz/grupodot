package com.grupodot.demo.service;


import com.grupodot.demo.entidades.Consulta;

public interface ConsultaService {
	
	public Consulta obtenerTasaInteresMasBaja(double monto);
	
	public Consulta save(Consulta consulta);

}
