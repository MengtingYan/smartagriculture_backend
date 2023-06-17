package com.springboot.dao.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SoilPh {

    @Setter
    @Getter
    private Long id;

    @Getter
    @Setter
    private float ph;

    @Builder
    public SoilPh(Long id, Float ph){
        this.id = id;
        this.ph = ph;
    }
}
