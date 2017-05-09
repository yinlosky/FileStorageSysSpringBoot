package edu.umbc.yhuang9;

import edu.umbc.yhuang9.fileentity.FileEntity;
import edu.umbc.yhuang9.fileentity.Product;
import edu.umbc.yhuang9.services.FileServiceImpl;
import edu.umbc.yhuang9.services.ProductServiceImpl;
import edu.umbc.yhuang9.storageservice.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.TemporalType;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.System.exit;

/**
 * Created by yhuang9 on 5/6/17.
 */
@SpringBootApplication
public class ApplicationMain implements CommandLineRunner{
    @Resource
    StorageService storageservice;

    @Resource
    ProductServiceImpl productService;

    @Resource
    FileServiceImpl fileService;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args){
        SpringApplication.run(ApplicationMain.class, args);
    }

    @Transactional(readOnly = true)
    @Override
    public void run(String... strings) throws Exception {
        this.storageservice.deleteAll();
        this.storageservice.init();

      System.out.println("\n1.findAll()...");
        for(Product product: productService.listAllProducts()){
            System.out.println(product.getDescription());
        }

        System.out.println("\n2.findByEmail(String email)...");
        for (Product product: productService.findByEmail("yhuang9@umbc.edu")) {
            System.out.println(product.getDescription());
        }

        System.out.println("\n3.findByEmail(String email)...");
        for (FileEntity fileEntity: fileService.findByEmail("yhuang9@umbc.edu")) {
            System.out.println(fileEntity.getFileName());
        }

        System.out.println("\n4.findByDateBetween(Date date)...");
        //System.out.println(sdf.parse("2017-05-09"));

        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(new Date()); // sets calendar time/date

        cal.add(Calendar.HOUR_OF_DAY, -1); // add 1 hour
        System.out.println(cal.getTime()); // returns new date object, one hour in the future
        Date before = cal.getTime();

        cal.setTime(new Date()); // sets calendar time/date
        cal.add(Calendar.HOUR_OF_DAY, 1); // add 1 hour
        Date now = cal.getTime();
        System.out.println(now);

        for (FileEntity fileEntity: fileService.findByDateBetween(before,now)) {
            System.out.println(fileEntity.getFileName());
        }

        //System.out.println("Done!");

        //exit(0);


    }
}
