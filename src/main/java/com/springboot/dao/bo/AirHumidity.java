package com.springboot.dao.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirHumidity {

    @Setter
    @Getter
    private Long id;

    @Getter
    @Setter
    private Long humidity;

    @Builder
    public AirHumidity(Long id,Long humidity){
        this.id=id;
        this.humidity =humidity;
    }
}
