package com.thoutube.repositories;

import com.thoutube.model.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

	Page<Post> findByAuthorId(Long id, Pageable pagination);
    
}