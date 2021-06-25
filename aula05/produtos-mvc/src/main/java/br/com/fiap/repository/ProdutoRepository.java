package br.com.fiap.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.ProdutoModel;

@Repository
public class ProdutoRepository {
	
	private static final String GET_ALL = "SELECT * FROM TB_PRODUTO";
	private static final String SAVE = "INSERT INTO TB_PRODUTO (NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO) VALUES (?,?,?,?,?)";
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	private static Map<Long, ProdutoModel> produtos;
	
	private ProdutoRepository() {
	}

	public List<ProdutoModel> findAll() {
		List<ProdutoModel> produtos =  jdbcTemplate.query(GET_ALL,new BeanPropertyRowMapper<ProdutoModel>(ProdutoModel.class));
		
		return produtos;
	}

	public ProdutoModel findById(long id) {
		return produtos.get(id);
	}

	public void save(ProdutoModel produtoModel) {
		this.jdbcTemplate.update(SAVE,
				produtoModel.getNome(),
				produtoModel.getSku(),
				produtoModel.getDescricao(),
				produtoModel.getCaracteristicas(),
				produtoModel.getPreco());
	}
	
	public void update(ProdutoModel produtoModel) {
		produtos.put(produtoModel.getId(), produtoModel);
	}
	
	public void deleteById(long id) {
		produtos.remove(id);
	}
	
}
