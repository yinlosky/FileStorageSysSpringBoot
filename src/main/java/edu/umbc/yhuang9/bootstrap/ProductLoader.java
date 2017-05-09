package edu.umbc.yhuang9.bootstrap;

import edu.umbc.yhuang9.fileentity.Product;
import edu.umbc.yhuang9.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yhuang9 on 5/8/17.
 * ProductLoader class is used to automatically load our test data into our
 * database for testing purpose.
 *
 */
@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent>{

    private ProductRepository productRepository;
    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        shirt.setDate(new Date());
        shirt.setEmail("yhuang9@umbc.edu");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setDate(new Date());
        mug.setEmail("dorsa@umbc.edu");
        productRepository.save(mug);


        log.info("Saved Mug - id:" + mug.getId());
    }
}

