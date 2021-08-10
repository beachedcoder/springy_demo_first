package com.example.putnam.spbdemos.config;

import com.example.putnam.spbdemos.svcs.MockBookFinderImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSvcs {
    
    @Bean(name = "cacheBookFinder")
    public MockBookFinderImpl buildMockBookCacheService() {
        return new MockBookFinderImpl();
    }
}
