package com.example.snapshots

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.snapshots.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private val COD_GALLERY = 10
    private lateinit var mBinding: FragmentAddBinding
    private var mPhotoSelectedUri: Uri? = null

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        mBinding.imgPhoto.setImageURI(uri)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAddBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.btnSelect.setOnClickListener { openGallery() }
        mBinding.btnPost.setOnClickListener { postSnapshot() }
    }

    private fun openGallery() {
        getContent.launch("image/*")
//        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//        startActivityForResult(intent, COD_GALLERY)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(resultCode == Activity.RESULT_OK){
//            if(requestCode == COD_GALLERY){
//                mPhotoSelectedUri = data?.data
//                mBinding.imgPhoto.setImageURI(mPhotoSelectedUri)
//            }
//        }
//    }

    private fun postSnapshot() {
        TODO("Not yet implemented")
    }

}