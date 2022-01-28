package br.com.phoebustecnologia.Library.services.clientTestService;

import br.com.phoebustecnologia.Library.dto.ClientDTO.ClientDTO;
import br.com.phoebustecnologia.Library.model.Client;
import br.com.phoebustecnologia.Library.model.SexClient;

public class ClientTestBuilder {

    public static Client.ClientBuilder createClient(){
        return Client.builder()
                .id(1L)
                .name("clientTest")
                .phone("5415-6515")
                .email("emailteste@test.com")
                .age(20)
                .sex(SexClient.MASCULINE);
    }
    public static ClientDTO.ClientDTOBuilder createClientDTO(){
        return ClientDTO.builder()
                .id(1L)
                .name("clientTest")
                .phone("5415-6515")
                .email("emailteste@test.com")
                .age(20)
                .sex(SexClient.MASCULINE);
    }
    public static Client.ClientBuilder createClientSaved(){
        return Client.builder()
                .name("clientTest")
                .phone("5415-6515")
                .email("emailteste@test.com")
                .age(20)
                .sex(SexClient.MASCULINE);
    }
}
