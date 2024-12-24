package edu.qs.service;

import java.util.List;

import edu.qs.binding.SearchRequest;
import edu.qs.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	
	public boolean exportPdf(HttpServletResponse response) throws Exception;
	
	
}
