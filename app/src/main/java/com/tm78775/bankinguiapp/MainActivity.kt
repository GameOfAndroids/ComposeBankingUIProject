package com.tm78775.bankinguiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tm78775.bankinguiapp.ui.HomeScreen
import com.tm78775.bankinguiapp.ui.HomeScreenViewModel
import com.tm78775.bankinguiapp.ui.theme.BankingUiAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<HomeScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingUiAppTheme {
                Build(viewModel)
            }
        }
    }
}



@Composable
fun Build(viewModel: HomeScreenViewModel) {
    Scaffold {
        Surface(color = MaterialTheme.colors.background) {
            HomeScreen(viewModel = viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BankingUiAppTheme {
        Build(HomeScreenViewModel())
    }
}