package com.martin.authorbook.mapper;

import com.martin.authorbook.dto.author.AuthorBookResponseDTO;
import com.martin.authorbook.dto.author.AuthorRequestDTO;
import com.martin.authorbook.dto.author.AuthorResponseDTO;
import com.martin.authorbook.dto.book.BookResponseDTO;
import com.martin.authorbook.entity.Author;

import java.util.List;

public class AuthorMapper {

    public static Author fromDTO (AuthorRequestDTO authorRequestDTO) {
        Author author = new Author();
        author.setFirstname(authorRequestDTO.getFirstname());
        author.setLastname(authorRequestDTO.getLastname());
        author.setBooks(authorRequestDTO.getBooks());
        return author;
    }

    public static AuthorResponseDTO toDTO (Author savedAuthor) {
        AuthorResponseDTO responseDTO = new AuthorResponseDTO();
        responseDTO.setId(savedAuthor.getId());
        responseDTO.setFirstname(savedAuthor.getFirstname());
        responseDTO.setLastname(savedAuthor.getLastname());
        return responseDTO;
    }

    public static AuthorBookResponseDTO toAuthorWithBooksDTO (Author savedAuthor) {
        AuthorBookResponseDTO responseDTO = new AuthorBookResponseDTO();
        responseDTO.setId(savedAuthor.getId());
        responseDTO.setFirstname(savedAuthor.getFirstname());
        responseDTO.setLastname(savedAuthor.getLastname());

        // Converts the list of Book entities associated with the Author into a list of DTOs,
        // using the Book mapper. This allows us to return the author's data along with their books.
        List<BookResponseDTO> bookResponseDTO = savedAuthor.getBooks()
                .stream().map(BookMapper::toDTO).toList();

        responseDTO.setBooks(bookResponseDTO);

        return responseDTO;
    }


}
