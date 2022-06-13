package kz.coreproject.data.app_lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kz.coreproject.data.app_lifecycle.ApplicationLifecycleState
import javax.inject.Inject

class ApplicationObserver
@Inject constructor(
    private val state: ApplicationLifecycleState
) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onForeground() {
        Log.e("ApplicationObserver", "!!!App goes to foreground")
        // App goes to foreground
        state.isForeground = true
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onBackground() {
        Log.e("ApplicationObserver", "!!!App goes to background")
        // App goes to background
        state.isForeground = false
    }

}