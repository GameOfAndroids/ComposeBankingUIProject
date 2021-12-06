package com.tm78775.bankinguiapp.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tm78775.bankinguiapp.R
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.tm78775.bankinguiapp.Build
import com.tm78775.bankinguiapp.ui.theme.*

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(
            state = scrollState
        )
    ) {
        WalletSection(modifier = Modifier)
        AccountsList(accounts = viewModel.getAccounts())
        FinanceSection(financeItems = viewModel.getFinanceItems())
        CurrenciesSection()
    }
}

@Composable
fun WalletSection(
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Wallet",
                style = TextStyle(
                    fontFamily = FontFamily(
                        Font(R.font.poppins_light)
                    ),
                    color = LightGray,
                    fontSize = 18.sp
                )
            )
            Text(
                text = "$ 24,532",
                style = TextStyle(
                    fontFamily = FontFamily(
                        Font(R.font.poppins_semibold)
                    ),
                    color = Color.White,
                    fontSize = 32.sp
                )
            )
        }
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .clickable {
                    Log.d(this.toString(), "Search Fool!")
                }
                .background(Gray)
                .padding(6.dp)
        ) {
            Icon(
                Icons.Default.Search,
                tint = Color.White,
                contentDescription = "Search"
            )
        }
    }
}


@Composable
fun AccountsList(
    accounts : List<AccountItem>
) {
    LazyRow(
        contentPadding = PaddingValues(
            horizontal = 12.dp,
            vertical = 8.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(accounts) { _, item ->
            AccountItem(item)
        }
    }
}

@Composable
fun AccountItem(
    item: AccountItem
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(28.dp))
            .clickable { }
            .width(170.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        item.startColor,
                        item.endColor
                    )
                )
            )
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Top
        ) {
            // Visa Icon
            Icon(
                painter = painterResource(id = R.drawable.ic_visa_logo),
                contentDescription = item.title,
                modifier = Modifier.size(42.dp)
            )

            // Account Name
            Text(
                text = item.title,
                style = TextStyle(
                    color = TextOnColor,
                    fontFamily = FontFamily(
                        Font(R.font.poppins_med)
                    ),
                    fontSize = 16.sp
                )
            )

            // Account Balance
            Text(
                text = item.balance,
                style = TextStyle(
                    color = TextOnColor,
                    fontFamily = FontFamily(
                        Font(R.font.poppins_semibold)
                    ),
                    fontSize = 28.sp
                ),
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Account Last 4 Digits
            Text(
                text = "···· ${item.acctLastFourDigits}",
                style = TextStyle(
                    color = TextOnColor,
                    fontFamily = FontFamily(
                        Font(R.font.poppins_med)
                    ),
                    fontSize = 14.sp
                )
            )
        }
    }
}

@Composable
fun FinanceSection(
    financeItems: List<FinanceItem>
) {
    Column {
        Text(
            text = "Finance",
            style = TextStyle(
                fontFamily = FontFamily(
                    Font(R.font.poppins_med)
                ),
                color = Color.White,
                fontSize = 30.sp
            ),
            modifier = Modifier.padding(start = 16.dp, top = 32.dp)
        )
    }

    LazyRow(
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 8.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(financeItems) { _, item ->
            FinanceItem(item = item)
        }
    }
}

@Composable
fun FinanceItem(
    item: FinanceItem
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(40.dp))
            .size(
                width = 130.dp,
                height = 130.dp
            )
            .background(Gray)
            .clickable { }
            .padding(top = 8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(36.dp)
                    .background(item.color)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        tint = Color.White
                    )
                }
            }
            Text(
                text = "${item.title.split(" ").first()}\n${item.title.split(" ")[1]}",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 15.sp
                ),
                fontFamily = FontFamily(
                    Font(R.font.poppins_reg)
                )
            )
        }
    }
}

@Composable
fun CurrenciesSection() {
    Box(
        modifier = Modifier
            .padding(top = 48.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .height(350.dp)
            .background(Gray)
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Currencies",
                    style = TextStyle(
                        fontFamily = FontFamily(
                            Font(R.font.poppins_med)
                        ),
                        color = Color.White,
                        fontSize = 30.sp
                    )
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Gray)
                        .clickable { }
                        .padding(4.dp)
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
            CurrenciesBox(
                modifier = Modifier
                    .padding(
                        horizontal = 12.dp,
                        vertical = 12.dp
                    )
            )
        }
    }
}

@Composable
fun CurrenciesBox(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(DarkGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Currencies",
                        style = TextStyle(
                            color = LightGray,
                            fontSize = 14.sp
                        ),
                        fontFamily = FontFamily(
                            listOf(
                                Font(R.font.poppins_semibold)
                            )
                        )
                    )

                    BoldListText(text = "USD")
                    BoldListText(text = "EUR")
                    BoldListText(text = "YEN")
                }
            }

            Column(
                modifier = Modifier.padding(start = 50.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Buy",
                    style = TextStyle(
                        color = LightGray,
                        fontSize = 14.sp
                    ),
                    fontFamily = FontFamily(
                        listOf(
                            Font(R.font.poppins_semibold)
                        )
                    )
                )

                BoldListText(text = "$ 27.43")
                BoldListText(text = "$ 33.34")
                BoldListText(text = "$ 0.25")
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Sell",
                    style = TextStyle(
                        color = LightGray,
                        fontSize = 14.sp
                    ),
                    fontFamily = FontFamily(
                        listOf(
                            Font(R.font.poppins_semibold)
                        )
                    )
                )

                BoldListText(text = "$ 27.60")
                BoldListText(text = "$ 33.70")
                BoldListText(text = "$ 0.27")
            }
        }
    }
}

@Composable
fun BoldListText(
    text: String
) {
    Text(
        text = text,
        style = TextStyle(
            color = Color.White,
            fontSize = 18.sp
        ),
        fontFamily = FontFamily(
            listOf(
                Font(R.font.poppins_med)
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BankingUiAppTheme {
        Build(HomeScreenViewModel())
    }
}