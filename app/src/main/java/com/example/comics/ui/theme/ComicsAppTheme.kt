package com.example.comics.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = Purple500,
    onPrimary = White,
    primaryContainer = Purple700,
    onPrimaryContainer = White,
    secondary = Teal200,
    onSecondary = Black,
    secondaryContainer = Teal700,
    onSecondaryContainer = Black,
    tertiary = Purple200,
    onTertiary = Black,
    tertiaryContainer = Purple700,
    onTertiaryContainer = White,
    error = LightError,
    errorContainer = LightError.copy(alpha = 0.15f),
    onError = White,
    onErrorContainer = Black,
    background = White,
    onBackground = Black,
    surface = White,
    onSurface = Black,
    surfaceVariant = Purple700,
    onSurfaceVariant = White,
    outline = Purple200,
    inverseOnSurface = White,
    inverseSurface = Black,
    inversePrimary = Purple200,
    surfaceTint = Purple500,
    outlineVariant = Purple700,
    scrim = Black,
)

private val DarkColors = darkColorScheme(
    primary = Purple200,
    onPrimary = Black,
    primaryContainer = Purple500,
    onPrimaryContainer = Black,
    secondary = Teal200,
    onSecondary = White,
    secondaryContainer = Teal700,
    onSecondaryContainer = White,
    tertiary = Purple700,
    onTertiary = White,
    tertiaryContainer = Purple200,
    onTertiaryContainer = Black,
    error = DarkError,
    errorContainer = DarkError.copy(alpha = 0.15f),
    onError = Black,
    onErrorContainer = White,
    background = Black,
    onBackground = White,
    surface = Black,
    onSurface = White,
    surfaceVariant = Purple500,
    onSurfaceVariant = Black,
    outline = Purple200,
    inverseOnSurface = Black,
    inverseSurface = White,
    inversePrimary = Purple700,
    surfaceTint = Purple200,
    outlineVariant = Purple500,
    scrim = White,
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



