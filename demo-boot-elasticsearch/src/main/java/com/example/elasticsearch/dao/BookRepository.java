package com.example.elasticsearch.dao;

import com.example.elasticsearch.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author ccubee
 * @since 20-4-6 13:56
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
}
