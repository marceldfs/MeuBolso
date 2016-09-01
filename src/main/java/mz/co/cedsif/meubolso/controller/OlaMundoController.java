package mz.co.cedsif.meubolso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

	@RequestMapping("/olaMundoSpring")
	public String execute() {
		System.out.println("Executando a logica com o Spring MVC");
		return "ola";
	}

	@RequestMapping("/novogasto")
	public String mostrarPaginaRegistarGastos() {
		System.out.println("Executando a logica com o Spring MVC");
		return "gastos";
	}
}
