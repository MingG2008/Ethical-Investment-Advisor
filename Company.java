package com.ethicalinvestor.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String symbol;
    
    @Column(nullable = false)
    private String name;
    
    private Double esgScore;
    private Double environmentalScore;
    private Double socialScore;
    private Double governanceScore;
    private String sector;
    private Double marketCap;
}
