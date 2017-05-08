package edu.umbc.yhuang9.controller;

import edu.umbc.yhuang9.fileentity.FileEntity;
import edu.umbc.yhuang9.fileentity.Product;
import edu.umbc.yhuang9.services.FileServiceImpl;
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

/**
 * Created by yhuang9 on 5/8/17.
 */
@Controller
public class FileController {
    // below is the database file service implementation.
    private FileServiceImpl fileServiceImpl;

    @Autowired
    public void setFileServiceImpl(FileServiceImpl fileServiceImpl){

        this.fileServiceImpl = fileServiceImpl;
    }
    // below is local file system storage service.

    private StorageService storageService;
    @Autowired
    public void setStorageService(StorageService storageService){
        this.storageService = storageService;
    }
    // when go to /files it will show all files
    @GetMapping("/files")
    public String listAllFiles(Model model){
        model.addAttribute("files", fileServiceImpl.listAllFileEntities());
        System.out.println("Returning files:");
        return "files";
    }

    @GetMapping("file/{id}")
    public String showFile(@PathVariable Integer id, Model model){
        model.addAttribute("file", fileServiceImpl.getFileById(id));
        return "filesshow";
    }


    // fileform is used to update or create a entry in the database and upload to local file system
    // we don't need the user to specify the file name since we can get it from the file
    // we need the user to specify who is the owner of the file

    @GetMapping("/new")
    public String newFile(Model model){
        return "fileform";
    }

    @PostMapping("/new")
    public String saveFile(@RequestParam("file")MultipartFile file, @RequestParam("name") String name,
                           @RequestParam("email") String email, ModelMap modelmap){
    try {
        String uri = MvcUriComponentsBuilder
                .fromMethodName(FileController.class, "downloadFile", file.getOriginalFilename()).build().toString();
        FileEntity fileEntity = new FileEntity(name, email, file.getOriginalFilename(), uri);
        fileServiceImpl.saveFile(fileEntity);
        this.storageService.store(file);
        modelmap.addAttribute("message", "You successfully uploaded FileName:" + file.getOriginalFilename() + "!\n" + "File ContentType: " + file.getContentType() + "!\n"
                + "File size: " + file.getSize() + "!\n");

        }
        catch(Exception e){
            modelmap.addAttribute("message", "Fail to upload "+ file.getOriginalFilename()+"!");
        }
        return "fileform";
    }

  // below is used for downloading the file
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Resource file = this.storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
  // below is used for editing the entries of the table
    @PostMapping(value = "file")
    public String updateFile(FileEntity fileEntity){

        this.fileServiceImpl.saveFile(fileEntity);

        return "redirect:/file/" + fileEntity.getId();
    }

}
