package br.com.fiap.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.ProdutoModel;
import br.com.fiap.repository.rowmapper.ProdutoRowMapper;

@Repository
public class ProdutoRepository {
	
	private static final String FIND_ALL = "SELECT * FROM TB_PRODUTO P "
			+ "INNER JOIN TB_CATEGORIA C ON P.ID_CATEGORIA=C.ID_CATEGORIA "
			+ "ORDER BY P.ID";
	private static final String FIND_BY_ID = "SELECT * FROM TB_PRODUTO P \n" + 
			"INNER JOIN TB_CATEGORIA C ON\n" + 
			"P.ID_CATEGORIA=C.ID_CATEGORIA WHERE P.ID=?";
	private static final String SAVE = "INSERT INTO TB_PRODUTO (NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE TB_PRODUTO SET NOME = ?, SKU = ?, DESCRICAO = ?, CARACTERISTICAS = ?, PRECO = ? WHERE ID = ?";
	private static final String DELETE_BY_ID = "DELETE FROM TB_PRODUTO WHERE ID = ?";
	
	@Autowired
	public JdbcTemplate jdbcTemplate;

	public ProdutoRepository() {
	}

	public List<ProdutoModel> findAll() {

		List<ProdutoModel> produtos = this.jdbcTemplate.query(FIND_ALL, new ProdutoRowMapper());
		return produtos;
	}

	public ProdutoModel findById(long id) {

		ProdutoModel produto = this.jdbcTemplate.queryForObject(FIND_BY_ID, new BeanPropertyRowMapper<ProdutoModel>(ProdutoModel.class), id);
		return produto;
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
		this.jdbcTemplate.update(UPDATE, 
				produtoModel.getNome(), 
				produtoModel.getSku(), 
				produtoModel.getDescricao(),
				produtoModel.getCaracteristicas(), 
				produtoModel.getPreco(), 
				produtoModel.getId());
	}

	public void deleteById(long id) {
		this.jdbcTemplate.update(DELETE_BY_ID, id);
	}
	
}
