package pt.digitalnext.mapstruct.domain.dto;

import lombok.Data;

@Data
public class ClientDTO {

    private String name;
    private String username;
    private String phone;
    private String birthDate;
    private String cc;
    private String nif;
}
