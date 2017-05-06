package edu.umbc.yhuang9.storageservice;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Created by yhuang9 on 5/5/17.
 * This is the storageservice class which offers the service to manage the files in the storage system.
 * In this implementation, I am using the local file system as the back end storage.
 */
@Service
public class StorageService {

    private final Path rootLocation = Paths.get("upload-dir");

    public void store(MultipartFile file){
        try{
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        }
        catch (Exception e){

            throw new RuntimeException("FAIL!");
        }
    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else{
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }

    public void deleteAll(){
        try{
            FileSystemUtils.deleteRecursively(rootLocation.toFile());
        }
        catch(Exception e){
            throw new RuntimeException("Can't delete the directory!");
        }
    }
}
