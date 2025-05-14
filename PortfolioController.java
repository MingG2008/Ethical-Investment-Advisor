package com.ethicalinvestor.controller;

import com.ethicalinvestor.model.Company;
import com.ethicalinvestor.model.UserPreference;
import com.ethicalinvestor.service.EthicalScreener;
import com.ethicalinvestor.service.PortfolioOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PortfolioController {
    
    @Autowired
    private EthicalScreener ethicalScreener;
    
    @Autowired
    private PortfolioOptimizer portfolioOptimizer;

    @GetMapping("/")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/portfolio")
    public String portfolio(Model model) {
        // Add portfolio data to model
        return "portfolio";
    }

    @PostMapping("/preferences")
    @ResponseBody
    public UserPreference savePreferences(@RequestBody UserPreference preferences) {
        // Save preferences
        return preferences;
    }
}
