package mz.co.cedsif.meubolso.model;

import java.util.Date;

public class Ganho {
	private Date Data;
	private String Descrição;
	private String Tipo;
	private Double valor;

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public String getDescrição() {
		return Descrição;
	}

	public void setDescrição(String descrição) {
		Descrição = descrição;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Ganho() {
	}

}
