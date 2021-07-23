package com.example.designpatterns.headfirst.command


class DB {
    companion object login(private val user: String, private val password: String) {
    }

    companion object logout(private val user: String) {
    }
}

interface Command {
    fun execute()
}

class LoginCommand(private val user: String, private val password: String) : Command {
    override fun execute() {
        DB.login(user, password)
    }
}

class LogoutCommand(private val user: String) : Command {
    override fun execute() {
        DB.logout(user)
    }
}

fun main() {
    val loginCommand = LoginCommand("clojure", "kotlin")
    val logoutCommand = LogoutCommand("clojure")
    loginCommand.execute()
    logoutCommand.execute()
}