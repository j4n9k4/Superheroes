package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.HeroesRepository
import com.example.superheroes.model.Hero
import com.example.superheroes.ui.theme.SuperheroesTheme

@Composable
fun SuperheroListItem(
    superhero: Hero,
    modifier: Modifier = Modifier
)
{
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp)
    ){
        Row(
            modifier = Modifier
                .height(72.dp)
                .padding(16.dp)
        ) {
            HeroInformation(superhero.nameRes, superhero.descriptionRes)
            HeroImage(superhero.imageRes)
        }
    }
}

@Composable
fun HeroInformation(
    @StringRes heroName: Int,
    @StringRes heroDescription: Int,
    modifier: Modifier = Modifier
)
{
    Column {
        Text(
            text = stringResource(heroName)
        )
        Text(
            text = stringResource(heroDescription)
        )
    }
}
@Composable
fun HeroImage(
    @DrawableRes heroImage: Int,
    modifier: Modifier = Modifier
)
{
    Image(
        painter = painterResource(heroImage),
        contentDescription = null
    )
}

@Preview
@Composable
fun SuperheroesAppPreview()
{
    SuperheroesTheme {
        SuperheroListItem(HeroesRepository.heroes[0])
    }
}