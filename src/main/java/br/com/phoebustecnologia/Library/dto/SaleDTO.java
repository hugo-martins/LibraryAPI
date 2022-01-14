package br.com.phoebustecnologia.Library.dto;

import br.com.phoebustecnologia.Library.model.Book;
import br.com.phoebustecnologia.Library.model.Client;
import br.com.phoebustecnologia.Library.model.Sale;
import br.com.phoebustecnologia.Library.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NamedEntityGraph
@Builder
public class SaleDTO  implements Serializable {

    private static final long SerialVersionId =  1L;
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @PrimaryKeyJoinColumn(name = "bookID")
    private Set<Book> bookPurchase;

    @Column(name = "valuePurchase")
    private Double valuePurchase;

    @Column(name = "datePurchase")
    private LocalDate datePurchase;

    @Column (name = "status")
    @Enumerated (EnumType.STRING)
    private Status status;


    public static SaleDTO saleDTO(Sale saleEntity){
        return builder()
                .client(saleEntity.getClient())
                .bookPurchase(saleEntity.getBookPurchase())
                .valuePurchase(saleEntity.getValuePurchase())
                .datePurchase(saleEntity.getDatePurchase())
                .build();
    }

    public static List<SaleDTO> ListFromAllSales (List<Sale> sales) {
        return sales.stream().map(SaleDTO::saleDTO).collect(Collectors.toList());
    }

}
