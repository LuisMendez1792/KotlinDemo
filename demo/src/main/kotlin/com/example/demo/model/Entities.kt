package com.example.demo.model

import com.example.demo.configurations.toSlug
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.time.LocalDateTime
import javax.persistence.*

@AllArgsConstructor
@NoArgsConstructor
@Entity
class Article (
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: User,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null)

@AllArgsConstructor
@NoArgsConstructor
@Entity
class User(
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    @Id @GeneratedValue var id: Long? = null
)