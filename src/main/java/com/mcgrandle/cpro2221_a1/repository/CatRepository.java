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
}
