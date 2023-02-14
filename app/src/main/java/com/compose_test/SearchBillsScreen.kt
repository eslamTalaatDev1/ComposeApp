package com.compose_test

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.compose_test.ui.theme.Compose_testTheme
import com.compose_test.ui.widgets.CustomTopBar



@Composable
fun SearchScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CustomTopBar(
                navController,
                topBarText = R.string.search_result,
                isSearchBarEnabled = true,
                boxHeight = com.intuit.sdp.R.dimen._105sdp
            )
        }, content = {
                Column(modifier = Modifier.padding(horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp), vertical = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))) {
                    CustomText(text = "4 Result Found", textColor = R.color.bills_color, paddingBottom = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp), textAlign = TextAlign.Start)
                    SearchList()
                }

        })
}


@Composable
fun SearchList(){
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),

        modifier = Modifier
            .fillMaxHeight()
     ) {

        items(4) { item ->
            SingleSearchList( )
        }
    }
}

@Composable
fun SingleSearchList(){

    Card(
        elevation = 0.dp,
        shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._5sdp)),
        border = BorderStroke(0.dp, color = colorResource(id =R.color.spinner_background )),
        backgroundColor = colorResource(id = R.color.spinner_background),
        modifier = Modifier
            .absolutePadding(top = dimensionResource(id = com.intuit.sdp.R.dimen._5sdp))
            .height(dimensionResource(id = com.intuit.sdp.R.dimen._45sdp))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
           CustomText(text = "Mobile Bills", paddingRight = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp), paddingLeft = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))
            Image(
                contentScale = ContentScale.FillWidth,
                painter = painterResource(R.drawable.arrow_right),
                contentDescription = "",
                modifier = Modifier
                    .width(dimensionResource(id = com.intuit.sdp.R.dimen._20sdp))
                    .height(dimensionResource(id = com.intuit.sdp.R.dimen._20sdp))
            )
            CustomText(text = "Vodafone", isBold = true, paddingLeft = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp), paddingRight = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))
        }
        
    }
}



//@Preview(showBackground = true)
//@Composable
//fun Preview() {
//         SearchScreen()
// }