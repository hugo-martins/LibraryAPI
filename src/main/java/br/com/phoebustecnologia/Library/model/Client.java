package br.com.phoebustecnologia.Library.model;

import br.com.phoebustecnologia.Library.dto.ClientDTO.ClientDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "clients")
public class Client implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private String email;


    private Integer age;

    @Enumerated(EnumType.STRING)
    private SexClient sex;

    public Client(Long id, String name, Integer age, SexClient sex) {
    }

    public static Client clientFrom (ClientDTO dto){
        return builder()
                .id(dto.getId())
                .name(dto.getName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .age(dto.getAge())
                .sex(dto.getSex())
                .build();
    }
    public static Client clientSaved (ClientDTO dto){
        return builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .age(dto.getAge())
                .sex(dto.getSex())
                .build();
    }

}
