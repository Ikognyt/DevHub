package br.com.ylotec.devhub.model

data class User(
    val login: String = "",
    val avatar_url: String = "",
    val repos_url: String = "",
    val name: String = "",
    val blog: String = "",
    val bio: String = "",
    val repositories: List<UserRepos> = emptyList()
)