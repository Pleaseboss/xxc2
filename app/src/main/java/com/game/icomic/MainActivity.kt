package com.game.icomic

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var comicListView: ListView
    private val comics = mutableListOf<Comic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        comicListView = findViewById(R.id.comicListView)

        // 示例：加载本地漫画
        loadComics()

        // 设置列表适配器
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, comics.map { it.title })
        comicListView.adapter = adapter

        // 点击事件
        comicListView.setOnItemClickListener { _, _, position, _ ->
            val selectedComic = comics[position]
            ComicViewerActivity.start(this, selectedComic)
        }
    }

    private fun loadComics() {
        val pages1 = generateComicPages("comic1", 6)
    gi    val pages2 = generateComicPages("comic2", 6)
        comics.add(Comic("Comic 1", pages1))
        comics.add(Comic("Comic 2", pages2))
    }

    private fun generateComicPages(comicName: String, pageCount: Int): List<String> {
        val pages = mutableListOf<String>()
        for (i in 1..pageCount) {
            pages.add("$comicName/page$i.jpg")
        }
        return pages
    }

}