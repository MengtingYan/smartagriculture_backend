package com.springboot.dao.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightIntensity {

    @Setter
    @Getter
    private Long id;

    @Getter
    @Setter
    private Long light;

    @Builder
    public LightIntensity(Long id, Long light){
        this.id=id;
        this.light=light;
    }
}
