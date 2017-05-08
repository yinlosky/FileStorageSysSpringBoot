package edu.umbc.yhuang9;

import edu.umbc.yhuang9.storageservice.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * Created by yhuang9 on 5/6/17.
 */
@SpringBootApplication
public class ApplicationMain implements CommandLineRunner{
    @Resource
    StorageService storageservice;
    public static void main(String[] args){
        SpringApplication.run(ApplicationMain.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
        this.storageservice.deleteAll();
        this.storageservice.init();
    }

}
