package com.mcgrandle.cpro2221_a1.repository;

import com.mcgrandle.cpro2221_a1.entity.Cat;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CatRepository
{
    //initializing the cat counter to track inputted ids in ascending order as they're entered automatically
    private int catCounter = 1;
    //initializing a list to hold the cat objects in
    private final List<Cat> list = new ArrayList<>();
    //method that returns all cat objects in the list
    public List<Cat> getAllCats() {
        return list;
    }
    //method that filters through the cat list by id and returns either a match or null
    public Cat findById(int id)
    {
        return list.stream()
                .filter(cat -> cat.getId() == id)
                .findAny()
                .orElse(null);
    }
    //method that saves a cat object to the list
    public Cat save(Cat cat)
    {
        cat.setId(catCounter++);
        list.add(cat);
        return cat;
    }
    //method that updates and returns an updated cat
    public Cat update(int id, Cat update)
    {
        Cat cat = list.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElse(null);
        if (cat == null) { throw new RuntimeException("Cat not found with id: " + id); }
        cat.setName(update.getName());
        cat.setAge(update.getAge());
        return cat;
    }
    //method that takes in a cat id, checks if it's in the repository, then deletes if so
    public String delete(int id)
    {
        boolean removed = list.removeIf(cat -> cat.getId() == id);
        if (!removed) { throw new RuntimeException("Cat not found with id: " + id); }
        return "Cat " + id + " removed successfully.";
    }
}
