package com.droid.jetpacktutorial.palette.view

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import com.droid.jetpacktutorial.R
import kotlinx.android.synthetic.main.palette_activity.*

/**
 * Add the below dependencies to app build.gradle
 * implementation "androidx.palette:palette:$paletteVersion"
 */
class PaletteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.palette_activity)

        val bitmap = image.drawable.toBitmap()

        getPaletteFromBitmap(bitmap)
    }

    private fun getPaletteFromBitmap(bitmap: Bitmap) {
        Palette.from(bitmap).generate {
            val color = it?.vibrantSwatch?.rgb ?: 0
            color_palette.setBackgroundColor(color)
        }
    }
}