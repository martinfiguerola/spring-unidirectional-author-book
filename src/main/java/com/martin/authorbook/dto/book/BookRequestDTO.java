package com.martin.authorbook.dto.book;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class BookRequestDTO {

    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "ISBN cannot be blank")
    private String isbn;

}
