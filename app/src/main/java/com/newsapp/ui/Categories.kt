package com.newsapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.newsapp.R
import com.newsapp.navigation.Screens

@Composable
fun Categories(navController: NavHostController) {
    fun onNewsClick(){
        navController.navigate(Screens.NewsDetailsScreen.name)
    }
    Column(modifier = Modifier
        .padding(horizontal = 16.dp)
        .fillMaxWidth()) {

        Column(modifier = Modifier.padding(bottom = 20.dp, top = 20.dp)) {
            Text(text = "Health News", fontWeight = FontWeight.Bold, fontSize = MaterialTheme.typography.titleLarge.fontSize)
            HorizontalDivider(thickness = 1.dp, modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp))
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
        ) {
            item {
//                NewsCard(title = "News article", dateTime = "4 hours ago",
//                    image = painterResource(id = R.drawable.news1), onClick = { onNewsClick() })
//                NewsCard(title = "News article 2", dateTime = "20 hours ago",
//                    image = painterResource(id = R.drawable.news3), onClick = { onNewsClick() })
            }
        }

    }
}