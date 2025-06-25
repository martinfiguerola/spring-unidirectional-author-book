package com.martin.authorbook.service.book;

import com.martin.authorbook.dto.book.BookRequestDTO;
import com.martin.authorbook.dto.book.BookResponseDTO;

public interface BookService {

    BookResponseDTO save (BookRequestDTO bookRequestDTO);
}
