package cz.lundegaard.contactform.service.impl;

import cz.lundegaard.contactform.backend.entity.ContactForm;
import cz.lundegaard.contactform.backend.entity.RequestKind;
import cz.lundegaard.contactform.backend.repository.ContactFormRepository;
import cz.lundegaard.contactform.backend.repository.RequestKindRepository;
import cz.lundegaard.contactform.service.ContactFormService;
import cz.lundegaard.contactform.service.dto.ContactFormDto;
import cz.lundegaard.contactform.service.dto.RequestKindDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Implementation for data access on contact form.
 */
@Service
@Transactional
public class ContactFormServiceImpl implements ContactFormService {

    private static final Logger LOG = LoggerFactory.getLogger(ContactFormServiceImpl.class);

    @Inject
    private ContactFormRepository contactFormRepository;
    @Inject
    private RequestKindRepository requestKindRepository;

    @Override
    public void save(@Valid ContactFormDto contactFormDto) {
        contactFormRepository.save(toEntity(contactFormDto));
        LOG.info("Persisted object: " + contactFormDto.toString());
    }

    @Override
    public List<RequestKindDto> getRequestKindList() {
        return StreamSupport.stream(requestKindRepository.findAll().spliterator(), false)
                .map(item -> new RequestKindDto(item.getId(), item.getCode(), item.getText()))
                .collect(Collectors.toList());
    }

    @Override
    public RequestKindDto getRequestKindDto(Long id) {
        RequestKind requestKind = getRequestKind(id);
        return new RequestKindDto(requestKind.getId(), requestKind.getCode(), requestKind.getText());
    }

    private RequestKind getRequestKind(Long id) {
        Optional<RequestKind> optional = requestKindRepository.findById(id);
        return optional.orElseThrow(() -> new RuntimeException("Couldn't find a RequestKind with id: " + id));
    }

    private ContactForm toEntity(ContactFormDto contactFormDto) {
        Assert.notNull(contactFormDto, "contactFormDto cannot be null");
        Assert.notNull(contactFormDto.getRequestKind(), "RequestKind cannot be null");

        ContactForm contactForm = new ContactForm();
        contactForm.setRequestKind(getRequestKind(contactFormDto.getRequestKind().getId()));
        contactForm.setPolicyNumber(contactFormDto.getPolicyNumber());
        contactForm.setFirstName(contactFormDto.getFirstName());
        contactForm.setSecondName(contactFormDto.getSecondName());
        contactForm.setRequestText(contactFormDto.getRequestText());
        return contactForm;
    }


}
