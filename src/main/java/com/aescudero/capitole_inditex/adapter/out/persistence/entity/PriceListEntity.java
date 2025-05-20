package com.aescudero.capitole_inditex.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRICE_LISTS")
@NoArgsConstructor
@Getter
@Setter
public class PriceListEntity {

    @Id
    private Long id;

    private String description;
}
