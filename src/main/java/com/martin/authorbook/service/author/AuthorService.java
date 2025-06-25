package com.martin.authorbook.service.author;


import com.martin.authorbook.dto.author.AuthorBookResponseDTO;
import com.martin.authorbook.dto.author.AuthorRequestDTO;
import com.martin.authorbook.dto.author.AuthorResponseDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    AuthorResponseDTO save (AuthorRequestDTO authorRequestDTO);
    List<AuthorResponseDTO> findAll ();
    Optional<AuthorBookResponseDTO> findById (Long id);
    Boolean deleteById (Long id);
    Optional<AuthorResponseDTO> update (Long id, AuthorRequestDTO authorRequestDTO);

}
