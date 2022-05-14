package ru.cchgeu.electronicassistantbackend.utils.reference;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.font.FontProvider;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ConverterPDF {

    public void convertert(String reference, String nameFile) {
        ConverterProperties converterProperties = new ConverterProperties();
        FontProvider fontProvider  = new FontProvider();
        fontProvider.addFont("src/main/resources/fonts/font.ttf","cp1251");
        fontProvider.addStandardPdfFonts();
        fontProvider.addSystemFonts();
        converterProperties.setFontProvider(fontProvider);
        try {
            HtmlConverter.convertToPdf(reference, new FileOutputStream(nameFile), converterProperties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
