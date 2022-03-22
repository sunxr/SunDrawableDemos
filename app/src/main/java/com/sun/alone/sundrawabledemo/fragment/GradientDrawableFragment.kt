package com.sun.alone.sundrawabledemo.fragment

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat
import com.sun.alone.sundrawabledemo.R
import com.sun.alone.sundrawabledemo.databinding.FragmentGradientDrawableBinding
import com.sun.alone.sundrawabledemo.tools.px

class GradientDrawableFragment : BaseFragment<FragmentGradientDrawableBinding>() {
  override fun initView() {
    binding.gradientDrawableInclude.apply {
      tv1.setText(R.string.gradient_drawable)
      tv1.background = ContextCompat.getDrawable(requireContext(), R.drawable.gradient_drawable)
      tv2.setText(R.string.gradient_drawable)

      val gradientDrawable = GradientDrawable().apply {
        shape = GradientDrawable.OVAL
        gradientType = GradientDrawable.RADIAL_GRADIENT
        colors = intArrayOf(Color.parseColor("#00F5FF"), Color.parseColor("#BBFFFF"))
        gradientRadius = 100f.px
      }
      tv2.background = gradientDrawable
    }
  }
}