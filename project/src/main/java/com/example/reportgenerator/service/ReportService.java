package com.example.reportgenerator.service;

import org.springframework.web.multipart.MultipartFile;

public interface ReportService {

    void processCSVFiles(MultipartFile inputFile, MultipartFile referenceFile) throws Exception;
}
