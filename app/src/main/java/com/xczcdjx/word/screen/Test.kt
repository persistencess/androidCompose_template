package com.xczcdjx.word.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.xczcdjx.word.utils.convertStrToMill
import com.xczcdjx.word.utils.formatDate
import com.xczcdjx.word.utils.formatDateTime
import com.xczcdjx.word.utils.formatNow
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime

@Preview(showBackground = true)
@Composable
fun Test(modifier: Modifier = Modifier) {
    Scaffold { pad ->
        Column(modifier.padding(pad)) {
//            Text(formatDate("2024-08-31 16:00:00"), fontSize = 30.sp)
            Text(formatDateTime("2024-09-02T11:44:16.266Z"), fontSize = 30.sp)
            println(Clock.System.now())
            println(formatNow())
            println(formatNow(showTime = true))
            val mi=convertStrToMill("2024-08-31 16:10:00")
            println(mi)
            println(formatNow(Instant.fromEpochSeconds(mi/1000),true))
//            LocalDateTime.
        }
    }
}