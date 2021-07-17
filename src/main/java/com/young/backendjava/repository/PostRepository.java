package com.young.backendjava.repository;

import com.young.backendjava.domain.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> getByUserIdOrderByCreatedAtDesc(long userId);

    @Query(value = "SELECT * FROM posts p WHERE p.exposure_id = :exposure and p.expired_at > :now ORDER BY created_at DESC LIMIT 20", nativeQuery = true)
    List<PostEntity> getLastPublicPosts(@Param("exposure") long exposureId, @Param("now") LocalDateTime now);

    PostEntity findByPostId(String postId);
}
