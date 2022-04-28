package com.app.myPracticalTask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.app.myPracticalTask.databinding.ActivityMainBinding
import com.app.myPracticalTask.view.AlbumFragment
import com.app.myPracticalTask.view.AlbumViewModel
import com.app.myPracticalTask.view.pojo.PojoAlbum
import com.hubwallet.utillss.ResultWrapper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: AlbumViewModel by viewModels()
    private var viewBinding:ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        homepage()
        albumApi()
    }

    private fun albumApi() {
        viewModel.AndroidGetAlbumData( ).observe(this,{
            updateUI(it)
        })
    }
    private fun updateUI(_state: ResultWrapper<Any>?) {
        when (_state) {
            is ResultWrapper.Loading -> {
                viewBinding!!.progressBarB.visibility = View.VISIBLE
            }
            is ResultWrapper.NetworkError -> {
                viewBinding!!.progressBarB.visibility = View.GONE
            }
            is ResultWrapper.GenericError -> {
                viewBinding!!.progressBarB.visibility = View.GONE
                _state.error?.error?.let {
                    Toast.makeText(this, "err " + it, Toast.LENGTH_SHORT).show()
                }
            }
            is ResultWrapper.Success -> {
                when (_state.data) {
                    is PojoAlbum -> {
                        _state.data.let {
                            setData()
                        }
                        // Toast.makeText(requireActivity(), "${_state.data.message} ", Toast.LENGTH_LONG).show()
                    }


                }
                viewBinding!!.progressBarB.visibility = View.GONE
                //requireActivity().enableTouch()
            }
        }
    }

    private fun setData() {

    }

    fun homepage() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame_main, AlbumFragment())
        //fragment.arguments = bundle
         ft.addToBackStack(null)
        ft.commit()


    }
}