package mz.co.cedsif.meubolso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MeuBolsoController {

	@RequestMapping("/index")
	public String mostrarPaginaInicial() {
		System.out.println("Executando a logica com o Spring MVC");
		return "index";
	}

}