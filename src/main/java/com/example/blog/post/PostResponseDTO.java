package com.example.blog.post;

public record PostResponseDTO(Long id, String title, String text, String image, String date) {
    public PostResponseDTO(Post post) {
        this(post.getId(), post.getTitle(), post.getText(), post.getImage(),post.getDate());
    }
}
