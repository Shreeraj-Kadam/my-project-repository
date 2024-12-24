package edu.qs.runner;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.qs.entity.CitizenPlan;
import edu.qs.repository.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner{
	
	@Autowired
	private CitizenPlanRepository repository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		/*
		
		// Cash Plan Data - approved
		CitizenPlan c1 = new CitizenPlan("Jhon", "male", "Cash", "Approved", LocalDate.now(), LocalDate.now().plusMonths(6), 5000.0, null, null, null);
		
		// Cash Plan Data - denied
		CitizenPlan c2 = new CitizenPlan("Smith", "male", "Cash", "Denied", null, null, null, "Rental Income", null, null);
		
		// Cash Plan Data - terminated
		CitizenPlan c3 = new CitizenPlan("Mini", "female", "Cash", "Terminated", LocalDate.now().minusMonths(4), LocalDate.now().plusMonths(2), 5000.0, null, LocalDate.now(), "Employeed");
		
		
		// Food Plan Data - approved
		CitizenPlan c4 = new CitizenPlan("David", "male", "Food", "Approved", LocalDate.now(), LocalDate.now().plusMonths(6), 4000.0, null, null, null);
				
		// Food Plan Data - denied
		CitizenPlan c5 = new CitizenPlan("Cathy", "female", "Food", "Denied", null, null, null, "Property Income", null, null);
				
		// Cash Plan Data - terminated
		CitizenPlan c6 = new CitizenPlan("Rohit", "male", "Food", "Terminated", LocalDate.now().minusMonths(4), LocalDate.now().plusMonths(2), 4000.0, null, LocalDate.now(), "Employeed");
		
		
		// Medical Plan Data - approved
		CitizenPlan c7 = new CitizenPlan("Charles", "male", "Medical", "Approved", LocalDate.now(), LocalDate.now().plusMonths(6), 6000.0, null, null, null);
						
		// Food Plan Data - denied
		CitizenPlan c8 = new CitizenPlan("Ruby", "female", "Medical", "Denied", null, null, null, "Property Income", null, null);
						
		// Cash Plan Data - terminated
		CitizenPlan c9 = new CitizenPlan("Rocky", "male", "Medical", "Terminated", LocalDate.now().minusMonths(4), LocalDate.now().plusMonths(2), 6000.0, null, LocalDate.now(), "Employeed");
		
		
		
		// Employment Plan Data - approved
		CitizenPlan c10 = new CitizenPlan("Darik", "male", "Employment", "Approved", LocalDate.now(), LocalDate.now().plusMonths(6), 7000.0, null, null, null);
								
		// Employment Plan Data - denied
		CitizenPlan c11 = new CitizenPlan("Lucy", "female", "Employment", "Denied", null, null, null, "Rental Income", null, null);
								
		// Employment Plan Data - terminated
		CitizenPlan c12 = new CitizenPlan("Kevin", "male", "Employment", "Terminated", LocalDate.now().minusMonths(4), LocalDate.now().plusMonths(2), 7000.0, null, LocalDate.now(), "Gov Job");
		
		
		repository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12));
		
		*/
		
	}

}
