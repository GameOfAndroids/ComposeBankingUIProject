package com.tm78775.bankinguiapp.ui

import androidx.lifecycle.ViewModel
import com.tm78775.bankinguiapp.R
import com.tm78775.bankinguiapp.ui.theme.*

class HomeScreenViewModel : ViewModel() {

    fun getAccounts() : List<AccountItem> {
        return ArrayList<AccountItem>().apply {
            AccountItem(
                title = "Business",
                cardIcon = R.drawable.ic_visa_logo,
                balance = "$ 5,363",
                acctLastFourDigits = "6917",
                startColor = DarkGreen,
                endColor = LightGreen
            ).also {
                add(it)
            }

            AccountItem(
                title = "Savings",
                cardIcon = R.drawable.ic_visa_logo,
                balance = "$ 3,235",
                acctLastFourDigits = "2375",
                startColor = DarkOrange,
                endColor = LightOrange
            ).also {
                add(it)
            }

            AccountItem(
                title = "Checking",
                cardIcon = R.drawable.ic_visa_logo,
                balance = "$ 17,207",
                acctLastFourDigits = "1123",
                startColor = DarkYellow,
                endColor = LightYellow
            ).also {
                add(it)
            }

            AccountItem(
                title = "Swiss Account",
                cardIcon = R.drawable.ic_visa_logo,
                balance = "$ 52,603",
                acctLastFourDigits = "0001",
                startColor = DarkGreen,
                endColor = LightGreen
            ).also {
                add(it)
            }

            AccountItem(
                title = "Business",
                cardIcon = R.drawable.ic_visa_logo,
                balance = "$ 5,363",
                acctLastFourDigits = "6917",
                startColor = DarkOrange,
                endColor = LightOrange
            ).also {
                add(it)
            }
        }
    }

    fun getFinanceItems() : List<FinanceItem> {
        return listOf(
            FinanceItem(
                title = "My Bonuses",
                icon = R.drawable.ic_outline_star_24,
                color = Blue
            ),
            FinanceItem(
                title = "My Budget",
                icon = R.drawable.ic_outline_account_balance_wallet_24,
                color = LightGreen
            ),
            FinanceItem(
                title = "Finance Analysis",
                icon = R.drawable.ic_outline_donut_small_24,
                color = Purple
            ),
            FinanceItem(
                title = "My Salary",
                icon = R.drawable.ic_outline_dollar_24,
                color = DarkOrange
            ),
            FinanceItem(
                title = "My Savings",
                icon = R.drawable.ic_outline_savings_24,
                color = DarkYellow
            )
        )
    }

}