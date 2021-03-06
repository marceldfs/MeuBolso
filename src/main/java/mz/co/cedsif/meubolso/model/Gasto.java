package mz.co.cedsif.meubolso.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Gasto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	@NotNull
	private String descricao;
	private TipoMovimentos tipo;
	private Double valor;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoMovimentos getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentos tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Gasto() {
	}

	public Gasto(Date data, String descricao, TipoMovimentos tipo, double valor) {
		this.data = data;
		this.descricao=descricao;
		this.tipo=tipo;
		this.valor=valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
