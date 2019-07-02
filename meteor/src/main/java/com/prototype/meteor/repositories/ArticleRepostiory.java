package com.prototype.meteor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Article;

@Repository
public interface ArticleRepostiory  extends JpaRepository<Article, Integer>{

}
