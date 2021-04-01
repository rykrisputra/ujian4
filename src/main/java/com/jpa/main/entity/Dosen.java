package com.jpa.main.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="dosen")
public class Dosen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_dosen;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="nama_dosen")
	private String nama_dosen;
	
	@ManyToMany(mappedBy="dosens")
	private List<PlotMataKuliah> plotmatkuls;
}
