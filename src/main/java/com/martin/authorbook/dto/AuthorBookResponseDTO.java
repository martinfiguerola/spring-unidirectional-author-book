package com.martin.authorbook.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class AuthorBookResponseDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private List<BookResponseDTO> books = new ArrayList<>();


}
