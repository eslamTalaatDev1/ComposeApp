package com.compose_test.allbills

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.compose_test.CustomText
import com.compose_test.R
import com.compose_test.navigation.Screens
import com.compose_test.ui.widgets.CustomTopBar


@Composable
fun AllBills(navController: NavController) {
    Scaffold(
        topBar = {
            CustomTopBar(
               navController = navController,
                topBarText = R.string.billsText,
                isSearchBarEnabled = true,
                isRightImageEnabled = true,
                boxHeight = com.intuit.sdp.R.dimen._105sdp
             )
                 }, content = {
            var list=ArrayList<String>()
            for(i in 0 until 12){
                list.add("Mobile Bills")
            }
            AllBillsList(list,navController)

        })
}

@Composable
fun AllBillsList(data: List<String>,navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
         modifier = Modifier.fillMaxHeight(),
     ) {
        itemsIndexed(data) { index, item ->
            SingleBillItem( data[index],navController,index)
        }
    }
}
@Composable
fun SingleBillItem(item:String,navController: NavController,index:Int) {
    Card(
        elevation = dimensionResource(id = com.intuit.sdp.R.dimen._2sdp),
        modifier  = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = com.intuit.sdp.R.dimen._120sdp))
            .padding(
                horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._3sdp),
                vertical = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp)
            )
            .clickable {
                if (index == 11) {
                    navController.navigate(Screens.InternationalBillsScreen.route)

                } else {
                    navController.navigate(Screens.SelectedBillActivity.route)

                }
            },
         backgroundColor = Color.White){

        Column(

            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
             verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.mobile), contentDescription ="",
            modifier = Modifier
                .width(dimensionResource(id = com.intuit.sdp.R.dimen._30sdp))
                .height(dimensionResource(id = com.intuit.sdp.R.dimen._30sdp)),
            contentScale = ContentScale.Fit)
            CustomText(text = item, textColor = R.color.bills_color, textAlign = TextAlign.Center
            , paddingTop = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))

        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun AllBillsPreview() {
//    Compose_testTheme {
//        MainActivity()
//    }
//}