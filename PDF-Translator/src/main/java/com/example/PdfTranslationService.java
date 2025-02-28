package com.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateException;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.Translation;

@Service
public class PdfTranslationService {

    @Autowired
    private Translate translate;

    public String translatePdf(InputStream inputStream, String targetLanguage) throws IOException {
        if (inputStream == null) {
            throw new NullPointerException("Input stream cannot be null");
        }

        try (PDDocument document = PDDocument.load(inputStream)) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);

            Translation translation = translate.translate(text, TranslateOption.targetLanguage(targetLanguage));
            return translation.getTranslatedText();
        } catch (TranslateException e) {
            throw new IOException("Translation failed", e);
        }
    }
}
