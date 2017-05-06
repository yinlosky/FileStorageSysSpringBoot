package edu.umbc.yhuang9.fileentity;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by yhuang9 on 5/6/17.
 *
 * FileEntity class defines the file attributes(metadata)
 * We have included the user's name, email, the file, the link to download the file and the file's name.
 */
public class FileEntity {
    private String name;
    private String email;
    private String fileName;
    private String uri;


    public FileEntity(String n, String e, String f, String u){
        this.name=n;
        this.email=e;
        this.fileName=f;
        this.uri = u;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
