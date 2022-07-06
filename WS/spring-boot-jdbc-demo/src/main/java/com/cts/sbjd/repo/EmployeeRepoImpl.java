package com.cts.sbjd.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.sbjd.model.Employee;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private static final String GET_ALL_QRY = "SELECT * FROM emps";
	private static final String GET_BY_ID_QRY = "SELECT * FROM emps WHERE eid=:empId";
	private static final String INS_QRY = "INSERT INTO emps VALUES(:empId,:fullName,:salary)";
	private static final String UPD_QRY = "UPDATE emps SET fnm=:fullName,sal=:salary WHERE eid=:empId";
	private static final String DEL_BY_ID_QRY = "DELETE FROM emps WHERE eid=:empId";

	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query(GET_ALL_QRY,
				(rs, rowNum) -> (new Employee(rs.getLong(1), rs.getString(2), rs.getDouble(3))));
	}

	@Override
	public Employee findById(long empId) {
		return jdbcTemplate.queryForObject(GET_BY_ID_QRY,
				new MapSqlParameterSource("empId", empId),
				(rs, rowNum) -> (new Employee(rs.getLong(1), rs.getString(2), rs.getDouble(3))));
	}

	@Override
	public Employee add(Employee emp) {
		jdbcTemplate.update(INS_QRY, new BeanPropertySqlParameterSource(emp));
		return emp;
	}

	@Override
	public Employee update(Employee emp) {
		jdbcTemplate.update(UPD_QRY, new BeanPropertySqlParameterSource(emp));
		return emp;
	}

	@Override
	public void deleteById(long empId) {
		jdbcTemplate.update(DEL_BY_ID_QRY, new MapSqlParameterSource("empId", empId));
	}

}
