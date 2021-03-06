package br.com.fiap.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.fiap.model.ProdutoModel;

public class ProdutoRepository {

	private static ProdutoRepository instance;
	
	private static Map<Long, ProdutoModel> produtos;
	
	public static ProdutoRepository getInstance() {
		
		if (instance == null) {
			instance = new ProdutoRepository();
		}
		return instance;
	}

	private ProdutoRepository() {

		produtos = new HashMap<Long, ProdutoModel>();

		produtos.put(1L, new ProdutoModel(1L, "Nome do Produto 1", "Sku-0001", "Descrição do produto 1", 1000.90,
				"Detalhes 1, 2, 4 do produto 1"));
		produtos.put(2L, new ProdutoModel(2L, "Nome do Produto 2", "Sku-0002", "Descrição do produto 2", 2000.90,
				"Detalhes 1, 2, 4 do produto 2"));
		produtos.put(3L, new ProdutoModel(3L, "Nome do Produto 3", "Sku-0003", "Descrição do produto 3", 3000.90,
				"Detalhes 1, 2, 4 do produto 3"));
		produtos.put(4L, new ProdutoModel(4L, "Nome do Produto 4", "Sku-0004", "Descrição do produto 4", 4000.90,
				"Detalhes 1, 2, 4 do produto 4"));
	}

	public ArrayList<ProdutoModel> findAll() {
		return new ArrayList<ProdutoModel>(produtos.values());
	}

	public ProdutoModel findById(long id) {
		return produtos.get(id);
	}
	
	public void save(ProdutoModel produtoModel) {
		Long newId = (long) (produtos.size() + 1);
		produtoModel.setId(newId);
		produtos.put(newId, produtoModel);
	}
	
	public void update(ProdutoModel produtoModel) {
		produtos.put(produtoModel.getId(), produtoModel);
	}
	
	public void deleteById(long id) {
		produtos.remove(id);
	}
	
}
