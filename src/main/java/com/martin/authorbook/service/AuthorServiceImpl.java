package com.martin.authorbook.service;
import com.martin.authorbook.dto.AuthorBookResponseDTO;
import com.martin.authorbook.dto.AuthorRequestDTO;
import com.martin.authorbook.dto.AuthorResponseDTO;
import com.martin.authorbook.entity.Author;
import com.martin.authorbook.mapper.AuthorMapper;
import com.martin.authorbook.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuthorResponseDTO save(AuthorRequestDTO authorRequestDTO) {

        // Step 1: Receive the DTO and convert it into an entity
        Author author = AuthorMapper.fromDTO(authorRequestDTO);

        // Step 2: Persist the transformed entity in the database.
        Author savedAuthor = repository.save(author);

        // Step 3: Convert the savedAuthor into a DTO and return it
        return AuthorMapper.toDTO(savedAuthor);

    }

    @Override
    public List<AuthorResponseDTO> findAll() {

        // Step 1: Get all authors from the database
        List<Author> authors = repository.findAll();

        // Step 2: Convert each author entity to a DTO and return the list
        return authors.stream()
                .map(AuthorMapper::toDTO)
                .toList();

    }

    @Override
    public Optional<AuthorBookResponseDTO> findById(Long id) {
        // Step 1: Get Author Entity Optional from the database
        Optional<Author> optionalAuthor = repository.findById(id);

        // Step 2: If exists, convert to DTO and return it
        return optionalAuthor.map(AuthorMapper::toBookDTO);
    }
}
