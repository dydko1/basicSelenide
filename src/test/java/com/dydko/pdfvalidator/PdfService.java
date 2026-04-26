package com.dydko.pdfvalidator;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.InputStream;

public class PdfService {

    public static String read(String fileName) throws Exception {
        InputStream is = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("pdf/" + fileName);

        if (is == null) {
            throw new RuntimeException("Nie znaleziono PDF: " + fileName);
        }

        PDDocument document = Loader.loadPDF(is.readAllBytes());
        String text = new PDFTextStripper().getText(document);
        document.close();

        return normalize(text);
    }

    private static String normalize(String text) {
        return text
                .replace('\u00A0', ' ')
                .replaceAll("\\s+", " ")
                .trim()
                .toLowerCase();
    }
}