package com.example.copy_paste

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.copy_paste.ViewModels.DetailScreenViewModel
import com.example.copy_paste.data.Copied

class SendDirect : AppCompatActivity() {
    lateinit var data: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailScreenViewModel: DetailScreenViewModel by viewModels()
        if (intent.action != null && intent.action.equals(Intent.ACTION_PROCESS_TEXT) ){
            if (intent.hasExtra(Intent.EXTRA_PROCESS_TEXT)){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    data = intent.getStringExtra(Intent.EXTRA_PROCESS_TEXT).toString()
                }
                Toast.makeText(this,"data --> $data", Toast.LENGTH_LONG).show()
                detailScreenViewModel.addCopied(Copied(text = data))
                finish()
            }
        }
    }
}