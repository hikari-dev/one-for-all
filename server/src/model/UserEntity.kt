package dev.hikari.oneforall.model

import org.hibernate.annotations.CreationTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "user")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    val uid: Int = 0,

    @Column(name = "nick")
    val nick: String = "",

    @Column(name = "email", unique = true)
    val email: String = "",

    @Column(name = "password")
    val password: String = "",

    @Column(name = "register_time")
    @CreationTimestamp
    val registerTime: Timestamp = Timestamp(0),

    @Column(name = "register_ip")
    val registerIp: String = "",

    @Column(name = "last_login_ip")
    val lastLoginIp: String = "",

    @Column(name = "last_login_time")
    val lastLoginTime: Timestamp = Timestamp(0),

    @Column(name = "banned")
    val banned: Boolean = false,

    @Column(name = "role")
    val role: Int = 0,
)