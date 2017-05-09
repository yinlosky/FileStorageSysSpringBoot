package edu.umbc.yhuang9.fileentity;

import org.apache.tomcat.jni.File;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yhuang9 on 5/6/17.
 *
 * FileEntity class defines the file attributes(metadata)
 * We have included the user's name, email, the file, the link to download the file and the file's name.
 */
@Entity
public class FileEntity {
    // id and version is used in H2 database for saving file entities
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;


    // name is the owner's name
    // email is the owner's email
    // fileName is the uploaded file's original file name
    // uri is the download link for this particular file
    private String name;
    private String email;
    private String fileName;
    private String uri;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date")
    private Date date;

    public FileEntity(){}

    public FileEntity(String n, String e, String f, String u){
        this.name=n;
        this.email=e;
        this.fileName=f;
        this.uri = u;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
