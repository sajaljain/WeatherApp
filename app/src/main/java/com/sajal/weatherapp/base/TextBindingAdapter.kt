package com.sajal.weatherapp.base

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object TextBindingAdapter {

    @JvmStatic
    @BindingAdapter("formatDayDate")
    fun setDayAndDate(textView: TextView, time: Int?) {
        textView.text = time?.let {
            val cl :Calendar = Calendar.getInstance().apply {
                this.timeInMillis = time * 1000L
            }
            val sdf = SimpleDateFormat( BaseConstants.EEEE_DD_MMM_YYYY , Locale.US)
            sdf.format(cl.time)
        }
    }

    @JvmStatic
    @BindingAdapter("formatTimeIn24HourMin")
    fun setTimeIn24HourFormat(textView: TextView, time: Int?) {
        textView.text = time?.let {
            val cl :Calendar = Calendar.getInstance().apply {
                this.timeInMillis = time * 1000L
            }
            val sdf = SimpleDateFormat( BaseConstants._24_HOUR_MIN , Locale.US)
            sdf.format(cl.time)
        }
    }







}