package com.aescudero.capitole_inditex.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BRANDS")
@Getter
@Setter
@NoArgsConstructor
public class BrandEntity {

    @Id
    private Long id;

    private String name;
}
