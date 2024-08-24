package ru.d3m4k.auth_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistryRequest {

    private String login;
    private String email;
    private String name;
    private String surname;
    private int codeGroup;

}
