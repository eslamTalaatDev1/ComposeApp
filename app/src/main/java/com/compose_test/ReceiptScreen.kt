package com.compose_test

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
 import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.compose_test.ui.widgets.CustomTopBar

@Composable
fun ReceiptScreen(navController: NavController?=null) {
    Scaffold(
        topBar = {
            CustomTopBar(
                navController!!,
                topBarText = R.string.checkout
            )

         }, content = {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        color = colorResource(
                            id = R.color.background_color
                        )
                    )
            ) {


                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)

                ){

                    Image(
                        painterResource(R.drawable.receipt_background),
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth,
                         modifier = Modifier
                             .fillMaxWidth()

                             .absolutePadding(bottom = dimensionResource(id = com.intuit.sdp.R.dimen._80sdp))

                    )
                    Column(modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        Row( modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painterResource(R.drawable.vodafone_image),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(dimensionResource(id = com.intuit.sdp.R.dimen._95sdp))
                                    .height(dimensionResource(id = com.intuit.sdp.R.dimen._95sdp))
                            )
                            CustomText(text = "Vodafone", isBold = true)
                        }
                        CustomText(text = "Bill # 235124123", textColor = R.color.bills_color
                            , isBold = true, textAlign = TextAlign.Center, paddingBottom = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))

                        Image(
                            painterResource(R.drawable.diver),
                            contentScale= ContentScale.FillWidth,
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .absolutePadding(left = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp), right = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                        )

                        itemsRow("Services","Mobile Bill")
                        itemsRow("Payment Method","Yalla Card ( **** 1312)")
                        itemsRow("Date & Time","4 sep 22, 10:00:00")
                        itemsRow("Amount","1600 EGP")
                        itemsRow("Payou Fees","10 EGP")
                        itemsRow("Biller Fees","20 EGP")
                        itemsRow("Discount","-5 EGP")
                        itemsRow("Earned Points","150 EGP", topPadding = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp), bottomPadding = dimensionResource(id = com.intuit.sdp.R.dimen._13sdp))




                        Image(
                            painterResource(R.drawable.diver),
                            contentScale= ContentScale.FillWidth,
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .absolutePadding(left = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp), right = dimensionResource(id = com.intuit.sdp.R.dimen._18sdp))
                        )

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .absolutePadding(top = dimensionResource(id = com.intuit.sdp.R.dimen._13sdp)),
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            CustomText(text = "Total Amount", textColor = R.color.bills_color, isBold = true)
                            CustomText(text = "150 EGP", isBold = true, textColor = R.color.bills_color)

                        }

                        Spacer(modifier =Modifier.height(dimensionResource(id = com.intuit.sdp.R.dimen._60sdp)) )

                        Button(

                            border = BorderStroke(1.dp, colorResource(id = R.color.bills_color)),
                            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = colorResource(id = R.color.background_color)),
                            shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._7sdp)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(dimensionResource(id = com.intuit.sdp.R.dimen._40sdp)),
                            onClick = { /*TODO*/ }) {

                            CustomText(text = "Close", textColor = R.color.bills_color)
                        }

                    }

                }

                ReceiptBottomBar()
            }
        })
}

@Composable
fun itemsRow(text:String,value:String,topPadding:Dp?=10.dp,bottomPadding:Dp?=0.dp){
    Row(modifier = Modifier
        .fillMaxWidth()
        .absolutePadding(top = topPadding!!, bottom = bottomPadding!!),
        horizontalArrangement = Arrangement.SpaceBetween) {
        CustomText(text = text)
        CustomText(text = value, isBold = true)

    }
}

@Composable
fun ReceiptBottomBar(){
   Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
       .fillMaxWidth()
       .padding(horizontal = dimensionResource(id = com.intuit.sdp.R.dimen._3sdp), vertical = dimensionResource(id = com.intuit.sdp.R.dimen._3sdp))
       .background(
           color = colorResource(
               id = R.color.white
           )
       )
       .height(100.dp), verticalAlignment = Alignment.CenterVertically){
       singleBottomBarItem("Email",R.drawable.mail_bills)
       singleBottomBarItem("Invoice",R.drawable.invoice)
       singleBottomBarItem("Repeat",R.drawable.repeat)
       singleBottomBarItem("Split",R.drawable.splite)
       singleBottomBarItem("Instalment",R.drawable.instalment)
   }

}

@Composable
fun singleBottomBarItem(text:String,image:Int){
    Card(
        shape = RoundedCornerShape(dimensionResource(id = com.intuit.sdp.R.dimen._4sdp)),
        border = BorderStroke(0.dp, color = colorResource(id =R.color.white )),
        modifier = Modifier
            .width(dimensionResource(id = com.intuit.sdp.R.dimen._55sdp))
            .height(dimensionResource(id = com.intuit.sdp.R.dimen._55sdp))
            .clickable { }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Image(
                painterResource(image),
                contentScale= ContentScale.FillWidth,
                contentDescription = "",
                modifier = Modifier
                    .width(dimensionResource(id = com.intuit.sdp.R.dimen._27sdp))
                    .height(dimensionResource(id = com.intuit.sdp.R.dimen._27sdp))


            )

            CustomText(text = text, textSize = com.intuit.sdp.R.dimen._10sdp, paddingTop = dimensionResource(id = com.intuit.sdp.R.dimen._3sdp))

        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ReceiptScreen()
//}
