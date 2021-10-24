package ru.cchgeu.electronicassistantbackend.services.impl;

import org.springframework.stereotype.Service;
import ru.cchgeu.electronicassistantbackend.model.dto.UserDto;
import ru.cchgeu.electronicassistantbackend.utils.ConverterPDF;
import ru.cchgeu.electronicassistantbackend.utils.OperationResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UserReference {
    public OperationResponse createReferenceTraining(UserDto user){

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        UUID uuid = UUID.randomUUID();

        String reference = "<!DOCTYPE html>\n" +
                "<html lang=\"ru\">\n" +
                "<style>\n" +
                "    .default-block {\n" +
                "        margin: 40px 100px 0;\n" +
                "        padding: 0;\n" +
                "    }\n" +
                "    .header {\n" +
                "        text-align: center;\n" +
                "    }\n" +
                "    .block-right {\n" +
                "        text-align: right;\n" +
                "        margin-bottom: 40px;\n" +
                "    }\n" +
                "    .block-normal {\n" +
                "        word-break: normal;\n" +
                "        margin-bottom: 40px;\n" +
                "    }\n" +
                "    body {\n" +
                "        font-size: 10px;\n" +
                "        margin: 40px 80px 20px;\n" +
                "        line-height: 1.5;\n" +
                "        padding: 0;\n" +
                "    }\n" +
                "</style>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"header default-block\">\n" +
                "        <p>\n" +
                "            МИНИСТЕРСТВО НАУКИ И ВЫСШЕГО ОБРАЗОВАНИЯ РФ <br>\n" +
                "            ФЕДЕРАЛЬНОЕ ГОСУДАРСТВЕННОЕ БЮДЖЕТНОЕ <br>\n" +
                "            ОБРАЗОВАТЕЛЬНОЕ УЧЕРЕЖДЕНИЕ  ВЫСШЕГО ОБРАЗОВАНИЯ <br>\n" +
                "            «Воронежский государственный технический университет» <br>\n" +
                "            ФГБОУ ВО «ВГТУ» <br> <br>\n" +
                "            СПРАВКА № " + uuid + "\n" +
                "        </p>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"block-right\">\n" +
                "        <p>\n" +
                "            "+ formatForDateNow.format(dateNow)+"\n" +
                "        </p>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"block-normal\">\n" +
                "        Дана " + user.getFIO() + " в том, что он (она) действительно является студенотом " + user.getCourse() + " курса, " + user.getFacultet() + ",\n" +
                "        очного (дневного) обучения группы " + user.getGroupp()+", с " + user.getDate_start() + " планируемая дата окончания\n" +
                "        обучения " + user.getDate_end() + ", обучение на " + user.getType_training()+ " основе<br>\n" +
                "        Справка выдана для предоставления " + user.getLocationsreferences() + ".<br>\n" +
                "        <br>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";



        String pathToFile = "src/main/resources/referencesOK/";


        ConverterPDF convert = new ConverterPDF();
        convert.convertert(reference,pathToFile + user.getFileName()+ "_" + formatForDateNow.format(dateNow) + ".pdf");
        return new OperationResponse("Pdf успешно создан!!!");
    }
}
