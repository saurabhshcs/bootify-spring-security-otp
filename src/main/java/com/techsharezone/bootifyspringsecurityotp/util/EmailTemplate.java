package com.techsharezone.bootifyspringsecurityotp.util;

/*
 * @created 25/11/2020 -01:01
 * @project bootify-spring-security-otp
 * @author  saurabhshcs
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class EmailTemplate {

    private final static Logger LOG = LoggerFactory.getLogger(EmailTemplate.class);

    private String tmeplateId;

    private String template;

    private Map<String, String> replacementParams;

    public EmailTemplate(String templateId) {
        this.tmeplateId = templateId;
        this.template = loadTemplate(templateId);
        this.replacementParams = replacementParams;
    }

    private String loadTemplate(final String templateId) {

        ClassLoader classLoader = getClass().getClassLoader();
        LOG.info("\n\n\n_______________getFile: {}", classLoader.getResource(templateId).getFile());
        File file = new File(classLoader.getResource(templateId).getFile());
        String content = "Empty";

        try {
            content = Files.readAllBytes(file.toPath()).toString();
            LOG.error("The file content [{}] is loaded for template id [{}]", content, templateId);

        } catch (IOException e) {
            LOG.error("Could not read template with ID [{}]", templateId);
        }
        return content;
    }

    public String getTemplate(final Map<String, String> replacements) {
        String cTemplate = this.template;

        for (Map.Entry<String, String> entry : replacements.entrySet()) {
         cTemplate = cTemplate.replace("{{" +entry.getKey() + "}}", entry.getValue());
        }
        return cTemplate;
    }
}
