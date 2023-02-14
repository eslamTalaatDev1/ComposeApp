package com.compose_test.ui.widgets
import androidx.compose.foundation.*

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.compose_test.R
import com.compose_test.Screens


@Composable
fun CustomTopBar(
    navController: NavController,
    @DimenRes boxHeight:Int?=com.intuit.sdp.R.dimen._60sdp,
    @DimenRes paddingHorizontal:Int?=com.intuit.sdp.R.dimen._5sdp,
    @DimenRes paddingVertical:Int?=com.intuit.sdp.R.dimen._5sdp,
    @ColorRes boxColor:Int?=R.color.bills_color,
    @ColorRes topBarTextColor:Int?=R.color.white,
    @DimenRes topBarTextSize:Int?=com.intuit.sdp.R.dimen._13sdp,
    isLeftImageEnabled:Boolean?=true,
     @DimenRes leftIconWeight:Int?=com.intuit.sdp.R.dimen._20sdp,
    @DimenRes leftIconHeight:Int?=com.intuit.sdp.R.dimen._20sdp,
    isRightImageEnabled:Boolean?=false,
     @DimenRes rightIconWeight:Int?=com.intuit.sdp.R.dimen._25sdp,
    @DimenRes rightIconHeight:Int?=com.intuit.sdp.R.dimen._25sdp,
     isSearchBarEnabled:Boolean?=false,
    @ColorRes textSearchColor:Int?=R.color.hint_color,
     @DrawableRes rightImage:Int?= R.drawable.white_setting_icon,
    @DrawableRes leftImage:Int?=R.drawable.left_arrow,
    @DrawableRes searchImage:Int?=R.drawable.ic_serach,
    @StringRes topBarText:Int,





    ){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = boxHeight!!))
            .background(color = colorResource(id = boxColor!!))
    ) {

        Column {
            if(isSearchBarEnabled!!.not())
            Spacer(modifier = Modifier.absolutePadding(top = 15.dp))


            Row(modifier = Modifier.padding(horizontal = dimensionResource(id = paddingHorizontal!!), vertical = dimensionResource(id = paddingVertical!!)).clickable {
                navController.navigateUp()
            }) {
                if(isLeftImageEnabled!!)
                IconButton(onClick = {navController.navigateUp() }) {

                    Image(
                        painter = painterResource(id = leftImage!!),
                        "contentDescription",
                        modifier = Modifier
                            .width(dimensionResource(id = leftIconWeight!!))
                            .height(dimensionResource(id = leftIconHeight!!)))


                }
                Text(
                    text = stringResource(id = topBarText),
                    Modifier
                        .weight(1f)
                        .height(40.dp)
                        .wrapContentHeight(),
                    color = colorResource(id = topBarTextColor!!),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = dimensionResource(id = topBarTextSize!!).value.sp
                )

                if(isRightImageEnabled!!)
                IconButton(onClick = { /* doSomething() */ }) {

                    Image(
                        painter = painterResource(id = rightImage!!),
                        "contentDescription",
                        modifier = Modifier
                            .width(dimensionResource(id = rightIconWeight!!))
                            .height(dimensionResource(id = rightIconHeight!!)))
                }
                else
                    Box(modifier = Modifier
                        .width(dimensionResource(id = rightIconWeight!!))
                        .height(dimensionResource(id = rightIconWeight!!)))
            }
            if(isSearchBarEnabled)
            Card(
                elevation = 5.dp,
                modifier  = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .height(45.dp).clickable { navController.navigate(Screens.SearchScreen.route) },
                border = BorderStroke(20.dp, Color.Transparent),
                backgroundColor = Color.White){

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = 10.dp)
                ) {
                    Text(text = "Search", modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                        .wrapContentHeight(),color= colorResource(
                        id = textSearchColor!!
                    )
                    )
                    IconButton(
                        onClick = { /* doSomething() */ }) {
                        Image(
                            painter = painterResource(id = searchImage!!),
                            "contentDescription",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp))
                    }

                }
            }


        }

    }
}