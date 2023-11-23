package com.keskin.productservice.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="product",schema = "stock_management")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quality")
    private int quality;

    @Column(name="price")
    private double price;

    @Builder.Default
    @Column(name = "product_updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date productUpdateDate = new Date();

    @Builder.Default
    @Column(name = "product_created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date productCreatedDate = new Date();

    @Column(name = "is_deleted")
    private boolean deleted;
}
