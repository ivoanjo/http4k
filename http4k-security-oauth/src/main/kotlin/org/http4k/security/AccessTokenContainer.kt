package org.http4k.security

import com.fasterxml.jackson.annotation.JsonProperty
import org.http4k.core.Body
import org.http4k.format.Jackson.auto
import org.http4k.security.openid.IdTokenContainer

data class AccessTokenContainer(val value: String)

data class AccessTokenDetails(val accessToken: AccessTokenContainer, val idToken: IdTokenContainer? = null)

data class AccessTokenResponse(
    @JsonProperty("access_token") val accessToken: String,
    @JsonProperty("id_token") val idToken: String? = null
)

val accessTokenResponseBody = Body.auto<AccessTokenResponse>().toLens()