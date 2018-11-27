package com.aiw.services;

import com.aiw.entities.Author;
import com.aiw.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> findAll(){
        List<Author> authorList = new ArrayList<>();
        authorRepository.findAll().forEach(authorList::add);
        return authorList;
    }
}
