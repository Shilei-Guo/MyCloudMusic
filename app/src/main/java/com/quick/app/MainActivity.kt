package com.quick.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.quick.app.core.design.theme.MyAppTheme
import com.quick.app.feature.splash.SplashRoute
import com.quick.app.ui.theme.ClientAppTheme

//如果用Compose开发UI，尽量只包含一个Activity就好了
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                SplashRoute()
                //
//                Scaffold(modifier = Modifier) { innerPadding ->
//                    MyButton(
//                        R.string.agree,
//                        modifier = Modifier.padding(innerPadding)
                //padding和background交换位置效果不一样哦！
//                    )
            }
        }
    }
    //setContent其实是setContent(),只不过Kotlin中，函数如果最后一个参数接收的是闭包，可以移到括号外面来
}

//如果要让一个方法成为一个组件也就是在界面上展示，就必须要加@Composable
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(//Text就是ComposeUI提供的组件
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MyButton(title: Int, modifier: Modifier = Modifier) {
    Button(
        onClick = {
            Log.d("MyButton", "点击了")
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier.
        fillMaxWidth()
    ) {
//        Text(text = StringResource(id = ))
    }
}
