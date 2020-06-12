package br.com.java.springwebcrud.repository;

import br.com.java.springwebcrud.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private List<Person> people;

    public PersonRepository(){
        people = new ArrayList<Person>();
        people.add(new Person(1,"Luis", "Nascimento", 25, "558422222222") );
        people.add(new Person(2,"Bruno", "Pereira", 28, "558422222223") );
    }

    public List<Person> findAll() {
        return people;
    }

    public void add(Person person){
        this.people.add(person);
    }
}
