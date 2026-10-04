package com.example.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.ui.theme.EmeraldDarkPrimaryContainer
import com.example.ui.theme.EmeraldPrimary
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scale = remember { Animatable(0.85f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        launch {
            alpha.animateTo(1f, animationSpec = tween(200))
        }
        scale.animateTo(1f, animationSpec = tween(200))
        delay(100)
        onDismiss()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable { onDismiss() }
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFF1F8F4),
                        Color(0xFFE2EFE7),
                        Color(0xFFD4E9DC)
                    )
                )
            )
            .clickable { onDismiss() }
            .testTag("splash_screen")
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            // Center Logo & Title
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .scale(scale.value)
                    .alpha(alpha.value)
            ) {
                Surface(
                    shape = RoundedCornerShape(28.dp),
                    color = Color.White,
                    shadowElevation = 8.dp,
                    modifier = Modifier.size(110.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.linearGradient(
                                    listOf(EmeraldPrimary, Color(0xFF064423))
                                )
                            )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_app_logo),
                            contentDescription = "NewsHub BD Logo",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(86.dp)
                                .clip(RoundedCornerShape(20.dp))
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "NewsHub BD",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = EmeraldPrimary,
                    letterSpacing = 0.5.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "সব খবর, এক অ্যাপে",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1B4332)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "All Bangladeshi Newspapers in One Place",
                    fontSize = 13.sp,
                    color = Color(0xFF2D6A4F),
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "Read • Explore • Stay Informed",
                    fontSize = 12.sp,
                    color = Color(0xFF40916C),
                    modifier = Modifier.padding(top = 4.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Feature Highlights Pills
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    SplashFeaturePill(icon = Icons.Filled.Bolt, label = "Latest News")
                    SplashFeaturePill(icon = Icons.Filled.Newspaper, label = "All Papers")
                    SplashFeaturePill(icon = Icons.Filled.Favorite, label = "Save Offline")
                }
            }

            // Bottom Monument Banner & Footer
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Monument silhouette image
                Image(
                    painter = painterResource(id = R.drawable.bg_monument_banner),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .alpha(0.85f)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onDismiss,
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldPrimary),
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(44.dp)
                        .testTag("splash_enter_btn")
                ) {
                    Text(
                        text = "Explore News ➔",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Made for a Better Informed Bangladesh ❤️",
                    fontSize = 12.sp,
                    color = Color(0xFF2D6A4F),
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun SplashFeaturePill(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color.White.copy(alpha = 0.85f),
        shadowElevation = 1.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = EmeraldPrimary,
                modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = label,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1B4332)
            )
        }
    }
}
