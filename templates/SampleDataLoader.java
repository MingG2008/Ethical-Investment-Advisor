package com.ethicalinvestor.config;

import com.ethicalinvestor.model.Company;
import com.ethicalinvestor.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    
    @Autowired
    private CompanyRepository companyRepository;
    
    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            Company apple = new Company();
            apple.setSymbol("AAPL");
            apple.setName("Apple Inc.");
            apple.setEsgScore(82.5);
            apple.setEnvironmentalScore(89.0);
            apple.setSocialScore(78.0);
            apple.setGovernanceScore(80.5);
            apple.setSector("Technology");
            apple.setMarketCap(2500000000000.0);
            
            companyRepository.save(apple);
            
            // Add more sample companies
        };
    }
}
