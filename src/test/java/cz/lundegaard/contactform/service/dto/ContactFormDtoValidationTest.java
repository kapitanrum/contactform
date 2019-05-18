package cz.lundegaard.contactform.service.dto;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

public class ContactFormDtoValidationTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testContactFormDtoSuccess() {
        ContactFormDto contactFormDto = new ContactFormDto();
        contactFormDto.setRequestKind(Mockito.mock(RequestKindDto.class));
        contactFormDto.setFirstName("abc");
        contactFormDto.setRequestText("abc");

        Set<ConstraintViolation<ContactFormDto>> violations = validator.validate(contactFormDto);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testContactFormDtoFailed() {
        ContactFormDto contactFormDto = new ContactFormDto();
        contactFormDto.setRequestKind(Mockito.mock(RequestKindDto.class));
        contactFormDto.setFirstName("ABC123");

        Set<ConstraintViolation<ContactFormDto>> violations = validator.validate(contactFormDto);
        assertFalse(violations.isEmpty());
    }

}