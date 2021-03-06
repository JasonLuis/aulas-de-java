package br.com.fiap.controller;

import javax.validation.Valid;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.model.LivroModel;
import br.com.fiap.repository.LivroRepository;


@Controller
@RequestMapping("/livro")
public class LivroController {
	
	LivroRepository repository = LivroRepository.getInstance();
	
	@GetMapping("/form")
	public String open(@RequestParam String page,
					   @RequestParam(required = false) Long id,
					   @ModelAttribute("livroModel") LivroModel livroModel,
					   Model model) {
		if("update-livros".equals(page)){
			model.addAttribute("livroModel",repository.findById(id));
		}
		return page;
	}
	//Leitura
	@GetMapping()
	public String findAll(Model model) {
		model.addAttribute("livro", repository.findAll());
		return "livros";
	}
	
	@GetMapping("/{id}")
	public String leituraId(@PathVariable("id") long id, Model model) {
		
		model.addAttribute("livro", repository.findById(id));
		return "detalhes-livros";
	}
	
	//Create
	@PostMapping()
	public String save(@Valid LivroModel livroModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()){
			return "new-livros";
		}
		
		repository.create(livroModel);
		redirectAttributes.addFlashAttribute("messages","Novo Livro cadastrado!");
		
		return "redirect:/livro";
		
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") long id,@Valid LivroModel livroModel,BindingResult bindingResult, RedirectAttributes redirectAttributes){
		
		if(bindingResult.hasErrors()) {
			return "update-livros";
		}
		
		livroModel.setId(id);
		repository.update(livroModel);
		redirectAttributes.addFlashAttribute("messages", "Livro atualizado com sucesso!");
		
		return "redirect:/livro";	
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
		repository.deleteById(id);
		redirectAttributes.addFlashAttribute("messages","Livro exclu??do com sucesso!");
		
		return "redirect:/livro";
	}
}
