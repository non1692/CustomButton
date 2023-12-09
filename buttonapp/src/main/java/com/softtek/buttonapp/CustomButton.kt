package com.softtek.buttonapp

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import kotlin.properties.Delegates


class CustomButton : AppCompatButton {

    enum class styles(val value: Int) {
        Standard(0),
        Dark(1),
        Light(2);

        companion object {
            fun fromInt(value: Int) = values().first { it.value == value }
        }
    }

    var style: Int by Delegates.observable(1) { property, old, new ->
        //Styled.stylish( this)
    }
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        context.obtainStyledAttributes(attrs, R.styleable.Styled).apply {
            style = getInt(R.styleable.Styled_styledButton, 0)
        }

        stylish(this)

    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        paint.shader = LinearGradient(
            0f,
            0f,
            0f,
            height.toFloat(),
            Color.YELLOW,
            Color.WHITE,
            Shader.TileMode.MIRROR
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setCustomFont(fontName: TypeFont): Typeface? {

        val typeface = when (fontName) {
            TypeFont.REGULAR -> {
                resources.getFont(R.font.garnett_regular)
            }

            TypeFont.REGULAR_ITALIC -> {
                resources.getFont(R.font.garnett_regular_italic)
            }

            TypeFont.SEMI_BOLD -> {
                resources.getFont(R.font.garnett_semibold)
            }

            TypeFont.SEMI_BOLD_ITALIC -> {
                resources.getFont(R.font.garnett_semibold_italic)
            }

            else -> {
                resources.getFont(R.font.garnett_regular)
            }
        }
        return typeface
    }

    private fun setCustomFont(context: Context, fontName: TypeFont): Typeface? {

        val typeface = when (fontName) {
            TypeFont.REGULAR -> {
                ResourcesCompat.getFont(context, R.font.garnett_regular)
            }

            TypeFont.REGULAR_ITALIC -> {
                ResourcesCompat.getFont(context, R.font.garnett_regular_italic)
            }

            TypeFont.SEMI_BOLD -> {
                ResourcesCompat.getFont(context, R.font.garnett_semibold)
            }

            TypeFont.SEMI_BOLD_ITALIC -> {
                ResourcesCompat.getFont(context, R.font.garnett_semibold_italic)
            }

            else -> {
                ResourcesCompat.getFont(context, R.font.garnett_regular)
            }
        }
        return typeface
    }

    private fun stylish(button: CustomButton) {
        when (button.style) {

            CustomButton.styles.Standard.value -> {
                button.background =
                    ContextCompat.getDrawable(button.context, R.drawable.button_custom_standard)
                button.setTextColor(
                    ContextCompat.getColor(
                        button.context,
                        R.color.button_text_standar
                    )
                )
                button.isAllCaps = false
                button.setPadding(14, 4, 14, 4)
                button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15F)
                button.elevation = 8.0F
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    button.typeface = setCustomFont(TypeFont.SEMI_BOLD)
                } else {
                    button.typeface = setCustomFont(button.context, TypeFont.SEMI_BOLD)
                }
            }

            CustomButton.styles.Dark.value -> {
                button.background =
                    ContextCompat.getDrawable(button.context, R.drawable.button_custom_standard)
                button.setTextColor(
                    ContextCompat.getColor(
                        button.context,
                        R.color.button_text_standar
                    )
                )
                button.isAllCaps = false
                button.setPadding(14, 4, 14, 4)
                button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15F)
                button.elevation = 8.0F
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    button.typeface = setCustomFont(TypeFont.SEMI_BOLD)
                } else {
                    button.typeface = setCustomFont(button.context, TypeFont.SEMI_BOLD)
                }
            }

            CustomButton.styles.Light.value -> {
                button.background =
                    ContextCompat.getDrawable(button.context, R.drawable.button_custom_light)
                button.setTextColor(
                    ContextCompat.getColor(
                        button.context,
                        R.color.button_text_light
                    )
                )
                button.isAllCaps = false
                button.setPadding(14, 4, 14, 4)
                button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15F)
                button.elevation = 8.0F
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    button.typeface = setCustomFont(TypeFont.REGULAR)
                } else {
                    button.typeface = setCustomFont(button.context, TypeFont.REGULAR)
                }
            }

        }
    }

    enum class TypeFont {
        REGULAR, REGULAR_ITALIC, SEMI_BOLD, SEMI_BOLD_ITALIC
    }

}
