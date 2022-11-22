package com.example.SecuCom.Modele;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "collaborateurs", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nomutilisateur"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class Collaborateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String nomutilisateur;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "collaborateurs_roles",
            joinColumns = @JoinColumn(name = "collaborateurs_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
}
