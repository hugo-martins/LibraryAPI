package br.com.phoebustecnologia.Library.dto.ClientDTO;

import br.com.phoebustecnologia.Library.model.Client;
import br.com.phoebustecnologia.Library.model.SexClient;
import lombok.*;

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
                .phone(clientEntity.getPhone())
                .email(clientEntity.getEmail())
                .sex(clientEntity.getSex())
                .build();

    }

    public static List<ClientDTO> ListFromAllClients (List<Client> clients) {
        return clients.stream().map(ClientDTO::clientDTO).collect(Collectors.toList());
    }


    public static ClientDTO clientSavedDTO(Client clientEntity){
        return builder()
                .name(clientEntity.getName())
                .age(clientEntity.getAge())
                .sex(clientEntity.getSex())
                .email(clientEntity.getEmail())
                .phone(clientEntity.getPhone())
                .build();

    }

}
