package cz.lundegaard.contactform.frontend.message;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletRequest;
import java.util.HashMap;

@Component(value = "msg")
public class ResourceBundleBean extends HashMap {

    @Inject
    private MessageSource messageSource;

    @Override
    public String get(Object key) {
        ServletRequest request = (ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String message;
        try {
            message = messageSource.getMessage((String) key, null, request.getLocale());
        }
        catch (NoSuchMessageException e) {
            message = "???" + key + "???";
        }
        return message;
    }
}