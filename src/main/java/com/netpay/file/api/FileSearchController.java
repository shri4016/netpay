package com.netpay.file.api;

import com.netpay.file.model.FileDocument;
import com.netpay.file.persistence.FileStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class FileSearchController {

    @Autowired
    FileStoreRepository fileStoreRepository;

    @GetMapping("/files/{name}")
   public List<FileDocument> getFilesByName(@PathVariable String name){
       return fileStoreRepository.findAll();
   }
}
