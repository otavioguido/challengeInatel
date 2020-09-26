package br.com.osilva.inatel.stockquotemanager.controller;

import br.com.osilva.inatel.stockquotemanager.exception.DataAccessException;
import br.com.osilva.inatel.stockquotemanager.model.Stock;
import br.com.osilva.inatel.stockquotemanager.service.QuotationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Validated
@Slf4j
public class QuotationController {

    @Autowired
    private QuotationService quotationService;

    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        return new ResponseEntity<>(quotationService.saveQuotation(stock), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(quotationService.findQuotationById(id), HttpStatus.OK);
        } catch (DataAccessException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Page<Stock>> readAll(
            @PageableDefault
            @SortDefault(sort = "stock", direction = Sort.Direction.ASC)
                    Pageable pageable) {
        return new ResponseEntity<>(quotationService.findAllQuotation(pageable), HttpStatus.OK);
    }
}
