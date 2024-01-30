package com.mcgrandle.cpro2221_a1.controller;

import com.mcgrandle.cpro2221_a1.entity.Cat;
import com.mcgrandle.cpro2221_a1.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//routing all the maps to be under "/cat"
@RequestMapping("/cat")
public class Controller
{
    //injecting catService bean to interface with the controller and repository
    @Autowired
    private final CatService catService = new CatService();

    //inserts a new cat into the "db" via the service
    @PostMapping("/create")
    public Cat createCat(@RequestBody Cat cat)
    {
        return catService.saveCat(cat);
    }
    //gets all cats in the "db" from the service
    @GetMapping("/search/all")
    public List<Cat> getAllCats() { return catService.getAllCats(); }
    //endpoint that gets a cat from the "db" via its id from the service
    @GetMapping("search/{catId}")
    public Cat getCatById(@PathVariable int catId) {
        return catService.getById(catId);
    }
    //endpoint that updates a cat that already exists in the "db" through the service
    @PutMapping("/update/{catId}")
    public Cat updateCat(@PathVariable int catId, @RequestBody Cat updatedCat) { return catService.updateCat(catId, updatedCat); }
    //endpoint that deletes a cat from the "db" by id via the service
    @DeleteMapping("/delete/{catId}")
    public String deleteCat(@PathVariable int catId) { return catService.delCat(catId); }
}
