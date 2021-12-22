package br.com.phoebustecnologia.Library.dto;

import br.com.phoebustecnologia.Library.model.Book;
import br.com.phoebustecnologia.Library.model.Client;
import br.com.phoebustecnologia.Library.model.SexClient;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientDTO implements Serializable {

    private static final long SerialVersionId = 1L;
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    @NotNull
    private SexClient sex;

    public static ClientDTO clientDTO(Client clientEntity){
        return builder()
                .id(clientEntity.getId())
                .name(clientEntity.getName())
                .age(clientEntity.getAge())
                .sex(clientEntity.getSex())
                .build();

    }

    public static List<ClientDTO> ListFromAllClients (List<Client> clients) {
        return clients.stream().map(ClientDTO::clientDTO).collect(Collectors.toList());
    }

}
