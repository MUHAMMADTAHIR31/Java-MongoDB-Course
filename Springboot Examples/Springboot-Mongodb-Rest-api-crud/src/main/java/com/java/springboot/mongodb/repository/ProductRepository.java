package com.java.springboot.mongodb.repository;

import com.java.springboot.mongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository  extends MongoRepository<Product,Long> {

}
