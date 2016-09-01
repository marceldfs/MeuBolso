package mz.co.cedsif.meubolso.test.builder;

import mz.co.cedsif.meubolso.model.Gasto;

public class GastoBuilder extends BasicoBuilder {
	private String[] descricoesPossiveis = { "Mensal", "Anual" };
	private String[] tiposPossiveis = { "Refeicao", "Bebida", "Divertimento", "Roupa", "Combustivel" };
	private double maximo;

	public GastoBuilder() {
		maximo = -10000;
	}

	public Gasto cria() {
		Gasto gasto = new Gasto();
		gasto.setData(gerarDataAleatoria());
		gasto.setDescricao(gerarTextoAleatorio(descricoesPossiveis));
		gasto.setTipo(gerarTextoAleatorio(tiposPossiveis));
		gasto.setValor(gerarValorAleatorio(maximo));
		return gasto;
	}
}
