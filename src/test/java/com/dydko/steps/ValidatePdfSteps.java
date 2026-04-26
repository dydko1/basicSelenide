package com.dydko.steps;

import com.dydko.pdfvalidator.PdfAssertions;
import com.dydko.pdfvalidator.PdfService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.Map;

public class ValidatePdfSteps {
    @Then("PDF {string} should contain:")
    public void pdfShouldContain(String fileName, DataTable table) throws Exception {

        String pdfText = PdfService.read(fileName);

        Map<String, String> expected = table.asMap(String.class, String.class);

        new PdfAssertions(pdfText).shouldContain(expected);
    }
}
