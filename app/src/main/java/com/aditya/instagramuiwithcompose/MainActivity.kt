package com.aditya.instagramuiwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aditya.instagramuiwithcompose.ui.theme.InstagramUIWithComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            InstagramUIWithComposeTheme {
                ProfileScreen()
            }
        }
    }
}

