package ru.cchgeu.electronicassistantbackend.services.impl;

import org.springframework.stereotype.Service;
import ru.cchgeu.electronicassistantbackend.services.ReferenceService;
import ru.cchgeu.electronicassistantbackend.utils.ConverterPDF;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Service
public class ReferenceImpl implements ReferenceService {

    private final ConverterPDF converter;

    public ReferenceImpl() {
        this.converter = new ConverterPDF();
    }


    @Override
    public void getReference() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("src/main/resources/static/CertificateOfTraining.html")));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка 1");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Ошибка 2");
                }
            }
        }
    }
}