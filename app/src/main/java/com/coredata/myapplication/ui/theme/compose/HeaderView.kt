package com.coredata.myapplication.ui.theme.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coredata.myapplication.R

@Composable
fun HeaderView(
    headerText: String,
    showTrailIcon : Boolean = true,
    onBackClick: () -> Unit = {},
) {
    Box (
        modifier = Modifier
            .fillMaxWidth().background(MaterialTheme.colorScheme.primary)) {
        if(showTrailIcon) {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_close), contentDescription = "back icon",
                modifier = Modifier.padding(top = 15.dp, start = 15.dp, bottom = 15.dp)
                    .clickable { onBackClick() }
            )
        }
        Text(
            modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp),
            textAlign = TextAlign.Center,
            text = headerText,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview
@Composable
private fun Preview() {
    HeaderView(
        headerText = "Header",
        onBackClick = {}
    )
}