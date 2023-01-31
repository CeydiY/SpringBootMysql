package com.cuenca.api.modelo;


import lombok.*;


import javax.persistence.*;

@Data
@Entity(name = "product")
@NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;
}

