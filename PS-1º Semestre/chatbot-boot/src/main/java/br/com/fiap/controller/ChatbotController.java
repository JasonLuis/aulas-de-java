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
import br.com.fiap.repository.ChatbotRepository;
import br.com.fiap.repository.SegmentRepository;
import br.com.fiap.repository.TriggerClass;

@Controller
@RequestMapping("/chatbot")
public class ChatbotController {
	
	private static final String CHATBOT_FOLDER = "chatbot/";
	
	@Autowired
	public ChatbotRepository chatbotRepository;
	
	@Autowired
	public SegmentRepository segmentoRepository;
	
	@Autowired
	public TriggerClass triggerClass;
	
	@GetMapping("/form")
	public String open(@RequestParam String page, 
					   @RequestParam(required = false) Long id,
					   @ModelAttribute("chatbotModel") ChatbotModel chatbotModel, 
					   Model model) {
		
		if("chatbot-editar".equals(page)) {
			model.addAttribute("chatbotModel", chatbotRepository.findById(id).get());
		}
		
		model.addAttribute("segmentos", segmentoRepository.findAll());
		
		return CHATBOT_FOLDER + page;
	}
	
	@GetMapping()
	public String findAll(Model model) {
		model.addAttribute("chatbots", chatbotRepository.findAll());
		return CHATBOT_FOLDER +  "chatbots";
	}
	
	@GetMapping("/{id}")
	public String detalhes(@PathVariable("id") long id, Model model) {
		model.addAttribute("chatbot", chatbotRepository.findById(id).get());
		return CHATBOT_FOLDER + "chatbot-detalhes";
	}
	
	@PostMapping()
	public String save(@Valid ChatbotModel chatbotModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("segmentos",segmentoRepository.findAll());
			return CHATBOT_FOLDER + "chatbot-novo";
		}
		
		ChatbotModel chatbot = chatbotRepository.save(chatbotModel);
		
		
		for(SegmentoModel segmento: chatbotModel.getSegmento()) {
			segmento.setChatbot(chatbot);
			segmentoRepository.save(segmento);
		}
		
		redirectAttributes.addFlashAttribute("messages", "Categoria cadastrada com sucesso!");
		
		return "redirect:/chatbot";
	}
	
	@PutMapping("/{id}")
	public String editar(@PathVariable("id") long id,@Valid ChatbotModel chatbotModel,BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
		if(bindingResult.hasErrors()) {
			model.addAttribute("segmentos",segmentoRepository.findAll());
		}
		
		triggerClass.update(id);
		chatbotModel.setIdBot(id);
		ChatbotModel chatbot = chatbotRepository.save(chatbotModel);
		
		for(SegmentoModel segmento: chatbotModel.getSegmento()) {
			segmento.setChatbot(chatbot);
			segmentoRepository.save(segmento);
		}
		
		redirectAttributes.addFlashAttribute("messages", "Edi??o realizada com sucesso!");
		return "redirect:/chatbot";
	}
	
	@DeleteMapping("/{id}")
	public String deleteId(@PathVariable("id") long id, RedirectAttributes redirectAttributes){
		triggerClass.update(id);
		chatbotRepository.deleteById(id);
		redirectAttributes.addFlashAttribute("messages", "Bot excluido com sucesso!");
		return "redirect:/chatbot";
	}
}
