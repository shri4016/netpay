package com.netpay.file.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.HashSet;

@Document(collection = "documents" )
public class FileDocument {

    public static final String PATH_SEPARATOR = ".";

    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String path;

    @Transient
    private Collection<FileDocument> documents = new HashSet<FileDocument>();


    public FileDocument() {
    }

    public FileDocument( final String id, final String name ) {
        this.id = id;
        this.name = name;
        this.path = id;
    }

    public FileDocument( final String id, final String name, final FileDocument parent ) {
        this( id, name );
        this.path = parent.getPath() + PATH_SEPARATOR + id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Collection<FileDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(Collection<FileDocument> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "FileDocument{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
