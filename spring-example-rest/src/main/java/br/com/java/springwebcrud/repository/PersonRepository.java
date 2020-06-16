package br.com.java.springwebcrud.repository;

import br.com.java.springwebcrud.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {

    private List<Person> people;
    private Long counter = Long.valueOf(0);

    public PersonRepository(){
        people = new ArrayList<Person>();
        people.add(new Person(0,"Luis", "Nascimento", 25, "558422222222") );
        people.add(new Person(1,"Bruno", "Pereira", 28, "558422222223") );
        counter = counter +1;
    }

    public List<Person> findAll() {
        return people;
    }

    public Person add(Person person){
        int id = this.people.size();
        this.counter = counter +1;
        person.setId(Math.toIntExact(counter));
        this.people.add(person);

        return person;
    }

    public Person remove(Long id) {
        int position = people.indexOf(findById(Math.toIntExact(id)));
        Person p = this.people.get(Math.toIntExact(position));
        people.remove(p);
        return p;
    }



    public Person update(Person person) {
        System.out.println(person);

        int position = people.indexOf(findById(person.getId()));

        //people.get(Math.toIntExact(oldPerson.getId())).setId(person.getId());
        people.get(Math.toIntExact(position)).setName(person.getName());
        people.get(Math.toIntExact(position)).setLastName(person.getLastName());
        people.get(Math.toIntExact(position)).setAge(person.getAge());
        people.get(Math.toIntExact(position)).setNumber(person.getNumber());

        return person;
    }

    public Person findById(int id){
        Person person = null;
        for(Person p: people){
            if(p.getId() == id){
                person = p;
            }
        }
        return person;
    }

    public Optional<Person> findPersonById(int id){
        Optional<Person> person = null;
        for(Person p: people){
            if(p.getId() == id){
                person = Optional.of(p);
            }
        }
        return person;
    }

    public Long findPosition(int id){
        long position = 0;
        for(Person p: people){
            position=position+1;
            if(p.getId() == id){
                break;
            }
        }
        return position;
    }
}
