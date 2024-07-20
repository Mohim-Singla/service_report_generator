package com.example.reportgenerator.model;

import java.math.BigDecimal;

public class OutputData {
    private String outfield1;
    private String outfield2;
    private String outfield3;
    private BigDecimal outfield4;
    private BigDecimal outfield5;

    public OutputData() {
    }

    public OutputData(String outfield1, String outfield2, String outfield3, BigDecimal outfield4, BigDecimal outfield5) {
        this.outfield1 = outfield1;
        this.outfield2 = outfield2;
        this.outfield3 = outfield3;
        this.outfield4 = outfield4;
        this.outfield5 = outfield5;
    }

    public String getOutfield1() {
        return outfield1;
    }

    public void setOutfield1(String outfield1) {
        this.outfield1 = outfield1;
    }

    public String getOutfield2() {
        return outfield2;
    }

    public void setOutfield2(String outfield2) {
        this.outfield2 = outfield2;
    }

    public String getOutfield3() {
        return outfield3;
    }

    public void setOutfield3(String outfield3) {
        this.outfield3 = outfield3;
    }

    public BigDecimal getOutfield4() {
        return outfield4;
    }

    public void setOutfield4(BigDecimal outfield4) {
        this.outfield4 = outfield4;
    }

    public BigDecimal getOutfield5() {
        return outfield5;
    }

    public void setOutfield5(BigDecimal outfield5) {
        this.outfield5 = outfield5;
    }
}
