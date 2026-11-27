package kh.edu.istad.restfulapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "m1_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 32)
    private String code;
    @Column(nullable = false, length = 128)
    private String name;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Boolean isAvailable;

    @ManyToOne
    private Category category;
}