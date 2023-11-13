package br.com.api.desapegai.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import br.com.api.desapegai.Model.Ad;
import br.com.api.desapegai.Model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserSpringSecurity implements UserDetails{

    private Long id;
    private String name;
    private String username;
    private String email;
    private String password; 
    private String address;
    private String phone;
    private List<Ad> ads; // Anúncios publicados pelo usuário
    private List<Role> roles = new ArrayList<>();


    

    @Override
    public java.util.Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {  
        return true;
    }

    

}


