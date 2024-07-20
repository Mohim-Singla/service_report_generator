package com.example.reportgenerator.service;

import java.nio.file.Path;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.reportgenerator.model.OutputData;
import com.example.reportgenerator.utils.CSVHelper;
import com.example.reportgenerator.utils.FileStorageService;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private TransformationService transformationService;

    @Override
    public void processCSVFiles(MultipartFile inputFile, MultipartFile referenceFile) throws Exception {
        // Store the input and the reference files in the file system
        Path inputFilePath = fileStorageService.storeFile(inputFile);
        Path referenceFilePath = fileStorageService.storeFile(referenceFile);

        // Parse the input and the reference files to get the CSV records
        List<CSVRecord> inputRecords = CSVHelper.parseCSV(inputFilePath);
        List<CSVRecord> referenceRecords = CSVHelper.parseCSV(referenceFilePath);

        // Call the transformation service to transform data and generate the reports
        List<OutputData> generatedReport = transformationService.transformData(inputRecords, referenceRecords);

        // Write the generated report to the file system
        fileStorageService.writeOutputData(generatedReport);
    }
}
