package com.beloushkin.test.camera2test.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.beloushkin.test.camera2test.CameraViewModel
import com.beloushkin.test.camera2test.R

class ExoPlayerFragment: Fragment() {

    private val cameraViewModel by lazy {
        ViewModelProviders.of(activity!!).get(CameraViewModel::class.java)
    }

    companion object {
        val TAG = ExoPlayerFragment::class.qualifiedName
        @JvmStatic fun newInstance() = ExoPlayerFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exoplayer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG,"Video uri: ${cameraViewModel.videoUri}" )
    }
}