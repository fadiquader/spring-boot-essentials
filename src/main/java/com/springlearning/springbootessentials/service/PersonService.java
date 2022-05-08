package com.springlearning.springbootessentials.service;

import com.springlearning.springbootessentials.dao.PersonDao;
import com.springlearning.springbootessentials.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
  private final PersonDao personDao;

  @Autowired
  public PersonService(
//      @Qualifier("fakeDao") PersonDao personDao
      @Qualifier("postgres") PersonDao personDao
  ) {
    this.personDao = personDao;
  }

  public int addPerson(Person person) {
    return this.personDao.insertPerson(person);
  }

  public List<Person> getAllPeople() {
    return this.personDao.selectAllPeople();
  }

  public Optional<Person> getPersonById(UUID id) {
    return personDao.selectPersonById(id);
  }

  public int deletePerson(UUID id) {
    return personDao.deletePersonById(id);
  }

  public int updatePersonById(UUID id, Person newPerson) {
    return personDao.updatePersonById(id, newPerson);
  }
}
