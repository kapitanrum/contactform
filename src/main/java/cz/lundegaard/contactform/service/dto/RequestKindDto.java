package cz.lundegaard.contactform.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

/**
 * Request kind
 */
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RequestKindDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String code;
    private String text;

    public RequestKindDto(Long id, String code, String text) {
        this.id = id;
        this.code = code;
        this.text = text;
    }

}
