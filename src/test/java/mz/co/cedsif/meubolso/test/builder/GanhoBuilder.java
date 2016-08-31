package mz.co.cedsif.meubolso.test.builder;

import mz.co.cedsif.meubolso.model.Ganho;

public class GanhoBuilder extends BasicoBuilder {
	private String[] descricoesPossiveis = { "Mensal", "Anual" };
	private String[] tiposPossiveis = { "Salario", "Venda de casa", "Venda de carro", "Servico prestado",
			"Rendimento de investimentos" };
	private double maximo;

	public GanhoBuilder() {
		maximo = 50000;
	}

	public Ganho cria() {
		Ganho ganho = new Ganho();
		ganho.setData(gerarDataAleatoria());
		ganho.setDescrição(gerarTextoAleatorio(descricoesPossiveis));
		ganho.setTipo(gerarTextoAleatorio(tiposPossiveis));
		ganho.setValor(gerarValorAleatorio(maximo));
		return ganho;
	}
}
