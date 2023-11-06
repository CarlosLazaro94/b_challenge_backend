package pe.bancom.support.domain;

import pe.bancom.support.commons.Audit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * this class contains fields of the request post
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PostRequest {
  private Integer id;
  private Integer userId;
  private String text;
  private Audit audit;
}
