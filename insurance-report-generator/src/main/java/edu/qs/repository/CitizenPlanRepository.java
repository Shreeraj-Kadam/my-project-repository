package edu.qs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.qs.entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer>{
	
	@Query("select distinct(planName) from CitizenPlan") // hql query
	public List<String> getPlanNames();
	
	@Query("select distinct(planStatus) from CitizenPlan") // hql query
	public List<String> getPlanStatus();
	
	
	
}
