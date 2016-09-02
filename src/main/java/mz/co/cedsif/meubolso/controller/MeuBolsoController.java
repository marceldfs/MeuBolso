package mz.co.cedsif.meubolso.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mz.co.cedsif.meubolso.dao.GastoDAO;
import mz.co.cedsif.meubolso.model.Gasto;

@Controller
public class MeuBolsoController {
	private GastoDAO gastoDAO;

	public MeuBolsoController() {
		preparaDao();
	}

	private void preparaDao() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("gasto");
		EntityManager manager = factory.createEntityManager();
		this.gastoDAO = new GastoDAO(manager);
	}

	@RequestMapping("/")
	public String mostrarPaginaInicial(Model modelo) {
		System.out.println("Executando a logica com o Spring MVC");
		preparaDao();
		List<Gasto> listaDeGastos = gastoDAO.getLista();
		modelo.addAttribute("gastos", listaDeGastos);
		return "index";
	}

	@RequestMapping("/novogasto")
	public String mostrarPaginaRegistarGastos() {
		System.out.println("Executando a logica com o Spring MVC");
		return "gastos";
	}

	@RequestMapping("/novoganho")
	public String mostrarPaginaRegistarGanhos() {
		System.out.println("Executando a logica com o Spring MVC");
		return "ganhos";
	}

	@RequestMapping("/adicionaGasto")
	public String adicionaGastos(Gasto gasto) {
		preparaDao();
		gastoDAO.inserir(gasto);
		return "redirect:";
	}
}
