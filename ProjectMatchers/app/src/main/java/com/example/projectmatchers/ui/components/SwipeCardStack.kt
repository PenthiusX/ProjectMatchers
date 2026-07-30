package com.example.projectmatchers.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.projectmatchers.data.model.UserProfile
import kotlinx.coroutines.launch
import kotlin.math.abs

@Composable
fun SwipeCardStack(
    profiles: List<UserProfile>,
    onSwipeLeft: (UserProfile) -> Unit,
    onSwipeRight: (UserProfile) -> Unit,
    modifier: Modifier = Modifier
) {
    var currentIndex by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()
    
    // We show current and next card
    Box(modifier = modifier.fillMaxSize()) {
        if (currentIndex < profiles.size) {
            // Next card (background)
            if (currentIndex + 1 < profiles.size) {
                ProfileCard(
                    profile = profiles[currentIndex + 1],
                    modifier = Modifier.graphicsLayer {
                        scaleX = 0.95f
                        scaleY = 0.95f
                    }
                )
            }

            // Current card (foreground with gestures)
            val profile = profiles[currentIndex]
            val offsetX = remember { Animatable(0f) }
            val offsetY = remember { Animatable(0f) }
            val rotation = remember { Animatable(0f) }
            
            val configuration = LocalConfiguration.current
            val density = LocalDensity.current
            val screenWidthPx = with(density) { configuration.screenWidthDp.dp.toPx() }

            ProfileCard(
                profile = profile,
                modifier = Modifier
                    .graphicsLayer {
                        translationX = offsetX.value
                        translationY = offsetY.value
                        rotationZ = rotation.value
                    }
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragEnd = {
                                scope.launch {
                                    if (abs(offsetX.value) > screenWidthPx / 3) {
                                        // Swipe away
                                        val targetX = if (offsetX.value > 0) screenWidthPx * 2 else -screenWidthPx * 2
                                        launch { offsetX.animateTo(targetX, tween(300)) }
                                        
                                        if (offsetX.value > 0) onSwipeRight(profile) else onSwipeLeft(profile)
                                        
                                        currentIndex++
                                        offsetX.snapTo(0f)
                                        offsetY.snapTo(0f)
                                        rotation.snapTo(0f)
                                    } else {
                                        // Return to center
                                        launch { offsetX.animateTo(0f, tween(300)) }
                                        launch { offsetY.animateTo(0f, tween(300)) }
                                        launch { rotation.animateTo(0f, tween(300)) }
                                    }
                                }
                            },
                            onDrag = { change, dragAmount ->
                                change.consume()
                                scope.launch {
                                    offsetX.snapTo(offsetX.value + dragAmount.x)
                                    offsetY.snapTo(offsetY.value + dragAmount.y)
                                    rotation.snapTo(offsetX.value / 20f)
                                }
                            }
                        )
                    }
            )
        }
    }
}
