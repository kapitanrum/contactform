package cz.lundegaard.contactform.service;

import cz.lundegaard.contactform.service.dto.ContactFormDto;
import cz.lundegaard.contactform.service.dto.RequestKindDto;

import java.util.List;

/**
 * Service for Contact Us
 */
public interface ContactFormService {

    /**
     * Save ContactFormDto to backend.
     *
     * @param contactUs dto with filled data
     */
    void save(ContactFormDto contactUs);

    /**
     * Codelist of RequestKind
     *
     * @return List of all RequestKind
     */
    List<RequestKindDto> getRequestKindList();

    /**
     * Get RequestKind by id
     *
     * @param id Id of request kind
     * @return
     */
    RequestKindDto getRequestKindDto(Long id);
}
