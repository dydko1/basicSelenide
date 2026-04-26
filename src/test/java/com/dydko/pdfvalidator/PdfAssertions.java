package com.dydko.pdfvalidator;

import java.util.Map;

public class PdfAssertions {

    private final String pdfText;

    public PdfAssertions(String pdfText) {
        this.pdfText = pdfText;
    }

    public void shouldContain(Map<String, String> expected) {

        expected.forEach((field, value) -> {
            String normalizedValue = normalize(value);

            if (!pdfText.contains(normalizedValue)) {
                throw new AssertionError(
                        "❌ Brak pola: " + field +
                        "\nExpected: " + value +
                        "\n--- PDF TEXT ---\n" + pdfText
                );
            }
        });
    }

    private String normalize(String text) {
        return text
                .replace('\u00A0', ' ')
                .replaceAll("\\s+", " ")
                .trim()
                .toLowerCase();
    }
}