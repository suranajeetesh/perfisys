package com.pqc.perfisys.core.ui

import androidx.lifecycle.ViewModel
import com.example.newbasicstructure.data.remote.model.ErrorModel
import com.example.newbasicstructure.util.extensionFunction.mutableLiveData

/**
 * Created by JeeteshSurana.
 */

open class BaseViewModel : ViewModel() {
    var mError = mutableLiveData(ErrorModel())
}