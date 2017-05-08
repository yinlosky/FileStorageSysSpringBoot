package edu.umbc.yhuang9.services;

import edu.umbc.yhuang9.fileentity.FileEntity;

/**
 * Created by yhuang9 on 5/8/17.
 */
public interface FileService {
    Iterable<FileEntity> listAllFileEntities();
    FileEntity getFileById(Integer id);
    FileEntity saveFile(FileEntity fileentity);
}
