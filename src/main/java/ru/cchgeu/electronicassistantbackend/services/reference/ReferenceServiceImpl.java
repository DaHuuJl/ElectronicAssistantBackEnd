package ru.cchgeu.electronicassistantbackend.services.reference;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.cchgeu.electronicassistantbackend.model.dto.ReferenceRequestInput;
import ru.cchgeu.electronicassistantbackend.model.mappers.UserMapper;
import ru.cchgeu.electronicassistantbackend.repositories.references.ReferenceRepository;
import ru.cchgeu.electronicassistantbackend.repositories.user.UserRepository;
import ru.cchgeu.electronicassistantbackend.services.user.StudentServiceImpl;
import ru.cchgeu.electronicassistantbackend.utils.Guard;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class ReferenceServiceImpl implements ReferenceService {
    static final Logger logger = LogManager.getLogger(ReferenceServiceImpl.class);
    private final ReferenceRepository referenceRepository;
    private final UserRepository userRepository;
    private final StudentServiceImpl studentService;
    private static final Random RANDOM = new SecureRandom();

    private final UserMapper userMapper;

    public ReferenceServiceImpl(ReferenceRepository referenceRepository, UserRepository userRepository, StudentServiceImpl studentService, UserMapper userMapper) {
        this.referenceRepository = referenceRepository;
        this.userRepository = userRepository;
        this.studentService = studentService;
        this.userMapper = userMapper;
    }

    @Override
    public void createReferenceForInput(ReferenceRequestInput referenceRequestInput) {
        switch (referenceRequestInput.getFormatReference()) {
            case PAPER:
                createPaperReference(referenceRequestInput);
                break;
            case ELECTRONIC:
                createElectronicReference(referenceRequestInput);
                break;
            default:
                Guard.fail("error.format.reference", "There is no such reference format");
        }
    }

    @Override
    public void createPaperReference(ReferenceRequestInput referenceRequestInput) {
        logger.log(Level.INFO, "PAPER version created");
    }

    @Override
    public void createElectronicReference(ReferenceRequestInput referenceRequestInput) {
        logger.log(Level.INFO, "ELECTRONIC version created");
    }

/*

    public static byte[] getNextSalt() {
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return salt;
    }

    public void createReferenceTraining(UserReferenceWorkDto userReferenceWorkDto) throws IOException, WriterException {

        LocalDateTime timeCreation = LocalDateTime.now();

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
                "            "+ timeCreation.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +"\n" +
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
        String nameFile = pathToFile + userReferenceDto.getFileName()+ "-" + timeCreation + ".pdf";

        ConverterPDF convert = new ConverterPDF();
        convert.convertert(referenceText, nameFile);
        Reference reference = new Reference(uuid,userReferenceDto.getId(), StatusReference.READY ,timeCreation.toLocalDate(), TypeReference.WORK, FormatReference.ELECTRONIC);
        referenceRepository.save(reference);
    }

    public Optional<User> verificationQRCodeReference(String uuidReference) {

        return userRepository.findById(referenceRepository.findById(uuidReference).get().getStudent_id());
    }*/
}
