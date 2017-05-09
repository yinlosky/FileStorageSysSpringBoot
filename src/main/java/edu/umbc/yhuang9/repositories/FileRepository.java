package edu.umbc.yhuang9.repositories;

import edu.umbc.yhuang9.fileentity.FileEntity;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;


import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * Created by yhuang9 on 5/8/17.
 */
public interface FileRepository extends CrudRepository<FileEntity, Integer> {
    List<FileEntity> findByEmail(String email);
    List<FileEntity> findByDateBetween(@Temporal(TemporalType.TIMESTAMP) Date bDate,@Temporal(TemporalType.TIMESTAMP) Date eDate );


}
