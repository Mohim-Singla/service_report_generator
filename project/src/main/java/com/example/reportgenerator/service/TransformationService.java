package com.example.reportgenerator.service;

import java.util.List;

import org.apache.commons.csv.CSVRecord;

import com.example.reportgenerator.model.OutputData;
import com.example.reportgenerator.model.Report;

public interface TransformationService {

    List<OutputData> transformData(List<CSVRecord> inputRecords, List<CSVRecord> referenceRecords);
}
