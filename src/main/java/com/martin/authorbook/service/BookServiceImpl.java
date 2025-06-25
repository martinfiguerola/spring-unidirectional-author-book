package com.martin.authorbook.service;

import com.martin.authorbook.dto.BookRequestDTO;
import com.martin.authorbook.dto.BookResponseDTO;
import com.martin.authorbook.entity.Book;
import com.martin.authorbook.mapper.BookMapper;
import com.martin.authorbook.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookResponseDTO save(BookRequestDTO bookRequestDTO) {

        // Step 1: Receive the DTO and convert it into an entity
        Book book = BookMapper.fromDTO(bookRequestDTO);

        // Step 2: Persist the transformed entity in the database
        Book savedBook = repository.save(book);

        // Step 3: Convert the saved entity into a DTO and return it
        return BookMapper.toDTO(savedBook);
    }
}
