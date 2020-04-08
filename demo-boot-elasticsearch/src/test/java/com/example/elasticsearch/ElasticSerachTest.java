package com.example.elasticsearch;

import com.example.elasticsearch.dao.BookRepository;
import com.example.elasticsearch.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ccubee
 * @since 20-4-6 13:58
 */
public class ElasticSerachTest extends DemoBootElasticsearchApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void data(){
        Book book = Book.builder().id(1).author("吴承恩").name("西游记").build();
//        bookRepository.save(book);
        bookRepository.index(book);
        Book bookFind = bookRepository.findById(1).get();
        System.out.println(bookFind);
    }
}
