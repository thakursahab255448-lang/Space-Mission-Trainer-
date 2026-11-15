package com.example.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val Mars2077ColorScheme = darkColorScheme(
    primary = MarsOrange,
    onPrimary = StarWhite,
    primaryContainer = NebulaViolet,
    onPrimaryContainer = StarWhite,
    secondary = CyanNebula,
    onSecondary = SpaceBlack,
    secondaryContainer = CosmicPurple,
    onSecondaryContainer = CyanNebula,
    tertiary = StarGold,
    onTertiary = SpaceBlack,
    background = DeepSpaceNavy,
    onBackground = StarWhite,
    surface = CosmicPurple,
    onSurface = StarWhite,
    surfaceVariant = CardSurfacePurple,
    onSurfaceVariant = MoonSilver,
    outline = CardBorderPurple,
    error = DangerRed
)

val AppShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(20.dp),
    large = RoundedCornerShape(28.dp),
    extraLarge = RoundedCornerShape(36.dp)
)

@Composable
fun MyApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = Mars2077ColorScheme,
        typography = Typography,
        shapes = AppShapes,
        content = content
    )
}
