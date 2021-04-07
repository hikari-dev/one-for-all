package dev.hikari.oneforall.repository

import dev.hikari.oneforall.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import java.sql.Timestamp
import javax.transaction.Transactional

interface UserRepository : JpaRepository<UserEntity, Int> {

    @Transactional
    @Modifying
    @Query("INSERT INTO user(nick,email,password,register_time,role) VALUES (?1,?2,?3,?4,?5)", nativeQuery = true)
    fun registerUser(nick: String, email: String, password: String, registerTime: Timestamp, role: Int): Int
}