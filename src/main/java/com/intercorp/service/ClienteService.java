package com.intercorp.service;


import java.util.List;

import com.intercorp.modelo.Cliente;
import com.intercorp.modelo.RequestCliente;
import com.intercorp.modelo.Response;
import com.intercorp.modelo.ResponseCliente;
import com.intercorp.modelo.ResponseKPI;

public interface ClienteService {
	
	public Response createCliente(RequestCliente requestCliente);
	public ResponseKPI kpideclientes();
	public List<ResponseCliente> listclientes();
 

}
