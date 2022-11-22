package com.example.SecuCom.Securite;

import com.example.SecuCom.Modele.Collaborateurs;
import com.example.SecuCom.Modele.Role;
import com.example.SecuCom.Repository.CollaborateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CollaborateurRepository collaborateurRepository;


    public CustomUserDetailsService(CollaborateurRepository collaborateurRepository) {
        this.collaborateurRepository = collaborateurRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String nomutilisateurOrEmail) throws UsernameNotFoundException {
        Collaborateurs collaborateurs = collaborateurRepository.findByNomutilisateurOrEmail(nomutilisateurOrEmail, nomutilisateurOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email:" + nomutilisateurOrEmail));
        return new org.springframework.security.core.userdetails.User(collaborateurs.getEmail(),
                collaborateurs.getPassword(), mapRolesToAuthorities(collaborateurs.getRoles()));
    }


    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNom())).collect(Collectors.toList());
    }
}
