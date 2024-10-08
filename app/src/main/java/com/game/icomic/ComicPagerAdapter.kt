package com.game.icomic

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.viewpager.widget.PagerAdapter
import java.io.IOException

class ComicPagerAdapter(
    private val context: Context,
    private val comicPages: List<String>
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context)
        val bitmap = loadImageFromAssets(comicPages[position])
        imageView.setImageBitmap(bitmap)
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER

        container.addView(imageView)

        return imageView
    }

    private fun loadImageFromAssets(filePath: String): Bitmap? {
        return try {
            val inputStream = context.assets.open(filePath)
            BitmapFactory.decodeStream(inputStream)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    override fun getCount(): Int {
        return comicPages.size
    }

    override fun isViewFromObject(@NonNull view: View, @NonNull obj: Any): Boolean {
        return view === obj
    }

    override fun destroyItem(container: ViewGroup, position: Int, @NonNull obj: Any) {
        container.removeView(obj as View)
    }
}
