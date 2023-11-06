package pe.bancom.support.domain;

import pe.bancom.support.commons.Audit;

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
public class UserRequest {
  private Integer id;
  private String cellPhone;
  private String name;
  private String lastName;
  private String password;
  private Audit audit;
}
