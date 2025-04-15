package com.coredata.myapplication.ui.theme.compose

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.coredata.myapplication.R
import com.coredata.myapplication.helper.Screens
import com.coredata.myapplication.state.UiState

@Composable
fun ListingScreen(uiState: UiState, navController: NavController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            HeaderView(headerText = Screens.LISTING.name, showTrailIcon = false)
        }
    ) { paddingValues ->
        if (uiState.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = stringResource(id = R.string.fetching_data))
            }
        } else {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
            ) {
                Divider(color = Color.LightGray, thickness = 1.dp)
                LazyColumn{
                    items(uiState.universityList?.size ?: 0) {
                        val university = uiState.universityList?.get(it)
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clickable {
                                navController.navigate(Screens.DETAIL.name + "/${university?.name}")
                            }
                        ) {
                            Image(painter = painterResource(android.R.drawable.ic_menu_myplaces) , contentDescription = "test")
                            Text(modifier = Modifier.padding(5.dp), text = "${university?.name}", color = Color.Black)
                        }
                    }
                }
            }
        }
    }
}