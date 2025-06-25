package com.martin.authorbook.dto.book;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class BookRequestDTO {

    private String title;
    private String isbn;

}
