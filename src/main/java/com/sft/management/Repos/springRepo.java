package com.sft.management.Repos;

import com.sft.management.Models.Book;

import org.springframework.data.repository.CrudRepository;

public interface springRepo extends CrudRepository<Book, Long>
{
}
