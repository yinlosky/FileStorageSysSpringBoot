package edu.umbc.yhuang9.services;

import edu.umbc.yhuang9.fileentity.Product;
import edu.umbc.yhuang9.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yhuang9 on 5/8/17.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
