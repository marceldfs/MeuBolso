package mz.co.cedsif.meubolso.test.builder;

import java.util.Date;

import mz.co.cedsif.meubolso.dao.GanhoDAO;
import mz.co.cedsif.meubolso.model.Ganho;
import mz.co.cedsif.meubolso.model.TipoGanho;

/**
 * Este builder na minha opniao deve ser alterado 
 * Pois desta forma que esta nao permite fazer testes com valores especificos 
 * caso necessario nos testes unitarios e de integracao
 * TODO: MARCEL E GRACIO refactorar os testes de aceitacao consoante a ideia abaixo 
 */

public class GanhoBuilder extends BasicoBuilder {
	private String[] descricoesPossiveis = { "Mensal", "Anual" };
	private String[] tiposPossiveis = { "Salario", "Venda de casa", "Venda de carro", "Servico prestado",
			"Rendimento de investimentos" };
	private double maximo;
	
	//variaveis para o novo builder
	private double valor; 
	private String descricao; 
	private TipoGanho tipo;
	private Ganho ganho;
	private Date data;
	
	public GanhoBuilder() {
		maximo = 50000;
	}

	public Ganho cria() {
		Ganho ganho = new Ganho();
		ganho.setData(gerarDataAleatoria());
		ganho.setDescricao(gerarTextoAleatorio(descricoesPossiveis));
//		ganho.setTipo(gerarTextoAleatorio(tiposPossiveis));
		ganho.setValor(gerarValorAleatorio(maximo));
		return ganho;
	}

	
	
	
	public GanhoBuilder comValor(double valor)
	{
		this.valor = valor;
		return this;
	}
	
	public GanhoBuilder comDescriao(String descricao)
	{
		this.descricao = descricao; 
		return this;
	}
	public GanhoBuilder comTipo(TipoGanho tipo)
	{
		this.tipo = tipo;
		return this;
	}
	public GanhoBuilder comData(Date data)
	{
		this.data = data;
		return this;
	}
	public Ganho buildGanho()
	{
		return new Ganho(this.data, this.descricao, this.tipo, this.valor);
	}
}
