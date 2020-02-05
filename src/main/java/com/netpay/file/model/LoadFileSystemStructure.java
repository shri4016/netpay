package com.netpay.file.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoadFileSystemStructure implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(LoadFileSystemStructure.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void run(String...args) throws Exception {

        try {

            final FileDocument parent = new FileDocument( "1", "C:\\" );

            final FileDocument documents = new FileDocument( "2", "Documents", parent);
            final FileDocument images = new FileDocument( "3", "Images", documents);
            final FileDocument works = new FileDocument( "4", "Works", documents);
            documents.setDocuments(Arrays.asList(images,works));

            final FileDocument image1 = new FileDocument( "5", "Image1.jpg", images);
            final FileDocument image2 = new FileDocument( "6", "Image2.jpg", images);
            final FileDocument image3 = new FileDocument( "7", "Image3.jpg", images);
            images.setDocuments(Arrays.asList(image1,image2,image3));

            final FileDocument letter	 = new FileDocument( "8", "Letter.doc", works);
            final FileDocument accountant	 = new FileDocument( "9", "Accountant", works);
            works.setDocuments(Arrays.asList(letter,accountant));

            final FileDocument account	 = new FileDocument( "10", "Accounting.xls", accountant);
            final FileDocument accountReport	 = new FileDocument( "11", "AnnualReport.xls", accountant);
            accountant.setDocuments(Arrays.asList(account,accountReport));




            final FileDocument programFiles = new FileDocument( "12", "Program Files", parent);
            final FileDocument skype = new FileDocument( "13", "Skype", programFiles);
            final FileDocument skypexe = new FileDocument( "14", "Skype.exe", skype);
            final FileDocument readme = new FileDocument( "15", "Readme.txt", skype);
            skype.setDocuments(Arrays.asList(skypexe,readme));
            final FileDocument mysql = new FileDocument( "16", "Mysql", programFiles);
            final FileDocument mysqlexe = new FileDocument( "17", "Mysql.exe", mysql);
            final FileDocument mysqlcom = new FileDocument( "18", "Mysql.com", mysql);
            mysql.setDocuments(Arrays.asList(mysqlexe,mysqlcom));
            programFiles.setDocuments(Arrays.asList(skype,mysql));

            mongoTemplate.insertAll( Arrays.asList( parent, documents,images,works,image1,image2,image3,letter,accountant,account,accountReport,programFiles,skype,skypexe,readme,mysql,mysqlexe,mysqlcom
            ) );
        }catch (Exception ex){
            ex.printStackTrace();
        }

        logger.info("Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.", Arrays.toString(args));
    }
}