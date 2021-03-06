package com.sun.alone.sundrawabledemo.fragment

import android.graphics.drawable.InsetDrawable
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.sun.alone.sundrawabledemo.R
import com.sun.alone.sundrawabledemo.databinding.FragmentInsetDrawableBinding

class InsetDrawableFragment : BaseFragment<FragmentInsetDrawableBinding>() {
  @RequiresApi(Build.VERSION_CODES.O)
  override fun initView() {
    binding.insetDrawableInclude.apply {
      tv1.setText(R.string.inset_drawable)
      tv1.background = ContextCompat.getDrawable(requireContext(), R.drawable.inset_drawable)
      tv2.setText(R.string.inset_drawable)

      val insetDrawable = InsetDrawable(
        ContextCompat.getDrawable(requireContext(), R.drawable.nick),
        0f, 0f, 0.5f, 0.25f
      )
      tv2.background = insetDrawable
    }
  }
}