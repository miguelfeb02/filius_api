package com.dklb.filius.infrastructure.driven_adapter.database.product;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;
    private String businessId;
    private String name;
    private Long price;
    private String category;
    private Long stock;
    private Long stockMin;
    private Boolean compound;
    private String extent;
    private String userMaker;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;


}
