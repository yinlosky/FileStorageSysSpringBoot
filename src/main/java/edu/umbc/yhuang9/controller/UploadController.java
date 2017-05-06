package edu.umbc.yhuang9.controller;

import edu.umbc.yhuang9.fileentity.FileEntity;
import edu.umbc.yhuang9.storageservice.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yhuang9 on 5/5/17.
 * This is the controller for uploading files to the server
 */
@Controller
public class UploadController {

    @Autowired
    StorageService storageservice;


    List<FileEntity> files = new ArrayList<>();

    // simply show the page to upload files
    @GetMapping("/")
    public String listUploadFiles(Model model){
        return "uploadForm";
    }

    // allow users to upload files to the server
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file")MultipartFile file, @RequestParam("name") String name,
                                   @RequestParam("email") String email, ModelMap modelmap){
        try{
            String uri = MvcUriComponentsBuilder
                    .fromMethodName(UploadController.class, "getFile", file.getOriginalFilename()).build().toString();
            FileEntity fileEn = new FileEntity(name, email, file.getOriginalFilename(), uri);
            files.add(fileEn);
            this.storageservice.store(file);
            modelmap.addAttribute("message", "You successfully uploaded FileName:" + file.getOriginalFilename() + "!\n"+"File ContentType: " + file.getContentType()+"!\n"
            +"File size: "+ file.getSize() + "!\n");

        }
        catch(Exception e){
            modelmap.addAttribute("message", "Fail to upload "+ file.getOriginalFilename()+"!");
        }
        return "uploadForm";
    }

    @GetMapping("/getAllFiles")
    public String getAllFiles(ModelMap modelmap){
        modelmap.addAttribute("files", files);
        modelmap.addAttribute("totalFiles", "TotalFiles: " + files.size());
        return "listFiles";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = this.storageservice.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

}
