package pe.bancom.support.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {
  private Integer id;
  private String cellPhone;
  private String name;
  private String lastName;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String password;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String createdDate;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String createdBy;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String lastModifiedDate;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String lastModifiedBy;
}
