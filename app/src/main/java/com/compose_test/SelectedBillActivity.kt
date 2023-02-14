package com.compose_test

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.compose_test.ui.widgets.CustomTopBar


var providerSelected by mutableStateOf(0)
var mobile_number by mutableStateOf("")


@Composable
fun SelectedBillActivity(navController: NavController) {
    Scaffold(
        topBar = {
            CustomTopBar(
                navController,
                topBarText = R.string.mobile,
                isRightImageEnabled = false
             ) }, content = {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .absolutePadding(
                        right = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp),
                        top = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp),
                        left = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp)
                    )
            ) {
                CustomText(
                    text = "Provider",
                    textColor = R.color.textColorBlack,
                    textSize = com.intuit.sdp.R.dimen._14sdp
                )
                AllProviderList(
                    providers()
                )

                CustomText(text = "Service")




                LazyVerticalGrid(
                    modifier = Modifier.absolutePadding(bottom = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp)),
                    columns = GridCells.Fixed(1),
                ) {

                    items(1) { item ->
                        SpinnerSample(
                            services(),
                            preselected = services().first(),
                            onSelectionChanged = {

                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }



                CustomText(text = "Mobile Number", paddingBottom = dimensionResource(id = com.intuit.sdp.R.dimen._3sdp))


                Card(
                    backgroundColor = colorResource(id = R.color.spinner_background),
                    shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp)),
                    modifier = Modifier
                        .height(dimensionResource(id = com.intuit.sdp.R.dimen._40sdp))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp)),
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Image(
                            painterResource(R.drawable.mobile),
                            contentDescription = "",
                            modifier = Modifier
                                .width(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                                .height(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                                .wrapContentHeight()
                        )
                        TextField(
                            "",
                            onValueChange = {
                                mobile_number=it
                            },
                            placeholder = {
                                CustomText("Mobile Number", textColor = R.color.light_grey, textSize = com.intuit.sdp.R.dimen._10sdp)
                            },

                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Gray,
                                backgroundColor = Color.Transparent,
                                disabledTextColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ), modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                        )

                        Image(
                            painterResource(R.drawable.contacts),
                            contentDescription = "",
                            modifier = Modifier
                                .width(dimensionResource(id = com.intuit.sdp.R.dimen._33sdp))
                                .height(dimensionResource(id = com.intuit.sdp.R.dimen._33sdp))
                                .wrapContentHeight()
                        )

                    }
                }
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))
                )
                Button(

                    border = BorderStroke(1.dp, colorResource(id = R.color.bills_color)),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = colorResource(id = R.color.bills_color)),
                    shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._8sdp)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = com.intuit.sdp.R.dimen._48sdp)),
                    onClick = {
                        navController.navigate(Screens.BillsConfirmation.route)
                    }) {

                    Text(text = "Next", color = Color.White)
                }

                Spacer(
                    modifier = Modifier

                        .padding(vertical = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))
                )


            }
        })
}

fun providers():ArrayList<ProviderModel>{
   return ArrayList(listOf(
        ProviderModel(
            isSelected = false,
            imageUrl = "https://www.freepnglogos.com/uploads/vodafone-png-logo/vodafone-logo-clarify-business-development-16.png"
        ),
        ProviderModel(
            isSelected = false,
            imageUrl = "https://www.etisalat.eg/StaticFiles/portal/etisalat/images/logo/ET_Logo.png"
        ),
        ProviderModel(
            isSelected = false,
            imageUrl = "http://te.eg/images/TE-Logo.jpg"
        ),
        ProviderModel(
            isSelected = false,
            imageUrl = "https://www.orange.eg/en/PublishingImages/Carousel%20(Homepage)%20825x340%20En.jpg"
        ),
    ))
}
fun services():ArrayList<ServiceModel>{
   return ArrayList(listOf(
       ServiceModel(
           "service1",
           R.drawable.vodafone_image,
           false,
           "mobile"
       ),
       ServiceModel(
           "service2",
           R.drawable.vodafone_image,
           false,
           "amount"
       ),
       ServiceModel(
           "service3",
           R.drawable.vodafone_image,
           false,
           "mobile"
       ),
       ServiceModel(
           "service4",
           R.drawable.vodafone_image,
           true,
           ""
       ),
       ServiceModel(
           "service5",
           R.drawable.vodafone_image,
           false,
           "amount"
       )
   ))
}
@Composable
fun SpinnerSample(
    list: List<ServiceModel>,
    preselected: ServiceModel,
    onSelectionChanged: (myData: ServiceModel) -> Unit,
    modifier: Modifier = Modifier
) {

    var selected by remember { mutableStateOf(preselected) }
    var expanded by remember { mutableStateOf(false) } // initial value

    Card(
        shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp)),
        border = BorderStroke(0.dp, color = colorResource(id = R.color.spinner_background)),
        backgroundColor = colorResource(id = R.color.spinner_background),
        modifier = modifier
            .clickable {
                expanded = !expanded
            }
            .absolutePadding(bottom = dimensionResource(id = com.intuit.sdp.R.dimen._1sdp))
            .height(dimensionResource(id = com.intuit.sdp.R.dimen._40sdp))
    ) {


        Row(
            modifier = Modifier.padding(horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painterResource(R.drawable.vodafone_image),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                    .height(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                    .wrapContentHeight()
            )
            Text(
                text = selected.text,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._14sdp), vertical = dimensionResource(id = com.intuit.sdp.R.dimen._6sdp))
            )
            Icon(Icons.Outlined.ArrowDropDown, null, modifier = Modifier.padding(dimensionResource(id = com.intuit.sdp.R.dimen._6sdp)))

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width((LocalConfiguration.current.screenWidthDp.dp)- dimensionResource(
                    id = com.intuit.sdp.R.dimen._45sdp
                ))  // delete this modifier and use .wrapContentWidth() if you would like to wrap the dropdown menu around the content
            ) {
                list.forEach { listEntry ->

                    DropdownMenuItem(
                        onClick = {
                            selected = listEntry
                            expanded = false
                            onSelectionChanged(selected)
                        }
                    ) {
                        Image(
                            painterResource(listEntry.imageUrl),
                            contentDescription = "",
                             modifier = Modifier
                                 .width(dimensionResource(id = com.intuit.sdp.R.dimen._28sdp))
                                 .height(dimensionResource(id = com.intuit.sdp.R.dimen._28sdp))
                        )
                        Text(
                            text = listEntry.text
                        )


                    }
                }
            }

        }
    }
}

@Composable
fun AllProviderList(data: List<ProviderModel>) {
    LazyRow() {
        itemsIndexed(data) { index, item ->
            SingleProvider(item, index)
        }

    }
}

@Composable
fun SingleProvider(item: ProviderModel, index: Int) {

    Card(
        shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._8sdp)),
        elevation = 0.dp,
        modifier = Modifier
            .width(dimensionResource(id = com.intuit.sdp.R.dimen._138sdp))
            .height(dimensionResource(id = com.intuit.sdp.R.dimen._120sdp))
            .padding(horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._3sdp), vertical = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))
            .clickable {
                providerSelected = index
            },
        border = BorderStroke(
            1.dp,
            if (providerSelected == index) colorResource(id = R.color.bills_color) else Color.Transparent
        ),
        backgroundColor = Color.White
    ) {

        Column(

            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.vodafone_image),
                "contentDescription",
            )


        }
    }
}

class ProviderModel(
    var isSelected: Boolean? = false,
    var imageUrl: String
)


class ServiceModel(
    var text: String,
    var imageUrl: Int,
    var isAntherServices: Boolean? = false,
    var type: String
)

//@Preview(showBackground = true)
//@Composable
//fun SelectedPreview() {
//    ScaffoldWithTopBar()
//}
