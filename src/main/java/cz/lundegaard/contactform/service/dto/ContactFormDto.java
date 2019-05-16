package cz.lundegaard.contactform.service.dto;

/**
 * Contact form DTO
 */
public class ContactFormDto {

  private RequestKindDto requestKind;
  private String policyNumber;
  private String firstName;
  private String secondName;
  private String requestText;


  public RequestKindDto getRequestKind() {
    return requestKind;
  }

  public void setRequestKind(RequestKindDto requestKind) {
    this.requestKind = requestKind;
  }

  public String getPolicyNumber() {
    return policyNumber;
  }

  public void setPolicyNumber(String policyNumber) {
    this.policyNumber = policyNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public String getRequestText() {
    return requestText;
  }

  public void setRequestText(String requestText) {
    this.requestText = requestText;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("ContactFormDto{");
    sb.append("requestKind=").append(requestKind);
    sb.append(", policyNumber='").append(policyNumber).append('\'');
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", secondName='").append(secondName).append('\'');
    sb.append(", requestText='").append(requestText).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
