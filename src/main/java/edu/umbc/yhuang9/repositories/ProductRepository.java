package edu.umbc.yhuang9.repositories;

import edu.umbc.yhuang9.fileentity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yhuang9 on 5/6/17.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByEmail(String email);
    List<Product> findByDate(Date date);

    // custom query example and return a stream
    @Query("select c from Product c where c.email = :email")
    Stream<Product> findByEmailReturnStream(@Param("email") String email);
}