package com.example.reportgenerator.model;

import java.math.BigDecimal;

public class Report {
    private String outfield1;
    private String outfield2;
    private String outfield3;
    private BigDecimal outfield4;
    private BigDecimal outfield5;

    public Report() {
    }
    public Report(String outfield1, String outfield2, String outfield3, BigDecimal outfield4, BigDecimal outfield5) {
        this.outfield1 = outfield1;
        this.outfield2 = outfield2;
        this.outfield3 = outfield3;
        this.outfield4 = outfield4;
        this.outfield5 = outfield5;
    }

    // Getters and setters
}
