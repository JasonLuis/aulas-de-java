package br.com.fiap.controller;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.model.ProdutoModel;
import br.com.fiap.repository.CategoriaRepository;
import br.com.fiap.repository.MarcaRepository;
import br.com.fiap.repository.ProdutoRepository;

@RestController
@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	private static final String PRODUTO_FOLDER = "produto/";
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@Autowired
	public MarcaRepository marcaRepository;
	
	@GetMapping()
	public ResponseEntity<List<ProdutoModel>> findAll(Model model) {
		List<ProdutoModel> produtos = produtoRepository.findAll();
		//model.addAttribute("produtos", produtoRepository.findExpensiveProductsByCategory(new BigDecimal(1), "Notebook"));
		return ResponseEntity.ok(produtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> findById(@PathVariable("id") long id) {
		
		ProdutoModel produto = produtoRepository.findById(id).get();
		return ResponseEntity.ok(produto);
	}
	
	@PostMapping()
	public ResponseEntity save(@RequestBody @Valid ProdutoModel produtoModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		@Valid
		ProdutoModel produto = produtoRepository.save(produtoModel);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(produto.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable("id") long id,@RequestBody @Valid ProdutoModel produtoModel, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		produtoModel.setId(id);
		produtoRepository.save(produtoModel);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable("id") long id) {
		
		produtoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
