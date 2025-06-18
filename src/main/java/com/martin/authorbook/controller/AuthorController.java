package com.martin.authorbook.controller;

import com.martin.authorbook.dto.AuthorRequestDTO;
import com.martin.authorbook.dto.AuthorResponseDTO;
import com.martin.authorbook.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDTO> createAuthor (@RequestBody AuthorRequestDTO authorRequestDTO) {
        AuthorResponseDTO responseDTO = authorService.save(authorRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }



}
