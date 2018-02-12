package org.BenchProject.Repository;

import java.util.List;

import org.BenchProject.Model.Names;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NameRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Names findById(long id) {
		Names names = null;

		try {
			names = jdbcTemplate.queryForObject("select * from Names where id=?", new Object[] { id },
					new BeanPropertyRowMapper<Names>(Names.class));

		} catch (EmptyResultDataAccessException e) {
			// e.printStackTrace();
		}
		return names;
	}

	public Names findByName(String name) {
		Names names = null;

		try {
			names = jdbcTemplate.queryForObject("select * from Names where name=?", new Object[] { name },
					new BeanPropertyRowMapper<Names>(Names.class));
		} catch (EmptyResultDataAccessException e) {
			// e.printStackTrace();
		}
		return names;
	}

	public List<Names> findAll() {
		return jdbcTemplate.queryForList("select * from Names", Names.class,
				new BeanPropertyRowMapper<Names>(Names.class));
	}

	public int insert(Names names) {
		return jdbcTemplate.update("insert into Names (name) " + "values(?)", new Object[] { names.getName() });
	}
}
