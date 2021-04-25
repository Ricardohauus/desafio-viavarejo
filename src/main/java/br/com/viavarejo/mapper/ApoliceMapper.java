package br.com.viavarejo.mapper;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.viavarejo.dto.ApoliceDTO;
import br.com.viavarejo.model.Apolice;

public class ApoliceMapper {

	public static ApoliceDTO convertEntityToApoliceDTO(Apolice a) {
		ApoliceDTO apoliceDTO = new ApoliceDTO();
		apoliceDTO.setCliente(a.getCliente());
		apoliceDTO.setDataFim(a.getDataFim());
		apoliceDTO.setDataInicio(a.getDataInicio());
		apoliceDTO.setNumero(a.getNumero());
		apoliceDTO.setPlacaVeiculo(a.getPlacaVeiculo());
		apoliceDTO.setValor(a.getValor());
		apoliceDTO.setSituacao(a.getDataFim().isBefore(LocalDate.now()) ? "Venceu" : "Em Vigência");
		long dias = Math.abs((ChronoUnit.DAYS.between(LocalDate.now(), a.getDataFim())));
		apoliceDTO.setSituacaoEmDias(
				apoliceDTO.getSituacao().equals("Venceu") ? "A sua Apolice venceu há " + dias + " Dia(s)"
						: "A sua Apolice vai vencer em " + dias + " Dia(s)");
		return apoliceDTO;
	}

}
