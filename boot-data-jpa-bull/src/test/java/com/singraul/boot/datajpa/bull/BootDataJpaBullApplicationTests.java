package com.singraul.boot.datajpa.bull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.singraul.boot.datajpa.bull.entity.Bull;
import com.singraul.boot.datajpa.bull.repos.BullRepository;

@SpringBootTest
class BootDataJpaBullApplicationTests {

	@Autowired
	private BullRepository bullRepo;

	@Test
	void testSaveBull() {
		Bull bull = new Bull();
		bull.setBullId(23);
		bull.setBullName("Devendra");
		bull.setBullColor("Black");
		bull.setBullAge(6);

		bullRepo.save(bull);

		Bull bullSaved = bullRepo.findById(23).get();
		System.out.println(bullSaved);
		
		Assert.hasText(bullSaved.getBullName(), "Devendra");
		Assert.hasText(bullSaved.getBullColor(), "Black");
		Assert.notNull(bullSaved);
       
		
		// testing with Optional class
		Optional<Bull> bullOptional = bullRepo.findById(25);
		System.out.println("=======Bull=========\n"+bullOptional);
	}

}
