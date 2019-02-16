package org.http4k.lens

import org.http4k.cloudnative.env.Authority
import org.http4k.cloudnative.env.Host
import org.http4k.cloudnative.env.Port
import org.http4k.cloudnative.env.Secret
import org.http4k.cloudnative.env.Timeout

fun StringBiDiMappings.host() = nonEmpty().map(::Host, Host::value)
fun StringBiDiMappings.port() = int().map(::Port, Port::value)
fun StringBiDiMappings.authority() = nonEmpty().map({ Authority(it) }, Authority::toString)

fun <IN> BiDiLensSpec<IN, String>.secret() = nonEmptyString().bytes().map(::Secret)
fun <IN> BiDiLensSpec<IN, String>.host() = map(StringBiDiMappings.host())
fun <IN> BiDiLensSpec<IN, String>.port() = map(StringBiDiMappings.port())
fun <IN> BiDiLensSpec<IN, String>.authority() = map(StringBiDiMappings.authority())
fun <IN> BiDiLensSpec<IN, String>.timeout() = duration().map(::Timeout, Timeout::value)