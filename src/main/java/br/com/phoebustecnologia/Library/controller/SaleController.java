package br.com.phoebustecnologia.Library.controller;

import br.com.phoebustecnologia.Library.dto.SaleDTO;
import br.com.phoebustecnologia.Library.model.Sale;
import br.com.phoebustecnologia.Library.model.Status;
import br.com.phoebustecnologia.Library.services.SaleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sale")
public class SaleController {

    @Autowired
    private SaleServices saleServices;

    @GetMapping(value = "/status/{status}")
    public List<Sale> statusSale(@PathVariable Status status){
        return saleServices.findByStatus(status);

    }

    @GetMapping(value = "/all")
    public List<Sale> saleList() {
        return saleServices.findSaleAll();

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sale> saleListById(@PathVariable Long id) {
        Sale obj = saleServices.saleByID(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public void addSale(@RequestBody SaleDTO sale) {
        saleServices.saveSale(Sale.saleFROM(sale));
    }

    @DeleteMapping(value = "/{id}")
    public void  deleteSale(@PathVariable Long id) {
        saleServices.deleteSale(id);

    }

    @PutMapping(value = "/{id}")
    public void updateSale(@RequestBody SaleDTO sale, @PathVariable Long id) {
        sale.setId(id);
        saleServices.updateSale(Sale.saleFROM(sale));

    }


}
