package com.xczcdjx.word.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.char
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

fun formatDate(isoDateString: String): String {
    // 解析ISO 8601日期字符串为Instant对象
    val instant = Instant.parse(isoDateString)
    // 将Instant对象转换为本地日期时间对象
    val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
    // 提取日期部分并格式化为标准日期字符串
    return localDateTime.date.toString()
}

fun formatDateTime(isoDateString: String): String {
    val customFormat = LocalDateTime.Format {
        date(LocalDate.Formats.ISO)
        char(' ')
        hour(); char(':'); minute(); char(':'); second()
//        char(','); secondFraction(fixedLength = 3)
    }
    val instant = Instant.parse(isoDateString)
    val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
    return localDateTime.format(customFormat)
}

fun formatNow(now: Instant = Clock.System.now(), showTime: Boolean = false): String {
    val cF = LocalDateTime.Format {
        date(LocalDate.Formats.ISO)
        if (showTime) {
            char(' ')
            hour(); char(':'); minute(); char(':'); second()
//        char(','); secondFraction(fixedLength = 3)
        }
    }
    val localDT = now.toLocalDateTime(TimeZone.currentSystemDefault())
    return localDT.format(cF)
}

fun convertStrToMill(str: String):Long {
    val format = LocalDateTime.Format {
        date(LocalDate.Formats.ISO)
        char(' ')
        hour(); char(':'); minute(); char(':'); second()
    }
    return LocalDateTime.parse(str, format).toInstant(TimeZone.currentSystemDefault())
        .toEpochMilliseconds()
}