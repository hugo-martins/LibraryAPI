package br.com.phoebustecnologia.Library.controller.clientTest;

import br.com.phoebustecnologia.Library.model.Client;
import br.com.phoebustecnologia.Library.model.SexClient;

public class ClientTest {

    public static Client.ClientBuilder createClient(){
        return Client.builder()
                .id(1L)
                .name("Hugo Silva Martins")
                .phone("5415-6515")
                .email("emailteste@test.com")
                .age(23)
                .sex(SexClient.MASCULINE);
    }
}
