package kh.edu.istad.restfulapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "m1_customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false, length = 60)
    private String email;
    @Column(unique = true, nullable = false, length = 12)
    private String phoneNumber;
    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToOne
    private User user;
}