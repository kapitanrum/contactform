package cz.lundegaard.contactform.util.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class AlphaValidator implements ConstraintValidator<Alpha, String> {

    private static final Logger LOG = LoggerFactory.getLogger(AlphaValidator.class);

    private final static String regex = "^[a-zA-ZÀ-ž]*$";

    private java.util.regex.Pattern pattern;

    @Override
    public void initialize(Alpha alpha) {
        try {
            this.pattern = java.util.regex.Pattern.compile(regex);
        } catch (PatternSyntaxException ex) {
            LOG.error("Pattern " + regex + "is not valid");
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // null values are valid
        if (value == null) {
            return true;
        }

        Matcher m = this.pattern.matcher(value);
        return m.matches();
    }
}
