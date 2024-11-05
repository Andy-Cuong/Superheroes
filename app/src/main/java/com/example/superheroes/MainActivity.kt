package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.HeroesRepo
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                Scaffold(
                    topBar = { HeroTopAppBar(modifier = Modifier.fillMaxWidth()) }
                ) { innerPadding ->
                    HeroList(HeroesRepo.heroes, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HeroTopAppBar(modifier: Modifier = Modifier) {
    Surface(
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp),
                )
            }

            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}

@Composable
@Preview
fun HeroAppPrev() {
    SuperheroesTheme {
        Scaffold(
            topBar = { HeroTopAppBar(modifier = Modifier.fillMaxWidth()) }
        ) { innerPadding ->
            HeroList(HeroesRepo.heroes, modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
@Preview
fun HeroAppDarkThemePrev() {
    SuperheroesTheme(darkTheme = true) {
        Scaffold(
            topBar = { HeroTopAppBar(modifier = Modifier.fillMaxWidth()) }
        ) { innerPadding ->
            HeroList(HeroesRepo.heroes, modifier = Modifier.padding(innerPadding))
        }
    }
}