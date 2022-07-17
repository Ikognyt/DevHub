package br.com.ylotec.devhub.model

import android.provider.ContactsContract
import java.net.URL
import java.util.*

data class User(
    val login: String,
    val id: Int,
    val node_id: String,
    val avatar_url: URL,
    val gravatar_id: String,
    val url: URL,
    val html_url: URL,
    val followers_url: URL,
    val following_url: URL,
    val gists_url: URL,
    val starred_url: URL,
    val subscriptions_url: URL,
    val organizations_url: URL,
    val repos_url: URL,
    val events_url: URL,
    val received_events_url: URL,
    val type: String,
    val site_admin: Boolean,
    val name: String,
    val company: String,
    val blog: String,
    val location: String,
    val email: ContactsContract.CommonDataKinds.Email,
    val hireable: Boolean,
    val bio: String,
    val twitter_username: String,
    val public_repos: Int,
    val public_gists: Int,
    val followers: Int,
    val following: Int,
    val created_at: Date,
    val updated_at: Date
)