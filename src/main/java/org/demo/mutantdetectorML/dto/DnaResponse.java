package org.demo.mutantdetectorML.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DnaResponse {
    private boolean isMutant;
    private String message;

    // Constructor original
    public DnaResponse(boolean isMutant) {
        this.isMutant = isMutant;
        this.message = isMutant ? "El ADN es mutante" : "El ADN no es mutante";
    }
}
