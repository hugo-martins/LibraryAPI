package br.com.phoebustecnologia.Library.services;

import br.com.phoebustecnologia.Library.Repositories.SaleRepository;
import br.com.phoebustecnologia.Library.dto.SaleDTO;
import br.com.phoebustecnologia.Library.exceptions.SaleNotFoundException;
import br.com.phoebustecnologia.Library.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServices {

    @Autowired
    private SaleRepository saleRepository;


    //Pesquisar lista de Compras pelo Status
    public List<SaleDTO> findByStatus(Status status){
        return saleRepository.findByStatus(status);
    }

    //Pesquisar lista de Compras
    public List<SaleDTO> findAll(){
        return SaleDTO.ListFromAllSales(saleRepository.findAll());
    }

    //Pesquisar compra por ID;
    public SaleDTO findById(Long id) throws Throwable{
        return (SaleDTO) saleRepository.findById(id).orElseThrow(SaleNotFoundException::new);
    }

    //Salvar venda
    public SaleDTO save(SaleDTO sale){
        if(sale.getId()!=null){
            throw new SaleNotFoundException();
        }
        return saleRepository.save(sale);
    }

    //Deletar venda
    public void delete(Long id){
        if(!saleRepository.existsById(id)){
            throw new SaleNotFoundException();
        }
        saleRepository.deleteById(id);
    }

    //Atualizar venda
    public SaleDTO update(SaleDTO saleDTO) throws Throwable{
        if(!saleRepository.existsById(saleDTO.getId())){
            throw new SaleNotFoundException();
        }
        SaleDTO obj = findById(saleDTO.getId());
        updateValuesSale(obj, saleDTO);
        saleRepository.save(obj);
        return obj;
    }

    //Método para salvar e atualizar entidades das vendas
    public void updateValuesSale(SaleDTO newObj, SaleDTO oldObj){
        newObj.setClient(oldObj.getClient());
        newObj.setBookPurchase(oldObj.getBookPurchase());
        newObj.setValuePurchase(oldObj.getValuePurchase());
        newObj.setDatePurchase(oldObj.getDatePurchase());
        newObj.setStatus(oldObj.getStatus());

    }
}
