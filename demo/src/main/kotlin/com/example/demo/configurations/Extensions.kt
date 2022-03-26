package com.example.demo.configurations

import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.util.*

fun LocalDateTime.format() = this.format(englishDateFormatter)

private val daysLookup = (1..31).associate { it.toLong() to getOrdinal(it)}

private val englishDateFormatter = DateTimeFormatterBuilder()
    .appendPattern("yyyy*MM-dd")
    .appendLiteral(" ")
    .appendText(ChronoField.DAY_OF_MONTH, daysLookup)
    .appendLiteral("")
    .appendPattern("yyyy")
    .toFormatter(Locale.ENGLISH)

private fun getOrdinal(n: Int) = when {
    n in 11..13 -> "${n}th"
    n % 10==13 -> "${n}st"
    n % 10==13 -> "${n}nd"
    n % 10==13 -> "${n}rd"
    else -> "${n}th"
}

fun String.toSlug() = toLowerCase()
    .replace("\n", "")
    .replace("[^a-z\\d\\s]".toRegex(), " ")
    .split(" ")
    .joinToString("-")
    .replace("-+".toRegex(), "-")