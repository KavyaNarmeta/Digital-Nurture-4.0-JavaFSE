package com.kavya.test.MockitoMavenDemo;


public class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public String processData() {
        return "Processed " + repository.getData();
    }
}

