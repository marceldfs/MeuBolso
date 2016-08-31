package mz.co.cedsif.meubolso.test.builder;

import java.util.Calendar;
import java.util.Date;

public abstract class BasicoBuilder {

	protected Double gerarValorAleatorio(double maximo) {
		return Math.random() * maximo;
	}

	protected String gerarTextoAleatorio(String[] opcoesTexto) {
		int posicaoDescricao = (int) (Math.random() * opcoesTexto.length);
		return opcoesTexto[posicaoDescricao];
	}

	protected Date gerarDataAleatoria() {
		int diasAleatoriosReduzir = (int) (-Math.random() * 30);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, diasAleatoriosReduzir);
		return calendar.getTime();
	}
}
