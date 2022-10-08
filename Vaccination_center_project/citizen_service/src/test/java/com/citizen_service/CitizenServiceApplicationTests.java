package com.citizen_service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citizen_service.entity.Citizen;
import com.citizen_service.repository.CitizenRepository;

@SpringBootTest
class CrudDemo01ApplicationTests {
	@Autowired
	private CitizenRepository citizenRepo;

	@Test
	void saveCitizen() {
		Citizen s1 = new Citizen();
		s1.setId(2);
		s1.setCitizenName("siddu");
		s1.setMobileNumber(8106595594l);
		s1.setAdhaarNumber(244025543261l);
		s1.setVaccinationCenterId(1);
		citizenRepo.save(s1);

	}

	@Test
	void gatAllCitizens() {
		List<Citizen> findAll = citizenRepo.findAll();
		for (Citizen citizen : findAll) {
			System.out.println(citizen.getId());
			System.out.println(citizen.getCitizenName());
			System.out.println(citizen.getAdhaarNumber());
			System.out.println(citizen.getMobileNumber());
			System.out.println(citizen.getVaccinationCenterId());
		}
	}

	@Test
	void deleteCitizenById() {
		citizenRepo.deleteById(1);
	}

	@Test
	void getCitizenById() {
		Optional<Citizen> findById = citizenRepo.findById(1);
		Citizen citizen = findById.get();
		System.out.println(citizen.getId());
		System.out.println(citizen.getCitizenName());
		System.out.println(citizen.getMobileNumber());
		System.out.println(citizen.getAdhaarNumber());
		System.out.println(citizen.getVaccinationCenterId());
	}

	@Test
	void updateCitizen() {
		Optional<Citizen> findById = citizenRepo.findById(1);
		Citizen citizen = findById.get();
		citizen.setAdhaarNumber(244025553621l);
		citizenRepo.save(citizen);
	}

}
