package br.com.phoebustecnologia.Library.model;

import br.com.phoebustecnologia.Library.dto.ClientDTO;
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

    private static final Long serialVersionUID = 12345L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private SexClient sex;

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

}
