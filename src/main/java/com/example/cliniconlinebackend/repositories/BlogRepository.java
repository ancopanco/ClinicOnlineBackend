package com.example.cliniconlinebackend.repositories;

import com.example.cliniconlinebackend.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface BlogRepository extends JpaRepository<Blog,Integer>{
    @Transactional
    @Modifying
    @Query("update Blog p set p.accepted = 1 where p.id_blog = ?1")
    int updateBlog(int id_blog);

}
