package core_ui.values

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val brown = Color(0xccd5ae)
val lightBrown = Color(0xe9edc9)
val middle = Color(0xefefae0)
val lightGreen= Color(0xfaedcd)
val green = Color(0xd4a373)


fun lightColors(
    primary: Color = Color(0xFF6200EE),
    primaryVariant: Color = Color(0xFF3700B3),
    background: Color = Color.White
    /* ... */
): Colors = lightColors(
    primary,
    primaryVariant,
    background
)