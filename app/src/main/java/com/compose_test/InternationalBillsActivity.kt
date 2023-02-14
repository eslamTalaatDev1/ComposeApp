package com.compose_test

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
 import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.compose_test.ui.widgets.CustomTopBar

var icCountryChecked by mutableStateOf(0)


@Composable
fun InternationalBillsScreen(navController:NavController) {

    Scaffold(
        topBar = {
            CustomTopBar(
                navController,
                 topBarText = R.string.international,
                   isRightImageEnabled = false,

            )
        }, content = {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .absolutePadding(right =dimensionResource(id = com.intuit.sdp.R.dimen._18sdp), top = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp), left = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
            ) {

                CustomText("Select Country", isBold = true, paddingBottom = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                CountriesList(
                    list(),
                    navController
                )
                Spacer(modifier = Modifier
                    .weight(1f)
                    .padding(vertical = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp)))
                Button(

                    border = BorderStroke(1.dp, colorResource(id = R.color.bills_color)),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = colorResource(id = R.color.bills_color)),
                    shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._8sdp)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = com.intuit.sdp.R.dimen._45sdp)),
                    onClick = {navController.navigate(Screens.SelectedBillActivity.route)}) {

                    CustomText(text = "Next", textColor = R.color.white)
                }

                Spacer(modifier = Modifier

                    .padding(vertical = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp)))


            }
        })
}

fun list():ArrayList<CountryModel>{
    return ArrayList(listOf(
        CountryModel(
            "Egypt",
            R.drawable.ic_visa_logo
        ),
        CountryModel(
            "Dubai",
            R.drawable.ic_visa_logo,
            isSelect = true
        ),
        CountryModel(
            "Pakistan",
            R.drawable.ic_visa_logo
        ),
        CountryModel(
            "Saudi Arabia",
            R.drawable.ic_visa_logo
        )
    ))
}
@Composable
fun CountriesList(list: List<CountryModel>,navController: NavController) {
    LazyVerticalGrid(

        columns = GridCells.Fixed(1),

        modifier = Modifier.height(dimensionResource(id = com.intuit.sdp.R.dimen._200sdp)),
    ) {
        itemsIndexed(list) { index, item ->
            SingleItem( list[index],index,navController)
        }
    }
}

@Composable
fun SingleItem(item: CountryModel,index:Int,navController: NavController) {

    Box(
        modifier = Modifier
            .clickable {
                icCountryChecked=index
             }
            .padding(vertical = dimensionResource(id = com.intuit.sdp.R.dimen._3sdp))

            .background(shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp)), color = Color.Transparent)
            .border(
                border = BorderStroke(
                    1.dp,
                    colorResource(id = if (icCountryChecked==index) R.color.bills_color else R.color.white)
                )
            )


    ) {
        Row(
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(item.image),
                contentDescription = "",
                modifier = Modifier
                    .width(dimensionResource(id = com.intuit.sdp.R.dimen._35sdp))
                    .height(dimensionResource(id = com.intuit.sdp.R.dimen._35sdp))
            )

            CustomText(text = item.name, paddingLeft = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp), paddingRight = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .absolutePadding(left = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp), right = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))
            )
            if(icCountryChecked==index)
            Icon(
                Icons.Default.Check,
                contentDescription = "",
                tint = colorResource(id = R.color.bills_color),
                modifier = Modifier
                    .width(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                    .height(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
            )

        }
    }
}

class CountryModel(
    var name: String,
    var image: Int,
    var isSelect:Boolean?=false
)

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    InternationalBillsScreen()
//}
