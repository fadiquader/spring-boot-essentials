package com.springlearning.springbootessentials.dao;

import com.springlearning.springbootessentials.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertPerson(UUID id, Person person) {
    final String SQL = "INSERT INTO person (id, name) VALUES (?, ?)";
    jdbcTemplate.update(SQL, id, person.getName());
    return 0;
  }

  @Override
  public List<Person> selectAllPeople() {
    final String SQL = "SELECT id, name FROM person";
    return jdbcTemplate.query(SQL, (resultSet, i) -> {
      UUID id = UUID.fromString(resultSet.getString("id"));
      return new Person(
          id,
          resultSet.getString("name")
      );
    });
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    final String SQL = "SELECT * FROM person WHERE id = ?";
    Person person = jdbcTemplate.queryForObject(SQL, new Object[]{id}, (resultSet, i) -> {
      UUID personId = UUID.fromString(resultSet.getString("id"));
      return new Person(
          personId,
          resultSet.getString("name")
      );
    });

    return Optional.ofNullable(person);
  }

  @Override
  public int deletePersonById(UUID id) {
    return 0;
  }

  @Override
  public int updatePersonById(UUID id, Person person) {
    return 0;
  }
}
