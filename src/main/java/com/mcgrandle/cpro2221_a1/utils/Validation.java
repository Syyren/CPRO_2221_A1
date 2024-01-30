package com.mcgrandle.cpro2221_a1.utils;

import com.mcgrandle.cpro2221_a1.entity.Cat;

import java.util.List;

public class Validation
{
    public void Age(int age)
    {
        if (age < 0) { throw new CustomException("Age cannot be less than zero."); }
        if (age >= 30) { throw new CustomException("Age cannot be greater than 30."); }
    }

    public void Name(String name)
    {
        if (name == null) { throw new CustomException("Name cannot be null!"); }
        if (name.isEmpty()) { throw new CustomException("Name cannot be empty!"); }
    }

    public void List(List<Cat> list)
    {
        if (list.isEmpty()) { throw new CustomException("No cats in the database!"); }
    }

    public void Cat(Cat cat, int id)
    {
        if(cat == null) { throw new CustomException("Cat not found with id: " + id); }
    }
}
