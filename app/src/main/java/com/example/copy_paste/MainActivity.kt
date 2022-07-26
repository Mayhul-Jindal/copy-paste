package com.example.copy_paste

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.copy_paste.ViewModels.DetailScreenViewModel
import com.example.copy_paste.data.Copied
import com.example.copy_paste.navigation.nav_graphs.SetupNavGraph
import com.example.copy_paste.ui.theme.CopyPasteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
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
        setContent {
            CopyPasteTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController, detailScreenViewModel)
            }
        }
    }
}
