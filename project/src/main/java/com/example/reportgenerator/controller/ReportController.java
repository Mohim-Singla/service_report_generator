package com.example.reportgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.reportgenerator.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/generate")
    public String generateReports(@RequestBody MultipartFile  inputFile,
                                  @RequestBody MultipartFile referenceFile) throws Exception {
        System.out.println("generating call ed reports");
        reportService.processCSVFiles(inputFile, referenceFile);
        return "Reports generated successfully!";
    }
}
