package cz.lundegaard.contactform.frontend;

import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.Map;

public class ServletContextAttributePopulator implements ServletContextAware {
    Map<String,Object> attributes;

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        for (Map.Entry<String,Object> entry : attributes.entrySet()) {
            servletContext.setAttribute(entry.getKey(), entry.getValue());
        }
    }
}
