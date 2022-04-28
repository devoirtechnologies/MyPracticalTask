package com.app.myPracticalTask.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.app.myPracticalTask.R
import com.app.myPracticalTask.databinding.FragmentAlbumBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumFragment : Fragment() {

   private var viewBinding :FragmentAlbumBinding?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        viewBinding = DataBindingUtil.inflate(R.layout.fragment_album, container, false)
        viewBinding = FragmentAlbumBinding.inflate(layoutInflater)
        val view = viewBinding!!.root
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}