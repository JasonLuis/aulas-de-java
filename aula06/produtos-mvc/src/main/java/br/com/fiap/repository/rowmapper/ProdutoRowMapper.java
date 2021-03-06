package br.com.fiap.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.model.CategoriaModel;
import br.com.fiap.model.ProdutoModel;

public class ProdutoRowMapper implements RowMapper<ProdutoModel>{

	@Override
	public ProdutoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		ProdutoModel produtoModel = new BeanPropertyRowMapper<>(ProdutoModel.class).mapRow(rs, rowNum);
		CategoriaModel categoriaModel = new BeanPropertyRowMapper<>(CategoriaModel.class).mapRow(rs, rowNum);
		
		produtoModel.setCategoria(categoriaModel);
		return produtoModel;
	}
	
	
	
}
