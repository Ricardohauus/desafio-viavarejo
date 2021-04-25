package br.com.viavarejo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.viavarejo.model.Cliente;
import br.com.viavarejo.service.impl.ClienteServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@Api(value = "Cliente")
public class ClienteController {

	@Autowired
	ClienteServiceImpl clienteService;

	@ApiOperation(value = "Cria um Cliente")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> create(@RequestBody(required = true) @Valid Cliente cliente) {
		return new ResponseEntity<Cliente>(this.clienteService.create(cliente), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Atualiza um Cliente pelo seu ID")
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> update(@RequestBody(required = true) @Valid Cliente cliente,
			@PathVariable("id") String id) {
		return new ResponseEntity<Cliente>(this.clienteService.update(cliente, id), HttpStatus.OK);
	}

	@ApiOperation(value = "Deleta uma Cliente pelo seu ID")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> delete(@PathVariable(required = true, name = "id") String id) {
		return new ResponseEntity<Boolean>(this.clienteService.delete(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Consulta um Cliente pelo seu ID")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> findById(@PathVariable(required = true, name = "id") String id) {
		return new ResponseEntity<Cliente>(this.clienteService.findById(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Lista todos os Clientes")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> findAll() {
		return new ResponseEntity<List<Cliente>>(this.clienteService.findAll(), HttpStatus.OK);
	}

}
