package com.example.blog.post;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "post")
@Entity(name = "post")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    private String image;
    private String date;

    public Post(PostRequestDTO data){
        this.title = data.title();
        this.text = data.text();
        this.image = data.image();
        this.date = data.date();
    }


}
