package com.example.mywebapplication;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "This is a test";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "WELCOME "+name;
    }

    @PostMapping("/qwueryting")
    @ResponseBody
    public String getID(@RequestParam(name="id") String fooId, @RequestParam String name){
        return "ID: "+fooId+" Name: "+name;
    }

}
