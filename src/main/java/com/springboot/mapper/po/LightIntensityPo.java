package com.springboot.mapper.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "light_intensity")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LightIntensityPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long light;
}
