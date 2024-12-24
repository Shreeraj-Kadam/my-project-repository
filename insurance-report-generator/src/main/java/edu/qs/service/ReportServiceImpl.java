package edu.qs.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import edu.qs.binding.SearchRequest;
import edu.qs.entity.CitizenPlan;
import edu.qs.repository.CitizenPlanRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository repository;

	@Override
	public List<String> getPlanNames() {

		return repository.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {

		return repository.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {

		CitizenPlan cp = new CitizenPlan();

		if (request.getPlanName() != null && !request.getPlanName().equals("")) {

			cp.setPlanName(request.getPlanName());
		}

		if (request.getGender() != null && !request.getGender().equals("")) {

			cp.setGender(request.getGender());
		}

		if (request.getPlanStatus() != null && !request.getPlanStatus().equals("")) {
			cp.setPlanStatus(request.getPlanStatus());
		}

		if (request.getPlanStartDate() != null && !request.getPlanStartDate().equals("")) {

			cp.setPlanStartDate(LocalDate.parse(request.getPlanStartDate()));
		}

		if (request.getPlanEndDate() != null && !request.getPlanEndDate().equals("")) {

			cp.setPlanEndDate(LocalDate.parse(request.getPlanEndDate()));
		}

		return repository.findAll(Example.of(cp));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {

		List<CitizenPlan> records = repository.findAll();
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plan-sheet");
		Row headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("Id");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Plan Start Date");
		headerRow.createCell(5).setCellValue("Plan End Date");
		headerRow.createCell(6).setCellValue("Benefit Amount");

		int rowNum = 1;
		for (CitizenPlan plan : records) {
			Row dataRow = sheet.createRow(rowNum);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());
			if (plan.getPlanStartDate() != null) {
				dataRow.createCell(4).setCellValue(plan.getPlanStartDate() + "");
			} else {
				dataRow.createCell(4).setCellValue("N/A");
			}

			if (plan.getPlanEndDate() != null) {
				dataRow.createCell(5).setCellValue(plan.getPlanEndDate() + "");
			} else {
				dataRow.createCell(5).setCellValue("N/A");
			}

			if (plan.getBenefitAmt() != null) {
				dataRow.createCell(6).setCellValue(plan.getBenefitAmt());
			} else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			rowNum++;
		}

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		return false;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		Document document = new Document();
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();

		Paragraph p = new Paragraph("citizen Plan Info");
		document.add(p);

		PdfPTable table = new PdfPTable(6);
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan Start Date");
		table.addCell("Plan End Date");

		List<CitizenPlan> plans = repository.findAll();

		for (CitizenPlan plan : plans) {

			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate() + "");
			table.addCell(plan.getPlanEndDate() + "");

		}

		document.add(table);
		document.close();

		return false;
	}

}
