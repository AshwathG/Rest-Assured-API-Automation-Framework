package com.demo.util;

import com.github.javafaker.Faker;

public class FakerUtils {
	
	// method to generate random name

    public static String generateName(){
        Faker faker = new Faker();
        return "Demo " + faker.regexify("[A-Za-z0-9 ,_-]{10}");
    }
    
    // method to generate random description

    public static String generateDescription(){
        Faker faker = new Faker();
        return "Description " + faker.regexify("[ A-Za-z0-9_@./#&+-]{50}");
    }
}
