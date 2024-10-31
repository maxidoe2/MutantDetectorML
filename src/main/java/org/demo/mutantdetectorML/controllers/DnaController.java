package org.demo.mutantdetectorML.controllers;

import org.demo.mutantdetectorML.dto.DnaRequest;
import org.demo.mutantdetectorML.dto.DnaResponse;
import org.demo.mutantdetectorML.services.DnaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/mutant")
public class DnaController {

    private final DnaService dnaService;

    public DnaController(DnaService dnaService) {
        this.dnaService = dnaService;
    }

    @PostMapping
    public ResponseEntity<DnaResponse> checkMutant(@Valid @RequestBody DnaRequest dnaRequest) {
        try {
            boolean isMutant = dnaService.analyzeDna(dnaRequest.getDna());
            DnaResponse dnaResponse = new DnaResponse(isMutant);
            if (isMutant) {
                return ResponseEntity.ok(dnaResponse);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dnaResponse);
            }
        } catch (IllegalArgumentException e) {
            // Maneja la excepción y retorna un 400 Bad Request con el mensaje de error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DnaResponse(false, e.getMessage()));
        }
    }
}
