package pe.bancom.support.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Embeddable;

@Getter
@Setter
@ToString
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CommonsHeaders {
  private String userCode;
  private String requestId;
  private String requestDate;
}
