package com.intercorp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intercorp.modelo.Cliente;
import com.intercorp.modelo.RequestCliente;
import com.intercorp.modelo.Response;
import com.intercorp.modelo.ResponseCliente;
import com.intercorp.modelo.ResponseKPI;
import com.intercorp.service.ClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@PostMapping("/createCliente")
	@ApiOperation(value = "Operacion de insercion", notes = "Guarda los clientes que se registren en la API")
	public Response createcliente(@RequestBody RequestCliente requestCliente) {

		return clienteService.createCliente(requestCliente);
	}

	@GetMapping("/kpideclientes")
	@ApiOperation(value = "Operacion de KPI de clientes", notes = "Obtiene la edad promedio y la desviacion estandar")
	public ResponseKPI kpideclientes() {

		return 	clienteService.kpideclientes();

	}

	@GetMapping("/listclientes")
	@ApiOperation(value = "Listado de clientes", notes = "Obtiene los datos de clientes y la fecha probable de muerte")
	public List<ResponseCliente> listclientes() {

		return clienteService.listclientes();
	}

}
