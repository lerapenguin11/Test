package com.example.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.ResultTest
import com.example.domain.entity.room.Rooms
import com.example.domain.usecase.GetRoomDataUseCase
import kotlinx.coroutines.launch

class RoomViewModel(
    private val getRoomDataUseCase: GetRoomDataUseCase
) : ViewModel(){

    private val _dataLoadingRoom = MutableLiveData(true)
    val dataLoadingRoom: LiveData<Boolean> = _dataLoadingRoom

    private val _errorRoom = MutableLiveData<String>()
    val errorRoom: LiveData<String> = _errorRoom

    private val _roomRemote = MutableLiveData<List<Rooms>?>()
    val roomRemoteLiveData : MutableLiveData<List<Rooms>?> = _roomRemote

    fun getDataRoom() {
        viewModelScope.launch {
            _dataLoadingRoom.postValue(true)
            when (val roomResult = getRoomDataUseCase.invoke()) {
                is ResultTest.Success -> {
                    _roomRemote.value = roomResult.data
                }

                is ResultTest.Error -> {
                    _dataLoadingRoom.postValue(false)
                    _errorRoom.postValue(roomResult.exception.message)
                }
            }
        }
    }
}