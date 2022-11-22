package com.example.SecuCom.Payload;

import lombok.Data;

@Data
public class SignUpDto {
    private String nom;
    private String prenom;
    private String nomutilisateur;
    private String email;
    private String password;
}
