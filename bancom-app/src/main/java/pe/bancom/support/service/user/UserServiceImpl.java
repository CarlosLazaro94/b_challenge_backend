package pe.bancom.support.service.user;

import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.bancom.support.builder.UserBuilder;
import pe.bancom.support.commons.CommonsHeaders;
import pe.bancom.support.db.users.UserRepository;
import pe.bancom.support.domain.ResponseMessage;
import pe.bancom.support.domain.User;
import pe.bancom.support.domain.UserRequest;
import pe.bancom.support.domain.UserResponse;

/**
 * this class contains method crud services for user
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository repository;
  private final UserBuilder builder;

  @Override
  public UserResponse getUsers() {
    return builder.buildResponse(repository.get());
  }

  @Override
  public ResponseMessage createUser(UserRequest request, CommonsHeaders headers) {
    return ResponseMessage
        .builder()
        .code("BN0001")
        .message(repository
            .post(builder.buildCreate(request, headers)))
        .build();
  }

  @Override
  public ResponseMessage updateUser(UserRequest request, CommonsHeaders header) {
    User userById = repository.getById(request.getId());
    return ResponseMessage
        .builder()
        .code("BN0002")
        .message(repository
            .patch(builder.buildUpdate(request, userById, header)))
        .build();
  }

  @Override
  public ResponseMessage deleteUser(String userId, CommonsHeaders headers) {
    User userById = repository.getById(Integer.parseInt(userId));
    return ResponseMessage
        .builder()
        .code("BN0003")
        .message(repository
            .patch(builder.buildDelete(userById, headers)))
        .build();
  }
}
