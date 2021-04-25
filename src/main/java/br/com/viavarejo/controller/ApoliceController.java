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

import br.com.viavarejo.dto.ApoliceDTO;
import br.com.viavarejo.model.Apolice;
import br.com.viavarejo.service.impl.ApoliceServiceImpl;

@RestController
@RequestMapping("/apolices")
public class ApoliceController {

	@Autowired
	ApoliceServiceImpl apoliceService;

	@PostMapping
	public ResponseEntity<Apolice> create(@RequestBody @Valid Apolice apolice) {
		return new ResponseEntity<Apolice>(this.apoliceService.create(apolice), HttpStatus.CREATED);
	}

	@PutMapping("/{numero}")
	public ResponseEntity<Apolice> update(@RequestBody @Valid Apolice cliente, @PathVariable("numero") String numero) {
		return new ResponseEntity<Apolice>(this.apoliceService.update(cliente, numero), HttpStatus.OK);
	}

	@DeleteMapping("/{numero}")
	public ResponseEntity<Boolean> delete(@PathVariable("numero") String numero) {
		this.apoliceService.delete(numero);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Apolice>> findAll() {
		return new ResponseEntity<List<Apolice>>(this.apoliceService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/findByNumero/{numero}")
	public ResponseEntity<ApoliceDTO> findByNumero(@PathVariable("numero") String numero) {
		return new ResponseEntity<ApoliceDTO>(this.apoliceService.findByNumero(numero), HttpStatus.OK);
	}

}
