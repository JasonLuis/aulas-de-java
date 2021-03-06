package br.com.fiap.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.fiap.model.SegmentoModel;

@Component
public class TriggerClass {
	
	private static final String UPDATE = "UPDATE TB_SEGMENT SET ID_BOT = NULL WHERE ID_BOT = ?";
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public TriggerClass() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void update(long id) {
		this.jdbcTemplate.update(UPDATE, id);
	}
	
}
