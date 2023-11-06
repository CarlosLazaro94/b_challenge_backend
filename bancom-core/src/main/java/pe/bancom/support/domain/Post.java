package pe.bancom.support.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * this class contains fields of the user posts
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Post {
  private Integer id;
  private User user;
  private String text;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String createDate;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String createBy;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String lastModifiedDate;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String lastModifiedBy;
}
