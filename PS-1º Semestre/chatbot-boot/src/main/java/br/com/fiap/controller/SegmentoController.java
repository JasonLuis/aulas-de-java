package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.fiap.model.ChatbotModel;
import br.com.fiap.model.SegmentoModel;
import br.com.fiap.repository.SegmentRepository;

@Controller
@RequestMapping("/segmento")
public class SegmentoController {
	
	private static final String SEGMENTO_FOLDER = "segmento/";
	
	@Autowired
	public SegmentRepository segmentoRepository;
	
	
	@GetMapping("/form")
	public String open(@RequestParam String page, 
					   @RequestParam(required = false) Long id,
					   @ModelAttribute("segmentoModel") SegmentoModel segmentoModel, 
					   Model model) {
		
		if("segmento-editar".equals(page)) {
			model.addAttribute("segmentoModel", segmentoRepository.findById(id).get());
		}
				
		return SEGMENTO_FOLDER + page;
	}
	
	@GetMapping()
	public String findAll(Model model) {
		model.addAttribute("segmentos", segmentoRepository.findAll());
		return SEGMENTO_FOLDER +  "segmentos";
	}
	
	@PostMapping()
	public String save(@Valid SegmentoModel segmentoModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		if(bindingResult.hasErrors()) {
			return SEGMENTO_FOLDER + "segmento-novo";
		}
		segmentoRepository.save(segmentoModel);
		redirectAttributes.addFlashAttribute("messages", "Segmento cadastrado com sucesso!");
		
		return "redirect:/segmento";
	}
	
	@PutMapping("/{id}")
	public String editar(@PathVariable("id") long id,@Valid SegmentoModel segmentoModel,BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("segmentos",segmentoRepository.findAll());
		}
		
		segmentoModel.setIdSegment(id);
		segmentoRepository.save(segmentoModel);
		redirectAttributes.addFlashAttribute("messages", "Edi??o realizada com sucesso!");
		return "redirect:/segmento";
	}

	
	@DeleteMapping("/{id}")
	public String deleteId(@PathVariable("id") long id, RedirectAttributes redirectAttributes){
		segmentoRepository.deleteById(id);
		redirectAttributes.addFlashAttribute("messages", "Segmento excluido com sucesso!");
		return "redirect:/segmento";
	}
}
