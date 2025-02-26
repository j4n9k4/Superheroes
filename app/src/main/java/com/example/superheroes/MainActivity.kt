package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                SuperheroApp()
            }
        }
    }
}
@Composable
fun SuperheroApp()
{
    Scaffold(
        topBar = { TopAppBar() },
        modifier = Modifier.fillMaxSize()

    ) { padding ->
        SuperheroesList(padding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar()
{
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}

@Preview
@Composable
fun SuperheroAppPreview()
{
    SuperheroesTheme {
        SuperheroApp()
    }
}
