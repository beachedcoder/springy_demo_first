package com.example.putnam.spbdemos.endpoints;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
    path = "/api/v1/author/",
    produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {
 //TODO build out URI
 //TODO add CRUD transactions for Author entity
 //TODO author transaction ultimately must end in peristence tier 


 // URI:: api/v1/author/current
 @GetMapping(path = "current")
 public ResponseEntity getAllCurrentAuthors() {
     return null;
 }  
}
