package com.young.backendjava.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "exposures")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExposureEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exposure")
    private List<PostEntity> posts = new ArrayList<>();

    public void removePost(PostEntity post) {
        posts.remove(post);
        post.setExposure(null);
    }

}
