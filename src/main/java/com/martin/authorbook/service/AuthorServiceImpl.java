package com.martin.authorbook.service;
import com.martin.authorbook.repository.AuthorRepository;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

}
