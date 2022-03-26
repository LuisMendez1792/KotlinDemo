package com.example.demo.repository

import com.example.demo.model.Article
import org.springframework.data.repository.CrudRepository

interface  ArticleRepository: CrudRepository<Article, Long> {
    fun findBySlug(slug: String) : Article?
    fun findByOrderByAddedAtDesc(): Iterable<Article>
}
