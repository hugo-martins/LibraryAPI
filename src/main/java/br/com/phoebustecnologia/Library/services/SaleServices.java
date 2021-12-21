package br.com.phoebustecnologia.Library.services;

import br.com.phoebustecnologia.Library.Repositories.SaleRepository;
import br.com.phoebustecnologia.Library.exceptions.SaleNotFoundException;
import br.com.phoebustecnologia.Library.model.Sale;
import br.com.phoebustecnologia.Library.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServices {

    @Autowired
    private SaleRepository saleRepository;


    //Pesquisar lista de Compras pelo Status
    public List<Sale> findByStatus(Status status){
        return saleRepository.findByStatus(status);
    }

    //Pesquisar lista de Compras
    public List<Sale> findSaleAll(){
        return saleRepository.findAll();
    }

    //Pesquisar compra por ID;
    public Sale saleByID(Long id){
        return saleRepository.findById(id).orElseThrow(SaleNotFoundException::new);
    }

    //Salvar venda
    public Sale saveSale(Sale sale){
        return saleRepository.save(sale);
    }

    //Deletar venda
    public void deleteSale(Long id){
        if(!saleRepository.existsById(id)){
            throw new SaleNotFoundException();
        }
        saleRepository.deleteById(id);
    }

    //Atualizar Sale
    public void updateSale(Sale sale){
        if(!saleRepository.existsById(sale.getId())){
            throw new SaleNotFoundException();
        }
        Sale obj = saleByID(sale.getId());
        updateValuesSale(obj, sale);
        saleRepository.save(obj);

    }

    //Método para salvar e atualizar entidades das vendas
    public void updateValuesSale(Sale newObj, Sale oldObj){
        newObj.setClient(oldObj.getClient());
        newObj.setBookPurchase(oldObj.getBookPurchase());
        newObj.setValuePurchase(oldObj.getValuePurchase());
        newObj.setDatePurchase(oldObj.getDatePurchase());
        newObj.setStatus(oldObj.getStatus());

    }
}
