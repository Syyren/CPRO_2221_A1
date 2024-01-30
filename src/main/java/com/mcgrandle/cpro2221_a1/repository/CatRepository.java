package com.mcgrandle.cpro2221_a1.repository;

import com.mcgrandle.cpro2221_a1.entity.Cat;
import com.mcgrandle.cpro2221_a1.utils.Validation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CatRepository
{
    //initializing the cat counter to track inputted ids in ascending order as they're entered automatically
    private int catCounter = 1;
    //initializing a list to hold the cat objects in
    private final Validation validate = new Validation();
    private final List<Cat> list = new ArrayList<>();
    //method that returns all cat objects in the list
    public List<Cat> getAllCats()
    {
        validate.List(list);
        return list;
    }
    //method that filters through the cat list by id and returns either a match or null
    public Cat findById(int id)
    {
        Cat cat = list.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElse(null);
        validate.Cat(cat, id);
        return cat;
    }
    //method that saves a cat object to the list
    public Cat save(Cat cat)
    {
        validate.Age(cat.getAge());
        validate.Name(cat.getName());
        cat.setId(catCounter++);
        list.add(cat);
        return cat;
    }
    //method that updates and returns an updated cat
    public Cat update(int id, Cat update)
    {
        validate.Name(update.getName());
        validate.Age(update.getAge());
        Cat cat = list.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElse(null);
        validate.Cat(cat, id);
        cat.setName(update.getName());
        cat.setAge(update.getAge());
        return cat;
    }
    //method that takes in a cat id, checks if it's in the repository, then deletes if so
    public String delete(int id)
    {
        Cat cat = list.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElse(null);
        validate.Cat(cat, id);
        list.removeIf(c -> c.getId() == id);
        return "Cat with id: " + id + " removed successfully.";
    }
}
