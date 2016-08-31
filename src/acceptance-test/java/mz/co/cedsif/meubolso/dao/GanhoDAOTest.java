package mz.co.cedsif.meubolso.dao;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import mz.co.cedsif.meubolso.model.Ganho;
import mz.co.cedsif.meubolso.model.TipoGanho;

public class GanhoDAOTest {

	@Test
	public void deveInserirGanho() {
		LocalDate data = new LocalDate();
		data.withDayOfMonth(31).withMonthOfYear(8).withYear(2016);
		String descricao = "Salario";
		double valor = 2000.0;
		Ganho ganho = new Ganho(data, descricao, TipoGanho.FIXO, valor);
		Assert.assertTrue(new GanhoDAO().inserir(ganho));
	}

}
