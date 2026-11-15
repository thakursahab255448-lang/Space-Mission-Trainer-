package com.example.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.data.PlanetsCatalog
import com.example.model.PlanetData
import com.example.model.SceneAnimationType
import com.example.ui.theme.CosmicBlue
import com.example.ui.theme.CosmicPurple
import com.example.ui.theme.CyanNebula
import com.example.ui.theme.DeepSpaceNavy
import com.example.ui.theme.ElectricPurple
import com.example.ui.theme.GalaxyPink
import com.example.ui.theme.MarsOrange
import com.example.ui.theme.SpaceBlack
import com.example.ui.theme.StarGold
import com.example.ui.theme.StarWhite
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.min
import kotlin.math.sin

private data class StarPoint(
    val xFraction: Float,
    val yFraction: Float,
    val radius: Float,
    val phaseOffset: Float,
    val tint: Color
)

@Composable
fun AnimatedSpaceBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val stars = remember {
        val colors = listOf(StarWhite, StarGold, CyanNebula, ElectricPurple, Color(0xFFFFCCBC))
        List(75) { i ->
            val seed = (i * 7919) % 1000
            val seedY = (i * 6271 + 193) % 1000
            StarPoint(
                xFraction = seed / 1000f,
                yFraction = seedY / 1000f,
                radius = 1.5f + (i % 4) * 1.1f,
                phaseOffset = (i % 10) * 0.6f,
                tint = colors[i % colors.size]
            )
        }
    }

    val infiniteTransition = rememberInfiniteTransition(label = "space_bg")
    val twinkleTime by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = (2 * PI).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 5000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "twinkle"
    )
    val shootingStarProgress by infiniteTransition.animateFloat(
        initialValue = -0.2f,
        targetValue = 1.4f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 7000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shooting_star"
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        SpaceBlack,
                        DeepSpaceNavy,
                        CosmicPurple,
                        DeepSpaceNavy
                    )
                )
            )
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height

            // Soft Nebula Glows
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(ElectricPurple.copy(alpha = 0.14f), Color.Transparent),
                    center = Offset(w * 0.8f, h * 0.18f),
                    radius = w * 0.55f
                ),
                center = Offset(w * 0.8f, h * 0.18f),
                radius = w * 0.55f
            )
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(CosmicBlue.copy(alpha = 0.12f), Color.Transparent),
                    center = Offset(w * 0.15f, h * 0.55f),
                    radius = w * 0.5f
                ),
                center = Offset(w * 0.15f, h * 0.55f),
                radius = w * 0.5f
            )
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(MarsOrange.copy(alpha = 0.09f), Color.Transparent),
                    center = Offset(w * 0.75f, h * 0.82f),
                    radius = w * 0.45f
                ),
                center = Offset(w * 0.75f, h * 0.82f),
                radius = w * 0.45f
            )

            // Twinkling Stars
            stars.forEach { s ->
                val alpha = 0.35f + 0.65f * ((sin(twinkleTime + s.phaseOffset) + 1f) / 2f)
                drawCircle(
                    color = s.tint.copy(alpha = alpha),
                    radius = s.radius,
                    center = Offset(w * s.xFraction, h * s.yFraction)
                )
            }

            // Shooting star streak
            if (shootingStarProgress in 0f..1f) {
                val headX = w * (0.1f + 0.8f * shootingStarProgress)
                val headY = h * (0.08f + 0.35f * shootingStarProgress)
                val tailX = headX - 90f
                val tailY = headY - 40f
                drawLine(
                    brush = Brush.linearGradient(
                        colors = listOf(Color.Transparent, StarGold, StarWhite),
                        start = Offset(tailX, tailY),
                        end = Offset(headX, headY)
                    ),
                    start = Offset(tailX, tailY),
                    end = Offset(headX, headY),
                    strokeWidth = 3f,
                    cap = StrokeCap.Round
                )
            }
        }
        content()
    }
}

@Composable
fun InteractiveSolarSystemCanvas(
    selectedPlanet: PlanetData?,
    speedMultiplier: Float,
    showOrbitLines: Boolean,
    showLabels: Boolean,
    onPlanetTapped: (PlanetData) -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 350.dp
) {
    val planets = remember { PlanetsCatalog.allPlanets }
    val infiniteTransition = rememberInfiniteTransition(label = "solar_system_orbit")
    val baseAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 28000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "orbit_angle"
    )

    // Relative orbital speed factors so inner planets move faster than outer planets
    val speedFactors = remember {
        listOf(4.1f, 3.0f, 2.4f, 1.9f, 1.3f, 0.95f, 0.68f, 0.48f)
    }
    val startOffsets = remember {
        listOf(15f, 85f, 165f, 235f, 45f, 130f, 275f, 320f)
    }

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(24.dp))
            .background(
                Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF281856),
                        Color(0xFF120A2A),
                        Color(0xFF090416)
                    )
                )
            )
            .pointerInput(baseAngle, speedMultiplier) {
                detectTapGestures { tapOffset ->
                    val cx = size.width / 2f
                    val cy = size.height / 2f
                    val maxRadius = min(cx, cy) * 0.90f
                    val minRadius = maxRadius * 0.20f
                    val step = (maxRadius - minRadius) / 7.3f

                    var closestPlanet: PlanetData? = null
                    var minDist = 64f // Generous touch target radius in px for kids

                    planets.forEachIndexed { index, planet ->
                        val orbitR = minRadius + index * step
                        val angleDeg = startOffsets[index] + baseAngle * speedFactors[index] * speedMultiplier
                        val angleRad = angleDeg * (PI / 180.0)
                        val px = cx + (orbitR * cos(angleRad)).toFloat()
                        val py = cy + (orbitR * sin(angleRad)).toFloat()
                        val dist = hypot(tapOffset.x - px, tapOffset.y - py)
                        if (dist < minDist) {
                            minDist = dist
                            closestPlanet = planet
                        }
                    }
                    closestPlanet?.let { onPlanetTapped(it) }
                }
            }
    ) {
        val cx = size.width / 2f
        val cy = size.height / 2f
        val maxRadius = min(cx, cy) * 0.90f
        val minRadius = maxRadius * 0.20f
        val step = (maxRadius - minRadius) / 7.3f

        // Background stars inside the solar system box
        for (i in 0 until 40) {
            val sx = ((i * 3571) % 1000) / 1000f * size.width
            val sy = ((i * 2903 + 401) % 1000) / 1000f * size.height
            drawCircle(
                color = StarWhite.copy(alpha = 0.35f),
                radius = if (i % 3 == 0) 2.2f else 1.3f,
                center = Offset(sx, sy)
            )
        }

        // Asteroid Belt between Mars (index 3) and Jupiter (index 4)
        val beltRadius = minRadius + 3.5f * step
        for (a in 0 until 64) {
            val aRad = (a * (360f / 64f) + baseAngle * 0.25f) * (PI / 180.0)
            val jitter = ((a % 3) - 1) * 2.5f
            val ax = cx + ((beltRadius + jitter) * cos(aRad)).toFloat()
            val ay = cy + ((beltRadius + jitter) * sin(aRad)).toFloat()
            drawCircle(
                color = Color(0xFFB0BEC5).copy(alpha = 0.45f),
                radius = 1.6f,
                center = Offset(ax, ay)
            )
        }

        //Glowing Sun at the Center
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color(0xFFFFF59D),
                    StarGold,
                    MarsOrange.copy(alpha = 0.55f),
                    Color.Transparent
                ),
                center = Offset(cx, cy),
                radius = minRadius * 0.85f
            ),
            radius = minRadius * 0.85f,
            center = Offset(cx, cy)
        )
        drawCircle(
            color = StarGold,
            radius = minRadius * 0.44f,
            center = Offset(cx, cy)
        )

        // Draw Orbits & Planets
        planets.forEachIndexed { index, planet ->
            val orbitR = minRadius + index * step
            val isSelected = selectedPlanet?.id == planet.id

            if (showOrbitLines) {
                drawCircle(
                    color = if (isSelected) CyanNebula.copy(alpha = 0.65f) else StarWhite.copy(alpha = 0.16f),
                    radius = orbitR,
                    center = Offset(cx, cy),
                    style = Stroke(width = if (isSelected) 2.5f else 1.2f)
                )
            }

            val angleDeg = startOffsets[index] + baseAngle * speedFactors[index] * speedMultiplier
            val angleRad = angleDeg * (PI / 180.0)
            val px = cx + (orbitR * cos(angleRad)).toFloat()
            val py = cy + (orbitR * sin(angleRad)).toFloat()

            val planetRadius = when (planet.id) {
                "mercury" -> 6.5f
                "venus" -> 9.0f
                "earth" -> 10.0f
                "mars" -> 8.5f
                "jupiter" -> 15.5f
                "saturn" -> 13.5f
                "uranus" -> 11.0f
                "neptune" -> 10.5f
                else -> 9.0f
            }

            // Selection halo
            if (isSelected) {
                drawCircle(
                    color = CyanNebula.copy(alpha = 0.35f),
                    radius = planetRadius + 10f,
                    center = Offset(px, py)
                )
                drawCircle(
                    color = StarWhite,
                    radius = planetRadius + 5f,
                    center = Offset(px, py),
                    style = Stroke(width = 2f)
                )
            }

            // Saturn or Uranus rings
            if (planet.id == "saturn") {
                rotate(degrees = -22f, pivot = Offset(px, py)) {
                    drawOval(
                        color = Color(0xFFFFE082).copy(alpha = 0.85f),
                        topLeft = Offset(px - planetRadius * 1.9f, py - planetRadius * 0.55f),
                        size = Size(planetRadius * 3.8f, planetRadius * 1.1f),
                        style = Stroke(width = 3.2f)
                    )
                }
            }

            // Planet body
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(planet.primaryColor, planet.secondaryColor),
                    center = Offset(px - planetRadius * 0.3f, py - planetRadius * 0.3f),
                    radius = planetRadius * 1.3f
                ),
                radius = planetRadius,
                center = Offset(px, py)
            )

            // Tiny Moon orbiting Earth
            if (planet.id == "earth") {
                val moonRad = (baseAngle * 8f) * (PI / 180.0)
                val mx = px + (planetRadius * 1.7f * cos(moonRad)).toFloat()
                val my = py + (planetRadius * 1.7f * sin(moonRad)).toFloat()
                drawCircle(
                    color = Color(0xFFE0E0E0),
                    radius = 2.6f,
                    center = Offset(mx, my)
                )
            }
        }
    }
}

@Composable
fun PlanetIllustrationCanvas(
    planet: PlanetData,
    modifier: Modifier = Modifier,
    sizeDp: Dp = 150.dp
) {
    val infiniteTransition = rememberInfiniteTransition(label = "planet_spin")
    val pulse by infiniteTransition.animateFloat(
        initialValue = 0.94f,
        targetValue = 1.06f,
        animationSpec = infiniteRepeatable(
            animation = tween(2400, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glow_pulse"
    )

    Canvas(modifier = modifier.height(sizeDp).fillMaxWidth()) {
        val cx = size.width / 2f
        val cy = size.height / 2f
        val r = min(size.width, size.height) * 0.34f

        // Outer cosmic glow
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    planet.primaryColor.copy(alpha = 0.42f),
                    planet.secondaryColor.copy(alpha = 0.12f),
                    Color.Transparent
                ),
                center = Offset(cx, cy),
                radius = r * 1.65f * pulse
            ),
            radius = r * 1.65f * pulse,
            center = Offset(cx, cy)
        )

        // Back ring for Saturn / Uranus
        if (planet.id == "saturn") {
            rotate(degrees = -18f, pivot = Offset(cx, cy)) {
                drawOval(
                    color = Color(0xFFFFE082).copy(alpha = 0.7f),
                    topLeft = Offset(cx - r * 1.95f, cy - r * 0.48f),
                    size = Size(r * 3.9f, r * 0.96f),
                    style = Stroke(width = 10f)
                )
                drawOval(
                    color = Color(0xFFFFB74D).copy(alpha = 0.5f),
                    topLeft = Offset(cx - r * 1.6f, cy - r * 0.36f),
                    size = Size(r * 3.2f, r * 0.72f),
                    style = Stroke(width = 5f)
                )
            }
        } else if (planet.id == "uranus") {
            rotate(degrees = 78f, pivot = Offset(cx, cy)) {
                drawOval(
                    color = CyanNebula.copy(alpha = 0.55f),
                    topLeft = Offset(cx - r * 1.65f, cy - r * 0.32f),
                    size = Size(r * 3.3f, r * 0.64f),
                    style = Stroke(width = 4f)
                )
            }
        }

        // Main Planet Sphere
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    planet.primaryColor,
                    planet.secondaryColor,
                    Color(0xFF120A28)
                ),
                center = Offset(cx - r * 0.3f, cy - r * 0.3f),
                radius = r * 1.35f
            ),
            radius = r,
            center = Offset(cx, cy)
        )

        // Planet-specific surface features
        when (planet.id) {
            "mercury" -> {
                drawCircle(Color(0xFF607D8B), radius = r * 0.18f, center = Offset(cx - r * 0.3f, cy - r * 0.1f))
                drawCircle(Color(0xFF546E7A), radius = r * 0.24f, center = Offset(cx + r * 0.25f, cy + r * 0.28f))
                drawCircle(Color(0xFF78909C), radius = r * 0.12f, center = Offset(cx + r * 0.1f, cy - r * 0.4f))
            }
            "earth" -> {
                // Continents & polar cap
                drawCircle(Color(0xFF4CAF50).copy(alpha = 0.85f), radius = r * 0.34f, center = Offset(cx - r * 0.25f, cy - r * 0.1f))
                drawCircle(Color(0xFF66BB6A).copy(alpha = 0.85f), radius = r * 0.26f, center = Offset(cx + r * 0.3f, cy + r * 0.2f))
                drawCircle(StarWhite.copy(alpha = 0.65f), radius = r * 0.22f, center = Offset(cx, cy - r * 0.72f))
            }
            "mars" -> {
                // Polar ice cap & rusty canyons
                drawCircle(StarWhite.copy(alpha = 0.85f), radius = r * 0.24f, center = Offset(cx, cy - r * 0.75f))
                drawLine(
                    color = Color(0xFFBF360C),
                    start = Offset(cx - r * 0.5f, cy + r * 0.05f),
                    end = Offset(cx + r * 0.45f, cy - r * 0.1f),
                    strokeWidth = 6f,
                    cap = StrokeCap.Round
                )
                drawCircle(Color(0xFFBF360C).copy(alpha = 0.6f), radius = r * 0.18f, center = Offset(cx - r * 0.25f, cy - r * 0.25f))
            }
            "jupiter" -> {
                // Cloud bands and Great Red Spot
                drawLine(
                    color = Color(0xFFD84315).copy(alpha = 0.55f),
                    start = Offset(cx - r * 0.85f, cy - r * 0.25f),
                    end = Offset(cx + r * 0.85f, cy - r * 0.25f),
                    strokeWidth = 10f,
                    cap = StrokeCap.Round
                )
                drawLine(
                    color = Color(0xFFFFE0B2).copy(alpha = 0.65f),
                    start = Offset(cx - r * 0.9f, cy + r * 0.15f),
                    end = Offset(cx + r * 0.9f, cy + r * 0.15f),
                    strokeWidth = 8f,
                    cap = StrokeCap.Round
                )
                drawOval(
                    color = Color(0xFFFF3D00),
                    topLeft = Offset(cx + r * 0.05f, cy + r * 0.1f),
                    size = Size(r * 0.44f, r * 0.28f)
                )
            }
        }
    }
}

@Composable
fun EducationalSceneCanvas(
    sceneType: SceneAnimationType,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "edu_scene")
    val animProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 6000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "scene_progress"
    )

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF140B30),
                        Color(0xFF231454),
                        Color(0xFF140B30)
                    )
                )
            )
    ) {
        val w = size.width
        val h = size.height
        val cx = w / 2f
        val cy = h / 2f
        val angleRad = animProgress * 2 * PI

        // Background stars
        for (i in 0 until 24) {
            val sx = ((i * 1973) % 1000) / 1000f * w
            val sy = ((i * 3191) % 1000) / 1000f * h
            drawCircle(
                color = StarWhite.copy(alpha = 0.4f + 0.4f * sin(angleRad.toFloat() + i)),
                radius = 2f,
                center = Offset(sx, sy)
            )
        }

        when (sceneType) {
            SceneAnimationType.STARFIELD_NEBULA -> {
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(GalaxyPink.copy(alpha = 0.5f), CyanNebula.copy(alpha = 0.25f), Color.Transparent),
                        center = Offset(cx, cy),
                        radius = h * 0.7f
                    ),
                    radius = h * 0.7f,
                    center = Offset(cx, cy)
                )
                drawCircle(StarGold, radius = 14f, center = Offset(cx - 60f, cy - 15f))
                drawCircle(CyanNebula, radius = 18f, center = Offset(cx + 55f, cy + 12f))
                drawCircle(StarWhite, radius = 10f, center = Offset(cx + 5f, cy - 28f))
            }
            SceneAnimationType.ORBITING_PLANETS -> {
                drawCircle(StarGold, radius = 22f, center = Offset(cx, cy))
                val r1 = 44f
                val r2 = 72f
                drawCircle(StarWhite.copy(alpha = 0.2f), radius = r1, center = Offset(cx, cy), style = Stroke(1.5f))
                drawCircle(StarWhite.copy(alpha = 0.2f), radius = r2, center = Offset(cx, cy), style = Stroke(1.5f))
                drawCircle(
                    color = CosmicBlue,
                    radius = 9f,
                    center = Offset(cx + (r1 * cos(angleRad * 2)).toFloat(), cy + (r1 * sin(angleRad * 2)).toFloat())
                )
                drawCircle(
                    color = MarsOrange,
                    radius = 8f,
                    center = Offset(cx + (r2 * cos(angleRad)).toFloat(), cy + (r2 * sin(angleRad)).toFloat())
                )
            }
            SceneAnimationType.MOON_ORBIT -> {
                drawCircle(CosmicBlue, radius = 26f, center = Offset(cx, cy))
                drawCircle(Color(0xFF4CAF50), radius = 10f, center = Offset(cx - 6f, cy - 4f))
                val moonOrbit = 58f
                drawCircle(StarWhite.copy(alpha = 0.25f), radius = moonOrbit, center = Offset(cx, cy), style = Stroke(1.5f))
                val mx = cx + (moonOrbit * cos(angleRad)).toFloat()
                val my = cy + (moonOrbit * sin(angleRad)).toFloat()
                drawCircle(Color(0xFFE0E0E0), radius = 11f, center = Offset(mx, my))
            }
            SceneAnimationType.MARS_ROVER_DRIVE -> {
                // Martian horizon
                drawRect(
                    color = Color(0xFFBF360C),
                    topLeft = Offset(0f, h * 0.68f),
                    size = Size(w, h * 0.32f)
                )
                val roverX = w * (0.2f + 0.6f * animProgress)
                val roverY = h * 0.62f
                // Rover body
                drawRect(
                    color = StarWhite,
                    topLeft = Offset(roverX - 24f, roverY - 18f),
                    size = Size(48f, 20f)
                )
                // Mast & Camera
                drawLine(StarWhite, Offset(roverX + 14f, roverY - 18f), Offset(roverX + 14f, roverY - 34f), strokeWidth = 4f)
                drawCircle(CyanNebula, radius = 6f, center = Offset(roverX + 14f, roverY - 36f))
                // 3 Wheels
                drawCircle(SpaceBlack, radius = 7f, center = Offset(roverX - 16f, roverY + 4f))
                drawCircle(SpaceBlack, radius = 7f, center = Offset(roverX, roverY + 4f))
                drawCircle(SpaceBlack, radius = 7f, center = Offset(roverX + 16f, roverY + 4f))
            }
            SceneAnimationType.ASTRONAUT_FLOAT -> {
                val bobY = cy + (14f * sin(angleRad)).toFloat()
                // Backpack
                drawRect(Color(0xFFB0BEC5), topLeft = Offset(cx - 18f, bobY - 14f), size = Size(36f, 34f))
                // Suit Helmet
                drawCircle(StarWhite, radius = 18f, center = Offset(cx, bobY - 22f))
                // Gold Visor
                drawCircle(StarGold, radius = 12f, center = Offset(cx + 3f, bobY - 22f))
            }
            SceneAnimationType.ROCKET_BLASTOFF -> {
                val rocketX = w * (0.18f + 0.64f * animProgress)
                val rocketY = cy + (8f * sin(angleRad * 2)).toFloat()
                // Flame
                drawCircle(MarsOrange, radius = 12f, center = Offset(rocketX - 32f, rocketY))
                drawCircle(StarGold, radius = 7f, center = Offset(rocketX - 26f, rocketY))
                // Rocket body
                drawOval(
                    color = StarWhite,
                    topLeft = Offset(rocketX - 24f, rocketY - 11f),
                    size = Size(48f, 22f)
                )
                drawCircle(CyanNebula, radius = 5f, center = Offset(rocketX + 4f, rocketY))
            }
            SceneAnimationType.SPIRAL_GALAXY -> {
                rotate(degrees = animProgress * 360f, pivot = Offset(cx, cy)) {
                    for (arm in 0 until 3) {
                        val armOffset = arm * (2 * PI / 3)
                        for (p in 1..18) {
                            val dist = p * 3.2f
                            val a = p * 0.35 + armOffset
                            val gx = cx + (dist * cos(a)).toFloat()
                            val gy = cy + (dist * sin(a)).toFloat()
                            drawCircle(
                                color = if (p % 2 == 0) CyanNebula else ElectricPurple,
                                radius = 3.2f,
                                center = Offset(gx, gy)
                            )
                        }
                    }
                    drawCircle(StarGold, radius = 12f, center = Offset(cx, cy))
                }
            }
            SceneAnimationType.BLACK_HOLE_GRAVITY -> {
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(MarsOrange, StarGold, ElectricPurple.copy(alpha = 0.3f), Color.Transparent),
                        center = Offset(cx, cy),
                        radius = 56f
                    ),
                    radius = 56f,
                    center = Offset(cx, cy)
                )
                drawCircle(SpaceBlack, radius = 24f, center = Offset(cx, cy))
                drawCircle(StarGold, radius = 26f, center = Offset(cx, cy), style = Stroke(width = 3f))
            }
        }
    }
}

@Composable
fun MoonPhaseCanvas(
    illuminationFraction: Float,
    waxing: Boolean,
    modifier: Modifier = Modifier,
    sizeDp: Dp = 120.dp
) {
    Canvas(modifier = modifier.height(sizeDp).fillMaxWidth()) {
        val cx = size.width / 2f
        val cy = size.height / 2f
        val r = min(size.width, size.height) * 0.38f

        // Glow
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(StarGold.copy(alpha = 0.25f * illuminationFraction), Color.Transparent),
                center = Offset(cx, cy),
                radius = r * 1.5f
            ),
            radius = r * 1.5f,
            center = Offset(cx, cy)
        )

        // Dark Moon base
        drawCircle(
            color = Color(0xFF262238),
            radius = r,
            center = Offset(cx, cy)
        )

        // Lit portion approximation
        if (illuminationFraction > 0.02f) {
            val path = Path()
            val steps = 40
            for (i in 0..steps) {
                val theta = -PI / 2 + (PI * i / steps)
                val y = cy + (r * sin(theta)).toFloat()
                val halfChord = (r * cos(theta)).toFloat()
                val xOuter = if (waxing) cx + halfChord else cx - halfChord
                if (i == 0) path.moveTo(xOuter, y) else path.lineTo(xOuter, y)
            }
            val terminatorScale = 1f - 2f * illuminationFraction // 1 -> -1
            for (i in steps downTo 0) {
                val theta = -PI / 2 + (PI * i / steps)
                val y = cy + (r * sin(theta)).toFloat()
                val halfChord = (r * cos(theta)).toFloat()
                val xInner = if (waxing) {
                    cx + halfChord * terminatorScale
                } else {
                    cx - halfChord * terminatorScale
                }
                path.lineTo(xInner, y)
            }
            path.close()
            drawPath(
                path = path,
                brush = Brush.radialGradient(
                    colors = listOf(Color(0xFFFFFDE7), Color(0xFFFFE082), Color(0xFFD7CCC8)),
                    center = Offset(cx, cy),
                    radius = r * 1.1f
                )
            )
        }

        // Subtle craters
        drawCircle(Color(0xFF9E9E9E).copy(alpha = 0.25f), radius = r * 0.16f, center = Offset(cx - r * 0.25f, cy - r * 0.2f))
        drawCircle(Color(0xFF9E9E9E).copy(alpha = 0.25f), radius = r * 0.22f, center = Offset(cx + r * 0.2f, cy + r * 0.22f))
        drawCircle(StarWhite.copy(alpha = 0.3f), radius = r, center = Offset(cx, cy), style = Stroke(width = 2f))
    }
}
