package com.mcgrandle.cpro2221_a1.utils;

import com.mcgrandle.cpro2221_a1.entity.Cat;

import java.util.List;

public class Validation
{
    public void Age(int age)
    {
        final int MIN = 1;
        final int MAX = 30;
        if (age < MIN || age > MAX)
        { throw new CustomException("Age must be between "+ MIN +" and "+ MAX +"."); }
    }

    public void Name(String name)
    {
        if (name == null || name.isEmpty())
        { throw new CustomException("Name cannot be null or empty!"); }
    }

    public void List(List<Cat> list)
    {
        if (list.isEmpty())
        { throw new CustomException("No cats in the database!"); }
    }

    public void Cat(Cat cat, int id)
    {
        if(cat == null)
        { throw new CustomException("Cat not found with id: " + id); }
    }
}
