package com.coredata.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coredata.myapplication.helper.Screens
import com.coredata.myapplication.state.UiState
import com.coredata.myapplication.ui.theme.MyApplicationTheme
import com.coredata.myapplication.ui.theme.compose.DetailViewScreen
import com.coredata.myapplication.ui.theme.compose.HeaderView
import com.coredata.myapplication.ui.theme.compose.ListingScreen
import com.coredata.myapplication.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Home()
                }
            }
        }
    }

    @Preview
    @Composable
    private fun Home() {
        val uiState by viewModel.uiState.collectAsState()
        val navComposable = rememberNavController()
        NavHost(navController = navComposable, startDestination = Screens.LISTING.name) {
            composable(Screens.LISTING.name) {
                ListingScreen(
                    uiState = uiState,
                    navController = navComposable
                )
            }
            composable(Screens.DETAIL.name + "/{itemId}") {
                val itemId = it.arguments?.getString("itemId")
                DetailViewScreen(
                    uiState = uiState,
                    navController = navComposable,
                    item = itemId.orEmpty()
                )
            }
        }
    }
}
