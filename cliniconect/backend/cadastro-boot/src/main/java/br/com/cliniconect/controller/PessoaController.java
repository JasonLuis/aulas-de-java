package br.com.cliniconect.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cliniconect.exception.ResponseBusinessException;
import br.com.cliniconect.model.PessoaModel;
import br.com.cliniconect.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@CrossOrigin
	@GetMapping()
	public ResponseEntity findAll(Model model) {
		List<PessoaModel> pessoa = pessoaRepository.findAll();
		
		return ResponseEntity.ok(pessoa);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable("id") long id, Model model) {
		PessoaModel pessoa = pessoaRepository.findById(id).get();
		
		return ResponseEntity.ok(pessoa);
	}
	
	@CrossOrigin
	@PostMapping()
	public ResponseEntity create(@RequestBody @Valid PessoaModel pessoaModel) throws ResponseBusinessException{
		PessoaModel pessoa = pessoaRepository.save(pessoaModel);
		
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/id").buildAndExpand(pessoa.getId()).toUri();
		
		
		return ResponseEntity.ok(pessoaRepository.findById(pessoa.getId()).get());
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity update (@PathVariable("id") long id,
			@RequestBody @Valid PessoaModel pessoaModel) {
		pessoaModel.setId(id);
		pessoaRepository.save(pessoaModel);
		
		return ResponseEntity.ok(pessoaRepository.findById(pessoaModel.getId()).get());
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") long id) {
		pessoaRepository.deleteById(id);
	
		return ResponseEntity.noContent().build();
	}
}
