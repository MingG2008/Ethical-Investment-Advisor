package com.ethicalinvestor.service;

import com.ethicalinvestor.model.Company;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortfolioOptimizer {
    private static final double RISK_FREE_RATE = 0.02;

    public double calculateExpectedReturn(Company company) {
        double sum = 0;
        Scanner myObj1 = new Scanner(System.in);  
        System.out.println("Enter number of possible outcomes");
        int numOutcome = myObj.nextInt();   
        for (int i = 0; i < numOutcome; i++){
            Scanner myObj2 = new Scanner(System.in);  
            System.out.println("Enter probability of outcome i");
            double probi = myObj.nextDouble(); 
            Scanner myObj3 = new Scanner(System.in); 
            System.out.println("Enter return for outcome i");
            double returni  = myObj.nextDouble();
            sum += probi*returni;
        }
        return sum;
    }

    public double calculatePortfolioRisk(double[] weighti, double[] weightj, List<Company> companies) {
        int sum = 0;
        Scanner myObj1 = new Scanner(System.in);  
        System.out.println("Enter volatility of asset i");
        double volaI = myObj.nextDouble(); 
        Scanner myObj2 = new Scanner(System.in);  
        System.out.println("Enter volatility of asset j");
        double volaJ = myObj.nextDouble(); 
        Scanner myObj3 = new Scanner(System.in);  
        System.out.println("Enter correlation between asset i and asset j returns");
        double corr = myObj.nextDouble(); 
        for (int i = 0; i < weighti.length; i++){
            for (int j = 0; j < weightj.length; j++){
                sum += weighti[i]*weightj[j]*volaI*volaJ*corr;
            }
        }
        return Math.sqrt(sum);
    }

    public double[] optimizePortfolio(List<Company> companies, String riskTolerance) {
        int numAssets = companies.size();
        double[] weights = new double[numAssets];
        for (int i = 0; i < numAssets; i++) {
            weights[i] = 1.0 / numAssets;
        }
        
        return weights;
    }
}
