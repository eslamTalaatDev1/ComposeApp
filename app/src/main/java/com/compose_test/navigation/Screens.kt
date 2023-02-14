package com.compose_test.navigation

sealed class Screens(var route:String){
    object MainActivity : Screens(route = "MainScreen")
    object SelectedBillActivity : Screens(route = "SelectedBillActivity")
    object BillsConfirmation : Screens(route = "BillsConfirmation")
    object ReceiptScreen : Screens(route = "ReceiptScreen")
    object SearchScreen : Screens(route = "SearchScreen")
    object InternationalBillsScreen : Screens(route = "InternationalBillsScreen")
}

