package br.com.java.springwebcrud.controller;


import br.com.java.springwebcrud.model.Person;
import br.com.java.springwebcrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/")
    public ModelAndView person(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("allPeople", repository.findAll());
        return modelAndView;
    }

    @GetMapping("/new-person")
    public String createPerson(Model model){
        model.addAttribute("person", new Person());
        return "new-person";
    }

    @PostMapping("/index")
    public String createPerson(@Valid @ModelAttribute Person person, BindingResult result, RedirectAttributes redirect){

        if(result.hasErrors()){
            System.out.println("tem erros");
            return "new-person";
        }

        repository.add(person);
        redirect.addFlashAttribute("message", "Person successfully saved!");

        return "redirect:/";
    }

}
