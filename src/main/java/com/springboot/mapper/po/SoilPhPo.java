package com.springboot.mapper.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "soil_ph")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SoilPhPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float ph;
}
