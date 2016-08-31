package mz.co.cedsif.meubolso.model;

import java.util.Date;

public class Ganho {
	
	@Id
	@GeneratedValue
	private Long id;

	@Temporal(TemporalType.DATE)
	private LocalDate data;

	private String descricao;
	private double valor;
	
	private String tipo;
	

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescrição() {
		return descricao;
	}

	public void setDescrição(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
