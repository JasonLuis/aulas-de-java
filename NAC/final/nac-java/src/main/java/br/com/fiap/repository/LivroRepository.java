package br.com.fiap.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import br.com.fiap.model.LivroModel;

public class LivroRepository {
	
	private static  LivroRepository instance;
	private static Map<Long, LivroModel> livros;
	
	public static LivroRepository getInstance() {
		
		if(instance == null) {
			instance = new LivroRepository();
		}
		return instance;
	
	}
	
	private LivroRepository() {
		livros = new HashMap<Long, LivroModel>();
		livros.put(1L, new LivroModel(1L, 
				"O cavaleiro",
				"Geronimo", "10/10/2000", 50.50, "Ação", "Bom de mais"));
		livros.put(2L, new LivroModel(2L, 
				"O cavaleiro 2",
				"Geronimo", "10/10/2001", 50.50, "Ação", "Bom de mais"));
	}
	
	public ArrayList<LivroModel> findAll(){
		return new ArrayList<LivroModel>(livros.values());
	}
	
	public LivroModel findById(long id){
		return livros.get(id);
	}
	
	public void create(LivroModel livroModel) {
		Long newId = (long) (livros.size() + 1);
		livroModel.setId(newId);
		livros.put(newId, livroModel);
	}

	public void deleteById(long id) {
		livros.remove(id);
	}

	public void update(@Valid LivroModel livroModel) {
		livros.put(livroModel.getId(), livroModel);
	}
}
