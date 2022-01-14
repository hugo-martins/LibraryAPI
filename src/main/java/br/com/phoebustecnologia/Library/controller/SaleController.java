package br.com.phoebustecnologia.Library.controller;

import br.com.phoebustecnologia.Library.dto.SaleDTO;
import br.com.phoebustecnologia.Library.model.Status;
import br.com.phoebustecnologia.Library.services.SaleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sale")
public class SaleController {

    @Autowired
    private SaleServices saleServices;

    @GetMapping(value = "/status/{status}")
    public List<SaleDTO> statusSale(@PathVariable Status status){
        return saleServices.findByStatus(status);

    }

    @GetMapping(value = "/all")
    public List<SaleDTO> saleList() {
        return saleServices.findAll();

    }

    @GetMapping(value = "/{id}")
    public SaleDTO saleById(@PathVariable Long id) throws Throwable {
        return saleServices.findById(id);

    }

    @PostMapping
    public void addSale(@RequestBody SaleDTO sale) {
        saleServices.save(sale);
    }

    @DeleteMapping(value = "/{id}")
    public void  deleteSale(@PathVariable Long id) {
        saleServices.delete(id);

    }

    @PutMapping(value = "/{id}")
    public void updateSale(@RequestBody SaleDTO sale, @PathVariable Long id) throws Throwable{
        sale.setId(id);
        saleServices.update(sale);

    }


}
