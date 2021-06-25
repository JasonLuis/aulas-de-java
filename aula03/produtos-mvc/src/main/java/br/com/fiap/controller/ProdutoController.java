package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.model.ProdutoModel;
import br.com.fiap.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	ProdutoRepository repository = ProdutoRepository.getInstance();

	@RequestMapping(value = "/produto", method = RequestMethod.GET)
	public String findAll(Model model) {

		model.addAttribute("produtos", repository.findAll());
		return "produtos";
	}

	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable("id") long id, Model model) {
		
		model.addAttribute("produto", repository.findById(id));
		return "produto-detalhe";
	}
	
	@RequestMapping(value = "/produto/new", method = RequestMethod.GET)
	public String openSave(@ModelAttribute("produtoModel") ProdutoModel produtoModel) {
		return "produto-novo";
	}
	
	@RequestMapping(value = "/produto/new", method = RequestMethod.POST)
	public String save(@Valid ProdutoModel produtoModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			return "produto-novo";
		}
		
		repository.save(produtoModel);
		redirectAttributes.addFlashAttribute("messages", "Produto cadastrado com sucesso!");
		
		return "redirect:/produto";
	}
	
	@RequestMapping(value = "produto/update/{id}", method = RequestMethod.GET)
	public String openUpdate(@PathVariable("id") long id, Model model, @ModelAttribute("produtoModel") ProdutoModel produtoModel) {
		
		model.addAttribute("produtoModel", repository.findById(id));
		return "produto-editar";
	}
	
	@RequestMapping(value = "/produto/update", method = RequestMethod.POST)
	public String update(Model model, @Valid ProdutoModel produtoModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			return "produto-editar";
		}
		
		repository.update(produtoModel);
		redirectAttributes.addFlashAttribute("messages", "Produto alterado com sucesso!");
		
		return "redirect:/produto";
	}
	
	@RequestMapping(value = "produto/delete/{id}", method = RequestMethod.DELETE)
	public String deleteById(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
		
		repository.deleteById(id);
		redirectAttributes.addFlashAttribute("messages", "Produto excluído com sucesso!");

		return "redirect:/produto";
	}

}
