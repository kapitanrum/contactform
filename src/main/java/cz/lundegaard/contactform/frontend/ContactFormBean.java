package cz.lundegaard.contactform.frontend;

import cz.lundegaard.contactform.service.ContactFormService;
import cz.lundegaard.contactform.service.dto.ContactFormDto;
import cz.lundegaard.contactform.service.dto.RequestKindDto;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Component
public class ContactFormBean {

    private static final int REQUEST_TEXT_MAX_SIZE = 5000;

    @Inject
    private ContactFormService contactUsService;

    private ContactFormDto contactUs;
    /**
     * Codelist for selectbox
     */
    private List<RequestKindDto> requestKindList;

    @PostConstruct
    private void init() {
        requestKindList = contactUsService.getRequestKindList();
        contactUs = new ContactFormDto();
    }

    public List<RequestKindDto> getRequestKindList() {
        return requestKindList;
    }

    public ContactFormDto getContactUs() {
        return contactUs;
    }

    public String send() {
        contactUsService.save(contactUs);
        return "result";
    }

    public String returnToForm() {
        contactUs = new ContactFormDto();
        return "form";
    }

    public int getRequestTextMaxSize() {
        return REQUEST_TEXT_MAX_SIZE;
    }
}
