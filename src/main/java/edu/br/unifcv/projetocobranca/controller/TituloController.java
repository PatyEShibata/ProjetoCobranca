package edu.br.unifcv.projetocobranca.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.br.unifcv.projetocobranca.model.Titulo;
import edu.br.unifcv.projetocobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroTitulo";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		
		if (titulo.getDescricao().length() <= 5) {
			mv.addObject("warning", true);
			return mv;
		}

		if (titulo.getDataVencimento() == null || titulo.getDescricao() == null || titulo.getStatus() == null || titulo.getValor() == null) {
			mv.addObject("erro", true);
			
		return mv;	
		}
		else {
		titulos.save(titulo);
		mv.addObject("mensagem", "Título Salvo com Sucesso");
		}
		
		return mv;
	}
	

}
