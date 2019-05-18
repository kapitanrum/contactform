package cz.lundegaard.contactform.service;

import cz.lundegaard.contactform.backend.entity.RequestKind;
import cz.lundegaard.contactform.backend.repository.ContactFormRepository;
import cz.lundegaard.contactform.backend.repository.RequestKindRepository;
import cz.lundegaard.contactform.service.dto.ContactFormDto;
import cz.lundegaard.contactform.service.dto.RequestKindDto;
import cz.lundegaard.contactform.service.impl.ContactFormServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example junit test with mockito
 */
@RunWith(MockitoJUnitRunner.class)
public class ContactFormServiceTest {

    @Mock
    private RequestKindRepository requestKindRepository;

    @InjectMocks
    private ContactFormServiceImpl contactFormService;


    @Test
    public void getRequestKindList() {
        List<RequestKind> list = new ArrayList<>();
        list.add(Mockito.mock(RequestKind.class));
        list.add(Mockito.mock(RequestKind.class));
        list.add(Mockito.mock(RequestKind.class));
        Mockito.when(requestKindRepository.findAll()).thenReturn(list);

        List<RequestKindDto> result = contactFormService.getRequestKindList();
        Assert.assertEquals(result.size(), 3);
    }

}