package edu.umbc.yhuang9.services;

import edu.umbc.yhuang9.fileentity.FileEntity;
import edu.umbc.yhuang9.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yhuang9 on 5/8/17.
 */
@Service
public class FileServiceImpl implements FileService{

    private FileRepository fileRepository;

    @Autowired
    public void setFileRepository(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    @Override
    public Iterable<FileEntity> listAllFileEntities() {
        return fileRepository.findAll();
    }

    @Override
    public FileEntity getFileById(Integer id) {
        return fileRepository.findOne(id);
    }

    @Override
    public FileEntity saveFile(FileEntity fileentity) {
        return fileRepository.save(fileentity);
    }


}
