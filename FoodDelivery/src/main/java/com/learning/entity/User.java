package com.learning.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.learning.entity.Role;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode
@ToString
//ORM mapping purpose
@Entity //entity class is used for ORM - from javax
//to customize table name
@Table(name = "register",uniqueConstraints = {@UniqueConstraint(columnNames = "userName"), @UniqueConstraint(columnNames = "email")})

public class User implements Comparable<User>{

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "regId")
	private Long id;
	
	@NotBlank
	@Size(max=20)
	private String userName;
	

	@Size(max=50)
	@NotBlank
	private String name;
	
	@NotBlank
	@Size(max=50)
	@Email
	private String email;
	
	@Size(max=100)
	@NotBlank
	private String password;
	
	@NotBlank
	private String address;

	@Override
	public int compareTo(User o) {
		 //TODO Auto-generated method stub
		//ascending
		return this.id.compareTo(o.getId());
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	//@JsonIgnore
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "regId"), 
	inverseJoinColumns = @JoinColumn(name = "roleId") )//relationship btwn registered user(regId) and role(roleId)
	private Set<Role> roles = new HashSet<>();
	
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    //@JsonSerialize(using = CustomListSerializer.class)
	//@JsonIgnore
	//@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
	private Login login;
	
	public User(String userName,String name,String email, String password,  String address) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
	}
	
	

}