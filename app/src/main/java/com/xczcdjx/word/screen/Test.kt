package com.xczcdjx.word.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.xczcdjx.word.share.TextShare
import com.xczcdjx.word.utils.convertStrToMill
import com.xczcdjx.word.utils.formatDateTime
import com.xczcdjx.word.utils.formatNow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import javax.inject.Inject

@HiltViewModel
class TestViewmodel @Inject constructor(
    private val testInf: TextShare
) : ViewModel() {
    val getFun = testInf.test()
}
@Preview(showBackground = true)
@Composable
fun Test(modifier: Modifier = Modifier, vm: TestViewmodel = hiltViewModel()) {
    Scaffold { pad ->
        Column(modifier.padding(pad)) {
//            Text(formatDate("2024-08-31 16:00:00"), fontSize = 30.sp)
            // 日期时间处理
            Text(formatDateTime("2024-09-02T11:44:16.266Z"), fontSize = 30.sp)
            println(Clock.System.now())
            println(formatNow())
            println(formatNow(showTime = true))
            val mi=convertStrToMill("2024-08-31 16:10:00")
            println(mi)
            println(formatNow(Instant.fromEpochSeconds(mi/1000),true))
            // hilt provide
            Text(vm.getFun)
        }
    }
}