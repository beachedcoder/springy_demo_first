package com.example.putnam.spbdemos.endpoints;

import com.example.putnam.spbdemos.domain.Author;
import com.example.putnam.spbdemos.svcs.AuthorPersistenceServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

 private final AuthorPersistenceServiceImpl authSvc;

 public AuthorController(AuthorPersistenceServiceImpl svcRef) {
     this.authSvc = svcRef;
 }

 // URI:: api/v1/author/current
 @GetMapping(path = "current")
 public ResponseEntity getAllCurrentAuthors() {
     return new ResponseEntity(this.authSvc.getCurrentAuthorRoster(), HttpStatus.OK);
 }

 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Author> addNuewAuthor(@RequestBody Author writer) {
    //TODO add logic pre svc call
    //      then return updated json response
    return null;
}
 
 

}
