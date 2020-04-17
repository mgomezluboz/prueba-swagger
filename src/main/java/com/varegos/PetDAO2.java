package com.varegos;

import javax.sql.DataSource;

import org.apache.camel.Body;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varegos.dto.Pet;
import java.sql.Types;

public class PetDAO2 {
	
	protected DataSource dataSource;
	protected JdbcTemplate jdbc;
	
	public void insertPet(@Body Object body) {
		Pet pet = (Pet)body;
		
		jdbc = new JdbcTemplate(dataSource);
		
		jdbc.update("INSERT INTO Pet VALUES (?,?,?)", new Object[] {pet.getCategory().getId(), pet.getName(), pet.getStatus()}, new int[] {Types.INTEGER, Types.VARCHAR, Types.VARCHAR});
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
	}

	public PetDAO2(DataSource ds) {
		this.dataSource = ds;
	}

}
