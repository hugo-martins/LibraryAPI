package br.com.phoebustecnologia.Library.clientTest;


import br.com.phoebustecnologia.Library.Repositories.ClientRepository;
import br.com.phoebustecnologia.Library.model.Client;
import br.com.phoebustecnologia.Library.model.SexClient;
import br.com.phoebustecnologia.Library.services.ClientServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientServices clientServices;

    @BeforeEach
    public void setUP() {
        this.clientServices = new ClientServices();
     }

    @Test
    public void findAllClient(){
        Mockito.when(clientServices.findClientAll())
                .thenReturn(Stream.of(ClientTest.createClient()
                        .name("Hugo 1").build()).collect(Collectors.toList())
                );
        List<Client> listClient = clientServices.findClientAll();

        assertAll("Client",
                ()-> assertThat(listClient.size(), is(1)),
                ()-> assertThat(listClient.get(0).getName(), is("Hugo Silva Martins")),
                ()-> assertThat(listClient.get(0).getPhone(), is("5415-6515")),
                ()-> assertThat(listClient.get(0).getEmail(), is("emailteste@test.com")),
                ()-> assertThat(listClient.get(0).getAge(), is(23)),
                ()-> assertThat(listClient.get(0).getSex(), is(SexClient.MASCULINE))
        );

        Mockito.verify(clientServices.findClientAll());
    }
}
