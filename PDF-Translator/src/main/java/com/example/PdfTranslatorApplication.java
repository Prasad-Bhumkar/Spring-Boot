package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;

@SpringBootApplication
public class PdfTranslatorApplication {

    @Value("${translation.api.key}")
    private String apiKey;

    public static void main(String[] args) {
        SpringApplication.run(PdfTranslatorApplication.class, args);
    }

    @Bean
    public Translate translate() {
        return TranslateOptions.newBuilder().setApiKey(apiKey).build().getService();
    }
}