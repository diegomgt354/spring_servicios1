package com.example.servicios.servicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/developers")
public class DeveloperController {

    private static final List<Developer> developers = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong();

    public DeveloperController() {
        initData();
    }

    private void initData() {
        developers.add(new Developer(contador.incrementAndGet(), "Diego Gutierrez", 15,
                new ArrayList<>(Arrays.asList("Python", "javaScript", "Java"))));

        developers.add(new Developer(contador.incrementAndGet(), "Elizeth Rojas", 18,
                new ArrayList<>(Arrays.asList("PHP", "javaScript", "Kotlin"))));
    }

    @GetMapping
    public ResponseEntity<List<Developer>> listDevelopers() {
        return new ResponseEntity<>(developers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> findByDeveloperForId(@PathVariable long id) {
        Developer developer = developers.stream().filter(d -> id == d.getId()).findAny().orElse(null);
        HttpStatus estate = (developer != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(developer, estate);
    }

    @PostMapping
    public ResponseEntity<Developer> registerDeveloper(@RequestBody Developer dev) {
        Developer developer = new Developer(contador.incrementAndGet(),
                dev.getName(), dev.getAge(), dev.getLanguage());
        developers.add(developer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("developers", "api/developers/" + developer.getId());
        return new ResponseEntity<>(developer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Developer> updateDeveloper(
            @PathVariable long id, @RequestBody Developer dev) {
        Developer developerTemp = null;
        for (Developer developer : developers) {
            if (developer.getId() == id) {
                developer.setName(dev.getName());
                developer.setAge(dev.getAge());
                developer.setLanguage(dev.getLanguage());
                developerTemp = developer;
                break;
            }
        }
        return new ResponseEntity<>(developerTemp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Developer> deleteDeveloper(@PathVariable long id) {
        Developer developer = developers.stream().filter(d -> id == d.getId()).findAny().orElse(null);
        if (developer != null)
            developers.remove(developer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
