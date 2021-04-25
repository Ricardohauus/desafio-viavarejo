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

import br.com.viavarejo.dto.ApoliceDTO;
import br.com.viavarejo.model.Apolice;
import br.com.viavarejo.service.impl.ApoliceServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/apolices")
@Api(value = "Apolice")
public class ApoliceController {

	@Autowired
	ApoliceServiceImpl apoliceService;

	@ApiOperation(value = "Cria uma Apolice")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Apolice> create(@RequestBody(required = true) @Valid Apolice apolice) {
		return new ResponseEntity<Apolice>(this.apoliceService.create(apolice), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Atualiza uma Apolice pelo seu numero")
	@PutMapping(value = "/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Apolice> update(@RequestBody(required = true) @Valid Apolice apolice,
			@PathVariable("numero") String numero) {
		return new ResponseEntity<Apolice>(this.apoliceService.update(apolice, numero), HttpStatus.OK);
	}

	@ApiOperation(value = "Deleta uma Apolice pelo seu numero")
	@DeleteMapping(value = "/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> delete(@PathVariable(required = true, name = "numero") String numero) {
		return new ResponseEntity<Boolean>(this.apoliceService.delete(numero), HttpStatus.OK);
	}

	@ApiOperation(value = "Lista todas as Apolices")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Apolice>> findAll() {
		return new ResponseEntity<List<Apolice>>(this.apoliceService.findAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "Consulta a Apolice pelo seu numero")
	@GetMapping(value = "/findByNumero/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApoliceDTO> findByNumero(@PathVariable(required = true, name = "numero") String numero) {
		return new ResponseEntity<ApoliceDTO>(this.apoliceService.findByNumero(numero), HttpStatus.OK);
	}

}
