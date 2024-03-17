package org.trackcoin.controller;


import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trackcoin.model.view.TradeCreationDTO;
import org.trackcoin.model.view.TradeDTO;
import org.trackcoin.service.TradeService;

import java.util.List;

@RestController
@RequestMapping("/trade")
public class TradeController {

    @Autowired
    TradeService tradeService;

    @GetMapping("/")
    @Operation(summary = "Find all Trades", description = "This endpoint fetches all trades.")
    public ResponseEntity<List<TradeDTO>> getAll() {
        return new ResponseEntity<>(tradeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a Trade by ID", description = "This endpoint fetches a trade when given an ID.")
    public ResponseEntity<TradeDTO> get(@PathVariable Long id) {
        return new ResponseEntity<>(tradeService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/{baseCurrencyCode}/{quoteCurrencyCode}")
    @Operation(summary = "Add a Trade", description = "This endpoint adds a trade in the database when given a JSON containing it´s information.")
    public ResponseEntity<TradeCreationDTO> add(@Valid @RequestBody TradeCreationDTO tradeCreationDTO, @PathVariable String baseCurrencyCode, @PathVariable String quoteCurrencyCode) {
        return new ResponseEntity<>(tradeService.create(tradeCreationDTO, baseCurrencyCode, quoteCurrencyCode), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Trade", description = "This endpoint deletes a trade from the database.")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        tradeService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Trade", description = "This endpoint updates a trade given a JSON with its new information.")
    public ResponseEntity<TradeDTO> update(@Valid @RequestBody TradeDTO tradeDto, @PathVariable Long id) {
        return new ResponseEntity<>(tradeService.update(tradeDto, id), HttpStatus.OK);
    }
}
