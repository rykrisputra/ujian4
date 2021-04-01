package com.jpa.main.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="plotmatakuliah")
public class PlotMataKuliah {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_plot_matkul;
	
	@ManyToMany
    @JoinTable(
        name = "plotmatakuliah",
        joinColumns= @JoinColumn(name="id_plot_matkul", referencedColumnName="id_plot_matkul"),
        inverseJoinColumns= @JoinColumn(name="id_MatKul", referencedColumnName="idMatKul"))
	private List<MataKuliah> matkuls = new ArrayList<MataKuliah>();
	
	@ManyToMany
    @JoinTable(
        name = "plotmatakuliah",
        joinColumns= @JoinColumn(name="id_plot_matkul", referencedColumnName="id_plot_matkul"),
        inverseJoinColumns= @JoinColumn(name="id_dosen", referencedColumnName="id_dosen"))
	private List<Dosen> dosens = new ArrayList<Dosen>();
	
	@ManyToMany
    @JoinTable(
        name = "plotmatakuliah",
        joinColumns= @JoinColumn(name="id_plot_matkul", referencedColumnName="id_plot_matkul"),
        inverseJoinColumns= @JoinColumn(name="nim", referencedColumnName="nim"))
	private List<Mahasiswa> mahasiswas = new ArrayList<Mahasiswa>();
	
}
