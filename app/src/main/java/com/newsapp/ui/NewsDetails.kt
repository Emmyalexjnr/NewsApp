package com.newsapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.newsapp.R

@Composable
fun NewsDetails(navController: NavHostController) {
    val image = painterResource(id = R.drawable.news1)
    val description =
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop " +
                "publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Arrow back",
                modifier = Modifier.size(30.dp)
            )
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = "Share icon",
                modifier = Modifier.size(30.dp)
            )
        }
        HorizontalDivider(thickness = 1.dp)
        Column(modifier = Modifier.padding(20.dp, 10.dp)) {
            Text(
                text = "What is Lorem Ipsum?",
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp)
            )
            Text("By Time Baker, Political reporter", fontSize = 15.sp)
            Text(text = "Sunday 07, July 2024 14:20", fontSize = 15.sp, color = Color.Gray)
        }

        Column {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp, 0.dp, 0.dp)
                    .height(280.dp),
                painter = image,
                contentDescription = "News one",
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier
                    .padding(16.dp, 12.dp, 16.dp, 0.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(color = Color.LightGray)
            ) {
                Text(text = "Health", modifier = Modifier.padding(20.dp, 10.dp))
            }
            Column(modifier = Modifier.padding(16.dp, 10.dp)) {
                Text(text = description)
            }


        }
    }
}