package com.springlearning.springbootessentials.api;

import com.springlearning.springbootessentials.model.Person;
import com.springlearning.springbootessentials.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  public void addPerson(@RequestBody Person person) {
    personService.addPerson(person);
  }

  @GetMapping
  public List<Person> getAllPeople() {
    return personService.getAllPeople();
  }

  @GetMapping(path = "{id}")
  public Optional<Person> getPersonById(@PathVariable("id") UUID id) {
    return personService.getPersonById(id);
  }

  @DeleteMapping("{id}")
  public void deletePersonById(@PathVariable UUID id) {
    personService.deletePerson(id);
  }

  @PutMapping("{id}")
  public void updatePerson(@PathVariable UUID id,
                           @RequestBody @Valid @NotNull Person personToUpdate) {
    personService.updatePersonById(id, personToUpdate);
  }
}
