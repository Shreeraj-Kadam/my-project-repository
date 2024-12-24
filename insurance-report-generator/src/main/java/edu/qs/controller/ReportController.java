package edu.qs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.qs.binding.SearchRequest;
import edu.qs.service.ReportService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attach;filename=plan.xls");
		
		service.exportExcel(response);
		
	}
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/application/pdf");
		response.addHeader("Content-Disposition", "attach;filename=plan.pdf");
		service.exportPdf(response);
	}
	
	
	@PostMapping("/handle_search")
	public String handleSearch(@ModelAttribute("search") SearchRequest request, Model model, HttpServletRequest req  ) {
		
		req.setAttribute("plans", service.search(request));
		
		init(model);
		System.out.println(request);
		return "index";
	}
	
	
	@GetMapping("/")
	public String indexPage(Model model) {
		
				
		SearchRequest searchObj = new SearchRequest();
		model.addAttribute("search" , searchObj);
		init(model);
		
		return "index";
	}


	private void init(Model model) {

		
		model.addAttribute("names", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatus());
	}
	
}
