package com.example.fightcentre.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    val disposables: CompositeDisposable = CompositeDisposable()
    val errorMessage: MutableLiveData<String> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}