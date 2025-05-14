package com.ethicalinvestor.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "user_preferences")
public class UserPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private Integer environmentalPriority = 5;
    private Integer socialPriority = 5;
    private Integer governancePriority = 5;
    private String riskTolerance = "moderate";
    private Integer investmentHorizon = 5;
}
