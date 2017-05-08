package edu.umbc.yhuang9.repositories;

import edu.umbc.yhuang9.fileentity.FileEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yhuang9 on 5/8/17.
 */
public interface FileRepository extends CrudRepository<FileEntity, Integer> {

}
