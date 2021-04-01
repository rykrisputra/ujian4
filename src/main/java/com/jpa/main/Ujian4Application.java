package com.jpa.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.main.entity.Admin;
import com.jpa.main.entity.Dosen;
import com.jpa.main.entity.Mahasiswa;
import com.jpa.main.entity.MataKuliah;
import com.jpa.main.entity.Nilai;
import com.jpa.main.entity.Pertanyaan;
import com.jpa.main.entity.PlotMataKuliah;
import com.jpa.main.entity.Soal;
import com.jpa.main.repository.AdminRepository;
import com.jpa.main.repository.DosenRepository;
import com.jpa.main.repository.MahasiswaRepository;
import com.jpa.main.repository.MataKuliahRepository;
import com.jpa.main.repository.NilaiRepository;
import com.jpa.main.repository.PertanyaanRepository;
import com.jpa.main.repository.PlotMataKuliahRepository;
import com.jpa.main.repository.SoalRepository;

@SpringBootApplication
public class Ujian4Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Ujian4Application.class, args);
	}
	
	@Autowired
	PlotMataKuliahRepository plotMataKuliahRepository;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	MataKuliahRepository mataKuliahRepository;
	@Autowired
	DosenRepository dosenRepository;
	@Autowired
	MahasiswaRepository mahasiswaRepository;
	@Autowired
	SoalRepository soalRepository;
	@Autowired
	PertanyaanRepository pertanyaanRepository;
	@Autowired
	NilaiRepository nilaiRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		PlotMataKuliah plotmatkul = new PlotMataKuliah();
		
		Admin admin = new Admin();
		admin.setUsername("Zero");
		admin.setPassword("000");
		
		Admin admin2 = new Admin();
		admin2.setUsername("One");
		admin2.setPassword("111");
		
		Dosen dosen = new Dosen();
		dosen.setNama_dosen("Manto");
		dosen.setUsername("mantooo");
		dosen.setPassword("hulahula");
		
		Dosen dosen2 = new Dosen();
		dosen2.setNama_dosen("Harum");
		dosen2.setUsername("haharurum");
		dosen2.setPassword("hahihu");
		
		MataKuliah matkul = new MataKuliah();
		matkul.setNamaMatKul("Basis Data");
		
		MataKuliah matkul2 = new MataKuliah();
		matkul2.setNamaMatKul("Basis Data");
		
		Mahasiswa mahasiswa = new Mahasiswa();
		mahasiswa.setNama_mhs("Rufus");
		mahasiswa.setJenis_kelamin("Laki-Laki");
		mahasiswa.setPassword("16116704");
		
		Mahasiswa mahasiswa2 = new Mahasiswa();
		mahasiswa2.setNama_mhs("Yudhis");
		mahasiswa2.setJenis_kelamin("Laki-Laki");
		mahasiswa2.setPassword("16116705");
		
		List<Mahasiswa> mahasiswas = new ArrayList<Mahasiswa>();
		mahasiswas.add(mahasiswa);
		mahasiswas.add(mahasiswa2);
		plotmatkul.setMahasiswas(mahasiswas);
		this.mahasiswaRepository.saveAll(mahasiswas);
		
		List<Admin> admins = new ArrayList<Admin>();
		admins.add(admin);
		admins.add(admin2);
		this.adminRepository.saveAll(admins);
		
		List<MataKuliah> matkuls = new ArrayList<MataKuliah>();
		matkuls.add(matkul);
		matkuls.add(matkul2);
		plotmatkul.setMatkuls(matkuls);
		this.mataKuliahRepository.saveAll(matkuls);
		
		List<Dosen> dosens = new ArrayList<Dosen>();
		dosens.add(dosen);
		dosens.add(dosen2);
		plotmatkul.setDosens(dosens);
		this.dosenRepository.saveAll(dosens);
		
		Soal soal = new Soal();
		soal.setNama_soal("Matematika");
		soal.setStatus(1);
		
		Pertanyaan pertanyaan1 = new Pertanyaan();
		pertanyaan1.setPertanyaan("1 + 1 =");
		pertanyaan1.setJawaban_1("2");
		pertanyaan1.setJawaban_2("1");
		pertanyaan1.setJawaban_3("3");
		pertanyaan1.setJawaban_4("4");
		pertanyaan1.setJawaban_benar("2");
		pertanyaan1.setStatus_gambar(1);
		
		Pertanyaan pertanyaan2= new Pertanyaan();
		pertanyaan2.setPertanyaan("1 * 1 =");
		pertanyaan2.setJawaban_1("2");
		pertanyaan2.setJawaban_2("1");
		pertanyaan2.setJawaban_3("3");
		pertanyaan2.setJawaban_4("4");
		pertanyaan2.setJawaban_benar("1");
		pertanyaan2.setStatus_gambar(2);
		
		List<Pertanyaan> lstPertanyaan = new ArrayList<Pertanyaan>();
		lstPertanyaan.add(pertanyaan1);
		lstPertanyaan.add(pertanyaan2);
		
		soal.setLstTanya(lstPertanyaan);
		this.soalRepository.save(soal);
		
		
		Nilai nilai1 = new Nilai();
		nilai1.setNilai(60);
		
		soal.setNilai(nilai1);
		this.soalRepository.save(soal);
		
		
		
		
	}

}
