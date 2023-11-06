package pe.bancom.support.builder;

import static pe.bancom.support.util.Utils.formatDateTime;
import static pe.bancom.support.util.Utils.formatterIsoDateTime;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.bancom.support.commons.Audit;
import pe.bancom.support.commons.CommonsHeaders;
import pe.bancom.support.domain.User;
import pe.bancom.support.domain.UserRequest;
import pe.bancom.support.domain.UserResponse;

/**
 * this class contains methods builder for user
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

@Component
@AllArgsConstructor
public class UserBuilder {

  public UserResponse buildResponse(List<User> users) {
    return UserResponse.builder().users(users).build();
  }

  public UserRequest buildCreate(UserRequest request, CommonsHeaders headers) {
    return request.toBuilder().audit(Audit.builder().deleted(false).createdBy(headers.getUserCode())
        .createdDate(LocalDateTime.now()).build()).build();
  }

  public UserRequest buildUpdate(UserRequest request, User user, CommonsHeaders headers) {
    return request
        .toBuilder()
        .audit(Audit.builder()
            .deleted(false)
            .createdBy(user.getCreatedBy())
            .createdDate(formatDateTime(user.getCreatedDate()))
            .lastModifiedBy(headers.getUserCode())
            .lastModifiedDate(formatterIsoDateTime(headers.getRequestDate()))
            .build())
        .build();
  }

  public UserRequest buildDelete(User user, CommonsHeaders headers) {
    return UserRequest.builder()
        .id(user.getId())
        .cellPhone(user.getCellPhone())
        .name(user.getName())
        .lastName(user.getLastName())
        .password(user.getPassword())
        .audit(Audit
            .builder()
              .deleted(true)
              .createdDate(formatDateTime(user.getCreatedDate()))
              .createdBy(user.getCreatedBy())
              .lastModifiedBy(headers.getUserCode())
            .lastModifiedDate(formatterIsoDateTime(headers.getRequestDate()))
            .build())
        .build();
  }
}
