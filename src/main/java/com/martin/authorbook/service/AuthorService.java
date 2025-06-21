package com.martin.authorbook.service;


import com.martin.authorbook.dto.AuthorBookResponseDTO;
import com.martin.authorbook.dto.AuthorRequestDTO;
import com.martin.authorbook.dto.AuthorResponseDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    AuthorResponseDTO save (AuthorRequestDTO authorRequestDTO);
    List<AuthorResponseDTO> findAll ();
    Optional<AuthorBookResponseDTO> findById (Long id);
    Boolean deleteById (Long id);
    Optional<AuthorResponseDTO> update (Long id, AuthorRequestDTO authorRequestDTO);

}
