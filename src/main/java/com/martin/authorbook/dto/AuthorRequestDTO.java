package com.martin.authorbook.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthorRequestDTO {

    @NotBlank(message = "The firstname cannot be blank")
    private String firstname;
    @NotBlank(message = "The lastname cannot be blank")
    private String lastname;

    public AuthorRequestDTO(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

}
