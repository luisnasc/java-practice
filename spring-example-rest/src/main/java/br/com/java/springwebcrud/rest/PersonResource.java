package br.com.java.springwebcrud.rest;

import br.com.java.springwebcrud.exception.PersonNotFoundException;
import br.com.java.springwebcrud.model.Person;
import br.com.java.springwebcrud.repository.PersonRepository;
import br.com.java.springwebcrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonResource {

    @Autowired
    private PersonService service;

    @GetMapping("/api/person")
    public List<Person> getAllPeople(){
        return service.findAll();
    }

    @GetMapping("/api/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") final Long id){
        final Person person = service.findPersonById(Math.toIntExact(id));
        return ResponseEntity.ok(person);
    }

    @PostMapping("/api/person")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@Valid @RequestBody Person person){
        return service.add(person);
    }

    @PutMapping("/api/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") final Long id, @Valid @RequestBody Person personDTO){
        return ResponseEntity.ok(service.update(id, personDTO));
    }

    @DeleteMapping("/api/person/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable("id") final Long id){
        service.remove(id);
    }
}
