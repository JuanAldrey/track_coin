package org.trackcoin.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trackcoin.model.view.CurrencyDTO;
import org.trackcoin.service.CurrencyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @GetMapping("/")
    @Operation(summary = "Find all Currencies", description = "This endpoint fetches all currencies.")
    public ResponseEntity<List<CurrencyDTO>> getAll() {
        return new ResponseEntity<>(currencyService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a Currency by ID", description = "This endpoint fetches a currency when given an ID.")
    public ResponseEntity<CurrencyDTO> get(@PathVariable Long id) {
        return new ResponseEntity<>(currencyService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Add a Currency", description = "This endpoint adds a currency in the database when given a JSON containing it´s information.")
    public ResponseEntity<CurrencyDTO> add(@Valid @RequestBody CurrencyDTO currencyDTO) {
        return new ResponseEntity<>(currencyService.save(currencyDTO, null), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Currency", description = "This endpoint deletes a currency from the database.")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        currencyService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Currency", description = "This endpoint updates a currency given a JSON with its new information.")
    public ResponseEntity<CurrencyDTO> update(@Valid @RequestBody CurrencyDTO currencyDTO, @PathVariable Long id) {
        return new ResponseEntity<>(currencyService.save(currencyDTO, id), HttpStatus.OK);
    }
}
