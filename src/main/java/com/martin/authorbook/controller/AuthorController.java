package com.martin.authorbook.controller;

import com.martin.authorbook.service.AuthorService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }



}
