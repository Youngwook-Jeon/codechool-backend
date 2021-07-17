package com.young.backendjava.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Table(indexes = { @Index(columnList = "userId", name = "index_userid", unique = true),
        @Index(columnList = "email", name = "index_email", unique = true) })
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false, length = 80)
    private String firstName;

    @Column(nullable = false, length = 80)
    private String lastName;

    @Column(nullable = false)
    private String encodedPassword;

    @Column(nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<PostEntity> posts = new ArrayList<>();

    public void removePost(PostEntity post) {
        posts.remove(post);
        post.setUser(null);
    }
}
