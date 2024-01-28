package com.mcgrandle.cpro2221_a1.controller;

import com.mcgrandle.cpro2221_a1.entity.Cat;
import com.mcgrandle.cpro2221_a1.service.CatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//routing all the maps to be under "/cat"
@RequestMapping("/cat")
public class Controller
{
    //declaring the catList and initializing catService
    private final CatService catService = new CatService();
    private List<Cat> catList;
    //inserts a new cat into the "db"
    @PostMapping("/create")
    public Cat createCat(@RequestBody Cat cat)
    {
        return catService.saveCat(cat);
    }
    //gets all cats in the "db"
    @GetMapping("search/all")
    public List<Cat> getAllCats() { return catService.getAllCats(); }
    //gets a cat from the "db" via its id
    @GetMapping("search/{catId}")
    public Cat getCatById(@PathVariable int catId) {
        return catService.getById(catId);
    }
    //endpoint that updates a cat that already exists in the "db"
    @PutMapping("/update/{catId}")
    public Cat updateCat(@PathVariable int catId, @RequestBody Cat updatedCat)
    {
        catList = getAllCats();
        for (Cat cat : catList)
        {
            if (cat.getId() == catId)
            {
                cat.setName(updatedCat.getName());
                cat.setAge(updatedCat.getAge());
                return cat;
            }
        }
        throw new RuntimeException("No cats found with id: " + catId + ".");
    }
    //deletes a cat from the "db" by id
    @DeleteMapping("/delete/{catId}")
    public String deleteCat(@PathVariable int catId)
    {
        catList = getAllCats();
        //add exception handling
        catList.removeIf(cat -> cat.getId() == catId);
        return "Cat " + catId + " has been deleted.";
    }
}
