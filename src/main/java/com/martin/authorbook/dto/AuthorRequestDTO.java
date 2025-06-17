package com.martin.authorbook.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthorRequestDTO {

    private String firstname;
    private String lastname;

    public AuthorRequestDTO(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

}
