package com.h2k.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ActorMapper implements RowMapper<ActorDTO>{

	public ActorDTO mapRow(ResultSet rs, int row) throws SQLException {
		ActorDTO actor = new ActorDTO();
		if(rs != null) {
			actor.setActorId(rs.getInt("actor_id"));
			actor.setFirstName(rs.getString("first_name"));
			actor.setLastName(rs.getString("last_name"));
			actor.setLastUpdate(rs.getTimestamp("last_update"));
		}
		return actor;
	}
}
