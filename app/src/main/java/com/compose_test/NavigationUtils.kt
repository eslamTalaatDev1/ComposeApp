package com.compose_test

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation(
    navController:NavHostController
){
    NavHost(navController = navController, startDestination = Screens.MainActivity.route ){
        composable(route = Screens.MainActivity.route){
            AllBills(navController = navController)
        }
        composable(route = Screens.SelectedBillActivity.route){
            SelectedBillActivity(navController)
        }
        composable(route = Screens.BillsConfirmation.route){
            BillsConfirmation(navController)
        }
        composable(route = Screens.ReceiptScreen.route){
            ReceiptScreen(navController)
        }
        composable(route = Screens.SearchScreen.route){
            SearchScreen(navController)
        }
        composable(route = Screens.InternationalBillsScreen.route){
            InternationalBillsScreen(navController)
        }
     }
}