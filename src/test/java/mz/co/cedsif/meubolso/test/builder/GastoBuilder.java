package mz.co.cedsif.meubolso.test.builder;

import java.util.Date;

import mz.co.cedsif.meubolso.model.Ganho;
import mz.co.cedsif.meubolso.model.Gasto;
import mz.co.cedsif.meubolso.model.TipoMovimentos;

public class GastoBuilder extends BasicoBuilder {
	private String[] descricoesPossiveis = { "Mensal", "Anual" };
	private String[] tiposPossiveis = { "Refeicao", "Bebida", "Divertimento", "Roupa", "Combustivel" };
	private double maximo;
	
	private double valor; 
	private String descricao; 
	private TipoMovimentos tipo;
	private Date data;
	
	
	public GastoBuilder() {
		maximo = -10000;
	}

	public Gasto cria() {
		Gasto gasto = new Gasto();
		gasto.setData(gerarDataAleatoria());
		gasto.setDescricao(gerarTextoAleatorio(descricoesPossiveis));
		//gasto.setTipo(gerarTextoAleatorio(tiposPossiveis));
		gasto.setValor(gerarValorAleatorio(maximo));
		return gasto;
	}
	
	public GastoBuilder comValor(double valor)
	{
		this.valor = valor;
		return this;
	}
	
	public GastoBuilder comDescriao(String descricao)
	{
		this.descricao = descricao; 
		return this;
	}
	public GastoBuilder comTipo(TipoMovimentos tipo)
	{
		this.tipo = tipo;
		return this;
	}
	public GastoBuilder comData(Date data)
	{
		this.data = data;
		return this;
	}
	public Gasto buildGasto()
	{
		return new Gasto(this.data, this.descricao, this.tipo, this.valor);
	}
	
}
