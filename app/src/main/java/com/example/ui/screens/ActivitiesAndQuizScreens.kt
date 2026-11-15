package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.LessonsCatalogPart2
import com.example.data.PlanetsCatalog
import com.example.data.QuizzesCatalog
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion
import com.example.ui.theme.AuroraGreen
import com.example.ui.theme.CardBorderPurple
import com.example.ui.theme.CardSurfacePurple
import com.example.ui.theme.CosmicBlue
import com.example.ui.theme.CosmicPurple
import com.example.ui.theme.CyanNebula
import com.example.ui.theme.DangerRed
import com.example.ui.theme.ElectricPurple
import com.example.ui.theme.GalaxyPink
import com.example.ui.theme.MarsOrange
import com.example.ui.theme.MoonSilver
import com.example.ui.theme.RocketAmber
import com.example.ui.theme.SpaceBlack
import com.example.ui.theme.StarGold
import com.example.ui.theme.StarWhite

enum class SpaceActivityTab(val id: String, val title: String, val hindiTitle: String, val emoji: String) {
    MATCH_PLANET("match_planet", "1. Match the Planet", "ग्रह का मिलान करें", "🪐"),
    GUESS_PLANET("guess_planet", "2. Guess the Planet", "पहेली: मैं कौन सा ग्रह हूँ?", "🕵️"),
    ARRANGE_ORDER("arrange_order", "3. Arrange Planets in Order", "सूर्य से क्रम में लगाएँ", "☀️"),
    SPACE_VOCAB("space_vocab", "4. Space Vocabulary", "अंतरिक्ष शब्दावली", "📖"),
    IDENTIFY_ASTRONAUT("identify_astronaut", "5. Identify the Astronaut", "अंतरिक्ष यात्री को पहचानें", "👨‍🚀"),
    FIND_OBJECT("find_object", "6. Find Space Object", "सही अंतरिक्ष वस्तु खोजें", "🔭"),
    MEMORY_CHALLENGE("memory_challenge", "7. Planet Memory Challenge", "ग्रह मेमोरी चैलेंज", "🧠")
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InteractiveActivitiesScreen(
    completedActivities: Set<String>,
    showHindi: Boolean,
    onActivityCompleted: (String, String) -> Unit
) {
    val scrollState = rememberScrollState()
    var activeTab by remember { mutableStateOf(SpaceActivityTab.MATCH_PLANET) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Activities Header
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(2.dp, GalaxyPink),
            shape = RoundedCornerShape(26.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "🎮 7 Fun Space Activities",
                            style = MaterialTheme.typography.headlineMedium,
                            color = StarWhite
                        )
                        if (showHindi) {
                            Text(
                                text = "मजेदार अंतरिक्ष खेल और गतिविधियाँ (+4 ⭐ प्रत्येक)",
                                style = MaterialTheme.typography.titleSmall,
                                color = StarGold
                            )
                        }
                    }
                    Surface(
                        color = AuroraGreen.copy(alpha = 0.2f),
                        border = BorderStroke(1.dp, AuroraGreen),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text(
                            text = "${completedActivities.size} / 7 Won",
                            style = MaterialTheme.typography.labelLarge,
                            color = AuroraGreen,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }
                }
                Spacer(Modifier.height(10.dp))
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SpaceActivityTab.entries.forEach { tab ->
                        val won = tab.id in completedActivities
                        FilterChip(
                            selected = activeTab == tab,
                            onClick = { activeTab = tab },
                            label = {
                                Text("${tab.emoji} ${tab.title}" + if (won) " ✓" else "")
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = GalaxyPink,
                                selectedLabelColor = StarWhite
                            ),
                            modifier = Modifier.testTag("activity_tab_${tab.id}")
                        )
                    }
                }
            }
        }

        // Render the selected activity
        when (activeTab) {
            SpaceActivityTab.MATCH_PLANET -> MatchThePlanetActivity(
                showHindi = showHindi,
                onComplete = { onActivityCompleted(SpaceActivityTab.MATCH_PLANET.id, "Match the Planet") }
            )
            SpaceActivityTab.GUESS_PLANET -> GuessThePlanetActivity(
                showHindi = showHindi,
                onComplete = { onActivityCompleted(SpaceActivityTab.GUESS_PLANET.id, "Guess the Planet") }
            )
            SpaceActivityTab.ARRANGE_ORDER -> ArrangePlanetsInOrderActivity(
                showHindi = showHindi,
                onComplete = { onActivityCompleted(SpaceActivityTab.ARRANGE_ORDER.id, "Arrange Planets in Order") }
            )
            SpaceActivityTab.SPACE_VOCAB -> SpaceVocabularyActivity(
                showHindi = showHindi,
                onComplete = { onActivityCompleted(SpaceActivityTab.SPACE_VOCAB.id, "Space Vocabulary") }
            )
            SpaceActivityTab.IDENTIFY_ASTRONAUT -> IdentifyAstronautActivity(
                showHindi = showHindi,
                onComplete = { onActivityCompleted(SpaceActivityTab.IDENTIFY_ASTRONAUT.id, "Identify the Astronaut") }
            )
            SpaceActivityTab.FIND_OBJECT -> FindCorrectSpaceObjectActivity(
                showHindi = showHindi,
                onComplete = { onActivityCompleted(SpaceActivityTab.FIND_OBJECT.id, "Find the Correct Space Object") }
            )
            SpaceActivityTab.MEMORY_CHALLENGE -> PlanetMemoryChallengeActivity(
                showHindi = showHindi,
                onComplete = { onActivityCompleted(SpaceActivityTab.MEMORY_CHALLENGE.id, "Planet Memory Challenge") }
            )
        }

        Spacer(Modifier.height(24.dp))
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun MatchThePlanetActivity(showHindi: Boolean, onComplete: () -> Unit) {
    val pairs = remember {
        listOf(
            Triple("Mars 🔴", "The Red Planet with rusty iron soil & 2 moons", "लाल ग्रह जहाँ मिट्टी में आयरन ऑक्साइड है"),
            Triple("Saturn 🪐", "Famous for dazzling rings of ice and rock", "बर्फ और चट्टानों के सुंदर छल्लों वाला ग्रह"),
            Triple("Jupiter 🟠", "Largest planet with the Great Red Spot storm", "सबसे बड़ा ग्रह जहाँ ग्रेट रेड स्पॉट तूफ़ान है"),
            Triple("Earth 🌍", "The Blue Marble with liquid oceans & life", "नीला ग्रह जहाँ महासागर और जीवन है"),
            Triple("Venus 🌕", "Hottest planet (475°C) with thick yellow clouds", "सौर मंडल का सबसे गर्म ग्रह")
        )
    }
    var currentIdx by remember { mutableIntStateOf(0) }
    var feedback by remember { mutableStateOf<String?>(null) }
    var completedAll by remember { mutableStateOf(false) }

    val target = pairs[currentIdx]
    val planetChoices = remember { pairs.map { it.first } }

    ActivityCardShell(
        title = "🪐 Activity 1: Match the Planet",
        hindiTitle = "विशेषता पढ़कर सही ग्रह से मिलान करें!",
        subtitle = "Match ${currentIdx + 1} of ${pairs.size}"
    ) {
        if (completedAll) {
            ActivitySuccessBanner(
                message = "You matched all 5 planets to their scientific features! (+4 ⭐)",
                onReplay = {
                    currentIdx = 0
                    completedAll = false
                    feedback = null
                }
            )
        } else {
            Surface(
                color = CosmicPurple,
                border = BorderStroke(1.5.dp, CyanNebula),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Clue:", style = MaterialTheme.typography.labelLarge, color = CyanNebula)
                    Text(target.second, style = MaterialTheme.typography.titleLarge, color = StarWhite)
                    if (showHindi) {
                        Spacer(Modifier.height(4.dp))
                        Text(target.third, style = MaterialTheme.typography.bodyMedium, color = StarGold)
                    }
                }
            }

            Spacer(Modifier.height(12.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                planetChoices.forEach { choice ->
                    Button(
                        onClick = {
                            if (choice == target.first) {
                                if (currentIdx == pairs.lastIndex) {
                                    completedAll = true
                                    onComplete()
                                } else {
                                    currentIdx++
                                    feedback = "✅ Awesome match! Next planet clue:"
                                }
                            } else {
                                feedback = "💡 Not quite $choice — read the clue carefully and try again!"
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = MarsOrange)
                    ) {
                        Text(choice, style = MaterialTheme.typography.titleMedium)
                    }
                }
            }

            feedback?.let {
                Spacer(Modifier.height(10.dp))
                Text(it, style = MaterialTheme.typography.bodyMedium, color = StarGold)
            }
        }
    }
}

@Composable
private fun GuessThePlanetActivity(showHindi: Boolean, onComplete: () -> Unit) {
    val riddles = remember {
        listOf(
            Triple(
                "🕵️ Riddle 1: I am tilted 98 degrees on my side and roll around the Sun like a blue-green icy ball! Who am I?",
                "पहेली 1: मैं अपनी धुरी पर 98 डिग्री झुका हूँ और लुढ़कती गेंद की तरह घूमता हूँ। मैं कौन हूँ?",
                "Uranus 🧊" to listOf("Uranus 🧊", "Mercury 🪨", "Mars 🔴", "Earth 🌍")
            ),
            Triple(
                "🕵️ Riddle 2: I am the closest planet to the Sun and zoom around it in just 88 Earth days! Who am I?",
                "पहेली 2: मैं सूर्य के सबसे पास हूँ और केवल 88 दिनों में सूर्य का चक्कर लगाता हूँ। मैं कौन हूँ?",
                "Mercury 🪨" to listOf("Jupiter 🟠", "Mercury 🪨", "Neptune 🔵", "Saturn 🪐")
            ),
            Triple(
                "🕵️ Riddle 3: I am the 8th and farthest planet from the Sun with supersonic winds over 2,000 km/h! Who am I?",
                "पहेली 3: मैं सूर्य से आठवाँ और सबसे दूर का ग्रह हूँ जहाँ सबसे तेज़ हवाएँ चलती हैं। मैं कौन हूँ?",
                "Neptune 🔵" to listOf("Venus 🌕", "Earth 🌍", "Neptune 🔵", "Mars 🔴")
            ),
            Triple(
                "🕵️ Riddle 4: I have the tallest volcano in the Solar System (Olympus Mons) and NASA rovers drive on my red soil! Who am I?",
                "पहेली 4: मुझ पर सबसे ऊँचा ज्वालामुखी ओलंपस मॉन्स है और रोवर मेरी लाल मिट्टी पर चलते हैं। मैं कौन हूँ?",
                "Mars 🔴" to listOf("Mars 🔴", "Saturn 🪐", "Uranus 🧊", "Venus 🌕")
            )
        )
    }
    var step by remember { mutableIntStateOf(0) }
    var status by remember { mutableStateOf<String?>(null) }
    var won by remember { mutableStateOf(false) }

    ActivityCardShell(
        title = "🕵️ Activity 2: Guess the Planet ('Who Am I?')",
        hindiTitle = "अंतरिक्ष पहेली सुलझाएँ!",
        subtitle = "Riddle ${step + 1} of ${riddles.size}"
    ) {
        if (won) {
            ActivitySuccessBanner(
                message = "Bravo, Planet Detective! You solved every planet riddle! (+4 ⭐)",
                onReplay = {
                    step = 0
                    won = false
                    status = null
                }
            )
        } else {
            val r = riddles[step]
            Text(r.first, style = MaterialTheme.typography.titleMedium, color = StarWhite)
            if (showHindi) {
                Spacer(Modifier.height(4.dp))
                Text(r.second, style = MaterialTheme.typography.bodyMedium, color = StarGold)
            }
            Spacer(Modifier.height(12.dp))
            r.third.second.forEach { opt ->
                Surface(
                    color = CosmicPurple,
                    border = BorderStroke(1.5.dp, CardBorderPurple),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable {
                            if (opt == r.third.first) {
                                if (step == riddles.lastIndex) {
                                    won = true
                                    onComplete()
                                } else {
                                    step++
                                    status = "🎉 Correct! Here is the next riddle:"
                                }
                            } else {
                                status = "🔍 Try another planet!"
                            }
                        }
                ) {
                    Text(
                        text = opt,
                        style = MaterialTheme.typography.titleMedium,
                        color = StarWhite,
                        modifier = Modifier.padding(14.dp)
                    )
                }
            }
            status?.let {
                Spacer(Modifier.height(8.dp))
                Text(it, style = MaterialTheme.typography.bodyMedium, color = AuroraGreen)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ArrangePlanetsInOrderActivity(showHindi: Boolean, onComplete: () -> Unit) {
    val correctOrder = remember { PlanetsCatalog.allPlanets.map { "${it.emoji} ${it.name}" } }
    val shuffledOptions = remember {
        listOf(
            "🌍 Earth", "🪨 Mercury", "🪐 Saturn", "🔴 Mars",
            "🌕 Venus", "🔵 Neptune", "🟠 Jupiter", "🧊 Uranus"
        )
    }
    val chosenOrder = remember { mutableStateListOf<String>() }
    var message by remember { mutableStateOf("Tap the planets in order from #1 (closest to the Sun) to #8 (farthest)!") }
    val isComplete = chosenOrder.size == correctOrder.size

    ActivityCardShell(
        title = "☀️ Activity 3: Arrange Planets in Order from the Sun",
        hindiTitle = "सूर्य से दूरी के क्रम (1 से 8) में ग्रहों को चुनें",
        subtitle = "Progress: ${chosenOrder.size} / 8 Planets Placed"
    ) {
        if (isComplete) {
            ActivitySuccessBanner(
                message = "Perfect Order! Mercury → Venus → Earth → Mars → Jupiter → Saturn → Uranus → Neptune! (+4 ⭐)",
                onReplay = {
                    chosenOrder.clear()
                    message = "Tap the planets in order from #1 to #8!"
                }
            )
        } else {
            Text(message, style = MaterialTheme.typography.bodyMedium, color = CyanNebula)
            Spacer(Modifier.height(10.dp))

            // Slots filled so far
            Surface(
                color = SpaceBlack.copy(alpha = 0.6f),
                border = BorderStroke(1.dp, StarGold),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = "☀️ Sun → " + if (chosenOrder.isEmpty()) "(Tap #1 Mercury first!)" else chosenOrder.mapIndexed { i, s -> "${i + 1}. $s" }.joinToString(" → "),
                        style = MaterialTheme.typography.titleMedium,
                        color = StarGold
                    )
                }
            }

            Spacer(Modifier.height(12.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                shuffledOptions.forEach { item ->
                    val alreadyPicked = item in chosenOrder
                    Button(
                        onClick = {
                            if (!alreadyPicked) {
                                val expectedNext = correctOrder[chosenOrder.size]
                                if (item == expectedNext) {
                                    chosenOrder.add(item)
                                    if (chosenOrder.size == correctOrder.size) {
                                        onComplete()
                                    } else {
                                        message = "✅ Great! Now tap planet #${chosenOrder.size + 1} from the Sun!"
                                    }
                                } else {
                                    message = "💡 Remember: 'My Very Educated Mother Just Served Us Noodles!' Which planet is #${chosenOrder.size + 1}?"
                                }
                            }
                        },
                        enabled = !alreadyPicked,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (alreadyPicked) AuroraGreen else CosmicBlue
                        )
                    ) {
                        Text(item)
                    }
                }
            }
        }
    }
}

@Composable
private fun SpaceVocabularyActivity(showHindi: Boolean, onComplete: () -> Unit) {
    val vocabList = LessonsCatalogPart2.spaceVocabulary
    var index by remember { mutableIntStateOf(0) }
    val item = vocabList[index]

    ActivityCardShell(
        title = "📖 Activity 4: Space Vocabulary Explorer",
        hindiTitle = "अंतरिक्ष के महत्वपूर्ण शब्द और उनके अर्थ",
        subtitle = "Word ${index + 1} of ${vocabList.size}"
    ) {
        Surface(
            color = CosmicPurple,
            border = BorderStroke(2.dp, CyanNebula),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = item.emoji, fontSize = 36.sp)
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Text(item.term, style = MaterialTheme.typography.headlineMedium, color = StarGold)
                        Text(item.hindiTerm, style = MaterialTheme.typography.titleMedium, color = CyanNebula)
                    }
                }
                Spacer(Modifier.height(10.dp))
                Text(item.simpleMeaning, style = MaterialTheme.typography.bodyLarge, color = StarWhite)
                if (showHindi) {
                    Spacer(Modifier.height(6.dp))
                    Text("🇮🇳 ${item.hindiMeaning}", style = MaterialTheme.typography.bodyMedium, color = MoonSilver)
                }
                Spacer(Modifier.height(10.dp))
                Surface(
                    color = SpaceBlack.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Example: \"${item.exampleSentence}\"",
                        style = MaterialTheme.typography.bodySmall,
                        color = StarGold,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }

        Spacer(Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = { index = (index - 1 + vocabList.size) % vocabList.size }
            ) {
                Text("← Previous Word")
            }
            Button(
                onClick = {
                    if (index == vocabList.lastIndex) {
                        onComplete()
                    }
                    index = (index + 1) % vocabList.size
                },
                colors = ButtonDefaults.buttonColors(containerColor = MarsOrange)
            ) {
                Text(if (index == vocabList.lastIndex) "Finish Vocabulary (+4 ⭐)" else "Next Word →")
            }
        }
    }
}

@Composable
private fun IdentifyAstronautActivity(showHindi: Boolean, onComplete: () -> Unit) {
    val questions = remember {
        listOf(
            Triple(
                "👨‍🚀 Who was the first human to walk on the Moon on July 20, 1969 during Apollo 11?",
                "20 जुलाई 1969 को चंद्रमा पर कदम रखने वाले पहले इंसान कौन थे?",
                "Neil Armstrong" to listOf("Neil Armstrong", "Galileo", "Isaac Newton")
            ),
            Triple(
                "🇮🇳 Who became the first Indian citizen to fly in space in April 1984?",
                "अप्रैल 1984 में अंतरिक्ष में जाने वाले पहले भारतीय नागरिक कौन बने?",
                "Wing Commander Rakesh Sharma" to listOf("Wing Commander Rakesh Sharma", "Aryabhata", "Vikram Sarabhai")
            ),
            Triple(
                "👩‍🚀 Which inspiring Indian-born NASA astronaut flew on Space Shuttle Columbia and has a lunar hill & satellite series named after her?",
                "किस भारतीय मूल की महिला अंतरिक्ष यात्री ने कोलंबिया स्पेस शटल में उड़ान भरी?",
                "Dr. Kalpana Chawla" to listOf("Dr. Kalpana Chawla", "Marie Curie", "Amelia Earhart")
            ),
            Triple(
                "🎒 Which part of an astronaut's space suit supplies pure breathable oxygen and cooling water during a spacewalk?",
                "स्पेसवॉक के दौरान स्पेस सूट का कौन सा हिस्सा ऑक्सीजन और ठंडक देता है?",
                "The Life Support Backpack (PLSS)" to listOf("The Life Support Backpack (PLSS)", "The Boots", "The Velcro Nose Patch")
            )
        )
    }
    var qIdx by remember { mutableIntStateOf(0) }
    var done by remember { mutableStateOf(false) }
    var msg by remember { mutableStateOf<String?>(null) }

    ActivityCardShell(
        title = "👨‍🚀 Activity 5: Identify the Astronaut & Gear",
        hindiTitle = "महान अंतरिक्ष यात्रियों और उनके उपकरणों को पहचानें",
        subtitle = "Challenge ${qIdx + 1} of ${questions.size}"
    ) {
        if (done) {
            ActivitySuccessBanner(
                message = "Awesome! You identified all famous astronauts and space gear! (+4 ⭐)",
                onReplay = {
                    qIdx = 0
                    done = false
                    msg = null
                }
            )
        } else {
            val item = questions[qIdx]
            Text(item.first, style = MaterialTheme.typography.titleMedium, color = StarWhite)
            if (showHindi) {
                Spacer(Modifier.height(4.dp))
                Text(item.second, style = MaterialTheme.typography.bodyMedium, color = StarGold)
            }
            Spacer(Modifier.height(10.dp))
            item.third.second.forEach { choice ->
                Button(
                    onClick = {
                        if (choice == item.third.first) {
                            if (qIdx == questions.lastIndex) {
                                done = true
                                onComplete()
                            } else {
                                qIdx++
                                msg = "✅ Correct!"
                            }
                        } else {
                            msg = "💡 Try again!"
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = CosmicBlue),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(choice)
                }
            }
            msg?.let {
                Spacer(Modifier.height(6.dp))
                Text(it, style = MaterialTheme.typography.bodyMedium, color = AuroraGreen)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FindCorrectSpaceObjectActivity(showHindi: Boolean, onComplete: () -> Unit) {
    val objects = remember {
        listOf(
            Triple("☄️ Comet", "Find the icy cosmic snowball that grows a glowing tail near the Sun!", "धूमकेतु (Comet) को खोजें!"),
            Triple("🔭 Space Telescope", "Find the instrument that orbits above Earth's clouds to photograph deep galaxies!", "स्पेस टेलीस्कोप को खोजें!"),
            Triple("🤖 Mars Rover", "Find the 6-wheeled robot that drives across the Red Planet!", "मार्स रोवर को खोजें!"),
            Triple("🌈 Nebula", "Find the colorful cosmic cloud where new baby stars are born!", "तारों की नर्सरी (Nebula) को खोजें!")
        )
    }
    val allTiles = remember {
        listOf("☄️ Comet", "🔭 Space Telescope", "🤖 Mars Rover", "🌈 Nebula", "🪨 Asteroid", "🛰️ GPS Satellite")
    }
    var targetIdx by remember { mutableIntStateOf(0) }
    var finished by remember { mutableStateOf(false) }
    var status by remember { mutableStateOf<String?>(null) }

    ActivityCardShell(
        title = "🔭 Activity 6: Find the Correct Space Object",
        hindiTitle = "सही अंतरिक्ष वस्तु पर टैप करें!",
        subtitle = "Target ${targetIdx + 1} of ${objects.size}"
    ) {
        if (finished) {
            ActivitySuccessBanner(
                message = "Sharp eyes, Astronomer! You spotted every space object! (+4 ⭐)",
                onReplay = {
                    targetIdx = 0
                    finished = false
                    status = null
                }
            )
        } else {
            val target = objects[targetIdx]
            Text(target.second, style = MaterialTheme.typography.titleMedium, color = StarWhite)
            if (showHindi) {
                Text(target.third, style = MaterialTheme.typography.bodyMedium, color = StarGold)
            }
            Spacer(Modifier.height(12.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                allTiles.forEach { tile ->
                    Surface(
                        color = CosmicPurple,
                        border = BorderStroke(1.5.dp, CyanNebula),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.clickable {
                            if (tile == target.first) {
                                if (targetIdx == objects.lastIndex) {
                                    finished = true
                                    onComplete()
                                } else {
                                    targetIdx++
                                    status = "✅ Found it! Now spot the next object:"
                                }
                            } else {
                                status = "🔍 That's $tile — look closely for the target!"
                            }
                        }
                    ) {
                        Text(
                            text = tile,
                            style = MaterialTheme.typography.titleMedium,
                            color = StarWhite,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp)
                        )
                    }
                }
            }
            status?.let {
                Spacer(Modifier.height(8.dp))
                Text(it, style = MaterialTheme.typography.bodyMedium, color = AuroraGreen)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun PlanetMemoryChallengeActivity(showHindi: Boolean, onComplete: () -> Unit) {
    val deck = remember {
        listOf(
            "🌍 Earth", "🌍 Earth",
            "🔴 Mars", "🔴 Mars",
            "🪐 Saturn", "🪐 Saturn",
            "🟠 Jupiter", "🟠 Jupiter"
        ).shuffled()
    }
    val matchedIndices = remember { mutableStateListOf<Int>() }
    var firstFlipped by remember { mutableStateOf<Int?>(null) }
    var secondFlipped by remember { mutableStateOf<Int?>(null) }

    val allMatched = matchedIndices.size == deck.size

    ActivityCardShell(
        title = "🧠 Activity 7: Planet Memory Challenge",
        hindiTitle = "समान ग्रहों के जोड़े (Pairs) खोजें!",
        subtitle = "${matchedIndices.size / 2} / 4 Pairs Matched"
    ) {
        if (allMatched) {
            ActivitySuccessBanner(
                message = "Incredible memory! You matched all 4 planet pairs! (+4 ⭐)",
                onReplay = {
                    matchedIndices.clear()
                    firstFlipped = null
                    secondFlipped = null
                }
            )
        } else {
            Text(
                text = "Tap two cards to flip them and match the planet pairs!",
                style = MaterialTheme.typography.bodyMedium,
                color = MoonSilver
            )
            Spacer(Modifier.height(12.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                deck.forEachIndexed { idx, label ->
                    val isMatched = idx in matchedIndices
                    val isFaceUp = isMatched || firstFlipped == idx || secondFlipped == idx
                    Surface(
                        color = when {
                            isMatched -> AuroraGreen.copy(alpha = 0.3f)
                            isFaceUp -> MarsOrange
                            else -> CosmicPurple
                        },
                        border = BorderStroke(1.5.dp, if (isMatched) AuroraGreen else StarGold),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .width(140.dp)
                            .height(68.dp)
                            .clickable {
                                if (isMatched || firstFlipped == idx) return@clickable
                                if (firstFlipped == null) {
                                    firstFlipped = idx
                                } else if (secondFlipped == null) {
                                    secondFlipped = idx
                                    val firstIdx = firstFlipped!!
                                    if (deck[firstIdx] == deck[idx]) {
                                        matchedIndices.add(firstIdx)
                                        matchedIndices.add(idx)
                                        firstFlipped = null
                                        secondFlipped = null
                                        if (matchedIndices.size == deck.size) {
                                            onComplete()
                                        }
                                    }
                                } else {
                                    firstFlipped = idx
                                    secondFlipped = null
                                }
                            }
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = if (isFaceUp) label else "🚀 ?",
                                style = MaterialTheme.typography.titleMedium,
                                color = StarWhite
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ActivityCardShell(
    title: String,
    hindiTitle: String,
    subtitle: String,
    content: @Composable () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
        border = BorderStroke(2.dp, CyanNebula),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(title, style = MaterialTheme.typography.titleLarge, color = StarGold)
                    Text(hindiTitle, style = MaterialTheme.typography.bodySmall, color = CyanNebula)
                }
                Text(subtitle, style = MaterialTheme.typography.labelLarge, color = AuroraGreen)
            }
            Spacer(Modifier.height(14.dp))
            content()
        }
    }
}

@Composable
private fun ActivitySuccessBanner(message: String, onReplay: () -> Unit) {
    Surface(
        color = AuroraGreen.copy(alpha = 0.2f),
        border = BorderStroke(1.5.dp, AuroraGreen),
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("🏆", fontSize = 40.sp)
            Spacer(Modifier.height(6.dp))
            Text(
                text = message,
                style = MaterialTheme.typography.titleMedium,
                color = StarWhite,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(12.dp))
            Button(
                onClick = onReplay,
                colors = ButtonDefaults.buttonColors(containerColor = MarsOrange)
            ) {
                Icon(Icons.Default.Refresh, contentDescription = null)
                Spacer(Modifier.width(6.dp))
                Text("Play Again")
            }
        }
    }
}

// ==================== QUIZ CENTER SCREEN ====================
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun QuizCenterScreen(
    preselectedModuleId: String?,
    showHindi: Boolean,
    onQuizCompleted: (moduleId: String, moduleTitle: String, difficulty: String, score: Int, total: Int, stars: Int) -> Unit
) {
    val scrollState = rememberScrollState()
    var selectedModuleFilter by remember(preselectedModuleId) { mutableStateOf(preselectedModuleId ?: "all") }
    var selectedDifficultyFilter by remember { mutableStateOf<QuizDifficulty?>(null) }

    val filteredQuestions = remember(selectedModuleFilter, selectedDifficultyFilter) {
        QuizzesCatalog.allQuestions.filter { q ->
            val modMatch = selectedModuleFilter == "all" || q.moduleId == selectedModuleFilter
            val diffMatch = selectedDifficultyFilter == null || q.difficulty == selectedDifficultyFilter
            modMatch && diffMatch
        }.ifEmpty { QuizzesCatalog.allQuestions.take(10) }
    }

    var currentIndex by remember(filteredQuestions) { mutableIntStateOf(0) }
    var selectedOption by remember(filteredQuestions, currentIndex) { mutableStateOf<Int?>(null) }
    var answerLocked by remember(filteredQuestions, currentIndex) { mutableStateOf(false) }
    var score by remember(filteredQuestions) { mutableIntStateOf(0) }
    var earnedStars by remember(filteredQuestions) { mutableIntStateOf(0) }
    var quizFinished by remember(filteredQuestions) { mutableStateOf(false) }

    val currentQuestion: QuizQuestion = filteredQuestions[currentIndex.coerceIn(0, filteredQuestions.lastIndex)]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Quiz Center Filter Header
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(2.dp, StarGold),
            shape = RoundedCornerShape(26.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text(
                    text = "🏆 Space Knowledge Quiz Center (80 Questions!)",
                    style = MaterialTheme.typography.headlineSmall,
                    color = StarGold
                )
                if (showHindi) {
                    Text(
                        text = "अपना मॉड्यूल और कठिनाई स्तर चुनें (10 प्रश्न प्रति मॉड्यूल)",
                        style = MaterialTheme.typography.bodySmall,
                        color = CyanNebula
                    )
                }

                Spacer(Modifier.height(10.dp))
                Text("Select Learning Module:", style = MaterialTheme.typography.labelLarge, color = StarWhite)
                Spacer(Modifier.height(6.dp))
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    FilterChip(
                        selected = selectedModuleFilter == "all",
                        onClick = { selectedModuleFilter = "all" },
                        label = { Text("🌟 All Modules (80 Qs)") }
                    )
                    LessonsCatalogPart2.allModules.forEach { mod ->
                        FilterChip(
                            selected = selectedModuleFilter == mod.id,
                            onClick = { selectedModuleFilter = mod.id },
                            label = { Text("${mod.emoji} M${mod.number}: ${mod.title}") },
                            modifier = Modifier.testTag("quiz_filter_${mod.id}")
                        )
                    }
                }

                Spacer(Modifier.height(8.dp))
                Text("Select Difficulty:", style = MaterialTheme.typography.labelLarge, color = StarWhite)
                Spacer(Modifier.height(6.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(
                        selected = selectedDifficultyFilter == null,
                        onClick = { selectedDifficultyFilter = null },
                        label = { Text("All Levels") }
                    )
                    QuizDifficulty.entries.forEach { diff ->
                        FilterChip(
                            selected = selectedDifficultyFilter == diff,
                            onClick = { selectedDifficultyFilter = diff },
                            label = { Text("${diff.label} (+${diff.starsReward}⭐)") }
                        )
                    }
                }
            }
        }

        if (quizFinished) {
            // Quiz Summary & Reward Screen
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1A2F3B)),
                border = BorderStroke(2.dp, AuroraGreen),
                shape = RoundedCornerShape(26.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Default.EmojiEvents, contentDescription = null, tint = StarGold, modifier = Modifier.size(64.dp))
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Mission Quiz Complete!",
                        style = MaterialTheme.typography.displaySmall,
                        color = StarWhite
                    )
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = "Your Score: $score / ${filteredQuestions.size}",
                        style = MaterialTheme.typography.headlineMedium,
                        color = AuroraGreen
                    )
                    Text(
                        text = "Stars Earned: +$earnedStars ⭐",
                        style = MaterialTheme.typography.titleLarge,
                        color = StarGold
                    )
                    Spacer(Modifier.height(16.dp))
                    Button(
                        onClick = {
                            currentIndex = 0
                            score = 0
                            earnedStars = 0
                            selectedOption = null
                            answerLocked = false
                            quizFinished = false
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = MarsOrange),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("Play Quiz Again")
                    }
                }
            }
        } else {
            // Active Question Card
            Card(
                colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
                border = BorderStroke(2.dp, ElectricPurple),
                shape = RoundedCornerShape(26.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            color = MarsOrange.copy(alpha = 0.2f),
                            border = BorderStroke(1.dp, MarsOrange),
                            shape = RoundedCornerShape(50)
                        ) {
                            Text(
                                text = "${currentQuestion.type.label} • ${currentQuestion.difficulty.label} (+${currentQuestion.difficulty.starsReward}⭐)",
                                style = MaterialTheme.typography.labelLarge,
                                color = StarGold,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
                            )
                        }
                        Text(
                            text = "Q ${currentIndex + 1}/${filteredQuestions.size} • Score: $score",
                            style = MaterialTheme.typography.titleSmall,
                            color = CyanNebula
                        )
                    }

                    LinearProgressIndicator(
                        progress = { (currentIndex + 1).toFloat() / filteredQuestions.size.toFloat() },
                        color = StarGold,
                        trackColor = SpaceBlack,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(50))
                    )

                    // Visual Picture Clue Banner
                    Surface(
                        color = CosmicPurple,
                        border = BorderStroke(1.dp, CyanNebula.copy(alpha = 0.6f)),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = currentQuestion.visualEmoji, fontSize = 36.sp)
                            Spacer(Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = currentQuestion.moduleTitle,
                                    style = MaterialTheme.typography.labelMedium,
                                    color = CyanNebula
                                )
                                Text(
                                    text = currentQuestion.visualCaption,
                                    style = MaterialTheme.typography.titleSmall,
                                    color = StarGold
                                )
                            }
                        }
                    }

                    Text(
                        text = currentQuestion.question,
                        style = MaterialTheme.typography.headlineSmall,
                        color = StarWhite
                    )
                    if (showHindi) {
                        Text(
                            text = currentQuestion.hindiQuestion,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MoonSilver
                        )
                    }

                    currentQuestion.options.forEachIndexed { idx, opt ->
                        val isChosen = selectedOption == idx
                        val isRight = idx == currentQuestion.correctIndex
                        val bg = when {
                            answerLocked && isRight -> AuroraGreen.copy(alpha = 0.28f)
                            answerLocked && isChosen && !isRight -> DangerRed.copy(alpha = 0.28f)
                            else -> CosmicPurple
                        }
                        val border = when {
                            answerLocked && isRight -> AuroraGreen
                            answerLocked && isChosen && !isRight -> DangerRed
                            else -> CardBorderPurple
                        }

                        Surface(
                            color = bg,
                            border = BorderStroke(1.5.dp, border),
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(enabled = !answerLocked) {
                                    selectedOption = idx
                                    answerLocked = true
                                    if (idx == currentQuestion.correctIndex) {
                                        score++
                                        earnedStars += currentQuestion.difficulty.starsReward
                                    }
                                }
                                .testTag("quiz_center_option_$idx")
                        ) {
                            Row(
                                modifier = Modifier.padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clip(CircleShape)
                                        .background(if (answerLocked && isRight) AuroraGreen else MarsOrange),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "${('A' + idx)}",
                                        style = MaterialTheme.typography.labelLarge,
                                        color = StarWhite
                                    )
                                }
                                Spacer(Modifier.width(12.dp))
                                Text(
                                    text = opt,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = StarWhite
                                )
                            }
                        }
                    }

                    if (answerLocked) {
                        val wasRight = selectedOption == currentQuestion.correctIndex
                        Surface(
                            color = if (wasRight) AuroraGreen.copy(alpha = 0.16f) else MarsOrange.copy(alpha = 0.16f),
                            border = BorderStroke(1.dp, if (wasRight) AuroraGreen else MarsOrange),
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Text(
                                    text = if (wasRight) "🎉 Spot On! (+${currentQuestion.difficulty.starsReward} ⭐)" else "💡 Scientific Explanation:",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = if (wasRight) AuroraGreen else StarGold
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = currentQuestion.explanation,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = StarWhite
                                )
                                if (showHindi) {
                                    Spacer(Modifier.height(4.dp))
                                    Text(
                                        text = currentQuestion.hindiExplanation,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MoonSilver
                                    )
                                }
                            }
                        }

                        Button(
                            onClick = {
                                if (currentIndex < filteredQuestions.lastIndex) {
                                    currentIndex++
                                } else {
                                    quizFinished = true
                                    onQuizCompleted(
                                        selectedModuleFilter,
                                        currentQuestion.moduleTitle,
                                        selectedDifficultyFilter?.label ?: "Mixed",
                                        score,
                                        filteredQuestions.size,
                                        earnedStars
                                    )
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = MarsOrange),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp)
                                .testTag("quiz_next_question_button")
                        ) {
                            Text(
                                text = if (currentIndex < filteredQuestions.lastIndex) "Next Question" else "Finish Quiz & Claim Stars ⭐",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(Modifier.width(8.dp))
                            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(24.dp))
    }
}
