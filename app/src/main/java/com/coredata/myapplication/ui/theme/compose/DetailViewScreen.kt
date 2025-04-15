package com.coredata.myapplication.ui.theme.compose

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.coredata.myapplication.R
import com.coredata.myapplication.helper.Screens
import com.coredata.myapplication.state.UiState

@Composable
fun DetailViewScreen(uiState: UiState, navController: NavController, item: String) {
    val detailInfo = uiState.universityList?.find { it.name == item }

    AnimatedVisibility(
        visible = true,
        enter = slideInHorizontally(initialOffsetX = { fullWidth: Int -> fullWidth }),
        exit = slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth })
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            HeaderView(headerText = Screens.DETAIL.name,
                onBackClick = {
                    navController.navigate(Screens.LISTING.name)
                }
            )
            Divider(color = Color.LightGray, thickness = 1.dp)
            Column(modifier = Modifier.fillMaxSize()) {
                DetailItems(
                    title = stringResource(id = R.string.name),
                    desc = detailInfo?.name.orEmpty()
                )
                DetailItems(
                    title = stringResource(id = R.string.country),
                    desc = detailInfo?.country.orEmpty()
                )
                DetailItems(
                    title = stringResource(id = R.string.alpha_code),
                    desc = detailInfo?.alphaTwoCode.orEmpty()
                )
                DetailItems(
                    title = stringResource(id = R.string.web_page),
                    desc = detailInfo?.webPages?.firstOrNull()
                        ?: stringResource(id = R.string.no_website),
                    isHyperLink = true
                )
            }
        }
    }
}

@Composable
private fun DetailItems(
    title: String,
    desc: String,
    isHyperLink: Boolean = false
) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(start = 8.dp)
        )
        Text(
            modifier = Modifier
                .padding(start = 8.dp)
                .clickable {
                    if (isHyperLink) {
                        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(desc)))
                    }
                },
            text = desc,
            color = if (isHyperLink) Color.Blue else Color.Black,
            textDecoration = if (isHyperLink) TextDecoration.Underline else TextDecoration.None
        )
    }
}