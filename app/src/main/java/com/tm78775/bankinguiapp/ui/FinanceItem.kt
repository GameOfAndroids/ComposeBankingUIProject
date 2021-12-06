package com.tm78775.bankinguiapp.ui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class FinanceItem(
    val title: String,
    @DrawableRes val icon: Int,
    val color: Color
)
