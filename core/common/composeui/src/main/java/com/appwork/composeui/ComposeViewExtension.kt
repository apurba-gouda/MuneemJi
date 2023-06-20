package com.appwork.composeapp.ui.composeviewext

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier

fun Modifier.fullScreenView(): Modifier =
  this
    .fillMaxWidth()
    .fillMaxHeight()
