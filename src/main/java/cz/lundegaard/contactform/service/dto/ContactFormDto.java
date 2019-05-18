package cz.lundegaard.contactform.service.dto;

import cz.lundegaard.contactform.util.validation.Alpha;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Contact form DTO
 */
@Getter
@Setter
@ToString
public class ContactFormDto implements Serializable {

  private static final long serialVersionUID = 1L;
  private static final String alphaRegEx = "^[a-zA-ZÀ-ž]*$";

  @NotNull
  private RequestKindDto requestKind;
  @Pattern(regexp = "^[\\p{Alnum}]*$", message = "{validation.alphanum}")
  private String policyNumber;
  @Alpha
  private String firstName;
  @Alpha
  private String secondName;
  @NotEmpty
  private String requestText;
}
