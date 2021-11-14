package ru.cchgeu.electronicassistantbackend.services.impl;

import com.google.zxing.WriterException;
import org.springframework.stereotype.Service;
import ru.cchgeu.electronicassistantbackend.model.dto.UserReferenceDto;
import ru.cchgeu.electronicassistantbackend.model.entity.references.Format_reference;
import ru.cchgeu.electronicassistantbackend.model.entity.references.Reference;
import ru.cchgeu.electronicassistantbackend.model.entity.references.Status_reference;
import ru.cchgeu.electronicassistantbackend.model.entity.references.Type_reference;
import ru.cchgeu.electronicassistantbackend.repositories.ReferenceRepository;
import ru.cchgeu.electronicassistantbackend.utils.ConverterPDF;
import ru.cchgeu.electronicassistantbackend.utils.OperationResponse;
import ru.cchgeu.electronicassistantbackend.utils.QRCodeGeneration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class ReferenceService {

    private final ReferenceRepository referenceRepository;

    public ReferenceService(ReferenceRepository referenceRepository) {
        this.referenceRepository = referenceRepository;
    }

    public OperationResponse createReferenceTraining(UserReferenceDto userReferenceDto) throws IOException, WriterException {

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        String dateCreating = formatForDateNow.format(dateNow);

        java.sql.Date dateCreatingReference = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//        DataTime
        UUID uuid = UUID.randomUUID();

        String pathToQRC = "./src/main/resources/QRCodes/" + userReferenceDto.getId().toString() + "QRCode-" + dateCreating + ".jpg";
        String urlApiCheckReference = "http://localhost:8082/api/reference/verification?uuid-reference=" + uuid;
        QRCodeGeneration QRCode = new QRCodeGeneration();
        QRCode.generatQRCode(urlApiCheckReference,pathToQRC);
        String referenceText = "<!DOCTYPE html>\n" +
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
                "            "+ dateCreating +"\n" +
                "        </p>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"block-normal\">\n" +
                "        Дана " + userReferenceDto.getFIO() + " в том, что он (она) действительно является студенотом " + userReferenceDto.getCourse() + " курса, " + userReferenceDto.getFacultet() + ",\n" +
                "        очного (дневного) обучения группы " + userReferenceDto.getGroupp()+", с " + userReferenceDto.getDate_start() + " планируемая дата окончания\n" +
                "        обучения " + userReferenceDto.getDate_end() + ", обучение на " + userReferenceDto.getType_training()+ " основе<br>\n" +
                "        Справка выдана для предоставления " + userReferenceDto.getLocationsreferences() + ".<br>\n" +
                "        <br>\n" +
                "    </div>\n" +
                " <div style=\"text-align: right;\"><img alt=\"\" src=\""+ pathToQRC + "\"></div>" +
                "</body>\n" +
                "</html>";

        String pathToFile = "src/main/resources/referencesOK/";

        ConverterPDF convert = new ConverterPDF();
        convert.convertert(referenceText,pathToFile + userReferenceDto.getFileName()+ "_" + dateCreating + ".pdf");
        Reference reference = new Reference(uuid.toString(),userReferenceDto.getId(), Status_reference.READY ,dateCreatingReference, Type_reference.WORK, Format_reference.ELECTRONIC);
        referenceRepository.save(reference);
       return new OperationResponse("Pdf успешно создан!!!");
    }

    public OperationResponse verificationQRCodeReference(String uuidReference) {

        if(referenceRepository.findById(uuidReference).isPresent())
        {return new OperationResponse("Ok");}
        return new OperationResponse("Bad");
    }

}
