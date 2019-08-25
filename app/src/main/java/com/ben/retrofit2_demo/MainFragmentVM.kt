package com.ben.retrofit2_demo

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ben.retrofit2_demo.utils.SingleLiveEvent

class MainFragmentVM : ViewModel() {
  val clickLiveEvent = SingleLiveEvent<Int>()
  val aaa = MutableLiveData<String>()

  fun onClick(v: View) {
    when (v.id) {
      R.id.button -> {
        println("-------------------")
      }
    }
  }

}
