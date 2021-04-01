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
@Table(name="mahasiswa")
public class Mahasiswa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nim;
	@Column(name="password")
	private String password;
	@Column(name="jenis_kelamin")
	private String jenis_kelamin;
	@Column(name="nama_mhs")
	private String nama_mhs;
	
	@ManyToMany(mappedBy="mahasiswas")
	private List<PlotMataKuliah> plotmatkuls;
}
