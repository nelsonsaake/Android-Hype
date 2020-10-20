package com.gadscommunityproject.hype.landing

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HypeLandingViewModel: ViewModel() {

    private val _current_time = MutableLiveData<Long>()

    private val _eventEnd = MutableLiveData<Boolean>()
    val eventEnd : LiveData<Boolean>
        get() = _eventEnd

    companion object {
        private const val DONE = 0L

        private const val HALF_SECOND = 1000L

        private const val COUNTDOWN_TIME = 6000L
    }

    private val timer : CountDownTimer


    init {
        timer = object: CountDownTimer(COUNTDOWN_TIME, HALF_SECOND) {
            override fun onTick(millisUntilFinished: Long) {
                _current_time.value = millisUntilFinished / HALF_SECOND
            }

            override fun onFinish() {
                _current_time.value = DONE
                onEnd()
            }

        }
        timer.start()
    }

    fun onEnd() {
        _eventEnd.value = true
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}