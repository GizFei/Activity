package com.giz.fragment.example

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.ListFragment
import com.giz.fragment.R
import com.giz.utility.log

/**
 * 官方示例学习：
 * https://developer.android.google.cn/guide/components/fragments#Example
 */
class FragmentLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_layout)

        supportActionBar?.title = "Fragment分屏管理"
    }

    class TitlesFragment : ListFragment() {

        // 是否为双Fragment的视图
        private var dualPane: Boolean = false
        // 当前选择位置
        private var curCheckPosition = 0

        private val CHOICE_KEY = "curChoice"

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)

            // 扩充列表
            listAdapter = ArrayAdapter<String>(
                activity!!,
                android.R.layout.simple_list_item_activated_1,
                Shakespeare.TITLES
            )

            // 检查是否有“详情页”的Fragment
            val detailsFrame: View? = activity?.findViewById(R.id.details)
            /*if (detailsFrame == null) {
                Toast.makeText(activity, "空详情页", Toast.LENGTH_SHORT).show()
            }*/
            dualPane = detailsFrame?.visibility == View.VISIBLE

            // 横竖屏切换时，获取保存的状态
            curCheckPosition = savedInstanceState?.getInt(CHOICE_KEY, 0) ?: 0

            if (dualPane) {
                // 单选列表模式
                listView.choiceMode = ListView.CHOICE_MODE_SINGLE

                showDetails(curCheckPosition)
            }
        }

        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            // 保存当前位置
            outState.putInt(CHOICE_KEY, curCheckPosition)
        }

        // 点击列表项动作
        override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
            showDetails(position)
        }

        private fun showDetails(index: Int) {
            curCheckPosition = index
            log("当前位置：$curCheckPosition。是否为双屏：$dualPane")

            if (dualPane) {
                log("设置列表选中项：$index")
                listView.choiceMode = ListView.CHOICE_MODE_SINGLE
                listView.setItemChecked(index, true)

                var details = fragmentManager?.findFragmentById(R.id.details) as? DetailsFragment
                if (details?.showIndex != index) {
                    details = DetailsFragment.newInstance(index)

                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.details, details)
                        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        commit()
                    }
                }
            } else {
                val intent = Intent(activity, DetailsActivity::class.java).apply {
                    putExtra("index", index)
                }
                startActivity(intent)
            }
        }

    }

    class DetailsFragment : Fragment() {
        val showIndex: Int by lazy { arguments?.getInt("index", 0) ?: 0 }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            if (container == null) {
                // 竖屏状态时，该Fragment不应返回视图
                return null
            }

            val text = TextView(activity).apply {
                val padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4f, activity?.resources?.displayMetrics).toInt()
                setPadding(padding, padding, padding, padding)
                text = Shakespeare.DIALOGUE[showIndex]
            }

            return ScrollView(activity).apply { addView(text) }
        }

        companion object {
            fun newInstance(index: Int) = DetailsFragment().apply{
                arguments = Bundle().apply { putInt("index", index) }
            }
        }
    }

    class DetailsActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            // 横屏模式则结束此活动，返回原活动显示
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                finish()
                return
            }

            if (savedInstanceState == null) {
                val details = DetailsFragment.newInstance(intent?.getIntExtra("index", 0) ?: 0)
                supportFragmentManager.beginTransaction()
                    .add(android.R.id.content, details)
                    .commit()
            }
        }
    }

}