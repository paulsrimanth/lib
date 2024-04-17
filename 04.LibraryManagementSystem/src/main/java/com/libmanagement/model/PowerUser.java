package com.libmanagement.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class PowerUser {
	@Id
	@GeneratedValue
	private Integer id;
	private String email;
	private String password;
	private String passReset;
	@OneToMany(targetEntity = Admin.class,cascade = CascadeType.ALL)
	@JoinColumn(name ="Pid",referencedColumnName = "id")
	private List<Admin> adminData;
	//Pid is poweruserId it will be added in Admin table ,
	//the id of power user will be added to a coloum of Pid in admin table
	//this acts a foriegn key
	

}
