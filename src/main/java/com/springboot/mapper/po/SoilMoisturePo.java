package com.springboot.mapper.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "soil_moisture")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SoilMoisturePo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long moisture;
}
