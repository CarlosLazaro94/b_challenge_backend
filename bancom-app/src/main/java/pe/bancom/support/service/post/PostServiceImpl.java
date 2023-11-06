package pe.bancom.support.service.post;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.bancom.support.builder.PostBuilder;
import pe.bancom.support.commons.CommonsHeaders;
import pe.bancom.support.db.posts.PostRepository;
import pe.bancom.support.db.users.UserRepository;
import pe.bancom.support.domain.Post;
import pe.bancom.support.domain.PostRequest;
import pe.bancom.support.domain.PostResponse;
import pe.bancom.support.domain.ResponseMessage;
import pe.bancom.support.domain.User;

/**
 * this class contains methods operations crud services
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

@Slf4j
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

  private final PostRepository repository;
  private final UserRepository userRepository;
  private final PostBuilder builder;

  @Override
  public PostResponse getPost() {
    return builder.buildResponse(repository.get());
  }

  @Override
  public ResponseMessage createPost(PostRequest request, CommonsHeaders header) {
    User user = userRepository.getById(request.getUserId());
    if(Objects.isNull(user)){
      return ResponseMessage.builder()
          .code("BN0004")
          .message("User not enabled or not created")
          .build();
    }

    return ResponseMessage
        .builder()
        .code("BN0001")
        .message(repository
            .post(builder.buildCreate(request, header)))
        .build();
  }

  @Override
  public ResponseMessage updatePost(PostRequest request, CommonsHeaders header) {
    Post postById = repository.getById(request.getId());
    if(header.getUserCode().equals(postById.getUser().getId())){
        return ResponseMessage.builder()
            .code("BN0004")
            .message("User no authorization for update it post")
            .build();
    }

    return ResponseMessage
        .builder()
        .code("BN0002")
        .message(repository
            .patch(builder.buildUpdate(request, postById, header)))
        .build();
  }

  @Override
  public ResponseMessage deletePost(String postId, CommonsHeaders headers) {
    Post postById = repository.getById(Integer.parseInt(postId));
    return ResponseMessage
        .builder()
        .code("BN0003")
        .message(repository
            .patch(builder.buildDelete(postById, headers)))
        .build();
  }
}
