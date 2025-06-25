package com.martin.authorbook.dto;

import com.martin.authorbook.entity.Book;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class AuthorRequestDTO {

    @NotBlank(message = "The firstname cannot be blank")
    private String firstname;
    @NotBlank(message = "The lastname cannot be blank")
    private String lastname;
    private List<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        return "AuthorRequestDTO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", books=" + books +
                '}';
    }
}
