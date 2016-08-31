package mz.co.cedsif.meubolso.test.builder;

import java.util.Calendar;
import java.util.Date;

import mz.co.cedsif.meubolso.model.Ganho;

public class GanhoBuilder {
	private String[] descricoesPossiveis = { "Vendi", "Mensal", "Anual" };
	private String[] tiposPossiveis = { "Salario", "Venda de casa", "Venda de carro", "Servico prestado",
			"Rendimento de investimentos" };
	private double maximo = 50000;

	public GanhoBuilder() {

	}

	public Ganho cria() {
		Ganho ganho = new Ganho();
		ganho.setData(gerarDataAleatoria());
		ganho.setDescrição(gerarTextoAleatorio(descricoesPossiveis));
		ganho.setTipo(gerarTextoAleatorio(tiposPossiveis));
		ganho.setValor(gerarValorAleatorio(maximo));
		return ganho;
	}

	private Double gerarValorAleatorio(double maximo) {
		return Math.random() * maximo;
	}

	private String gerarTextoAleatorio(String[] opcoesTexto) {
		int posicaoDescricao = (int) (Math.random() * opcoesTexto.length);
		return opcoesTexto[posicaoDescricao];
	}

	private Date gerarDataAleatoria() {
		int diasAleatoriosReduzir = (int) (-Math.random() * 30);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, diasAleatoriosReduzir);
		return calendar.getTime();
	}
}
