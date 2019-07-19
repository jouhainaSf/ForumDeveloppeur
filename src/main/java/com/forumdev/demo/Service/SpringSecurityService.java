package com.forumdev.demo.Service;

import com.forumdev.demo.Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SpringSecurityService implements UserDetails {

    private User user;

    public SpringSecurityService(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        this.user.getTypeList().forEach(t->{
            GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(t);
            grantedAuthorities.add(grantedAuthority);
                }
                );
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPwd();
    }

    @Override
    public String getUsername() {
        return user.getFirstName()+" "+user.getLastName();
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
        return user.getType().equals("owner");
    }
}
