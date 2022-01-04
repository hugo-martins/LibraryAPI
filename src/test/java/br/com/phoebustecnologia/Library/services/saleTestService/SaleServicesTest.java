package br.com.phoebustecnologia.Library.services.saleTestService;

import br.com.phoebustecnologia.Library.Repositories.BookRepository;
import br.com.phoebustecnologia.Library.Repositories.SaleRepository;
import br.com.phoebustecnologia.Library.model.Book;
import br.com.phoebustecnologia.Library.model.Sale;
import br.com.phoebustecnologia.Library.model.SexClient;
import br.com.phoebustecnologia.Library.model.Status;
import br.com.phoebustecnologia.Library.services.BookServices;
import br.com.phoebustecnologia.Library.services.SaleServices;
import br.com.phoebustecnologia.Library.services.bookTestService.BookTestBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test Sale Service")
class SaleServicesTest {

    @Mock
    private SaleRepository saleRepository;

    @InjectMocks
    private SaleServices saleServices;


    @BeforeEach
    void setUp() {
    }


    @Test
    @DisplayName("Should return all sales")
    void ShouldFindAllSales() {

        when(saleRepository.findAll()).thenReturn(
                Stream.of(SaleTestBuilder.createdSale().id(1L).status(Status.COMPLETED).build(),
                        SaleTestBuilder.createdSale().id(2L).status(Status.PENDING).build())
                        .collect(Collectors.toList())
        );

        List<Sale> saleList = saleRepository.findAll();

        assertAll("Sales",
                () -> assertThat(saleList.size(), is(2)),
                () -> assertThat(saleList.get(0).getClient().getName(), is("clientTest")),
                () -> assertThat(saleList.get(0).getClient().getSex(), is(SexClient.MASCULINE)),
                () -> assertThat(saleList.get(0).getId(), is(1L)),
                () -> assertThat(saleList.get(0).getStatus(), is(Status.COMPLETED)),
                () -> assertThat(saleList.get(0).getValuePurchase(), is(100.00)),
                () -> assertThat(saleList.get(0).getBookPurchase().size(), is(2)),
                () -> assertThat(saleList.get(1).getClient().getName(), is("clientTest")),
                () -> assertThat(saleList.get(1).getClient().getSex(), is(SexClient.MASCULINE)),
                () -> assertThat(saleList.get(1).getId(), is(2L)),
                () -> assertThat(saleList.get(1).getStatus(), is(Status.PENDING)),
                () -> assertThat(saleList.get(1).getValuePurchase(), is(100.00)),
                () -> assertThat(saleList.get(1).getBookPurchase().size(), is(2))
        );

    }


    @Test
    @DisplayName("Should return one sale")
    void ShouldFindById() {

        Long id = anyLong();

        Optional<Sale> saleCreated = Optional.of(SaleTestBuilder.createdSale().build());
        when(saleRepository.findById(id)).thenReturn(saleCreated);
        Sale saleSaved = saleServices.findById(id);

        assertAll("Sale",
                () -> assertThat(saleSaved.getClient().getName(), is("clientTest")),
                () -> assertThat(saleSaved.getClient().getSex(), is(SexClient.MASCULINE)),
                () -> assertThat(saleSaved.getStatus(), is(Status.COMPLETED)),
                () -> assertThat(saleSaved.getValuePurchase(), is(100.00)),
                () -> assertThat(saleSaved.getBookPurchase().size(), is(2))
                );

    }

    @Test
    @DisplayName("Should save a Sale")
    void ShouldSaveSale() {
        Sale mock = SaleTestBuilder.createdSale().build();
        when(saleRepository.save(mock)).thenReturn(mock);
        Sale sale = saleServices.save(mock);


        assertAll("Sale",
                () -> assertThat(sale.getClient().getName(), is("clientTest")),
                () -> assertThat(sale.getClient().getSex(), is(SexClient.MASCULINE)),
                () -> assertThat(sale.getStatus(), is(Status.COMPLETED)),
                () -> assertThat(sale.getValuePurchase(), is(100.00)),
                () -> assertThat(sale.getBookPurchase().size(), is(2))

        );


    }

    @Test
    @DisplayName("Should delete an Sale ")
    void ShouldDeleteSale() {

        when(saleRepository.existsById(anyLong())).thenReturn(true);
        saleServices.delete(1L);
        verify(saleRepository).existsById(anyLong());
    }

    @Test
    @DisplayName("Should updated sale to List")
    void update_whenSuccessful() {

        Sale sale = SaleTestBuilder.createdSale().id(1L).build();

        Optional<Sale> saleOpt = Optional.of(sale);

        when(saleRepository.existsById(1L)).thenReturn(true);
        when(saleRepository.findById(anyLong())).thenReturn(saleOpt);

        sale.setStatus(Status.PENDING);

        when(saleRepository.save(sale)).thenReturn(sale);

        Sale saleResult = saleServices.update(sale);

        assertAll("Sale",
                () -> assertThat(saleResult.getStatus(), Matchers.is(Status.PENDING)));
    }

}