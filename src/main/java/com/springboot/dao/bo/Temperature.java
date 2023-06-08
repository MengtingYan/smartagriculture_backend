package com.springboot.dao.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {

    @Setter
    @Getter
    private Long id;

    @Getter
    @Setter
    private float value;

    @Builder
    public Temperature(Long id,Float value){
       this.id=id;
       this.value=value;
    }
}
