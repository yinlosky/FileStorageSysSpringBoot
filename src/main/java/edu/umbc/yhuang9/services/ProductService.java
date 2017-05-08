package edu.umbc.yhuang9.services;

import edu.umbc.yhuang9.fileentity.Product;

/**
 * Created by yhuang9 on 5/8/17.
 */
public interface ProductService {
    Iterable<Product> listAllProducts();
    Product getProductById(Integer id);
    Product saveProduct(Product product);
}
