package com.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entity.Registration;
import com.demo.repository.RegistrationRepository;

@SpringBootTest
class Demo1ApplicationTests {

	@Autowired
	private RegistrationRepository registrationRepo;

	@Test
	public void saveReg() {
		Registration reg = new Registration();
		reg.setName("mike");
		reg.setEmail("mike@gmail.com");
		reg.setMobile("8207605712");

		registrationRepo.save(reg);
	}

	@Test
	public void deleteReg() {
		registrationRepo.deleteById(7l);
	}

	@Test
	public void findById() {

		Optional<Registration> opReg = registrationRepo.findById(1l);

		if (opReg.isPresent()) {
			Registration registration = opReg.get();
			System.out.println(registration.getId() + "--" + registration.getName() + "--" + registration.getEmail()
					+ "--" + registration.getMobile());
		} else {
			System.out.println("Record Not Found");
		}
	}

	@Test
	public void getAllReg() {
		Iterable<Registration> registrations = registrationRepo.findAll();

		for (Registration reg : registrations) {
			System.out.println(reg.getId() + "--" + reg.getName() + "--" + reg.getEmail() + "--" + reg.getMobile());
		}
	}

	@Test
	public void findRegByEmail() {

		Registration reg = registrationRepo.findRegByEmail("mike@gmail.com");

		System.out.println(reg.getId() + "--" + reg.getName() + "--" + reg.getEmail() + "--" + reg.getMobile());
	}

	@Test
	public void findByMobile() {

//		Optional<Registration> opReg = registrationRepo.findByMobile("8207605712");

		Registration reg = registrationRepo.findByMobile("8207605712");
	//	Registration reg = opReg.get();
		System.out.println(reg.getId() + "--" + reg.getName() + "--" + reg.getEmail() + "--" + reg.getMobile());
	}

	@Test
	public void findRegByEmailOrMobile() {

//		Iterable<Registration> registrations = registrationRepo.findByEmailOrMobile("mike@gmail.com", "8207605712");
//
//		for (Registration reg : registrations) {
//			System.out.println(reg.getId() + "--" + reg.getName() + "--" + reg.getEmail() + "--" + reg.getMobile());
//		}
		
		List<Registration> registrations = registrationRepo.findByEmailOrMobile("mike@gmail.com", "8207605712");

		for (Registration reg : registrations) {
			System.out.println(reg.getId() + "--" + reg.getName() + "--" + reg.getEmail() + "--" + reg.getMobile());
		}
	}
	
	@Test
	public void findByEmailAndMobile() {
		
		Optional<Registration> opReg = registrationRepo.findByEmailAndMobile("mike@gmail.com","8207605712");
		
		Registration reg = opReg.get();
		System.out.println(reg.getId() + "--" + reg.getName() + "--" + reg.getEmail() + "--" + reg.getMobile());
		
		
		
	}

}
