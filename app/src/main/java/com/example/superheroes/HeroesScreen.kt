package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
        modifier = modifier
            .clip(MaterialTheme.shapes.medium),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(74.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {
            HeroInformation(superhero.nameRes, superhero.descriptionRes, Modifier.padding(16.dp))
            Spacer(modifier = Modifier.weight(1F))
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
    Column(modifier = modifier) {
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(heroDescription),
            style = MaterialTheme.typography.bodyLarge
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
        contentDescription = null,
        modifier = modifier
            .padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
            .clip(MaterialTheme.shapes.small)
    )
}

@Preview(showSystemUi = false)
@Composable
fun SuperheroesAppPreview()
{
    SuperheroesTheme {
        SuperheroListItem(HeroesRepository.heroes[0])
    }
}