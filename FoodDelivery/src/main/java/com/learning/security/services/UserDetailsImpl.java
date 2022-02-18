package com.learning.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.entity.User;
import com.learning.security.services.UserDetailsImpl;

import lombok.Data;

@Data

public class UserDetailsImpl implements UserDetails {

	private Long id;

	private String name;
	
	private String userName;

	private String email;
	
	private String address;
	

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;
	// authorities are Roles

	private UserDetailsImpl(Long id, String name,String userName, String email, String password,String address,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.authorities = authorities;
	}

	
	public static UserDetailsImpl build(User user) {
		// TODO Auto-generated constructor stub
		List<GrantedAuthority> authorities = user.getRoles().stream() // it will transform ur set to stream
				.map(role -> new SimpleGrantedAuthority(role.getRoleName().toString())).collect(Collectors.toList());
		return new UserDetailsImpl(user.getId(), user.getName(),user.getUserName(), user.getEmail(), user.getPassword(),user.getAddress(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

}
