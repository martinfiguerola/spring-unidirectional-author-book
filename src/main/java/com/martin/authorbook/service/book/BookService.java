package com.martin.authorbook.service.book;

import com.martin.authorbook.dto.book.BookRequestDTO;
import com.martin.authorbook.dto.book.BookResponseDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {

    BookResponseDTO save (BookRequestDTO bookRequestDTO);
    Optional<BookResponseDTO> findById (Long id);
    List<BookResponseDTO> findAll ();
    Optional<BookResponseDTO> update (Long id, BookRequestDTO bookRequestDTO);
    Boolean deleteById (Long id);

}
