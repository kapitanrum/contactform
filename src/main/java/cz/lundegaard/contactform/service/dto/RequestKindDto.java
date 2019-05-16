package cz.lundegaard.contactform.service.dto;

/**
 * Request kind
 */
public class RequestKindDto {

    private Long id;
    private String code;
    private String text;


    public RequestKindDto(Long id, String code, String text) {
        this.id = id;
        this.code = code;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestKindDto that = (RequestKindDto) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
