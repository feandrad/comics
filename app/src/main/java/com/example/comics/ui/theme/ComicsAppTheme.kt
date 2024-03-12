package com.example.comics.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = Purple500,
    onPrimary = Natural90,
    primaryContainer = Purple700,
    onPrimaryContainer = Natural90,
    secondary = Teal200,
    onSecondary = DarkGrey,
    secondaryContainer = Teal700,
    onSecondaryContainer = DarkGrey,
    tertiary = Purple200,
    onTertiary = DarkGrey,
    tertiaryContainer = Purple700,
    onTertiaryContainer = Natural90,
    error = LightError,
    errorContainer = LightError.copy(alpha = 0.15f),
    onError = Natural90,
    onErrorContainer = DarkGrey,
    background = Natural90,
    onBackground = DarkGrey,
    surface = Natural90,
    onSurface = DarkGrey,
    surfaceVariant = Purple700,
    onSurfaceVariant = Natural90,
    outline = Purple200,
    inverseOnSurface = Natural90,
    inverseSurface = DarkGrey,
    inversePrimary = Purple200,
    surfaceTint = Purple500,
    outlineVariant = Purple700,
    scrim = DarkGrey,
)

private val DarkColors = darkColorScheme(
    primary = Purple200,
    onPrimary = DarkGrey,
    primaryContainer = Purple500,
    onPrimaryContainer = DarkGrey,
    secondary = Teal200,
    onSecondary = Natural90,
    secondaryContainer = Teal700,
    onSecondaryContainer = Natural90,
    tertiary = Purple700,
    onTertiary = Natural90,
    tertiaryContainer = Purple200,
    onTertiaryContainer = DarkGrey,
    error = DarkError,
    errorContainer = DarkError.copy(alpha = 0.15f),
    onError = DarkGrey,
    onErrorContainer = Natural90,
    background = DarkGrey,
    onBackground = Natural90,
    surface = DarkGrey,
    onSurface = Natural90,
    surfaceVariant = Purple500,
    onSurfaceVariant = DarkGrey,
    outline = Purple200,
    inverseOnSurface = DarkGrey,
    inverseSurface = Natural90,
    inversePrimary = Purple700,
    surfaceTint = Purple200,
    outlineVariant = Purple500,
    scrim = Natural90,
)


@Composable
fun ComicsAppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (!useDarkTheme) {
        LightColors
    } else {
        DarkColors
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}



