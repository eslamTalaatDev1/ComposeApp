package com.compose_test

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.compose_test.ui.widgets.CustomTopBar

var cvv by mutableStateOf("")
var expireDate by mutableStateOf("")
var billName by mutableStateOf("")
@Composable
fun BillsConfirmation(navController: NavController) {

    val isFavoriteCheck = remember { mutableStateOf(false) }
    val isAutoPayCheck = remember { mutableStateOf(false) }
    val isNotifyCheck = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CustomTopBar(
                navController,
                topBarText = R.string.mobile,
                isSearchBarEnabled = false
            )

         }, content = {

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

                Summary()

                CardDetails()

                BankCardDeta()

                BillsOptions(isFavoriteCheck, isAutoPayCheck, isNotifyCheck)

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
                        .height(dimensionResource(id = com.intuit.sdp.R.dimen._45sdp)),
                    onClick = {
                        navController.navigate(Screens.ReceiptScreen.route)
                    }) {

                    CustomText(text = "Confirm", textColor =R.color.white)
                }

                Spacer(
                    modifier = Modifier

                        .padding(vertical = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))
                )


            }
        })
}


@Composable
fun Summary() {
    CustomText(
        text = stringResource(id = R.string.bill_summary),
        textColor = R.color.black,
        textSize = com.intuit.sdp.R.dimen._13sdp
    )

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(top = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp)),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CustomText(
            text = "Services",
            textColor = R.color.light_grey,
            isBold = true,
            textSize = com.intuit.sdp.R.dimen._12sdp
        )
        CustomText(
            text = "Vodafone Bills",
            textColor =  R.color.black,
            isBold = true,
            textSize = com.intuit.sdp.R.dimen._12sdp
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(top = dimensionResource(id = com.intuit.sdp.R.dimen._3sdp)),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CustomText(
            text = "Mobile Number",
            textColor = R.color.light_grey,
            isBold = true,
            textSize = com.intuit.sdp.R.dimen._12sdp
        )
        CustomText(
            text = "01117210472",
            textColor = R.color.black,
            isBold = true,
            textSize = com.intuit.sdp.R.dimen._12sdp
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(top = dimensionResource(id = com.intuit.sdp.R.dimen._3sdp)),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CustomText(
            text = "Amount",
            textColor = R.color.light_grey,
            isBold = true,
            textSize = com.intuit.sdp.R.dimen._12sdp
        )
        CustomText(
            text = "30 EGP",
            textColor = R.color.black,
            isBold = true,
            textSize = com.intuit.sdp.R.dimen._12sdp
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(top = dimensionResource(id = com.intuit.sdp.R.dimen._3sdp)),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CustomText(
            text = "Services Fees",
            textColor = R.color.light_grey,
            isBold = true,
            textSize = com.intuit.sdp.R.dimen._12sdp
        )
        CustomText(
            text = "30 EGP",
            textColor = R.color.black,
            isBold = true,
            textSize = com.intuit.sdp.R.dimen._12sdp
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(top = dimensionResource(id = com.intuit.sdp.R.dimen._3sdp), bottom = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp)),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CustomText(
            text = "Total Amount",
            textColor =  R.color.light_grey,
            isBold = true,
            textSize = com.intuit.sdp.R.dimen._12sdp
        )
        CustomText(
            text = "123 EGP",
            textColor = R.color.black,
            isBold = true,
            textSize = com.intuit.sdp.R.dimen._12sdp
        )
    }
}

@Composable
fun CardDetails() {
    CustomText(
        text = "Payment Method",
        textColor = R.color.black,
        textSize = com.intuit.sdp.R.dimen._13sdp,
        paddingBottom = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp)
     )
    var listData = listOf(
        CardsData(
            "Yalla Card (Visa **** 1362)",
            R.drawable.ic_visa_logo
        ),
        CardsData(
            "Bank Card (Visa **** 3678)",
            R.drawable.ic_visa_logo
        ),
    )

    Spinner(
        listData,
        preselected = listData.first(),
        onSelectionChanged = {},
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun Spinner(
    list: List<CardsData>,
    preselected: CardsData,
    onSelectionChanged: (myData: CardsData) -> Unit,
    modifier: Modifier = Modifier
) {

    var selected by remember { mutableStateOf(preselected) }
    var expanded by remember { mutableStateOf(false) } // initial value

    Card(
         shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp)),
        border = BorderStroke(0.dp, color = colorResource(id =R.color.spinner_background )),
        backgroundColor = colorResource(id = R.color.spinner_background),
        modifier = modifier
            .clickable {
                expanded = !expanded
            }
            .height(dimensionResource(id = com.intuit.sdp.R.dimen._40sdp))
    ) {


        Row(
            modifier = Modifier.padding(horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painterResource(selected.imageUrl),
                contentDescription = "",
                 modifier = Modifier
                     .width(dimensionResource(id = com.intuit.sdp.R.dimen._38sdp))
                     .height(dimensionResource(id = com.intuit.sdp.R.dimen._35sdp))
                     .wrapContentHeight()
            )
            CustomText(
                text = selected.text,
                paddingLeft = dimensionResource(id = com.intuit.sdp.R.dimen._14sdp), paddingRight = dimensionResource(id = com.intuit.sdp.R.dimen._14sdp), paddingTop = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp), paddingBottom = dimensionResource(id = com.intuit.sdp.R.dimen._6sdp),
            )
            Icon(Icons.Outlined.ArrowDropDown, null, modifier = Modifier.padding(dimensionResource(id = com.intuit.sdp.R.dimen._6sdp)))

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width((LocalConfiguration.current.screenWidthDp.dp)- dimensionResource(
                    id = com.intuit.sdp.R.dimen._45sdp
                ))
            ) {
                list.forEach { listEntry ->

                    DropdownMenuItem(

                        onClick = {
                            selected = listEntry
                            expanded = false
                            onSelectionChanged(selected)
                        }
                    ){
                        Image(
                            painterResource(listEntry.imageUrl),
                            contentDescription = "",
                            modifier = Modifier
                                .width(dimensionResource(id = com.intuit.sdp.R.dimen._38sdp))
                                .height(dimensionResource(id = com.intuit.sdp.R.dimen._38sdp))
                                .absolutePadding(right = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))
                        )
                        CustomText(
                            text = listEntry.text
                        )


                    }
                }
            }

        }
    }
}

@Composable
fun BankCardDeta() {
    Row(

        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(top = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp)
                , bottom = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            CustomText(
                paddingBottom = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp),
                 text = "Expiry Date",
                textColor = R.color.black,
                textSize = com.intuit.sdp.R.dimen._13sdp
            )

            Card(
                backgroundColor = colorResource(id = R.color.spinner_background),
                elevation = 0.dp,
                shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp)),
                modifier = Modifier
                    .height(dimensionResource(id = com.intuit.sdp.R.dimen._37sdp))
                    .width(dimensionResource(id = com.intuit.sdp.R.dimen._120sdp))
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,


                    ) {
                    Image(
                        painterResource(R.drawable.bills_expiry_date),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                            .height(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                            .wrapContentHeight()
                    )

                    TextField(
                        expireDate,
                        onValueChange = {
                            expireDate = it
                        },

                        placeholder = {
                            CustomText(
                                text = "MM/YY",
                                textAlign = TextAlign.Center,
                                textSize = com.intuit.sdp.R.dimen._10sdp,
                                textColor = R.color.light_grey
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Gray,
                            backgroundColor = Color.Transparent,
                            disabledTextColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                        textStyle = LocalTextStyle.current.copy(
                            textAlign = TextAlign.Center
                        ),


                        )


                }
            }
        }
        Column {
            CustomText(
                paddingBottom = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp),
                 text = "Cvv",
                textColor =R.color.black,
                textSize = com.intuit.sdp.R.dimen._13sdp
            )

            Card(
                backgroundColor = colorResource(id = R.color.spinner_background),
                elevation = 0.dp,
                shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp)),
                modifier = Modifier
                    .height(dimensionResource(id = com.intuit.sdp.R.dimen._38sdp))
                    .width(dimensionResource(id = com.intuit.sdp.R.dimen._120sdp))
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,


                    ) {
                    Image(
                        painterResource(R.drawable.bills_cvv),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                            .height(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                            .wrapContentHeight()
                    )

                    TextField(
                        cvv,
                        onValueChange = {
                            cvv = it
                        },

                        placeholder = {
                            CustomText(
                                text = "000",
                                textAlign = TextAlign.Center,
                                textSize = com.intuit.sdp.R.dimen._10sdp,
                                textColor = R.color.light_grey
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Gray,
                            backgroundColor = Color.Transparent,
                            disabledTextColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                        textStyle = LocalTextStyle.current.copy(
                            textAlign = TextAlign.Center
                        ),


                        )


                }
            }
        }


    }
}

@Composable
fun BillsOptions(
    isFavoriteCheck: MutableState<Boolean>,
    isAutoPayCheck: MutableState<Boolean>,
    isNotifyCheck: MutableState<Boolean>
) {

    SingleCheckBox(isFavoriteCheck, "Add To Favorites")
    SingleCheckBox(isAutoPayCheck, "Auto Pay")
    SingleCheckBox(isNotifyCheck, "Notify")
}

@Composable
fun SingleCheckBox(isCheck: MutableState<Boolean>, text: String) {
    Column() {
        Row(modifier = Modifier.absolutePadding(bottom = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))) {
            Card(
                modifier = Modifier.background(Color.White),
                elevation = 0.dp,
                shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._4sdp)),
                border = BorderStroke(1.5.dp, color = colorResource(id = R.color.bills_color))
            ) {
                Box(
                    modifier = Modifier
                        .size(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                        .background(if (isCheck.value) colorResource(id = R.color.bills_color) else Color.White)
                        .clickable {
                            isCheck.value = !isCheck.value
                        },
                    contentAlignment = Center
                ) {
                    if (isCheck.value)
                        Icon(
                            Icons.Default.Check,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier
                                .width(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                                .height(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                        )
                }
            }

            CustomText(

               paddingRight = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp),
                paddingLeft = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp),
                text = text,
                textColor = R.color.textColorBlack,

                textSize =com.intuit.sdp.R.dimen._12sdp,
                isBold = true
             )
        }
        if (text == "Add To Favorites" && isCheck.value)
            FavoriteBox()
    }
}

@Composable
fun FavoriteBox() {
    Card(
        backgroundColor = colorResource(id = R.color.spinner_background),

        elevation = 0.dp,
        shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp)),
        modifier = Modifier
            .height(dimensionResource(id = com.intuit.sdp.R.dimen._57sdp))
            .fillMaxWidth()
            .absolutePadding(bottom = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,


            ) {
            Image(
                painterResource(R.drawable.bills_expiry_date),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                    .height(dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                    .wrapContentHeight()
            )

            TextField(
                billName,
                onValueChange = {
                    billName = it
                },

                placeholder = {
                    CustomText(
                        text = "Bill Name",
                        textAlign = TextAlign.Start,
                        textSize = com.intuit.sdp.R.dimen._10sdp,
                        textColor = R.color.light_grey
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Gray,
                    backgroundColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center
                ),


                )


        }
    }
}

class CardsData(
    var text: String,
    var imageUrl: Int
)

//@Preview(showBackground = true)
//@Composable
//fun ConfirmationPreview() {
//    BillsConfirmation()
//}