package com.tm78775.bankinguiapp.ui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class AccountItem(
    val title: String,
    @DrawableRes val cardIcon: Int,
    val balance: String,
    val acctLastFourDigits: String,
    val startColor: Color,
    val endColor: Color
)
