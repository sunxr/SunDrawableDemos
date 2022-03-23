package com.sun.alone.sundrawabledemo.fragment

import android.graphics.drawable.ScaleDrawable
import android.util.Log
import android.view.Gravity
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import com.sun.alone.sundrawabledemo.R
import com.sun.alone.sundrawabledemo.databinding.FragmentScaleDrawableBinding

class ScaleDrawableFragment : BaseFragment<FragmentScaleDrawableBinding>() {
  override fun initView() {
    binding.scaleDrawableInclude.apply {
      tv1.setText(R.string.scale_drawable)
      tv1.background = ContextCompat.getDrawable(requireContext(), R.drawable.scale_drawable)
      tv2.setText(R.string.scale_drawable)

      val scaleDrawable = ScaleDrawable(
        ContextCompat.getDrawable(requireContext(), R.drawable.nick),
        Gravity.CENTER,
        1f,
        1f
      )
      tv2.background = scaleDrawable

      binding.seekBar.apply {
        //init level
        tv1.background.level = progress
        scaleDrawable.level = progress
        //add listener
        setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
          override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            tv1.background.level = p1
            scaleDrawable.level = p1
            Log.e(TAG, "onProgressChanged: progress = $p1")
          }

          override fun onStartTrackingTouch(p0: SeekBar?) {

          }

          override fun onStopTrackingTouch(p0: SeekBar?) {

          }

        })
      }
    }
  }
}