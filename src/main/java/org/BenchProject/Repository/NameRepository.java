package org.BenchProject.Repository;

import java.util.List;

import org.BenchProject.Model.Names;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class NameRepository implements INames {

	private static final Logger logger = LoggerFactory.getLogger(NameRepository.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addNames(Names names) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(names);
		logger.info("Name saved succesfully. Details: " + names);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Names> listAllNames() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Names> namesList = session.createQuery("from Names").list();
		for (Names n : namesList) {
			logger.info("Names List: " + n);
		}
		return namesList;
	}

	// @Autowired
	// JdbcTemplate jdbcTemplate;
	//
	// public Names findById(long id) {
	// Names names = null;
	//
	// try {
	// names = jdbcTemplate.queryForObject("select * from Names where id=?", new
	// Object[] { id },
	// new BeanPropertyRowMapper<Names>(Names.class));
	//
	// } catch (EmptyResultDataAccessException e) {
	// // e.printStackTrace();
	// }
	// return names;
	// }
	//
	// public Names findByName(String name) {
	// Names names = null;
	//
	// try {
	// names = jdbcTemplate.queryForObject("select * from Names where name=?", new
	// Object[] { name },
	// new BeanPropertyRowMapper<Names>(Names.class));
	// } catch (EmptyResultDataAccessException e) {
	// // e.printStackTrace();
	// }
	// return names;
	// }
	//
	// public List<Names> findAll() {
	// return jdbcTemplate.queryForList("select * from Names", Names.class,
	// new BeanPropertyRowMapper<Names>(Names.class));
	// }
	//
	// public int insert(Names names) {
	// return jdbcTemplate.update("insert into Names (name) " + "values(?)", new
	// Object[] { names.getName() });
	// }
}
