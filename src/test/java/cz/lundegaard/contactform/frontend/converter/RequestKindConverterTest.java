package cz.lundegaard.contactform.frontend.converter;

import cz.lundegaard.contactform.Application;
import cz.lundegaard.contactform.service.ContactFormService;
import cz.lundegaard.contactform.service.dto.RequestKindDto;
import cz.lundegaard.contactform.service.impl.ContactFormServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = Application.class)
public class RequestKindConverterTest {

    @Inject
    RequestKindConverter requestKindConverter;

    @Test(expected = RuntimeException.class)
    public void getAsObject() {
        RequestKindDto requestKindDto = requestKindConverter.getAsObject(null, null, "1");
        assertTrue(requestKindDto != null);

        requestKindConverter.getAsObject(null, null, "10");
    }

    @Test
    public void getAsString() {
        String value = requestKindConverter.getAsString(null, null, new RequestKindDto(1L, "abc", "abc"));
        assertEquals(value, "1");
    }

}