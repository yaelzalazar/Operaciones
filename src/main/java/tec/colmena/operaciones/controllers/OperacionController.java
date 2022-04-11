package tec.colmena.operaciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OperacionController {
	
	@Autowired
	private RestTemplate clienteRest;
	
	@GetMapping("/sumarusa")
	public String sumar (@RequestParam float a, @RequestParam float b) {
		String resultado = Float.toString(a + b);
		return clienteRest.getForObject("https://resultados-usa.herokuapp.com/resultado/"+ resultado, String.class);
	}
	
	@GetMapping("/restareuropa")
	public String restar (@RequestParam float a, @RequestParam float b) {
		String resultado = Float.toString(a - b);
		return clienteRest.getForObject("https://resultados-europa.herokuapp.com//resultado/"+ resultado, String.class);
	}
	
	
}
