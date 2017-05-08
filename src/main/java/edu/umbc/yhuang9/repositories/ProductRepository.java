package edu.umbc.yhuang9.repositories;

import edu.umbc.yhuang9.fileentity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yhuang9 on 5/6/17.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}