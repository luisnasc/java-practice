package br.com.java.springwebcrud.service;

import br.com.java.springwebcrud.exception.PersonNotFoundException;
import br.com.java.springwebcrud.model.Person;
import br.com.java.springwebcrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findPersonById(int id) {

        final Optional<Person> person = repository.findPersonById(id);

        if(person.isPresent()) {
            return person.get();
        }else{
            throw new PersonNotFoundException();
        }

    }


    public Person add(Person person) {
        return  repository.add(person);
    }


    public Person update(Long id, Person personDTO) {
        final Optional<Person> personEntity = repository.findPersonById(Math.toIntExact(id));

        if(personEntity.isPresent()){
            repository.update(personDTO);
        }else {
            throw new PersonNotFoundException();
        }
        return  personDTO;
    }

    public void remove(Long id) {
        final Optional<Person> personEntity = repository.findPersonById(Math.toIntExact(id));
        if(personEntity.isPresent()) {
            repository.remove(id);
        }else{
            throw new PersonNotFoundException();
        }
    }
}
