package ru.cchgeu.electronicassistantbackend.services.mail;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.StringWriter;

@Service
public class TemplateEngineServiceImpl implements TemplateEngineService {

    /*
        TODO: Этот метод создан в качестве примера, его нужно убрать в будущем
    */
    @Override
    public String getTestDocument(String email, String subject) {
        TemplateEngine templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("HTML");
        templateEngine.setTemplateResolver(templateResolver);
        Context context = new Context();
        context.setVariable("h1", email);
        context.setVariable("h2", subject);
        StringWriter stringWriter = new StringWriter();
        templateEngine.process("static/templates/test.html", context, stringWriter);
        return stringWriter.toString();
    }
}