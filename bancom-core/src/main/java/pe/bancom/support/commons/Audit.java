package pe.bancom.support.commons;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * this class contains fields for audit
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

@Getter
@Setter
@ToString
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Audit {

  @Column(nullable = false)
  private Boolean deleted;

  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @Column(nullable = false)
  private LocalDateTime createdDate;

  @Column(nullable = false, length = 50)
  private String createdBy;

  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @Column
  private LocalDateTime lastModifiedDate;

  @Column(length = 50)
  private String lastModifiedBy;
}
