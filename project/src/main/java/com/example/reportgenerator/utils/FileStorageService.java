package com.example.reportgenerator.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.reportgenerator.model.InputData;
import com.example.reportgenerator.model.OutputData;
import com.example.reportgenerator.model.ReferenceData;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}") 
    private String uploadDir;

    public Path storeFile(MultipartFile file) throws IOException {
        Files.createDirectories(Paths.get(uploadDir));
        Path targetLocation = Paths.get(uploadDir).resolve(file.getOriginalFilename()).normalize();
        file.transferTo(targetLocation);
        return targetLocation;
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(Paths.get(uploadDir).toFile());
    }

    public void writeOutputData(List<OutputData> outputDataList) throws IOException {
        String filename = uploadDir + "/output.csv";

        try (FileWriter writer = new FileWriter(filename)) {
            
            writer.append("outfield1,outfield2,outfield3,outfield4,outfield5\n");

            
            for (OutputData outputData : outputDataList) {
                writer.append(outputData.getOutfield1());
                writer.append(",");
                writer.append(outputData.getOutfield2());
                writer.append(",");
                writer.append(outputData.getOutfield3());
                writer.append(",");
                writer.append(outputData.getOutfield4().toString()); 
                writer.append(",");
                writer.append(outputData.getOutfield5().toString()); 
                writer.append("\n");
            }

            System.out.println("Output CSV file was created successfully!");
        } catch (IOException e) {
            System.out.println("Error writing the output CSV file: " + e.getMessage());
            throw e;
        }
    }

    public List<InputData> loadInputData(String inputFileName) throws IOException {
        List<InputData> inputDataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(uploadDir + "/" + inputFileName))) {
            
            String line = reader.readLine(); 

            
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length != 7) {
                    
                    continue;
                }

                
                String field1 = fields[0].trim();
                String field2 = fields[1].trim();
                String field3 = fields[2].trim();
                String field4 = fields[3].trim();
                BigDecimal field5 = new BigDecimal(fields[4].trim());
                String refkey1 = fields[5].trim();
                String refkey2 = fields[6].trim();

                
                InputData inputData = new InputData(field1, field2, field3, field4, field5, refkey1, refkey2);
                inputDataList.add(inputData);
            }

            System.out.println("Loaded " + inputDataList.size() + " records from input CSV file.");
        } catch (IOException e) {
            System.out.println("Error loading input CSV file: " + e.getMessage());
            throw e;
        }

        return inputDataList;
    }

    public List<ReferenceData> loadReferenceData(String referenceFileName) throws IOException {
        List<ReferenceData> referenceDataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(uploadDir + "/" + referenceFileName))) {
            
            String line = reader.readLine(); 

            
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length != 6) {
                    
                    continue;
                }

                
                String refkey1 = fields[0].trim();
                String refdata1 = fields[1].trim();
                String refkey2 = fields[2].trim();
                String refdata2 = fields[3].trim();
                String refdata3 = fields[4].trim();
                BigDecimal refdata4 = new BigDecimal(fields[5].trim());

                
                ReferenceData referenceData = new ReferenceData(refkey1, refdata1, refkey2, refdata2, refdata3, refdata4);
                referenceDataList.add(referenceData);
            }

            System.out.println("Loaded " + referenceDataList.size() + " records from reference CSV file.");
        } catch (IOException e) {
            System.out.println("Error loading reference CSV file: " + e.getMessage());
            throw e;
        }

        return referenceDataList;
    }

    public void writeOutputData(String outputFileName, List<OutputData> outputDataList) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
