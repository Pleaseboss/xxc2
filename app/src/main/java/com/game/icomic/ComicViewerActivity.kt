package com.game.icomic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class ComicViewerActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var comicPagerAdapter: ComicPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_viewer)

        viewPager = findViewById(R.id.viewPager)

        // 获取选择的 Comic 对象
        val selectedComic = intent.getSerializableExtra("comic") as Comic

        // 创建适配器并设置给 ViewPager
        comicPagerAdapter = ComicPagerAdapter(this, selectedComic.pages)
        viewPager.adapter = comicPagerAdapter
    }

    companion object {
        fun start(context: Context, comic: Comic) {
            val intent = Intent(context, ComicViewerActivity::class.java).apply {
                putExtra("comic", comic)
            }
            context.startActivity(intent)
        }
    }
}
