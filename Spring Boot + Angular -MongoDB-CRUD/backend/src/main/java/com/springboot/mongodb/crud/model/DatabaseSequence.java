package com.springboot.mongodb.crud.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequence")
@Getter
@Setter
public class DatabaseSequence {

    @Id
    private String id;
    private long seq;
    public DatabaseSequence(){}

}
