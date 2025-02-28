package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PdfTranslationController {

    @Autowired
    private PdfTranslationService pdfTranslationService;

    @PostMapping("/translate")
    public ResponseEntity<String> translatePdf(@RequestParam("file") MultipartFile file,
                                               @RequestParam("language") String targetLanguage) {
        if (file.isEmpty() || targetLanguage == null || targetLanguage.isEmpty()) {
            return new ResponseEntity<>("Invalid input parameters.", HttpStatus.BAD_REQUEST);
        }
        String result;
        try {
            result = pdfTranslationService.translatePdf(file.getInputStream(), targetLanguage);
        } catch (IOException e) {
            return new ResponseEntity<>("Error processing file", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>("Error during translation", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
