package ru.cchgeu.electronicassistantbackend.services.impl;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cchgeu.electronicassistantbackend.model.dto.UserReferenceDto;
import ru.cchgeu.electronicassistantbackend.model.dto.UserReferenceWorkDto;
import ru.cchgeu.electronicassistantbackend.model.entity.references.FormatReference;
import ru.cchgeu.electronicassistantbackend.model.entity.references.Reference;
import ru.cchgeu.electronicassistantbackend.model.entity.references.StatusReference;
import ru.cchgeu.electronicassistantbackend.model.entity.references.TypeReference;
import ru.cchgeu.electronicassistantbackend.model.entity.user.User;
import ru.cchgeu.electronicassistantbackend.model.mappers.UserMapper;
import ru.cchgeu.electronicassistantbackend.repositories.ReferenceRepository;
import ru.cchgeu.electronicassistantbackend.repositories.UserRepository;
import ru.cchgeu.electronicassistantbackend.utils.ConverterPDF;
import ru.cchgeu.electronicassistantbackend.utils.QRCodeGeneration;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class ReferenceService {

    private final ReferenceRepository referenceRepository;
    private final UserRepository userRepository;

    private static final Random RANDOM = new SecureRandom();

    private final UserMapper userMapper;

    public static byte[] getNextSalt() {
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return salt;
    }

    @Autowired
    public ReferenceService(ReferenceRepository referenceRepository, UserRepository userRepository, UserMapper userMapper) {
        this.referenceRepository = referenceRepository;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void createReferenceTraining(UserReferenceWorkDto userReferenceWorkDto) throws IOException, WriterException {

        LocalDateTime timeCreation= LocalDateTime.now();

        String aString = userReferenceWorkDto.getStudent_id().toString() + timeCreation.toLocalDate() + getNextSalt();
        String uuid = UUID.nameUUIDFromBytes(aString.getBytes()).toString();

        String pathToQRC = "./src/main/resources/QRCodes/" + userReferenceWorkDto.getStudent_id().toString() + "-QRCode-" + timeCreation + ".jpg";
        String urlApiCheckReference = "http://localhost:8082/api/reference/verification?uuid-reference=" + uuid;


        UserReferenceDto  userReferenceDto =  userMapper.toDto(userRepository.findById(userReferenceWorkDto.getStudent_id()).get());



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
                "            ???????????????????????? ?????????? ?? ?????????????? ?????????????????????? ???? <br>\n" +
                "            ?????????????????????? ?????????????????????????????? ?????????????????? <br>\n" +
                "            ?????????????????????????????? ??????????????????????  ?????????????? ?????????????????????? <br>\n" +
                "            ???????????????????????? ?????????????????????????????? ?????????????????????? ???????????????????????? <br>\n" +
                "            ?????????? ???? ???????????? <br> <br>\n" +
                "            ?????????????? ??? " + uuid + "\n" +
                "        </p>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"block-right\">\n" +
                "        <p>\n" +
                "            "+ timeCreation.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +"\n" +
                "        </p>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"block-normal\">\n" +
                "        ???????? " + userReferenceDto.getFIO() + " ?? ??????, ?????? ???? (??????) ?????????????????????????? ???????????????? ???????????????????? " + userReferenceDto.getCourse() + " ??????????, " + userReferenceDto.getFacultet() + ",\n" +
                "        ???????????? (????????????????) ???????????????? ???????????? " + userReferenceDto.getGroupp()+", ?? " + userReferenceDto.getDate_start() + " ?????????????????????? ???????? ??????????????????\n" +
                "        ???????????????? " + userReferenceDto.getDate_end() + ", ???????????????? ???? " + userReferenceDto.getType_training()+ " ????????????<br>\n" +
                "        ?????????????? ???????????? ?????? ???????????????????????????? " + userReferenceDto.getLocationsreferences() + ".<br>\n" +
                "        <br>\n" +
                "    </div>\n" +
                " <div style=\"text-align: right;\"><img alt=\"\" src=\""+ pathToQRC + "\"></div>" +
                "</body>\n" +
                "</html>";

        String pathToFile = "src/main/resources/referencesOK/";
        String nameFile = pathToFile + userReferenceDto.getFileName()+ "-" + timeCreation + ".pdf";

        ConverterPDF convert = new ConverterPDF();
        convert.convertert(referenceText, nameFile);
        Reference reference = new Reference(uuid,userReferenceDto.getId(), StatusReference.READY ,timeCreation.toLocalDate(), TypeReference.WORK, FormatReference.ELECTRONIC);
        referenceRepository.save(reference);
    }

    public Optional<User> verificationQRCodeReference(String uuidReference) {

        return userRepository.findById(referenceRepository.findById(uuidReference).get().getStudent_id());
    }

}
