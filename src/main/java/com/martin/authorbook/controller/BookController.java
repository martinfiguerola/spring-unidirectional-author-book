package com.martin.authorbook.controller;

import com.martin.authorbook.dto.book.BookRequestDTO;
import com.martin.authorbook.dto.book.BookResponseDTO;
import com.martin.authorbook.service.book.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook (@Valid @RequestBody BookRequestDTO book) {
        BookResponseDTO bookResponseDTO = service.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBook (@PathVariable Long id) {
        return service.findById(id)
                .map(book -> ResponseEntity.status(HttpStatus.OK).body(book))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getBooks () {
        List<BookResponseDTO> bookResponseDTOS = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(bookResponseDTOS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook (@Valid @PathVariable Long id, @RequestBody BookRequestDTO bookRequestDTO) {
        Optional<BookResponseDTO> optionalBookResponseDTO = service.update(id, bookRequestDTO);
        return optionalBookResponseDTO
                .map( responseDTO ->  ResponseEntity.status(HttpStatus.OK).body(responseDTO))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook (@PathVariable Long id) {
        if(service.deleteById(id)) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with the given ID does not exist.");
    }
}
