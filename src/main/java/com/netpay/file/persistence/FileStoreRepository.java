package com.netpay.file.persistence;

import com.netpay.file.model.FileDocument;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FileStoreRepository extends MongoRepository<FileDocument,String>{
    List<FileDocument> findAll();
}
