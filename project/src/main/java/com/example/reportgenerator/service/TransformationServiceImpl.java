
package com.example.reportgenerator.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reportgenerator.model.InputData;
import com.example.reportgenerator.model.OutputData;
import com.example.reportgenerator.model.ReferenceData;
import com.example.reportgenerator.model.Report;
import com.example.reportgenerator.utils.FileStorageService;

@Service
public class TransformationServiceImpl implements TransformationService {

    @Autowired
    private FileStorageService fileStorageService;

    private void writeOutputData(String outputFileName, List<OutputData> outputDataList) throws IOException {

        fileStorageService.writeOutputData(outputFileName, outputDataList);
    }

    @Override
    public List<OutputData> transformData(List<CSVRecord> inputRecords, List<CSVRecord> referenceRecords) {
        List<OutputData> reports = new ArrayList<>();


        // transorm the data as per logic given
        for (CSVRecord inputRecord : inputRecords) {
    
            String field1 = inputRecord.get("field1");
            String field2 = inputRecord.get("field2");
            BigDecimal field5 = new BigDecimal(inputRecord.get("field5"));
            String refkey1 = inputRecord.get("refkey1");
            String refkey2 = inputRecord.get("refkey2");

    
            Optional<CSVRecord> matchingReference = referenceRecords.stream()
                    .filter(record -> refkey1.equals(record.get("refkey1")) && refkey2.equals(record.get("refkey2")))
                    .findFirst();

            if (matchingReference.isPresent()) {
                CSVRecord referenceRecord = matchingReference.get();
                String refdata1 = referenceRecord.get("refdata1");
                String refdata2 = referenceRecord.get("refdata2");
                String refdata3 = referenceRecord.get("refdata3");
                BigDecimal refdata4 = new BigDecimal(referenceRecord.get("refdata4"));
 
                String outfield1 = field1 + field2;
                String outfield2 = refdata1;
                String outfield3 = refdata2 + refdata3;
                BigDecimal outfield4 = field5.multiply(BigDecimal.valueOf(Math.max(field5.doubleValue(), refdata4.doubleValue())));
                BigDecimal outfield5 = BigDecimal.valueOf(Math.max(field5.doubleValue(), refdata4.doubleValue()));
        
                OutputData outputData = new OutputData(outfield1, outfield2, outfield3, outfield4, outfield5);

                reports.add(outputData);
            } else {
                System.out.println("Matching reference record not found for refkey1=" + refkey1 + " and refkey2=" + refkey2);
            }
        }

        // return the generated reports
        return reports;
    }
}
