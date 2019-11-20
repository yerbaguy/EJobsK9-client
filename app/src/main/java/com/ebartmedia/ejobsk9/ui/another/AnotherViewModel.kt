package com.ebartmedia.ejobsk9.ui.another

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnotherViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Another Fragment"
    }
    val text: LiveData<String> = _text
}