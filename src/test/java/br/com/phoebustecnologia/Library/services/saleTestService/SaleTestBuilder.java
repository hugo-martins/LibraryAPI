package br.com.phoebustecnologia.Library.services.saleTestService;


import br.com.phoebustecnologia.Library.dto.SaleDTO;
import br.com.phoebustecnologia.Library.model.Book;
import br.com.phoebustecnologia.Library.model.Client;
import br.com.phoebustecnologia.Library.model.Sale;
import br.com.phoebustecnologia.Library.model.Status;
import br.com.phoebustecnologia.Library.services.bookTestService.BookTestBuilder;
import br.com.phoebustecnologia.Library.services.clientTestService.ClientTestBuilder;

import java.util.HashSet;
import java.util.Set;

public class SaleTestBuilder {

    public static Sale.SaleBuilder createdSale(){
        Client client = ClientTestBuilder.createClient().build();
        Set<Book> books = new HashSet<>();
        books.add(BookTestBuilder.createdBook().title("bookTest1").isbn("151555-15515").build());
        books.add(BookTestBuilder.createdBook().title("bookTest1").isbn("151555-148885").build());
        return Sale.builder()
                .client(client)
                .status(Status.COMPLETED)
                .bookPurchase(books)
                .valuePurchase(100.00);
    }
    public static SaleDTO.SaleDTOBuilder createdSaleDTO(){
        Client clientDTO = ClientTestBuilder.createClient().build();
        Set<Book> books = new HashSet<>();
        books.add(BookTestBuilder.createdBook().title("bookTest1").isbn("151555-15515").build());
        books.add(BookTestBuilder.createdBook().title("bookTest1").isbn("151555-148885").build());
        return SaleDTO.builder()
                .client(clientDTO)
                .status(Status.COMPLETED)
                .bookPurchase(books)
                .valuePurchase(100.00);
    }
}
