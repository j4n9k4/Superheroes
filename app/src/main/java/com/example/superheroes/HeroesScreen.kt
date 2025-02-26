package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
                .sizeIn(minHeight = 72.dp)
                .padding(16.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {
            HeroInformation(superhero.nameRes, superhero.descriptionRes, Modifier.weight(1f))
            Spacer(Modifier.width(16.dp))
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
    Column(
        modifier = modifier
    )
    {
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
    Box(
        modifier = modifier
            .height(72.dp)
            .clip(MaterialTheme.shapes.small)


    )
    {
        Image(
            painter = painterResource(heroImage),
            contentDescription = null,
            modifier = modifier

        )
    }
}
@Composable
fun SuperheroesList(
)
{
    LazyColumn {
        items(HeroesRepository.heroes){
            SuperheroListItem(
                it,
                Modifier
                    .padding(top = 8.dp,
                bottom = 8.dp,
                start = 16.dp,
                end = 16.dp))
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun SuperheroesAppPreview()
{
    SuperheroesTheme {
        SuperheroesList()
    }
}