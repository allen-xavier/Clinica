package br.com.dh.lojaonline.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	@RequestMapping(method = RequestMethod.GET)
	static String ola() {
		return "olá";
	}
}
