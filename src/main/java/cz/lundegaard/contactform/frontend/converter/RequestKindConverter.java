package cz.lundegaard.contactform.frontend.converter;

import cz.lundegaard.contactform.service.ContactFormService;
import cz.lundegaard.contactform.service.dto.RequestKindDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import java.util.Objects;

/**
 * Converter for
 */
@Component
public class RequestKindConverter implements Converter<RequestKindDto> {

    @Inject
    private ContactFormService contactUsService;

    @Override
    public RequestKindDto getAsObject(FacesContext context, UIComponent component, String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return contactUsService.getRequestKindDto(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, RequestKindDto value) {
        if (value == null) {
            return "";
        }
        return Objects.toString(value.getId());
    }
}
