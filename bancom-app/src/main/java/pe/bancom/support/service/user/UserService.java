package pe.bancom.support.service.user;

import pe.bancom.support.commons.CommonsHeaders;
import pe.bancom.support.domain.ResponseMessage;
import pe.bancom.support.domain.UserRequest;
import pe.bancom.support.domain.UserResponse;

/**
 * this class contains interfaces crud services users
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

public interface UserService {
  UserResponse getUsers();
  ResponseMessage createUser(UserRequest request, CommonsHeaders header);
  ResponseMessage updateUser(UserRequest request, CommonsHeaders header);
  ResponseMessage deleteUser(String userId, CommonsHeaders headers);
}
