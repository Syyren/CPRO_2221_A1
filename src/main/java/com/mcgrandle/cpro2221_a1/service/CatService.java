package com.mcgrandle.cpro2221_a1.service;

import com.mcgrandle.cpro2221_a1.entity.Cat;
import com.mcgrandle.cpro2221_a1.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatService
{
    //injecting the cat repository bean with the autowired annotation
    @Autowired
    private CatRepository catRepository;
    //method that passes the cat object to the repository and saves it
    public Cat saveCat(Cat cat) {
        return catRepository.save(cat);
    }
    //method that passes the cat id to the repository to pull a matching object
    public Cat getById(int id) {
        return catRepository.findById(id);
    }
    //method that pulls all cat objects from the repository
    public List<Cat> getAllCats() {
        return catRepository.getAllCats();
    }
}
