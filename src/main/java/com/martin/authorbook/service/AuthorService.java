package com.martin.authorbook.service;


import com.martin.authorbook.dto.AuthorRequestDTO;
import com.martin.authorbook.dto.AuthorResponseDTO;

public interface AuthorService {

    AuthorResponseDTO save (AuthorRequestDTO authorRequestDTO);

}
