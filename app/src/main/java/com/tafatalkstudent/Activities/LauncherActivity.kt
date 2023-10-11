package com.tafatalkstudent.Activities

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.webkit.MimeTypeMap
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.StorageTask
import com.tafatalkstudent.Shared.*
import com.tafatalkstudent.databinding.LauncherActivityBinding


class LauncherActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var binding: LauncherActivityBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mImageUri: Uri
    private lateinit var mStorageRef: StorageReference
    private var mUploadTask: StorageTask<*>? = null


    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LauncherActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initall()
    }

    private fun initall() {

        mAuth = FirebaseAuth.getInstance()
        mStorageRef = FirebaseStorage.getInstance().getReference("uploads")

        binding.uploadFile.setOnClickListener {
            openFileChooser()
        }
    }


    private fun openFileChooser() {
        val intent = Intent()
        intent.type = "*/*" // Allow all file types
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, 100)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK && data != null && data.data != null) {
            mImageUri = data.data!!
            /* imageseleted.setVisibility(View.VISIBLE)
             PicassoClient.downloadImage(view.getContext(), mImageUri.toString(), imageseleted)*/
            showProgress(this)
            uploadFile()
        }
    }


    private fun uploadFile() {

        val fileReference: StorageReference = mStorageRef.child("${System.currentTimeMillis()}.${getFileExtension(mImageUri)}")

        mUploadTask = fileReference.putFile(mImageUri)
            .addOnSuccessListener { taskSnapshot ->
                // Get the download URL from taskSnapshot
                taskSnapshot.storage.downloadUrl.addOnSuccessListener { uri ->
                    val downloadUrl = uri.toString()
                    dismissProgress()
                    showAlertDialog("Upload successful. Download URL: $downloadUrl")

                    // You can use downloadUrl here for further processing if needed
                }.addOnFailureListener { e ->
                    dismissProgress()
                    showAlertDialog("Failed to get download URL: ${e.message}")
                }
            }
            .addOnFailureListener { e ->
                dismissProgress()
                showAlertDialog("Failed ${e}")
            }


    }


    private fun getFileExtension(uri: Uri): String? {
        val contentResolver: ContentResolver = applicationContext.contentResolver
        val mime = MimeTypeMap.getSingleton()
        return mime.getExtensionFromMimeType(contentResolver.getType(uri))
    }


}
