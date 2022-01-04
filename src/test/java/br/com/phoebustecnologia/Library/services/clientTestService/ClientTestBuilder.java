package br.com.phoebustecnologia.Library.services.clientTestService;

import br.com.phoebustecnologia.Library.model.Client;
import br.com.phoebustecnologia.Library.model.SexClient;

public class ClientTestBuilder {

    public static Client.ClientBuilder createClient(){
        return Client.builder()
                .name("clientTest")
                .phone("5415-6515")
                .email("emailteste@test.com")
                .age(20)
                .sex(SexClient.MASCULINE);
    }
}
