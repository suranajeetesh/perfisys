package com.pqc.perfisys.viewmodel

import androidx.lifecycle.ViewModel
import com.example.newbasicstructure.util.extensionFunction.mutableLiveData
import com.pqc.perfisys.data.local.ImageData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor() : ViewModel() {

    val imageList = mutableLiveData(
        arrayListOf(
            ImageData("https://images.unsplash.com/photo-1516117172878-fd2c41f4a759"),
            ImageData("https://images.unsplash.com/photo-1522771739844-6a9f6d5f14af"),
            ImageData("https://picsum.photos/480/720"),
            ImageData("https://picsum.photos/480/720"),
            ImageData("https://picsum.photos/480/720"),
            ImageData("https://picsum.photos/480/720"),
            ImageData("https://picsum.photos/480/720"),
            ImageData("https://picsum.photos/480/720"),
            ImageData("https://picsum.photos/480/720"),
            ImageData("https://picsum.photos/480/720"),
            ImageData("https://picsum.photos/480/720"),
            ImageData("https://picsum.photos/480/720"),
            ImageData("https://picsum.photos/480/720"),
            ImageData("https://picsum.photos/480/720"),
            ImageData("https://picsum.photos/480/720"),

        )
    )
}
