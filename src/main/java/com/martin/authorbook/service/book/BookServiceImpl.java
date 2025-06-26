package com.martin.authorbook.service.book;

import com.martin.authorbook.dto.book.BookRequestDTO;
import com.martin.authorbook.dto.book.BookResponseDTO;
import com.martin.authorbook.entity.Book;
import com.martin.authorbook.mapper.BookMapper;
import com.martin.authorbook.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

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

    @Override
    public Optional<BookResponseDTO> findById(Long id) {

        Optional<Book> optionalBook = repository.findById(id);

        return optionalBook.map(BookMapper::toDTO);
    }

    @Override
    public List<BookResponseDTO> findAll() {

        List<Book> books = repository.findAll();

        return books.stream()
                .map(BookMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<BookResponseDTO> update(Long id, BookRequestDTO bookRequestDTO) {
        Optional<Book> optionalBook = repository.findById(id);

        return optionalBook.map(book -> {
            book.setTitle(bookRequestDTO.getTitle());
            book.setIsbn(bookRequestDTO.getIsbn());

            Book savedBook = repository.save(book);

            return BookMapper.toDTO(savedBook);
        });
    }

    @Override
    public Boolean deleteById(Long id) {
        Optional<Book> optionalBook = repository.findById(id);

        return optionalBook.map(book -> {
            repository.delete(book);
            return true;
        }).orElse(false);

    }
}
