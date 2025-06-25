package com.martin.authorbook.controller;

import com.martin.authorbook.dto.author.AuthorBookResponseDTO;
import com.martin.authorbook.dto.author.AuthorRequestDTO;
import com.martin.authorbook.dto.author.AuthorResponseDTO;
import com.martin.authorbook.service.author.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDTO> createAuthor (@Valid @RequestBody AuthorRequestDTO authorRequestDTO) {
        AuthorResponseDTO responseDTO = authorService.save(authorRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDTO>> getAll () {
        List<AuthorResponseDTO> responseDTOS = authorService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorBookResponseDTO> getOne (@PathVariable Long id) {
        return authorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor (@PathVariable Long id) {
        if (authorService.deleteById(id)) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with the given ID does not exist.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> updateAuthor (@PathVariable Long id, @RequestBody AuthorRequestDTO authorRequestDTO) {
        return authorService.update(id, authorRequestDTO)
                .map(authorResponseDTO -> ResponseEntity.status(HttpStatus.OK).body(authorResponseDTO))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}
