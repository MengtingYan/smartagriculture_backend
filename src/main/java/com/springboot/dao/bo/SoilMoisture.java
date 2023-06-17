package com.springboot.dao.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SoilMoisture {

    @Setter
    @Getter
    private Long id;

    @Getter
    @Setter
    private Long moisture;

    @Builder
    public SoilMoisture(Long id, Long moisture){
        this.id=id;
        this.moisture=moisture;
    }
}
