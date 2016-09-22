package cn.zjc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author zjc
 * @version 2016/9/23 0:13
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

	@Autowired
	@Qualifier(value = "primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate1;

	@Autowired
	@Qualifier(value = "secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate2;

	@Before
	public void Setup() {
		jdbcTemplate1.update("DELETE FROM USER");
		jdbcTemplate2.update("DELETE FROM USER");
	}

	@Test
	public void TestMultiDataSource() {


		jdbcTemplate1.update("INSERT INTO user(name,age) VALUES(?,?)", new Object[]{"zjc", 23}); //插入主数据库

		jdbcTemplate2.update("INSERT INTO user(name,age) VALUES(?,?)", new Object[]{"zjc", 23}); //插入从数据库
		jdbcTemplate2.update("INSERT INTO user(name,age) VALUES(?,?)", new Object[]{"pp", 4});

		assertEquals("1", jdbcTemplate1.queryForObject("SELECT COUNT(1) FROM user", String.class));
		assertEquals("2", jdbcTemplate2.queryForObject("SELECT COUNT(1) FROM user", String.class));
	}
}
