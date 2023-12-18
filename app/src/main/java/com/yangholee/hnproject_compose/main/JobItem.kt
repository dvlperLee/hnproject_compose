package com.yangholee.hnproject_compose.main

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun JobItem(
    name: String,
    @DrawableRes resId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    description: String = "",
    itemSeparation: Dp = 16.dp,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1f)
                .clickable { onClick() }
                .padding(vertical = itemSeparation),
        ) {
            JobIcon(resId, iconModifier.size(64.dp))
            Spacer(modifier = Modifier.width(24.dp))
            JobContent(name, description)
        }

    }
}

@Composable
private fun JobContent(name: String, description: String, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(
                vertical = if (description.isEmpty()) 0.dp else 4.dp,
            ),
        )
        if (description.isNotEmpty()) {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Composable
private fun JobIcon(@DrawableRes resId: Int
                    , modifier: Modifier = Modifier) {
    Icon(
        modifier = modifier
            .padding(4.dp),
        painter =  painterResource(resId),
        contentDescription = null, // decorative image
        tint = Color.Unspecified
    )
}