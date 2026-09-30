package com.praticando.tere_verde.model;



import java.util.Collection;
import java.util.List;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity 
public class Usuario implements UserDetails {

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column (unique = true)
    private String email;
    private String senha;
     @Column (nullable = false)
    @NotBlank()
    private String role;






    
     public String getId() {
         return id;
     }
     public void setId(String id) {
         this.id = id;
     }
     public String getEmail() {
         return email;
     }
     public void setEmail(String email) {
         this.email = email;
     }
     public String getSenha() {
         return senha;
     }
     public void setSenha(String senha) {
         this.senha = senha;
     }
     public String getRole() {
         return role;
     }
     public void setRole(String role) {
         this.role = role;
     }
     @Override
     public  Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(new SimpleGrantedAuthority (this.role));
      
}
     @Override
     public @Nullable String getPassword() {
        return senha;
     }
     @Override
     public String getUsername() {
        return email;
     }
     
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}
