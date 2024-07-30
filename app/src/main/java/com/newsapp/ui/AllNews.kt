package com.newsapp.ui

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.newsapp.R
import com.newsapp.navigation.Screens
import com.newsapp.ui.components.Loader
import com.newsapp.viewmodels.NewsViewModel
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AllNews(navController: NavHostController) {
    val newsViewModel: NewsViewModel = viewModel()


    fun onNewsClick(){
        navController.navigate(Screens.NewsDetailsScreen.name)
    }
    if(newsViewModel.gettingAllNews) {
        Loader()
        return
    }
    Column(modifier = Modifier
        .padding(horizontal = 16.dp)
        .fillMaxWidth()) {

        Column(modifier = Modifier.padding(bottom = 20.dp, top = 20.dp)) {
            Text(text = "Top News", fontWeight = FontWeight.Bold, fontSize = MaterialTheme.typography.titleLarge.fontSize)
            HorizontalDivider(thickness = 1.dp, modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp))
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(newsViewModel.allArticles) { article ->
                if(article.urlToImage != null) {

                    val date = OffsetDateTime.parse(article.publishedAt, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                    val formatDate = date.format(DateTimeFormatter.ofPattern("dd LLLL yyyy")).toString()
                    NewsCard(title = article.title, dateTime = formatDate, url = article.urlToImage,
                         onClick = { onNewsClick() }, category = article.source.name)
                }
            }

        }

    }
}