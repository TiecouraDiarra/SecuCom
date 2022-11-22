package com.example.SecuCom.Repository;

import com.example.SecuCom.Modele.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNom(String nom);
}
