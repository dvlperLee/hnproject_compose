package com.yangholee.hnproject_compose.navigation

sealed class NavRoutes(val route: String) {
    object login : NavRoutes("login")
    object main : NavRoutes("main")
    object import : NavRoutes("import")

}