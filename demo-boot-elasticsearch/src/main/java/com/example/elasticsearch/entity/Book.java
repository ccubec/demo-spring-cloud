package com.example.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author ccubee
 * @since 20-4-6 13:55
 */
@Data
@Builder
@Document(indexName = "news", type = "book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Integer id;

    private String author;

    private String name;

    private String version;
}
