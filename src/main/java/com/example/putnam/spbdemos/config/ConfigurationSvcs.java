package com.example.putnam.spbdemos.config;

import com.example.putnam.spbdemos.dao.AuthorRepository;
import com.example.putnam.spbdemos.domain.Author;
import com.example.putnam.spbdemos.svcs.MockBookFinderImpl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSvcs {
    
    @Bean(name = "cacheBookFinder")
    public MockBookFinderImpl buildMockBookCacheService() {
        return new MockBookFinderImpl();
    }

    @Bean
    public CommandLineRunner loadExistInHouseAuthors(AuthorRepository dao) {
        return (String[] args) -> {
            dao.save(new Author("Janet","Java"));
            dao.save(new Author("Nancy", "Net"));
            dao.save(new Author("Katie","Kotlin"));
            dao.save(new Author("Rhonda","Ruby"));
        };
    }
}
