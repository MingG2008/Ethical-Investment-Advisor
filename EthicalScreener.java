package com.ethicalinvestor.service;

import com.ethicalinvestor.model.Company;
import com.ethicalinvestor.model.UserPreference;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EthicalScreener {
    private final Map<String, Double> esgWeights = Map.of(
        "environmental", 0.4,
        "social", 0.3,
        "governance", 0.3
    );

    public double calculateCompanyScore(Company company) {
        return company.getEnvironmentalScore() * esgWeights.get("environmental") +
               company.getSocialScore() * esgWeights.get("social") +
               company.getGovernanceScore() * esgWeights.get("governance");
    }

    public List<CompanyScore> screenCompanies(List<Company> companies, UserPreference preferences) {
        return companies.stream()
            .map(company -> new CompanyScore(company, calculateCompanyScore(company)))
            .filter(cs -> cs.getScore() >= preferences.getMinimumEsgScore())
            .sorted((cs1, cs2) -> Double.compare(cs2.getScore(), cs1.getScore()))
            .collect(Collectors.toList());
    }
}
