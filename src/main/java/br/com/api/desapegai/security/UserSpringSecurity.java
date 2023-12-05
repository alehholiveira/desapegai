package br.com.api.desapegai.security;


import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import br.com.api.desapegai.Model.Ad;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserSpringSecurity implements UserDetails{

    private long id;
    private String name;
    private String username;
    private String email;
    private String password; 
    private String address;
    private String phone;
    private List<Ad> ads; // Anúncios publicados pelo usuário
    Collection<? extends GrantedAuthority> role;


    

    public UserSpringSecurity(long new_id, String new_name, String new_username, String new_email,
     String new_password, String new_address, String new_phone, List<Ad> new_ads,Collection<? extends GrantedAuthority> new_role){
        this.id = new_id;
        this.name = new_name;
        this.username = new_username;
        this.email = new_email;
        this.password = new_password;
        this.address = new_address;
        this.phone = new_phone;
        this.ads = new_ads;
        this.role = new_role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role;
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


