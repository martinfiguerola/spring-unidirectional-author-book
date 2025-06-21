package com.martin.authorbook.mapper;

import com.martin.authorbook.dto.AuthorBookResponseDTO;
import com.martin.authorbook.dto.AuthorRequestDTO;
import com.martin.authorbook.dto.AuthorResponseDTO;
import com.martin.authorbook.dto.BookResponseDTO;
import com.martin.authorbook.entity.Author;

import java.util.List;

public class AuthorMapper {

    public static Author fromDTO (AuthorRequestDTO authorRequestDTO) {
        Author author = new Author();
        author.setFirstname(authorRequestDTO.getFirstname());
        author.setLastname(authorRequestDTO.getLastname());
        return author;
    }

    public static AuthorResponseDTO toDTO (Author savedAuthor) {
        AuthorResponseDTO responseDTO = new AuthorResponseDTO();
        responseDTO.setId(savedAuthor.getId());
        responseDTO.setFirstname(savedAuthor.getFirstname());
        responseDTO.setLastname(savedAuthor.getLastname());
        return responseDTO;
    }

    public static AuthorBookResponseDTO toBookDTO (Author savedAuthor) {
        AuthorBookResponseDTO responseDTO = new AuthorBookResponseDTO();
        responseDTO.setId(savedAuthor.getId());
        responseDTO.setFirstname(savedAuthor.getFirstname());
        responseDTO.setLastname(savedAuthor.getLastname());

        // Convert each book to DTO
        List<BookResponseDTO> bookResponseDTO = savedAuthor.getBooks()
                .stream().map(BookMapper::toDTO).toList();

        responseDTO.setBooks(bookResponseDTO);

        return responseDTO;
    }


}
