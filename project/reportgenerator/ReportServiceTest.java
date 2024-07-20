package com.example.reportgenerator.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class ReportServiceTest {

    @Autowired
    private ReportService reportService;

    @Test
    public void testProcessCSVFiles() throws Exception {
        String inputCsvContent = "field1,field2,field3,field4,field5,refkey1,refkey2\nvalue1,value2,value3,value4,10.5,key1,key2";
        MultipartFile inputFile = new MockMultipartFile("input.csv", "input.csv",
                "text/csv", inputCsvContent.getBytes(StandardCharsets.UTF_8));

        String referenceCsvContent = "refkey1,refdata1,refkey2,refdata2,refdata3,refdata4\nkey1,data1,key2,data2,data3,8.5";
        MultipartFile referenceFile = new MockMultipartFile("reference.csv", "reference.csv",
                "text/csv", referenceCsvContent.getBytes(StandardCharsets.UTF_8));

        reportService.processCSVFiles(inputFile, referenceFile);        
    }
}
