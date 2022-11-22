package com.example.SecuCom.Repository;

import com.example.SecuCom.Modele.Collaborateurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollaborateurRepository extends JpaRepository<Collaborateurs, Long> {
    Optional<Collaborateurs> findByEmail(String email);
    Optional<Collaborateurs> findByNomutilisateurOrEmail(String nomutilisateur, String email);
    Optional<Collaborateurs> findByNomutilisateur(String nomutilisateur);
    Boolean existsByNomutilisateur(String nomutilisateur);
    Boolean existsByEmail(String email);
}
