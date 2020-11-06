package com.giz.interaction.send

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.widget.Toast
import com.giz.interaction.R
import com.giz.utility.toast
import java.util.*

class SendImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_implicit_intent)

        supportActionBar?.title = "发送各类隐式Intent"
    }

    fun click(view: View) {
        when(view.tag) {
            "dial" -> { // 打电话
                Uri.parse("tel:17367078004").let {
                    Intent(Intent.ACTION_DIAL, it).navigation()
                }
            }
            "map" -> { // 查看地图
                Uri.parse("geo:22.546686,113.951534?z=14").let {
                    Intent(Intent.ACTION_VIEW, it).navigation()
                }
            }
            "web" -> { // 查看网页
                // 需要加上https://
                Uri.parse("https://www.baidu.com").let {
                    Intent(Intent.ACTION_VIEW, it).navigation()
                }
            }
            "email" -> { // 发送邮件
                Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("1150847818@qq.com"))
                    putExtra(Intent.EXTRA_SUBJECT, "邮件主题")
                    putExtra(Intent.EXTRA_TEXT, "邮件主体内容")
                }.navigation()
            }
            "calendar" -> { // 创建日历活动
                Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI).apply {
                    val beginTime = Calendar.getInstance().apply { set(2020, 9, 25, 10, 30) }
                    val endTime = Calendar.getInstance().apply { set(2020, 9, 25, 12, 30) }
                    putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime)
                    putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime)
                    putExtra(CalendarContract.Events.TITLE, "日历活动标题")
                    putExtra(CalendarContract.Events.EVENT_LOCATION, "活动位置")
                }.navigation()
            }
            "illegal" -> { // 非法Intent检测
                val illegalIntent = Intent("IllegalIntent")
                val activities: List<ResolveInfo> = packageManager.queryIntentActivities(illegalIntent, PackageManager.MATCH_DEFAULT_ONLY)
                if (activities.isEmpty()) {
                    toast("找不到合适的应用")
                }
            }
            "chooser" -> { // 强制显示选择器对话框
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "这是分享的内容")
                }
                val chooser = Intent.createChooser(intent, "分享")
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(chooser)
                }
            }
        }
    }

    private fun Intent.navigation() {
        startActivity(this)
    }
}