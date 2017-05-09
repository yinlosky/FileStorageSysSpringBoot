package edu.umbc.yhuang9.bootstrap;

import edu.umbc.yhuang9.fileentity.FileEntity;
import edu.umbc.yhuang9.repositories.FileRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by yhuang9 on 5/9/17.
 */
@Component
public class FileLoader  implements ApplicationListener<ContextRefreshedEvent> {
    private FileRepository fileRepository;
    private Logger log = Logger.getLogger(FileLoader.class);

    @Autowired
    public void setFileRepository(FileRepository fileRepository){
        this.fileRepository=fileRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        FileEntity fileEntity= new FileEntity("Yin", "yhuang9@umbc.edu", "test.txt", null);
        fileRepository.save(fileEntity);
    }
}
