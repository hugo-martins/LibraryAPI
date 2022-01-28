package br.com.phoebustecnologia.Library.model;

import br.com.phoebustecnologia.Library.dto.SaleDTO.SaleDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Sale implements Serializable {


    private static final long serialVersionId = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public static Sale saleFROM (SaleDTO saleDTO){
        return builder()
                .id(saleDTO.getId())
                .client(saleDTO.getClient())
                .bookPurchase(saleDTO.getBookPurchase())
                .valuePurchase(saleDTO.getValuePurchase())
                .datePurchase(saleDTO.getDatePurchase())
                .status(saleDTO.getStatus())
                .build();
    }
    public static Sale saleSaved (SaleDTO saleDTO){
        return builder()
                .client(saleDTO.getClient())
                .bookPurchase(saleDTO.getBookPurchase())
                .valuePurchase(saleDTO.getValuePurchase())
                .datePurchase(saleDTO.getDatePurchase())
                .status(saleDTO.getStatus())
                .build();
    }




}
