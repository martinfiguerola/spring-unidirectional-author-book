package com.martin.authorbook.service;

import com.martin.authorbook.dto.BookRequestDTO;
import com.martin.authorbook.dto.BookResponseDTO;

public interface BookService {

    BookResponseDTO save (BookRequestDTO bookRequestDTO);
}
