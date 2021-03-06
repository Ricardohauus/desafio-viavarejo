package br.com.viavarejo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Apolice")
@Document(collection = "apolice")
public class Apolice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2173009518293049956L;

	@Id
	@JsonIgnore
	private String numero;

	@ApiModelProperty(required = true, dataType = "org.joda.time.LocalDate", example = "dd/MM/yyyy")
	@NotNull(message = "Data Inicio {field.not.null}")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicio;

	@ApiModelProperty(required = true, dataType = "org.joda.time.LocalDate", example = "dd/MM/yyyy")
	@NotNull(message = "Data Fim {field.not.null}")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFim;

	@ApiModelProperty(required = true)
	@NotEmpty(message = "Placa do Veiculo {field.not.blank}")
	private String placaVeiculo;

	@ApiModelProperty(required = true)
	@NotNull(message = "Valor {field.not.null}")
	private Double valor;

	@ApiModelProperty(required = true)
	@DBRef
	@NotNull(message = "Cliente {field.not.null}")
	private Cliente cliente;

	@JsonProperty
	public String getNumero() {
		return numero;
	}

	@JsonIgnore
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((placaVeiculo == null) ? 0 : placaVeiculo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apolice other = (Apolice) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (placaVeiculo == null) {
			if (other.placaVeiculo != null)
				return false;
		} else if (!placaVeiculo.equals(other.placaVeiculo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
