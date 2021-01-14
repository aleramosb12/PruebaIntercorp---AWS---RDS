package com.intercorp.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intercorp.dao.ClienteDao;
import com.intercorp.modelo.Cliente;
import com.intercorp.modelo.RequestCliente;
import com.intercorp.modelo.Response;
import com.intercorp.modelo.ResponseCliente;
import com.intercorp.modelo.ResponseKPI;
import com.intercorp.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteDao clienteDao;
	
	@Override
	public Response createCliente(RequestCliente requestCliente) {
		
		Cliente cliente=new Cliente();
		
		cliente.setNombre(requestCliente.getNombre());
		cliente.setApellido(requestCliente.getApellido());
		cliente.setEdad(requestCliente.getEdad());
		cliente.setNacimiento(requestCliente.getNacimiento());
		
		Response responseCliente=new Response();
		cliente= clienteDao.save(cliente);
		
		if (cliente.equals(null)) {
			responseCliente.setCodigo(1);
			responseCliente.setMensaje("Ok");;
		}
		
		return responseCliente;
	}

	@Override
	public ResponseKPI kpideclientes() {
		
		int sumatoria=0;
		int cantidad = 0;
		double media=0;
		double varianza = 0;
		double desviacion = 0;

		
		List<Cliente> clientes =(List<Cliente>) clienteDao.findAll();
		ResponseKPI responseKPI=new ResponseKPI();

		for(Cliente cliente:clientes) {
			sumatoria = sumatoria + cliente.getEdad();
			cantidad++;
		}
		
		media = sumatoria / cantidad;
		
		for(Cliente cliente:clientes) {
			
			varianza = varianza + Math.pow(cliente.getEdad() - media, 2f);
		}
		
		varianza = varianza/cantidad;
		desviacion = Math.sqrt(varianza);
		
		responseKPI.setMedia(media);
		responseKPI.setVarianza(varianza);
		responseKPI.setDesviacion(desviacion);
		
		return responseKPI;
	}

	@Override
	public List<ResponseCliente> listclientes() {
		// TODO Auto-generated method stub
		
		List<ResponseCliente> ResponseClientes = new ArrayList<ResponseCliente>();
		
		Calendar calendar = Calendar.getInstance();
		
		for(Cliente cliente: (List<Cliente>) clienteDao.findAll()) {
			
			ResponseCliente ResponseCliente = new ResponseCliente();

			
			calendar.setTime(cliente.getNacimiento());
			calendar.add(Calendar.YEAR, 70);
			
			ResponseCliente.setId(cliente.getId());
			ResponseCliente.setNombre(cliente.getNombre());
			ResponseCliente.setApellido(cliente.getApellido());
			ResponseCliente.setEdad(cliente.getEdad());
			ResponseCliente.setNacimiento(cliente.getNacimiento());
			ResponseCliente.setFecha_muerte(calendar.getTime());
			
			ResponseClientes.add(ResponseCliente);
		}
		
		return ResponseClientes;
	}
	
}
