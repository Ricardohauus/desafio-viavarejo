package br.com.viavarejo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteServiceImpl clienteService;

	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody @Valid Cliente cliente) {
		return new ResponseEntity<Cliente>(this.clienteService.create(cliente), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@RequestBody @Valid Cliente cliente, @PathVariable("id") String id) {
		cliente.setId(id);
		return new ResponseEntity<Cliente>(this.clienteService.update(cliente, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
		this.clienteService.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable("id") String id) {
		return new ResponseEntity<Cliente>(this.clienteService.findById(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		return new ResponseEntity<List<Cliente>>(this.clienteService.findAll(), HttpStatus.OK);
	}

}
