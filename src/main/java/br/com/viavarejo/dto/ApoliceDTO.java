package br.com.viavarejo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.viavarejo.model.Cliente;

public class ApoliceDTO {
	private String numero;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicio;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFim;

	private String placaVeiculo;

	private Double valor;

	private Cliente cliente;

	private String situacao;

	private String situacaoEmDias;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getSituacaoEmDias() {
		return situacaoEmDias;
	}

	public void setSituacaoEmDias(String situacaoEmDias) {
		this.situacaoEmDias = situacaoEmDias;
	}
}
