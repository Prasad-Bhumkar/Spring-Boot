package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translation;

@SpringBootTest
public class PdfTranslatorApplicationTests {

    @Autowired
    private PdfTranslationService pdfTranslationService;

    @MockBean
    private Translate translate;

    @Test
    void testTranslatePdf() throws Exception {
        // Create a simple PDF document in memory
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PDDocument document = new PDDocument()) {
            document.addPage(new PDPage());
            document.save(outputStream);
        }

        String targetLanguage = "es"; // "es" for Spanish
        String originalText = "PDF content";
        String expectedTranslation = "Translated PDF content in Spanish";

        // Mock the API response
        Translation translation = new Translation() {
            @Override
            public String getTranslatedText() {
                return expectedTranslation;
            }
        };

        when(translate.translate(originalText, Translate.TranslateOption.targetLanguage(targetLanguage)))
            .thenReturn(translation);

        // Call the translatePdf method with a valid input stream
        String translatedContent = pdfTranslationService.translatePdf(new ByteArrayInputStream(outputStream.toByteArray()), targetLanguage);
        
        // Assert the expected output
        assertEquals(expectedTranslation, translatedContent);
    }

    @Test
    void testTranslatePdf_InvalidLanguage() throws Exception {
        // Create a simple PDF document in memory
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PDDocument document = new PDDocument()) {
            document.addPage(new PDPage());
            document.save(outputStream);
        }

        String targetLanguage = "invalid"; // Invalid language code
        String originalText = "PDF content";

        // Call the translatePdf method with an invalid language code
        try {
            pdfTranslationService.translatePdf(new ByteArrayInputStream(outputStream.toByteArray()), targetLanguage);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    void testTranslatePdf_NullInputStream() throws Exception {
        // Call the translatePdf method with a null input stream
        try {
            pdfTranslationService.translatePdf(null, "es");
            assert false;
        } catch (NullPointerException e) {
            assert true;
        }
    }

    @Test
    void testTranslatePdf_EmptyInputStream() throws Exception {
        // Call the translatePdf method with an empty input stream
        try {
            pdfTranslationService.translatePdf(new ByteArrayInputStream(new byte[0]), "es");
            assert false;
        } catch (IOException e) {
            assert true;
        }
    }
}