package org.demo.mutantdetectorML.dto;

import lombok.Getter;
import lombok.Setter;
import org.demo.mutantdetectorML.validators.ValidDna;

@Getter
@Setter
public class DnaRequest {
    @ValidDna
    private String[] dna;
}