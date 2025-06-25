package com.martin.authorbook.controller;

import com.martin.authorbook.dto.book.BookRequestDTO;
import com.martin.authorbook.dto.book.BookResponseDTO;
import com.martin.authorbook.service.book.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook (@RequestBody BookRequestDTO book) {
        BookResponseDTO bookResponseDTO = service.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookResponseDTO);
    }
}
