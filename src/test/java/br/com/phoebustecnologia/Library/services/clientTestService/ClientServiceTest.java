package br.com.phoebustecnologia.Library.services.clientTestService;


import br.com.phoebustecnologia.Library.Repositories.ClientRepository;
import br.com.phoebustecnologia.Library.model.Client;
import br.com.phoebustecnologia.Library.model.SexClient;
import br.com.phoebustecnologia.Library.services.ClientServices;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test Client Service")
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServices clientServices;


    @BeforeEach
    void setUp() {}


    @Test
    @DisplayName("Should return all clients")
    void ShouldFindAllClients() {

        when(clientRepository.findAll()).thenReturn(
                Stream.of(ClientTestBuilder.createClient().name("clientTest1").build(),
                        ClientTestBuilder.createClient().name("clientTest2").build())
                        .collect(Collectors.toList())
        );

        List<Client> clientList = clientRepository.findAll();

        assertAll("Clients",
                () -> assertThat(clientList.size(), is(2)),
                () -> assertThat(clientList.get(0).getName(), is("clientTest1")),
                () -> assertThat(clientList.get(0).getPhone(), is("5415-6515")),
                () -> assertThat(clientList.get(1).getName(), is("clientTest2")),
                () -> assertThat(clientList.get(1).getPhone(), is("5415-6515"))
        );

    }

    @Test
    @DisplayName("Should return client by Id")
    void ShouldFindByClientId() {

        Long id = anyLong();

        Optional<Client> clientCreated = Optional.of(ClientTestBuilder.createClient().build());
        when(clientRepository.findById(id)).thenReturn(clientCreated);
        Client clientSaved = clientServices.findById(id);

        assertAll("Client",
                () -> assertThat(clientSaved.getName(), is("clientTest")),
                () -> assertThat(clientSaved.getPhone(), is("5415-6515")),
                () -> assertThat(clientSaved.getEmail(), is("emailteste@test.com")),
                () -> assertThat(clientSaved.getAge(), is(20)),
                () -> assertThat(clientSaved.getSex(), is(SexClient.MASCULINE))
        );

    }
    @Test
    @DisplayName("Should save a client")
    void ShouldSaveClient() {
        Client mock = ClientTestBuilder.createClient().build();
        when(clientRepository.save(mock)).thenReturn(mock);
        Client client = clientServices.save(mock);

        assertAll("Client",
                () -> assertThat(client.getName(), is("clientTest")),
                () -> assertThat(client.getPhone(), is("5415-6515")),
                () -> assertThat(client.getEmail(), is("emailteste@test.com")),
                () -> assertThat(client.getAge(), is(20)),
                () -> assertThat(client.getSex(), is(SexClient.MASCULINE))
        );

    }

    @Test
    @DisplayName("Should delete a client")
    void ShouldDeleteBook() {

        when(clientRepository.existsById(anyLong())).thenReturn(true);
        clientServices.delete(1L);
        verify(clientRepository).existsById(anyLong());
    }

    @Test
    @DisplayName("Should updated clients to List")
    void update_whenSuccessful() {

        Client client = ClientTestBuilder.createClient().id(1L).build();

        Optional<Client> clientOpt = Optional.of(client);

        when(clientRepository.existsById(1L)).thenReturn(true);
        when(clientRepository.findById(anyLong())).thenReturn(clientOpt);

        client.setName("client1");

        when(clientRepository.save(client)).thenReturn(client);

        Client clientResult = clientServices.update(client);

        assertAll("Client",
                () -> assertThat(clientResult.getName(), Matchers.is("client1")));
        }


}
