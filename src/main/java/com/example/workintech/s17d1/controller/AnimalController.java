package com.example.workintech.s17d1.controller;

import com.example.workintech.s17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {

    Map<Integer, Animal> animals;

    @PostConstruct
    public void loadAll(){
        this.animals = new HashMap<>();
        this.animals.put(1,new Animal(1,"maymun"));
    }

    @GetMapping(path = "/workintech/animal")
    public List<Animal> getAnimals(){
        return new ArrayList<>(this.animals.values());
    }
    @GetMapping(path = "workintech/animal/{id}")
    public Animal getAnimal(@PathVariable("id") Integer id){
        if(id==null){
            return null;
        }
        return this.animals.get(id);
    }

    @PostMapping(path = "/workintech/animal")
    public void addAnimal(@RequestBody Animal animal ){
        if(animal.getId() == null || animal.getName() == null){
            return ;

        }
        this.animals.put(animal.getId(), animal);
        this.animals.get(animal.getId());
    }

    @PutMapping(path = "workintech/animal/{id}")
    public Animal updateAnimals(@PathVariable("id") Integer existingRecordId, @RequestBody Animal newAnimal){
         this.animals.replace(existingRecordId,newAnimal);
         return this.animals.get(existingRecordId);
    }

    @DeleteMapping(path = "/workintech/animal/{id}")
    public void deleteAnimals(@PathVariable("id") Integer id){
        this.animals.remove(id);

    }
}
