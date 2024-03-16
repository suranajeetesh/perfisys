package com.pqc.perfisys.viewmodel

import androidx.lifecycle.ViewModel
import com.example.newbasicstructure.util.extensionFunction.mutableLiveData
import com.pqc.perfisys.data.local.Category
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

    val categoriesLiveData = mutableLiveData(
        arrayListOf(
            Category("Category 1", "https://picsum.photos/480/720"),
            Category("Category 2", "https://picsum.photos/480/720"),
            Category("Category 3", "https://picsum.photos/480/720"),
            Category("Category 4", "https://picsum.photos/480/720"),
            Category("Category 5", "https://picsum.photos/480/720"),
            Category("Category 6", "https://picsum.photos/480/720"),
            Category("Category 7", "https://picsum.photos/480/720"),
            Category("Category 8", "https://picsum.photos/480/720"),
            Category("Category 9", "https://picsum.photos/480/720"),
            Category("Category 10", "https://picsum.photos/480/720"),
            Category("Category 11", "https://picsum.photos/480/720"),
            Category("Category 12", "https://picsum.photos/480/720"),
            Category("Category 13", "https://picsum.photos/480/720"),
            Category("Category 14", "https://picsum.photos/480/720"),
            Category("Category 15", "https://picsum.photos/480/720"),
            Category("Category 16", "https://picsum.photos/480/720"),
            Category("Category 17", "https://picsum.photos/480/720"),
            Category("Category 18", "https://picsum.photos/480/720"),
            Category("Category 19", "https://picsum.photos/480/720"),
            Category("Category 20", "https://picsum.photos/480/720"),
            Category("Category 21", "https://picsum.photos/480/720"),
            Category("Category 22", "https://picsum.photos/480/720"),
            Category("Category 23", "https://picsum.photos/480/720"),
            Category("Category 24", "https://picsum.photos/480/720"),
            Category("Category 25", "https://picsum.photos/480/720")
        )
    )
}
