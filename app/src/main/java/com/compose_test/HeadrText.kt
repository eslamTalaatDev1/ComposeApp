package com.compose_test

import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomText(text:String,isBold:Boolean?=false,paddingTop: Dp?=null,paddingBottom: Dp?=null,paddingRight: Dp?=null,paddingLeft: Dp?=null,
textColor:Int?=R.color.black,textAlign:TextAlign?=null,textSize:Int?=com.intuit.sdp.R.dimen._13sdp){
    Text(text = text,
        color = colorResource(id = textColor!!),
        fontSize = dimensionResource(id = textSize!!).value.sp,
        modifier = Modifier.absolutePadding(
            left = paddingLeft?:0.dp,
            right = paddingRight?:0.dp,
            top = paddingTop?:0.dp,
            bottom = paddingBottom?:0.dp
        ), fontWeight = if(isBold == true)FontWeight.Bold else FontWeight.Normal, textAlign =textAlign?:TextAlign.Start
    )
}