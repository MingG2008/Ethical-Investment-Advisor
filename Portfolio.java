package com.ethicalinvestor.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "portfolios")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private String name;
    private LocalDateTime createdAt;
    
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Holding> holdings;
}
