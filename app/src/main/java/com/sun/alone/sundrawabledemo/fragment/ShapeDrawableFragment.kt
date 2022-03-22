package com.sun.alone.sundrawabledemo.fragment

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import androidx.core.content.ContextCompat
import com.sun.alone.sundrawabledemo.R
import com.sun.alone.sundrawabledemo.databinding.FragmentShapeDrawableBinding
import com.sun.alone.sundrawabledemo.tools.px

class ShapeDrawableFragment : BaseFragment<FragmentShapeDrawableBinding>() {
  override fun initView() {
    binding.shapeDrawableInclude.apply {
      tv1.setText(R.string.shape_drawable)
      tv1.background = ContextCompat.getDrawable(requireContext(), R.drawable.shape_drawable)
      tv2.setText(R.string.shape_drawable)

      val roundRectShape = RoundRectShape(
        floatArrayOf(20f.px, 20f.px, 20f.px, 20f.px, 0f, 0f, 0f, 0f),
        null,
        null
      )
      tv2.background = MyShapeDrawable(roundRectShape)
    }
  }

  class MyShapeDrawable(shape: Shape): ShapeDrawable(shape) {
    private val fillPaint = Paint().apply {
      style = Paint.Style.FILL
      color = Color.parseColor("#4169E1")
    }
    private val strokePaint = Paint().apply {
      style = Paint.Style.STROKE
      color = Color.parseColor("#FFBB86FC")
      strokeMiter = 10f
      strokeWidth = 5f.px
      pathEffect = DashPathEffect(floatArrayOf(10f.px, 5f.px), 0f)
    }

    override fun onDraw(shape: Shape?, canvas: Canvas?, paint: Paint?) {
      super.onDraw(shape, canvas, paint)
      shape?.draw(canvas, fillPaint)
      shape?.draw(canvas, strokePaint)
    }
  }
}