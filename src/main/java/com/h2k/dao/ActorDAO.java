package com.h2k.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ActorDAO {

	// Spring Boot will create and configure DataSource and JdbcTemplate
	// To use it, just @Autowired
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public ActorDTO getActor(Integer id) {
		 	ActorDTO actor = null;
			try {
		      String SQL = "select * from Actor where actor_id = ?";
		      actor = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new ActorMapper());
			}catch(DataAccessException dex) {
				System.out.println("Data Access Exception :: " + dex.getMessage());
			}
	      return actor;
	   }
	
	public int updateActor(ActorDTO dto){
		String updateSQL = "Update Actor set first_name = \" " +  dto.getFirstName() + " \" where actor_id = " + dto.getActorId();
		int result = jdbcTemplate.update(updateSQL);
		return result;
	}
	
	
	public int insertActor(ActorDTO actor){
		String insertSQL = " INSERT INTO actor (actor_id,first_name, last_name, last_update) " + 
				"	VALUES (:actorid, :firstName, :lastName, CURRENT_TIMESTAMP)";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("actorid", actor.getActorId());
		paramMap.put("firstName", actor.getFirstName());
		paramMap.put("lastName", actor.getLastName());
		
		int rowsAffected = namedJdbcTemplate.update(insertSQL, paramMap);
		
		return rowsAffected;
		
		
		
	}

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	
}
