package com.martin.authorbook.mapper;

import com.martin.authorbook.dto.BookResponseDTO;
import com.martin.authorbook.entity.Book;

public class BookMapper {

    public static BookResponseDTO toDTO (Book book) {
        BookResponseDTO bookResponseDTO = new BookResponseDTO();
        bookResponseDTO.setId(book.getId());
        bookResponseDTO.setTitle(book.getTitle());
        bookResponseDTO.setIsbn(book.getIsbn());

        return bookResponseDTO;
    }
}
