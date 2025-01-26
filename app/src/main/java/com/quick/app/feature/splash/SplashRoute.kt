package com.quick.app.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quick.app.R
import com.quick.app.core.design.theme.MyAppTheme
import com.quick.app.core.design.theme.body2XLargeBold
import com.quick.app.util.SuperDateUtil

@Composable
//开屏界面
//调用工具类的方法可以在Route这个层次来调用
fun SplashRoute() {
    SplashScreen(
//        year = SuperDateUtil.currentYear()
        year = 2025
    )
}

@Composable
//真正的UI是放进SplashScreen里面的
//显示图片用Image控件，如果显示R.drawable里的图片就要painterResource
//大部分控件的尺寸边距背景颜色都是通过Modifier来设置的
//Modifier中的顺序是非常重要的
//App中的字体大小会随着手机系统设置跟随变化，sp可以，dp不行
fun SplashScreen(year: Int = 2024
) {
    //背景-Box容器-相对布局
    //Compose中一个控件的宽高背景等都可以通过Modifier来实现
    //Modifier:Max-宽高 Width-宽 Height-高

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primary)
    ) {

        //region 启动界面banner（横幅）
        Image(painter = painterResource(id = R.drawable.splash_banner),
            contentDescription = null,
            modifier = Modifier.padding(top = 20.dp)
                .align(Alignment.TopCenter) //顶部水平居中
        )//拓展：残障人士辅助功能(contentDescription
        //endregion

        //region 启动界面logo
        Image(painter = painterResource(id = R.drawable.splash_logo),
            contentDescription = null,
            modifier = Modifier.padding(bottom = 60.dp)
                .align(Alignment.BottomCenter) //底部水平居中
        )//拓展：残障人士辅助功能(contentDescription
        //endregion

        //版权文件
        //其中日期有的项目可以更改，有的项目不可以更改，更改方式可以是随系统时间变化
        //可以通过工具类SuperDateUtil.currentYear()来获取系统年份
        //大企业最好是不可以更改的，那我们就把year固定了
        /* 关于R.string.copyright的参数传递
        <string name="copyright" translatable="false">Copyright © %1$d Ixuea. All Rights Reserved</string>
        %1表示传递的第一个参数，如下即year
        %2表示传递的第二个参数，以此类推
        $d显示的是Int类型，$s显示的string类型
        %2 %1的顺序是可以变化的，哪个在前哪个就显示在前
         */
        Text(text = stringResource(id = R.string.copyright, year),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 30.dp)
                .align(Alignment.BottomCenter))
    }
}

@Preview(showBackground = true)
//实时预览需要添加这一行，方法名：xxPreview
//仅限于测试，打印日志/请求网络等复杂操作是不能执行的
@Composable
fun SplashRoutePreview():Unit{
    MyAppTheme {
        SplashRoute()
    }
}