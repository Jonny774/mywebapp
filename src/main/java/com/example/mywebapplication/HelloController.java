package com.example.mywebapplication;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    // https://spring.io/guides/gs/spring-boot
    // https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_spring_cloud_config_server
    // https://www.baeldung.com/spring-boot-yaml-vs-properties

    //Path variable examples
    // https://www.baeldung.com/spring-pathvariable
    //Accessed by using curl localhost:8080/ in terminal
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


    // Examples are taken from:
    // https://www.baeldung.com/spring-request-param

    //RequestParam annotation examples
    // we can use @RequestParam to extract query parameters,
    //from parameters, and even files from the request.

    //Example 1 - Simple Mapping
    //We use @RequestParam to extract the id quert parameter
    //A simple GET request would invoke getFoos
    // http://localhost:8080/api/example1?id=90
    @GetMapping("/api/example1")
    @ResponseBody
    public String getFoos(@RequestParam String id) {
        return "ID: "+id;
    }


    //Example 2 - Specifying the Request Parameter Name
    //in previous example, both the variable name and parameter name are the same
    //sometimes we want these to be different though
    //we can configure the @RequestParam name using the name attribute
    // http://localhost:8080/api/example2?id=96&name=jonny
    @GetMapping("/api/example2")
    @ResponseBody
    public String getID(@RequestParam(name="id") String fooId, @RequestParam String name){
        return "ID: "+fooId+" Name: "+name;
    }

    //Tried changing the endpoint to /example1 and 2 but it didnt work
    //what is the correct way to use the name variable (not having a long id string)

    //Example 3 - Optional Request Parameters
    //Method parameters annotated with @RequestParam are required by defualt
    //This means that is the parameter isn't present in the request, error
    //When a parameter isn't specified, the method parameter is bound to null.
    // http://localhost:8080/api/example3?id=96
    // if there is no id, ID=null
    @GetMapping("/api/example3")
    @ResponseBody
    public String getFoos2(@RequestParam(required = false) String id) {
        return "ID: " + id;
    }


    //Example 4 - Default value for the Request Parameter
    //we can also set a default value to the @RequestParam
    //by using the defualtValue attribute
    // http://localhost:8080/api/example4?id=96
    // if there is no id, ID=test
    @GetMapping("/api/example4")
    @ResponseBody
    public String getFoos3(@RequestParam(defaultValue = "test") String id) {
        return "ID: "+id;
    }


    //Example 5 - Mapping all parameters
    //We can also have multiple parameters without defining their names
    // or count just by using a Map
    // http://localhost:8080/api/example5?id=96
    // curl -X POST -F 'name=abc' -F 'id=123' http://localhost:8080/api/example5?id=96

    @GetMapping("/api/example5")
    @ResponseBody
    public String updateFoos(@RequestParam Map<String,String> allParams) {
        return "Parameters are "+allParams.entrySet();
    }

    //Example 6 - Mapping a Multi-Value Parameter
    //a single @RequestParam can have multiple values
    // http://localhost:8080/api/example6?id=1,2,3
    // http://localhost:8080/api/example6?id=1&id=2
    @GetMapping("/api/example6")
    @ResponseBody
    public String getFoos(@RequestParam List<String> id) {
        return "IDs are " + id;
    }



}
