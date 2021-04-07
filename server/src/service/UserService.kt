package dev.hikari.oneforall.service

import dev.hikari.oneforall.dto.RegisterDTO
import dev.hikari.oneforall.model.UserEntity
import dev.hikari.oneforall.repository.UserRepository
import kotlinx.coroutines.runInterruptible
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val bcrypt: BCryptPasswordEncoder
) {

    suspend fun registerUser(registerDTO: RegisterDTO, ip: String): Int {
        return runInterruptible {
            userRepository.save(
                UserEntity(
                    email = registerDTO.email,
                    password = bcrypt.encode(registerDTO.password),
                    nick = registerDTO.nick,
                    registerIp = ip,
                )
            )
            1
        }
    }
}