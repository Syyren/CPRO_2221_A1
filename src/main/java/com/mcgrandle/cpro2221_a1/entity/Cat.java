package com.mcgrandle.cpro2221_a1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//using the lombok plugin to create my constructors easily.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat
{
    //declaring the cat class attributes.
    private int id;
    private String name;
    private int age;
}
