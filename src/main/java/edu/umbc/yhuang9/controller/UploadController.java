package edu.umbc.yhuang9.controller;

import edu.umbc.yhuang9.storageservice.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yhuang9 on 5/5/17.
 * This is the controller for uploading files to the server
 */
@Controller
public class UploadController {

    @Autowired
    StorageService storageservice;



    @RequestMapping("/")

}
