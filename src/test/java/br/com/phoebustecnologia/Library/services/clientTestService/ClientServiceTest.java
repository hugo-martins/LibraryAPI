package br.com.phoebustecnologia.Library.services.clientTestService;


import br.com.phoebustecnologia.Library.Repositories.ClientRepository;
import br.com.phoebustecnologia.Library.dto.ClientDTO.ClientDTO;
import br.com.phoebustecnologia.Library.model.Client;
import br.com.phoebustecnologia.Library.model.SexClient;
import br.com.phoebustecnologia.Library.services.ClientServices.ClientServicesImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test Client Service")
public class ClientServiceTest {


    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServicesImpl clientServicesImpl;


    @BeforeEach
    void setUp() {
        this.clientServicesImpl = new ClientServicesImpl(clientRepository);
    }


    @Test
    @DisplayName("Should return all clients")
    void ShouldFindAllClients() {

        when(clientRepository.findAll()).thenReturn(
                Stream.of(ClientTestBuilder.createClient().name("clientTest1").build(),
                                ClientTestBuilder.createClient().name("clientTest2").build())
                        .collect(Collectors.toList())
        );

        List<ClientDTO> clientList = clientServicesImpl.findAll();

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
        ClientDTO clientSaved = clientServicesImpl.findById(id);

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

        Client clientSaved = ClientTestBuilder.createClientSaved().build();

        when(clientRepository.save(ArgumentMatchers.any(Client.class)))
                .thenReturn(ClientTestBuilder.createClientSaved().build());

        ClientDTO client = clientServicesImpl.save(ClientDTO.clientSavedDTO(clientSaved));


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
        Long id = anyLong();
        Optional<Client> clientCreated = Optional.of(ClientTestBuilder.createClient().build());
        when(clientRepository.findById(id)).thenReturn(clientCreated);

        clientServicesImpl.delete(1L);

    }

    @Test
    @DisplayName("Should updated clients to List")
    void update_whenSuccessful() {

        Client clientToUpdate = ClientTestBuilder.createClient().build();

        Optional<Client> clientOpt = Optional.of(clientToUpdate);

        when(clientRepository.findById(anyLong())).thenReturn(clientOpt);

        clientToUpdate.setName("client nome");

        when(clientRepository.save(ArgumentMatchers.any())).thenReturn(clientToUpdate);

        ClientDTO clientResult = clientServicesImpl.update(1L, ClientDTO.clientSavedDTO(clientToUpdate));

        assertAll("Client",
                () -> assertThat(clientResult.getName(), Matchers.is("client1")));
    }

}
