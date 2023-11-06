package pe.bancom.support.builder;

import static pe.bancom.support.util.Utils.formatDateTime;
import static pe.bancom.support.util.Utils.formatterIsoDateTime;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.bancom.support.commons.Audit;
import pe.bancom.support.commons.CommonsHeaders;
import pe.bancom.support.domain.Post;
import pe.bancom.support.domain.PostRequest;
import pe.bancom.support.domain.PostResponse;

/**
 * this class contains methods builder for post
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

@Component
@AllArgsConstructor
public class PostBuilder {

  public PostResponse buildResponse(List<Post> Posts) {
    return PostResponse.builder().posts(Posts).build();
  }

  public PostRequest buildCreate(PostRequest request, CommonsHeaders headers) {
    return request.toBuilder().audit(Audit.builder().deleted(false).createdBy(headers.getUserCode())
        .createdDate(LocalDateTime.now()).build()).build();
  }

  public PostRequest buildUpdate(PostRequest request, Post post, CommonsHeaders headers) {
    return request
        .toBuilder()
        .audit(Audit.builder()
            .deleted(false)
            .createdBy(post.getCreateBy())
            .createdDate(formatDateTime(post.getCreateDate()))
            .lastModifiedBy(headers.getUserCode())
            .lastModifiedDate(formatterIsoDateTime(headers.getRequestDate()))
            .build())
        .build();
  }

  public PostRequest buildDelete(Post post, CommonsHeaders headers) {
    return PostRequest.builder()
        .id(post.getId())
        .userId(post.getUser().getId())
        .text(post.getText())
        .audit(Audit
            .builder()
            .deleted(true)
            .createdDate(formatDateTime(post.getCreateDate()))
            .createdBy(post.getCreateBy())
            .lastModifiedBy(headers.getUserCode())
            .lastModifiedDate(formatterIsoDateTime(headers.getRequestDate()))
            .build())
        .build();
  }
}
