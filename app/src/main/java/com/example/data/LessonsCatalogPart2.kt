package com.example.data

import com.example.model.AcademyPage
import com.example.model.AchievementBadge
import com.example.model.LearningModule
import com.example.model.Lesson
import com.example.model.LessonMiniQuiz
import com.example.model.MoonPhaseInfo
import com.example.model.NasaResource
import com.example.model.SceneAnimationType
import com.example.model.SpaceFact
import com.example.model.SpaceVocabItem
import com.example.ui.theme.AuroraGreen
import com.example.ui.theme.CosmicBlue
import com.example.ui.theme.CyanNebula
import com.example.ui.theme.ElectricPurple
import com.example.ui.theme.GalaxyPink
import com.example.ui.theme.MarsOrange
import com.example.ui.theme.RocketAmber
import com.example.ui.theme.StarGold

object LessonsCatalogPart2 {

    val module6Lessons = listOf(
        Lesson(
            id = "m6_l1",
            moduleId = "mod_6",
            moduleName = "Module 6: Astronaut Life",
            lessonNumber = 1,
            title = "Who is an Astronaut?",
            hindiTitle = "अंतरिक्ष यात्री (Astronaut) कौन होते हैं?",
            emoji = "👨‍🚀",
            simpleExplanation = listOf(
                "The word 'Astronaut' comes from Greek words meaning 'Star Sailor'! An astronaut is a specially trained scientist, pilot, doctor, or engineer who travels into outer space.",
                "Astronauts conduct science experiments in microgravity (weightlessness), repair space telescopes, grow space plants, and test technologies for the Moon and Mars.",
                "Famous astronauts from around the world include Yuri Gagarin (first human in space), Neil Armstrong, Kalpana Chawla, Sunita Williams, and Rakesh Sharma (India's first astronaut in space)!"
            ),
            everydayExample = "An astronaut is like an explorer, scientist, mechanic, and pilot all rolled into one — working in a laboratory that flies at 28,000 km/h above Earth!",
            hindiExplanation = "'एस्ट्रोनॉट' (Astronaut) का अर्थ है 'तारों का नाविक'! अंतरिक्ष यात्री वे प्रशिक्षित वैज्ञानिक, पायलट या इंजीनियर होते हैं जो अंतरिक्ष में जाकर खोज और वैज्ञानिक प्रयोग करते हैं — जैसे राकेश शर्मा, कल्पना चावला, सुनीता विलियम्स और नील आर्मस्ट्रांग!",
            importantFacts = listOf(
                "Yuri Gagarin became the first human in space on April 12, 1961.",
                "Wing Commander Rakesh Sharma became the first Indian citizen in space in 1984.",
                "In India's Gaganyaan program, Indian astronauts are also called 'Vyomanauts' (Sky Sailors)!"
            ),
            whatDidYouLearn = listOf(
                "Astronaut means 'Star Sailor'.",
                "Astronauts are scientists, engineers, doctors, and pilots who work in space.",
                "Anyone who studies hard in science, math, and teamwork can dream of becoming an astronaut!"
            ),
            sceneType = SceneAnimationType.ASTRONAUT_FLOAT,
            miniQuiz = LessonMiniQuiz(
                question = "What does the word 'Astronaut' literally mean in Greek?",
                hindiQuestion = "ग्रीक भाषा में 'Astronaut' शब्द का असली अर्थ क्या है?",
                options = listOf("Star Sailor", "Rocket Driver", "Moon jumper", "Cloud walker"),
                correctIndex = 0,
                explanation = "Correct! 'Astro' means star and 'naut' means sailor — so an astronaut is a Star Sailor!",
                hindiExplanation = "बिल्कुल सही! 'Astro' का अर्थ तारा और 'naut' का अर्थ नाविक होता है, यानी 'तारों का नाविक'!"
            )
        ),
        Lesson(
            id = "m6_l2",
            moduleId = "mod_6",
            moduleName = "Module 6: Astronaut Life",
            lessonNumber = 2,
            title = "How Astronauts Train on Earth",
            hindiTitle = "अंतरिक्ष यात्री प्रशिक्षण कैसे लेते हैं?",
            emoji = "🏊",
            simpleExplanation = listOf(
                "Before flying to space, astronauts train for years! How do you practice floating in weightlessness while you are still on Earth?",
                "Astronauts practice spacewalks underwater inside a giant swimming pool called the Neutral Buoyancy Laboratory (NBL)! Floating in water feels very similar to floating in space.",
                "They also fly in special airplanes that dive in waves to create 25 seconds of real weightlessness, use virtual reality simulators, and exercise 2 hours every day to keep their bones and muscles strong!"
            ),
            everydayExample = "Have you ever floated in a swimming pool where you neither sink nor rise? NASA uses a giant pool holding a full-size model of the Space Station so astronauts can practice fixing it underwater!",
            hindiExplanation = "अंतरिक्ष में जाने से पहले अंतरिक्ष यात्री कई सालों तक कड़ा अभ्यास करते हैं। वे एक विशाल स्विमिंग पूल (Neutral Buoyancy Lab) में पानी के नीचे तैरकर स्पेसवॉक का अभ्यास करते हैं, क्योंकि पानी में तैरना अंतरिक्ष के भारहीनता (Zero Gravity) जैसा महसूस होता है!",
            importantFacts = listOf(
                "NASA's Neutral Buoyancy Lab pool in Houston holds 23.5 million liters (6.2 million gallons) of water!",
                "Astronauts learn emergency survival skills, robotics, medical first aid, and multiple languages.",
                "In space, astronauts exercise 2 hours daily on strapped-in treadmills so their muscles stay strong."
            ),
            whatDidYouLearn = listOf(
                "Astronauts train underwater in giant pools to simulate weightlessness.",
                "They use flight simulators and virtual reality to practice every mission step.",
                "Daily exercise is super important for keeping bones and muscles healthy in space."
            ),
            sceneType = SceneAnimationType.ASTRONAUT_FLOAT,
            miniQuiz = LessonMiniQuiz(
                question = "Where do astronauts practice for spacewalks while still on Earth?",
                hindiQuestion = "पृथ्वी पर रहते हुए अंतरिक्ष यात्री 'स्पेसवॉक' (अंतरिक्ष में चलने) का अभ्यास कहाँ करते हैं?",
                options = listOf(
                    "Underwater in a giant swimming pool",
                    "On top of a trampoline",
                    "Inside a hot desert",
                    "On a roller coaster"
                ),
                correctIndex = 0,
                explanation = "Spot on! Practicing underwater in a giant pool mimics the weightless feeling of floating in space.",
                hindiExplanation = "सही जवाब! विशाल स्विमिंग पूल में पानी के नीचे अभ्यास करने से अंतरिक्ष में तैरने जैसा अनुभव मिलता है।"
            )
        ),
        Lesson(
            id = "m6_l3",
            moduleId = "mod_6",
            moduleName = "Module 6: Astronaut Life",
            lessonNumber = 3,
            title = "What Astronauts Eat in Space",
            hindiTitle = "अंतरिक्ष यात्री क्या खाते हैं?",
            emoji = "🌮",
            simpleExplanation = listOf(
                "In microgravity, if you pour milk into a bowl of cereal, the milk and cereal balls will float away all over the room! So how do astronauts eat?",
                "Astronauts eat delicious freeze-dried meals (like mac & cheese, curry, scrambled eggs, and fruit) stored in sealed pouches. They add warm water through a tube and eat with spoons!",
                "Instead of bread (which makes floating crumbs that can get stuck in air filters or eyes!), astronauts use soft TORTILLAS to make space tacos and peanut butter wraps!"
            ),
            everydayExample = "Try making a sandwich using a soft roti or tortilla instead of crumbly toast — no crumbs fly around! That's why astronauts love tortillas and rotis in space!",
            hindiExplanation = "अंतरिक्ष में हर चीज़ हवा में तैरती है! इसलिए अंतरिक्ष यात्री ब्रेड की जगह 'टॉर्टिला' (रोटी) खाते हैं ताकि टुकड़े (Crumbs) हवा में न उड़ें। नमक और काली मिर्च भी तरल (Liquid) रूप में होती है!",
            importantFacts = listOf(
                "Salt and pepper in space come in liquid drops so grains don't float into astronauts' noses!",
                "Drinks like orange juice, tea, and water are sipped from sealed pouches using straws with clips.",
                "Astronauts on the International Space Station have grown and eaten fresh space lettuce and chili peppers!"
            ),
            whatDidYouLearn = listOf(
                "Astronauts use tortillas instead of crumbly bread in space.",
                "Salt and pepper are dissolved in liquid drops.",
                "Drinks are sipped through straws from sealed pouches so droplets don't float away."
            ),
            sceneType = SceneAnimationType.ASTRONAUT_FLOAT,
            miniQuiz = LessonMiniQuiz(
                question = "Why do astronauts prefer soft tortillas instead of regular bread in space?",
                hindiQuestion = "अंतरिक्ष यात्री ब्रेड की जगह टॉर्टिला (रोटी) खाना क्यों पसंद करते हैं?",
                options = listOf(
                    "Because tortillas don't make floating crumbs that could get into equipment or eyes",
                    "Because bread is too heavy for rockets",
                    "Because tortillas glow in the dark",
                    "Because bread melts in space"
                ),
                correctIndex = 0,
                explanation = "You got it! Floating bread crumbs can clog air vents or float into an astronaut's eye, whereas tortillas are crumb-free!",
                hindiExplanation = "बिल्कुल सही! ब्रेड के छोटे टुकड़े हवा में तैरकर मशीनों या आँखों में जा सकते हैं, जबकि टॉर्टिला से टुकड़े नहीं गिरते।"
            )
        ),
        Lesson(
            id = "m6_l4",
            moduleId = "mod_6",
            moduleName = "Module 6: Astronaut Life",
            lessonNumber = 4,
            title = "How Astronauts Sleep in Space",
            hindiTitle = "अंतरिक्ष यात्री कैसे सोते हैं?",
            emoji = "😴",
            simpleExplanation = listOf(
                "In space, there is no 'up' or 'down', and you don't need a soft mattress because your body floats weightlessly!",
                "If an astronaut just closed their eyes without tying themselves down, air currents from the fans would gently push them floating into walls and computers while they slept.",
                "So astronauts sleep inside cozy SLEEPING BAGS strapped to the wall, ceiling, or floor inside a small phone-booth-sized cabin! They even zip their arms inside or let them float gently in front of them."
            ),
            everydayExample = "Imagine zipping yourself into a warm camping sleeping bag hung up on the wall like a coat — and feeling as comfy as floating on a cloud!",
            hindiExplanation = "अंतरिक्ष में गुरुत्वाकर्षण न होने के कारण ऊपर या नीचे कुछ नहीं होता। सोते समय तैरकर दीवारों से न टकराएँ, इसके लिए अंतरिक्ष यात्री दीवार से बँधे हुए 'स्लीपिंग बैग' (Sleeping Bag) के अंदर ज़िप लगाकर सोते हैं!",
            importantFacts = listOf(
                "The International Space Station orbits Earth every 90 minutes, so astronauts see 16 sunrises and 16 sunsets every single day!",
                "Astronauts wear sleep masks to block the bright sunrises and schedule 8 hours of sleep per night.",
                "Air fans must always blow gently near an astronaut's head while sleeping so they breathe fresh oxygen."
            ),
            whatDidYouLearn = listOf(
                "Astronauts sleep in sleeping bags attached to the cabin walls.",
                "They see 16 sunrises and 16 sunsets every 24 hours in orbit!",
                "Without gravity, you can sleep upright, upside down, or sideways comfortably."
            ),
            sceneType = SceneAnimationType.ASTRONAUT_FLOAT,
            miniQuiz = LessonMiniQuiz(
                question = "Why do astronauts attach their sleeping bags to the wall in space?",
                hindiQuestion = "अंतरिक्ष यात्री अपने स्लीपिंग बैग को दीवार से क्यों बाँधते हैं?",
                options = listOf(
                    "So they don't float around and bump into things while sleeping",
                    "Because the floor is covered in water",
                    "To stay away from space bugs",
                    "Because beds are not allowed"
                ),
                correctIndex = 0,
                explanation = "Correct! Tying the sleeping bag to the wall keeps astronauts safely in one spot while they sleep.",
                hindiExplanation = "सही उत्तर! स्लीपिंग बैग को दीवार से बाँधने से वे नींद में इधर-उधर तैरकर चीज़ों से नहीं टकराते।"
            )
        ),
        Lesson(
            id = "m6_l5",
            moduleId = "mod_6",
            moduleName = "Module 6: Astronaut Life",
            lessonNumber = 5,
            title = "Space Suits: Personal Spacecraft",
            hindiTitle = "स्पेस सूट: एक छोटा अंतरिक्ष यान",
            emoji = "🥽",
            simpleExplanation = listOf(
                "When astronauts go outside their spacecraft for a spacewalk, or walk on the Moon or Mars, they wear a high-tech SPACE SUIT. A space suit is actually a miniature one-person spacecraft!",
                "Outer space has no air, freezing cold in the shade (-150°C), boiling heat in the sun (+120°C), and tiny fast-moving space dust (micrometeoroids).",
                "A space suit has up to 16 protective layers, a gold-coated helmet visor (like super sunglasses), a backpack with pure oxygen, drinking water, a radio, and water-cooling tubes to keep the astronaut comfortable!"
            ),
            everydayExample = "A space suit is like wearing a winter coat, a scuba diving tank, bulletproof armor, air conditioning, sunglasses, and a walkie-talkie all at the same time!",
            hindiExplanation = "स्पेस सूट (Space Suit) केवल कपड़े नहीं, बल्कि एक इंसान के आकार का छोटा अंतरिक्ष यान है! यह अंतरिक्ष यात्री को ऑक्सीजन, सही दबाव, भयंकर ठंड व गर्मी से सुरक्षा, पीने का पानी और पृथ्वी से बात करने के लिए रेडियो प्रदान करता है।",
            importantFacts = listOf(
                "Most space suits are bright WHITE because white reflects the Sun's intense heat best!",
                "During launch and landing, astronauts wear bright ORANGE suits because orange is easiest for rescue teams to spot in the ocean.",
                "Inside the helmet, there is a small Velcro patch so astronauts can scratch their nose if it itches!"
            ),
            whatDidYouLearn = listOf(
                "A space suit acts as a personal one-person spacecraft.",
                "Spacewalk suits are white to reflect heat and have a gold visor to protect eyes.",
                "The backpack (Life Support System) supplies oxygen, temperature control, and radio."
            ),
            sceneType = SceneAnimationType.ASTRONAUT_FLOAT,
            miniQuiz = LessonMiniQuiz(
                question = "Why are spacewalk suits colored bright WHITE?",
                hindiQuestion = "अंतरिक्ष में पहने जाने वाले स्पेस सूट का रंग सफेद (White) क्यों होता है?",
                options = listOf(
                    "White reflects the Sun's strong heat and stands out against black space",
                    "Because white paint is cheapest",
                    "To hide in the clouds",
                    "Because astronauts only like white"
                ),
                correctIndex = 0,
                explanation = "Spot on! White reflects solar radiation to keep astronauts cool and makes them easy to see against dark space.",
                hindiExplanation = "शाबाश! सफेद रंग सूर्य की तेज़ गर्मी को परावर्तित (Reflect) करता है और काले अंतरिक्ष में साफ दिखाई देता है।"
            )
        ),
        Lesson(
            id = "m6_l6",
            moduleId = "mod_6",
            moduleName = "Module 6: Astronaut Life",
            lessonNumber = 6,
            title = "How Astronauts Breathe in Space",
            hindiTitle = "अंतरिक्ष यात्री अंतरिक्ष में साँस कैसे लेते हैं?",
            emoji = "🫁",
            simpleExplanation = listOf(
                "Since there is no air in outer space, how do astronauts breathe comfortably inside the International Space Station for months at a time without helmets?",
                "Inside the Space Station, machines keep the cabin filled with normal air at the same pressure as Earth! Even cooler, they make fresh OXYGEN from WATER using electricity from solar panels (a process called Electrolysis).",
                "Special air scrubbers remove the carbon dioxide that astronauts breathe out, and every drop of moisture in the air is recycled back into clean water!"
            ),
            everydayExample = "Water (H2O) is made of Hydrogen and Oxygen atoms stuck together like LEGO bricks. Space station machines use solar electricity to unsnap those LEGO bricks so astronauts can breathe the Oxygen!",
            hindiExplanation = "स्पेस स्टेशन के अंदर हवा भरी होती है, इसलिए वहाँ हेलमेट पहनने की ज़रूरत नहीं होती। वहाँ की मशीनें सौर ऊर्जा (बिजली) की मदद से पानी (H2O) को तोड़कर ताज़ी ऑक्सीजन गैस बनाती हैं! इस प्रक्रिया को 'इलेक्ट्रोलिसिस' कहते हैं।",
            importantFacts = listOf(
                "Splitting water (H2O) into Hydrogen and Oxygen using electricity is called Electrolysis.",
                "The Space Station recycles more than 90% of all water — including sweat and breath moisture!",
                "Cargo spacecraft also bring backup tanks of air and water from Earth."
            ),
            whatDidYouLearn = listOf(
                "Inside a spacecraft cabin, astronauts breathe normal air without helmets.",
                "Machines split water (H2O) into breathable oxygen using solar electricity.",
                "Air filters remove carbon dioxide to keep the cabin air fresh."
            ),
            sceneType = SceneAnimationType.ASTRONAUT_FLOAT,
            miniQuiz = LessonMiniQuiz(
                question = "How does the International Space Station make most of its breathable oxygen?",
                hindiQuestion = "अंतर्राष्ट्रीय अंतरिक्ष स्टेशन (ISS) साँस लेने के लिए ऑक्सीजन मुख्य रूप से कैसे बनाता है?",
                options = listOf(
                    "By splitting water (H2O) into hydrogen and oxygen using solar electricity",
                    "By opening a window to let space air in",
                    "With giant bellows",
                    "Astronauts hold their breath for months"
                ),
                correctIndex = 0,
                explanation = "Brilliant! Using electrolysis, solar electricity splits water molecules (H2O) to release pure breathable oxygen.",
                hindiExplanation = "शानदार! सौर बिजली की मदद से पानी (H2O) को विभाजित करके ताज़ी ऑक्सीजन बनाई जाती है।"
            )
        ),
        Lesson(
            id = "m6_l7",
            moduleId = "mod_6",
            moduleName = "Module 6: Astronaut Life",
            lessonNumber = 7,
            title = "How Astronauts Communicate with Earth",
            hindiTitle = "अंतरिक्ष यात्री पृथ्वी से बात कैसे करते हैं?",
            emoji = "📡",
            simpleExplanation = listOf(
                "Sound waves cannot travel through empty space, so even if you shouted as loud as a lion, nobody outside your spacecraft would hear you! So how do astronauts talk to Mission Control and their families?",
                "They use RADIO WAVES and LASER BEAMS! Unlike sound, radio waves are a form of light (electromagnetic waves) that travel effortlessly through the vacuum of space at 300,000 kilometers per second!",
                "When an astronaut speaks into their microphone, the spacecraft turns their voice into radio signals, beams them to tracking satellites and NASA's Deep Space Network giant dish antennas on Earth, and turns them back into sound!"
            ),
            everydayExample = "It works just like your Wi-Fi or walkie-talkie! Your voice is turned into invisible radio waves that zoom at the speed of light to antennas on Earth.",
            hindiExplanation = "चूँकि आवाज़ अंतरिक्ष के निर्वात (Vacuum) में नहीं चल सकती, इसलिए अंतरिक्ष यात्री 'रेडियो तरंगों' (Radio Waves) का उपयोग करते हैं। रेडियो तरंगें प्रकाश की गति (3,00,000 किमी/सेकंड) से अंतरिक्ष को पार करके पृथ्वी के बड़े एंटीना तक पहुँचती हैं!",
            importantFacts = listOf(
                "Radio waves travel at the speed of light: 300,000 km per second!",
                "Talking to the Moon has a 1.3-second delay one way; talking to Mars has a 4-to-22-minute delay one way!",
                "NASA's Deep Space Network has giant radio dishes in California, Spain, and Australia so Earth never loses contact as it spins."
            ),
            whatDidYouLearn = listOf(
                "Astronauts use radio waves and laser communication because sound cannot travel through space.",
                "Radio waves travel at the speed of light.",
                "Giant antennas on Earth (Deep Space Network) talk to spacecraft across the Solar System."
            ),
            sceneType = SceneAnimationType.ROCKET_BLASTOFF,
            miniQuiz = LessonMiniQuiz(
                question = "How do astronauts send their voices through empty space back to Earth?",
                hindiQuestion = "अंतरिक्ष यात्री खाली अंतरिक्ष के पार अपनी आवाज़ पृथ्वी तक कैसे भेजते हैं?",
                options = listOf(
                    "Using radio waves that travel at the speed of light",
                    "Using a very long telephone wire",
                    "By shouting through a megaphone",
                    "By dropping paper notes from orbit"
                ),
                correctIndex = 0,
                explanation = "Correct! Microphones convert sound into radio waves, which travel through space at the speed of light to antennas on Earth.",
                hindiExplanation = "बिल्कुल सही! आवाज़ को रेडियो तरंगों (Radio Waves) में बदला जाता है जो प्रकाश की गति से पृथ्वी तक पहुँचती हैं।"
            )
        )
    )

    val module7Lessons = listOf(
        Lesson(
            id = "m7_l1",
            moduleId = "mod_7",
            moduleName = "Module 7: Rockets & Space Technology",
            lessonNumber = 1,
            title = "How Rockets Work",
            hindiTitle = "रॉकेट कैसे काम करते हैं?",
            emoji = "🚀",
            simpleExplanation = listOf(
                "Earth's gravity pulls everything down toward the ground. To escape into orbit, a rocket must zoom upward at an incredible speed of 28,000 km/h (17,500 mph)!",
                "Rockets work using Sir Isaac Newton's Third Law of Motion: 'For every action, there is an equal and opposite reaction.'",
                "Inside the rocket engines, fuel and liquid oxygen mix and burn, shooting hot gas downward out of the nozzles at tremendous speed (Action). This pushes the rocket powerfully UPWARD into the sky (Reaction)!"
            ),
            everydayExample = "Blow up a party balloon and let go of the neck without tying it! The air rushes out the bottom (Action), and the balloon zooms across the room in the opposite direction (Reaction). That's exactly how a rocket flies!",
            hindiExplanation = "रॉकेट न्यूटन के तीसरे नियम ('प्रत्येक क्रिया की समान और विपरीत प्रतिक्रिया होती है') पर काम करता है। जब रॉकेट का इंजन नीचे की ओर तेज़ गति से गर्म गैस छोड़ता है (Action), तो रॉकेट उतनी ही ताकत से ऊपर अंतरिक्ष की ओर उठता है (Reaction)!",
            importantFacts = listOf(
                "Unlike airplanes (which scoop oxygen from the air), rockets carry their own oxygen tanks so their engines work in airless space!",
                "To reach low Earth orbit, a rocket must reach about 28,000 km/h.",
                "Modern rockets like SpaceX Falcon 9 can even land their boosters back on Earth to be reused!"
            ),
            whatDidYouLearn = listOf(
                "Rockets work by pushing hot exhaust gas down to propel the rocket up (Action & Reaction).",
                "Rockets carry both fuel and oxidizer (oxygen) so they can fly in space.",
                "Reusable rockets make space travel safer and more affordable."
            ),
            sceneType = SceneAnimationType.ROCKET_BLASTOFF,
            miniQuiz = LessonMiniQuiz(
                question = "Why can a rocket engine work in outer space where an airplane jet engine cannot?",
                hindiQuestion = "बाहरी अंतरिक्ष में जहाँ हवाई जहाज का इंजन काम नहीं कर सकता, वहाँ रॉकेट इंजन कैसे काम करता है?",
                options = listOf(
                    "Because a rocket carries its own oxygen tank along with its fuel",
                    "Because rockets use giant propellers",
                    "Because rockets flap wings",
                    "Because space is full of wind"
                ),
                correctIndex = 0,
                explanation = "Spot on! Fire needs oxygen. Since space has no air, rockets carry their own liquid oxygen tanks on board!",
                hindiExplanation = "शाबाश! ईंधन जलाने के लिए ऑक्सीजन चाहिए। अंतरिक्ष में हवा नहीं है, इसलिए रॉकेट अपना ऑक्सीजन टैंक साथ ले जाते हैं।"
            )
        ),
        Lesson(
            id = "m7_l2",
            moduleId = "mod_7",
            moduleName = "Module 7: Rockets & Space Technology",
            lessonNumber = 2,
            title = "Parts of a Rocket",
            hindiTitle = "रॉकेट के मुख्य भाग",
            emoji = "🛠️",
            simpleExplanation = listOf(
                "A giant space rocket is built in stacked sections called STAGES, and has 4 main systems working together:",
                "1. PAYLOAD SYSTEM (at the top nose cone): Carries the astronauts in their capsule, or carries satellites and Mars rovers!\n2. GUIDANCE SYSTEM: The 'brain' of the rocket (computers, radar, and sensors) that steers it on course.",
                "3. PROPULSION SYSTEM: The giant fuel tanks, liquid oxygen tanks, and powerful rocket nozzles at the bottom.\n4. STRUCTURE (Stages): As the huge bottom First Stage runs out of fuel, it separates and drops away so the lighter Second Stage can fly even faster into orbit!"
            ),
            everydayExample = "Staging is like carrying two lunchboxes on a hike: once you eat everything in the first box, dropping it off makes your backpack much lighter for climbing the mountain!",
            hindiExplanation = "रॉकेट के 4 मुख्य भाग होते हैं: 1. पेलोड (सबसे ऊपर का हिस्सा जहाँ अंतरिक्ष यात्री या सैटेलाइट होते हैं), 2. गाइडेंस सिस्टम (रॉकेट का कंप्यूटर दिमाग), 3. प्रोपल्शन सिस्टम (ईंधन टैंक और इंजन), और 4. स्टेज (अलग होने वाले हिस्से)।",
            importantFacts = listOf(
                "Most of a rocket's weight on the launchpad (about 90%!) is actually fuel and liquid oxygen.",
                "The Payload Fairing (nose cone) protects satellites from wind and heat during launch.",
                "Crew rockets have a Launch Abort System tower on top to pull astronauts to safety in an emergency."
            ),
            whatDidYouLearn = listOf(
                "The Payload at the top carries astronauts, satellites, or rovers.",
                "The Guidance System is the computer brain that steers the rocket.",
                "Rockets use multiple stages so they don't carry empty fuel tanks all the way to space."
            ),
            sceneType = SceneAnimationType.ROCKET_BLASTOFF,
            miniQuiz = LessonMiniQuiz(
                question = "Which part at the top of a rocket carries the astronauts, satellites, or rovers?",
                hindiQuestion = "रॉकेट के सबसे ऊपरी हिस्से को क्या कहते हैं जिसमें अंतरिक्ष यात्री या सैटेलाइट होते हैं?",
                options = listOf("The Payload", "The Nozzle", "The Fin", "The Landing Gear"),
                correctIndex = 0,
                explanation = "Correct! The Payload is the precious cargo (astronaut capsule, satellite, or rover) carried at the top of the rocket.",
                hindiExplanation = "सही उत्तर! रॉकेट के सबसे ऊपर के हिस्से को 'पेलोड' (Payload) कहते हैं जिसमें यात्री या उपग्रह होते हैं।"
            )
        ),
        Lesson(
            id = "m7_l3",
            moduleId = "mod_7",
            moduleName = "Module 7: Rockets & Space Technology",
            lessonNumber = 3,
            title = "How Satellites Work",
            hindiTitle = "उपग्रह (Satellites) कैसे काम करते हैं?",
            emoji = "🛰️",
            simpleExplanation = listOf(
                "A satellite is any object that orbits around a larger object in space. The Moon is Earth's natural satellite, while spacecraft launched into orbit by humans are ARTIFICIAL SATELLITES!",
                "How do satellites stay up in space without falling down? They zoom sideways around Earth so fast that as Earth's gravity pulls them down, Earth's curved surface curves away beneath them — so they keep orbiting!",
                "Satellites help us every single day: they predict hurricanes and rain, give us GPS map directions on our phones, beam TV and internet signals, and monitor forests, oceans, and climate!"
            ),
            everydayExample = "When you use Google Maps to find the way to a park or check if it will rain tomorrow, you are using data beamed down from satellites in space!",
            hindiExplanation = "इंसानों द्वारा अंतरिक्ष में भेजे गए मशीनों को 'कृत्रिम उपग्रह' (Artificial Satellites) कहते हैं। इनमें सौर पैनल (Solar Panels) लगे होते हैं। ये मौसम की जानकारी देने, मोबाइल GPS चलाने, टीवी सिग्नल भेजने और पृथ्वी के पर्यावरण की देखभाल करने में मदद करते हैं!",
            importantFacts = listOf(
                "Sputnik 1 (1957) was the first artificial satellite; Aryabhata (1975) was India's first satellite.",
                "Satellites use wing-like Solar Panels to turn sunlight into electricity.",
                "GPS navigation uses a constellation of at least 24 satellites orbiting Earth."
            ),
            whatDidYouLearn = listOf(
                "Satellites stay in orbit by balancing forward speed with Earth's gravity pull.",
                "Solar panels power satellites using sunlight.",
                "Satellites give us weather forecasts, GPS navigation, communications, and Earth science."
            ),
            sceneType = SceneAnimationType.ORBITING_PLANETS,
            miniQuiz = LessonMiniQuiz(
                question = "How do most satellites generate electricity while orbiting in space?",
                hindiQuestion = "अंतरिक्ष में घूमते हुए अधिकांश उपग्रह (Satellites) बिजली कैसे प्राप्त करते हैं?",
                options = listOf(
                    "Using Solar Panels that capture sunlight",
                    "With a long extension cord plugged into Earth",
                    "Using wind turbines",
                    "By burning wood"
                ),
                correctIndex = 0,
                explanation = "You nailed it! Satellites unfold large solar panel wings to convert bright sunlight into electricity.",
                hindiExplanation = "बिल्कुल सही! उपग्रहों में बड़े सौर पैनल (Solar Panels) लगे होते हैं जो धूप से बिजली बनाते हैं।"
            )
        ),
        Lesson(
            id = "m7_l4",
            moduleId = "mod_7",
            moduleName = "Module 7: Rockets & Space Technology",
            lessonNumber = 4,
            title = "Space Stations: Homes in Orbit",
            hindiTitle = "अंतरिक्ष स्टेशन: अंतरिक्ष में तैरता घर",
            emoji = "🏗️",
            simpleExplanation = listOf(
                "A Space Station is a giant spacecraft designed as a home and science laboratory where crews of astronauts live and work in orbit for months at a time!",
                "The INTERNATIONAL SPACE STATION (ISS) is as wide as a full-size football field (109 meters across) and orbits about 400 kilometers above Earth!",
                "Built together by space agencies from the USA (NASA), Europe (ESA), Japan (JAXA), Canada (CSA), and Russia, the ISS has had astronauts living aboard continuously every single day since November 2000!"
            ),
            everydayExample = "Imagine a 6-bedroom house with 2 bathrooms, a gym, science labs, and a 360-degree glass window dome (the Cupola) flying around the world every 90 minutes!",
            hindiExplanation = "'अंतर्राष्ट्रीय अंतरिक्ष स्टेशन' (ISS) पृथ्वी से 400 किलोमीटर ऊपर घूमने वाली एक विशाल वैज्ञानिक प्रयोगशाला और अंतरिक्ष यात्रियों का घर है। यह फुटबॉल के मैदान जितना बड़ा है और मात्र 90 मिनट में पूरी पृथ्वी का एक चक्कर लगा लेता है!",
            importantFacts = listOf(
                "The ISS travels at 28,000 km/h — orbiting the entire Earth 16 times every day!",
                "It is so bright that you can often see the ISS gliding across the night sky like a fast-moving bright star!",
                "Astronauts look at Earth through a special 7-window dome on the ISS called the 'Cupola'."
            ),
            whatDidYouLearn = listOf(
                "The International Space Station (ISS) is a giant orbital laboratory 400 km above Earth.",
                "It is as wide as a football field and orbits Earth every 90 minutes.",
                "Astronauts from many countries work together peacefully aboard the ISS."
            ),
            sceneType = SceneAnimationType.ASTRONAUT_FLOAT,
            miniQuiz = LessonMiniQuiz(
                question = "How long does it take the International Space Station to orbit all the way around Earth once?",
                hindiQuestion = "अंतर्राष्ट्रीय अंतरिक्ष स्टेशन (ISS) को पृथ्वी का एक पूरा चक्कर लगाने में कितना समय लगता है?",
                options = listOf("About 90 minutes", "24 hours", "30 days", "1 year"),
                correctIndex = 0,
                explanation = "Awesome! Traveling at 28,000 km/h, the ISS circles the entire Earth once every 90 minutes.",
                hindiExplanation = "शाबाश! 28,000 किमी/घंटा की रफ़्तार से चलते हुए ISS केवल 90 मिनट में पृथ्वी की एक परिक्रमा पूरी कर लेता है।"
            )
        ),
        Lesson(
            id = "m7_l5",
            moduleId = "mod_7",
            moduleName = "Module 7: Rockets & Space Technology",
            lessonNumber = 5,
            title = "Space Telescopes: Eyes on the Cosmos",
            hindiTitle = "स्पेस टेलीस्कोप: ब्रह्मांड को देखने वाली आँखें",
            emoji = "🔭",
            simpleExplanation = listOf(
                "Telescopes on the ground look up through Earth's wavy, cloudy atmosphere, which makes distant stars look blurry and twinkling (like looking at a coin at the bottom of a swimming pool).",
                "By launching SPACE TELESCOPES high above Earth's atmosphere, astronomers get crystal-clear views of the deepest corners of the Universe!",
                "The famous HUBBLE Space Telescope (launched in 1990) and the golden-mirrored JAMES WEBB Space Telescope (launched in 2021) have photographed baby stars being born inside colorful nebulas and galaxies billions of light-years away!"
            ),
            everydayExample = "Looking through a ground telescope is like looking through a rainy car windshield. A space telescope steps outside above the clouds for a crystal-clear view!",
            hindiExplanation = "पृथ्वी की हवा और बादलों के कारण जमीन से दूर के तारे धुंधले दिखते हैं। इसलिए वैज्ञानिकों ने अंतरिक्ष में विशाल दूरबीनें (Space Telescopes) भेजी हैं — जैसे 'हबल स्पेस टेलीस्कोप' और सोने के दर्पण वाला 'जेम्स वेब स्पेस टेलीस्कोप' (JWST)!",
            importantFacts = listOf(
                "The James Webb Space Telescope (JWST) has a giant 6.5-meter mirror made of 18 gold-coated hexagons!",
                "JWST orbits 1.5 million kilometers from Earth and uses a tennis-court-sized sunshield to stay super cold.",
                "Space telescopes also help scientists study exoplanets (planets orbiting other stars!)."
            ),
            whatDidYouLearn = listOf(
                "Space telescopes orbit above Earth's blurry atmosphere for super sharp images.",
                "Hubble and James Webb (JWST) are humanity's most famous space telescopes.",
                "They help us see galaxies, nebulas, and exoplanets billions of light-years away."
            ),
            sceneType = SceneAnimationType.STARFIELD_NEBULA,
            miniQuiz = LessonMiniQuiz(
                question = "Why do space telescopes like Hubble and James Webb take clearer pictures than telescopes on the ground?",
                hindiQuestion = "हबल और जेम्स वेब जैसे स्पेस टेलीस्कोप जमीन की दूरबीनों से अधिक साफ तस्वीरें क्यों ले पाते हैं?",
                options = listOf(
                    "Because they are above Earth's cloudy, blurry atmosphere",
                    "Because astronauts wipe the stars clean",
                    "Because they touch the stars",
                    "Because space has brighter flashbulbs"
                ),
                correctIndex = 0,
                explanation = "Spot on! Orbiting in space above Earth's atmosphere eliminates air distortion and clouds.",
                hindiExplanation = "बिल्कुल सही! पृथ्वी के वायुमंडल और बादलों से ऊपर होने के कारण उन्हें अंतरिक्ष का एकदम साफ दृश्य मिलता है।"
            )
        ),
        Lesson(
            id = "m7_l6",
            moduleId = "mod_7",
            moduleName = "Module 7: Rockets & Space Technology",
            lessonNumber = 6,
            title = "Space Exploration Vehicles (Probes, Landers & Capsules)",
            hindiTitle = "अंतरिक्ष यान: प्रोब, लैंडर और कैप्सूल",
            emoji = "🛸",
            simpleExplanation = listOf(
                "Scientists build different types of space vehicles depending on the mission:",
                "1. SPACE PROBES & ORBITERS (like Voyager 1 & 2, Juno, and New Horizons): Fly past or orbit distant planets and moons to take photos and measurements.\n2. LANDERS & ROVERS (like Viking, Chandrayaan-3 Vikram Lander, and Perseverance): Touch down gently on a world's surface!",
                "3. CREW CAPSULES (like NASA's Orion, SpaceX Crew Dragon, and ISRO's Gaganyaan): Carry human astronauts safely to space and splash down on Earth using giant parachutes and heat shields!"
            ),
            everydayExample = "Think of space vehicles like travel vehicles: an Orbiter is a sightseeing airplane, a Lander/Rover is an off-road jeep, and a Crew Capsule is a safe family submarine with parachutes!",
            hindiExplanation = "अलग-अलग मिशनों के लिए अलग-अलग अंतरिक्ष यान बनाए जाते हैं: 'ऑर्बिटर' ग्रह के चारों ओर घूमकर फोटो लेते हैं, 'लैंडर' सतह पर उतरते हैं, 'रोवर' पहियों से चलकर मिट्टी की जाँच करते हैं, और 'क्रू कैप्सूल' अंतरिक्ष यात्रियों को सुरक्षित ले जाते और वापस लाते हैं!",
            importantFacts = listOf(
                "Voyager 1 (launched in 1977) is the farthest human-made object in history — now over 24 billion km away in interstellar space!",
                "Voyager 1 and 2 each carry a 'Golden Record' with sounds, music, and greetings from Earth in 55 languages (including Hindi!).",
                "Heat shields protect returning capsules from temperatures over 1,600°C when re-entering Earth's atmosphere."
            ),
            whatDidYouLearn = listOf(
                "Probes and orbiters study planets from space; landers and rovers explore the surface.",
                "Crew capsules use heat shields and parachutes to bring astronauts safely home.",
                "Voyager 1 is the farthest spacecraft ever built by humans."
            ),
            sceneType = SceneAnimationType.ROCKET_BLASTOFF,
            miniQuiz = LessonMiniQuiz(
                question = "Which NASA spacecraft launched in 1977 is the farthest human-made object from Earth?",
                hindiQuestion = "1977 में लॉन्च किया गया कौन सा नासा अंतरिक्ष यान पृथ्वी से सबसे दूर जाने वाली मानव निर्मित वस्तु है?",
                options = listOf("Voyager 1", "Apollo 11", "Curiosity", "Sputnik"),
                correctIndex = 0,
                explanation = "Correct! NASA's Voyager 1 has traveled more than 24 billion kilometers into interstellar space!",
                hindiExplanation = "सही उत्तर! नासा का 'वॉयेजर 1' (Voyager 1) पृथ्वी से 24 अरब किलोमीटर से भी अधिक दूर जा चुका है!"
            )
        )
    )

    val module8Lessons = listOf(
        Lesson(
            id = "m8_l1",
            moduleId = "mod_8",
            moduleName = "Module 8: Galaxies & Universe",
            lessonNumber = 1,
            title = "Types of Galaxies",
            hindiTitle = "आकाशगंगाओं के प्रकार (Types of Galaxies)",
            emoji = "🌀",
            simpleExplanation = listOf(
                "Astronomer Edwin Hubble discovered that the trillions of galaxies in our Universe fall into three main shape families:",
                "1. SPIRAL GALAXIES: Look like flat spinning pinwheels with bright curving arms full of young blue stars, gas, and dust. Our Milky Way and the Andromeda Galaxy are Spiral Galaxies!",
                "2. ELLIPTICAL GALAXIES: Look like smooth, glowing round or oval balls made mostly of older yellow and red stars.\n3. IRREGULAR GALAXIES: Don't have a neat circle or spiral shape — they look like colorful cosmic clouds!"
            ),
            everydayExample = "Galaxies are like cookies on a baking sheet: some are swirled pinwheel cookies (Spiral), some are smooth round buns (Elliptical), and some are free-form oatmeal clusters (Irregular)!",
            hindiExplanation = "ब्रह्मांड में आकाशगंगाएँ मुख्य रूप से 3 आकार की होती हैं: 1. सर्पिल (Spiral - चक्र या पिनव्हील जैसी, जैसे हमारी मिल्की वे), 2. दीर्घवृत्ताकार (Elliptical - अंडाकार या गेंद जैसी), और 3. अनियमित (Irregular - जिनका कोई निश्चित आकार नहीं होता)।",
            importantFacts = listOf(
                "Spiral galaxies have a bright central bulge surrounded by rotating spiral arms.",
                "Elliptical galaxies include the largest galaxies in the universe, containing trillions of stars!",
                "Irregular galaxies are often shaped by the gravity of neighboring galaxies pulling on them."
            ),
            whatDidYouLearn = listOf(
                "The 3 main galaxy types are Spiral, Elliptical, and Irregular.",
                "Our Milky Way and Andromeda are Spiral galaxies.",
                "Spiral galaxies are rich in gas and dust where new stars are born."
            ),
            sceneType = SceneAnimationType.SPIRAL_GALAXY,
            miniQuiz = LessonMiniQuiz(
                question = "What are the three main shape types of galaxies in the Universe?",
                hindiQuestion = "ब्रह्मांड में आकार के आधार पर आकाशगंगाओं के तीन मुख्य प्रकार कौन से हैं?",
                options = listOf(
                    "Spiral, Elliptical, and Irregular",
                    "Square, Triangle, and Rectangle",
                    "Small, Medium, and Flat",
                    "Rocky, Watery, and Leafy"
                ),
                correctIndex = 0,
                explanation = "Awesome! Astronomers classify galaxies into Spiral, Elliptical, and Irregular shapes.",
                hindiExplanation = "शाबाश! आकाशगंगाओं के तीन मुख्य प्रकार सर्पिल (Spiral), दीर्घवृत्ताकार (Elliptical) और अनियमित (Irregular) हैं।"
            )
        ),
        Lesson(
            id = "m8_l2",
            moduleId = "mod_8",
            moduleName = "Module 8: Galaxies & Universe",
            lessonNumber = 2,
            title = "Black Holes: Gravity Champions",
            hindiTitle = "ब्लैक होल: गुरुत्वाकर्षण का चैंपियन",
            emoji = "🕳️",
            simpleExplanation = listOf(
                "What is a Black Hole? Despite its name, a black hole is NOT an empty hole! It is a place in space where a huge amount of matter is packed into a tiny space, creating gravity that is super-duper strong.",
                "Just like you have to jump super fast to escape Earth's gravity, near a black hole's boundary (called the Event Horizon), gravity is so strong that even light — the fastest thing in the Universe — cannot escape! That's why it looks black.",
                "Don't worry: black holes do NOT roam around like vacuum cleaners sucking up the universe! They stay in their orbits just like regular stars, and the closest one is thousands of light-years away."
            ),
            everydayExample = "Imagine squeezing a giant mountain down into the size of a tiny marble. It would still weigh as much as a mountain, so its gravity right next to the marble would be super strong!",
            hindiExplanation = "ब्लैक होल (Black Hole) कोई खाली गड्ढा नहीं है, बल्कि अंतरिक्ष में वह जगह है जहाँ बहुत सारा द्रव्यमान एक छोटी सी जगह में सिमट गया है। इसका गुरुत्वाकर्षण (Gravity) इतना शक्तिशाली होता है कि इसके पास से प्रकाश (Light) भी बाहर नहीं निकल पाता!",
            importantFacts = listOf(
                "The boundary around a black hole where light cannot escape is called the 'Event Horizon'.",
                "In 2019, the Event Horizon Telescope captured the very first real photo of a black hole's glowing ring!",
                "Most large galaxies have a Supermassive Black Hole sitting calmly at their center."
            ),
            whatDidYouLearn = listOf(
                "A black hole has gravity so strong that even light cannot escape once inside the Event Horizon.",
                "Black holes are not roaming vacuum cleaners; they follow the normal laws of gravity.",
                "Glowing gas swirling around a black hole creates a bright ring that telescopes can photograph."
            ),
            sceneType = SceneAnimationType.BLACK_HOLE_GRAVITY,
            miniQuiz = LessonMiniQuiz(
                question = "Why does a black hole look black?",
                hindiQuestion = "ब्लैक होल काला क्यों दिखाई देता है?",
                options = listOf(
                    "Because its gravity is so strong that not even light can escape from it",
                    "Because it is painted with black ink",
                    "Because it only comes out at night",
                    "Because it is made of charcoal"
                ),
                correctIndex = 0,
                explanation = "Spot on! Because not even light can escape once past the Event Horizon, the center appears completely black.",
                hindiExplanation = "बिल्कुल सही! इसका गुरुत्वाकर्षण इतना अधिक है कि प्रकाश भी इससे बाहर नहीं आ सकता, इसलिए यह काला दिखता है।"
            )
        ),
        Lesson(
            id = "m8_l3",
            moduleId = "mod_8",
            moduleName = "Module 8: Galaxies & Universe",
            lessonNumber = 3,
            title = "Nebulas: Colorful Star Nurseries",
            hindiTitle = "नेबुला (निहारिका): तारों की रंगीन नर्सरी",
            emoji = "🌈",
            simpleExplanation = listOf(
                "A NEBULA (meaning 'cloud' in Latin) is a gigantic, colorful cloud of glowing gas (mostly hydrogen and helium) and cosmic dust floating in space between the stars!",
                "Nebulas are often called 'STAR NURSERIES' because gravity slowly pulls clumps of gas and dust inside the nebula together until they heat up and ignite into brand-new baby stars!",
                "Famous nebulas photographed by NASA's Hubble and James Webb telescopes include the Orion Nebula, the Eagle Nebula ('Pillars of Creation'), and the Carina Nebula."
            ),
            everydayExample = "Just like rainclouds in Earth's sky form raindrops, giant colorful Nebula clouds in space form sparkling new stars and planets!",
            hindiExplanation = "अंतरिक्ष में गैस और धूल के विशाल और रंग-बिरंगे बादलों को 'नेबुला' (Nebula) या 'निहारिका' कहते हैं। इन्हें 'तारों की नर्सरी' (Star Nursery) भी कहा जाता है क्योंकि इन्हीं बादलों के अंदर नए तारों का जन्म होता है!",
            importantFacts = listOf(
                "Our own Sun and Solar System were born inside a giant nebula 4.6 billion years ago!",
                "The Orion Nebula is so bright that you can spot it with binoculars on a clear winter night.",
                "Some nebulas can stretch across hundreds of light-years of space!"
            ),
            whatDidYouLearn = listOf(
                "A nebula is a giant cloud of gas and dust in outer space.",
                "Nebulas are 'Star Nurseries' where new baby stars and planets are born.",
                "The Eagle Nebula and Orion Nebula are famous star-forming nebulas."
            ),
            sceneType = SceneAnimationType.STARFIELD_NEBULA,
            miniQuiz = LessonMiniQuiz(
                question = "Why do astronomers call nebulas 'Star Nurseries'?",
                hindiQuestion = "खगोलशास्त्री नेबुला (निहारिका) को 'तारों की नर्सरी' क्यों कहते हैं?",
                options = listOf(
                    "Because new baby stars are born inside their clouds of gas and dust",
                    "Because astronauts go to preschool there",
                    "Because stars go there to sleep",
                    "Because they look like baby bottles"
                ),
                correctIndex = 0,
                explanation = "Correct! Gravity pulls the gas and dust inside a nebula together to form brand-new stars.",
                hindiExplanation = "सही जवाब! नेबुला के गैस और धूल के बादलों में गुरुत्वाकर्षण से नए तारों का जन्म होता है।"
            )
        ),
        Lesson(
            id = "m8_l4",
            moduleId = "mod_8",
            moduleName = "Module 8: Galaxies & Universe",
            lessonNumber = 4,
            title = "Stars and Constellations",
            hindiTitle = "तारे और तारामंडल (Constellations)",
            emoji = "✨",
            simpleExplanation = listOf(
                "Long before compasses or GPS existed, ancient sailors, farmers, and storytellers looked up at the night sky and played 'connect-the-dots' with bright stars!",
                "These imaginary star patterns are called CONSTELLATIONS. Astronomers officially divide the entire sky into 88 constellations.",
                "Famous patterns include Ursa Major (the Great Bear, holding the Big Dipper / 'Saptarishi' seven sages in Indian astronomy!), Orion the Hunter, Cassiopeia (shaped like a 'W'), and Leo the Lion!"
            ),
            everydayExample = "Looking at constellations is just like connecting numbered dots in a puzzle book to reveal a picture of a bear, a lion, or a hunter in the night sky!",
            hindiExplanation = "रात के आकाश में तारों के समूह को जोड़कर बनने वाली आकृतियों को 'तारामंडल' (Constellations) कहते हैं। प्राचीन काल में नाविक इनसे दिशा पहचानते थे। 'सप्तर्षि' (Big Dipper / Ursa Major) और 'ओरायन' सबसे प्रसिद्ध तारामंडल हैं!",
            importantFacts = listOf(
                "The International Astronomical Union recognizes 88 official constellations.",
                "The two front stars of the Big Dipper (Saptarishi) point directly to Polaris, the North Star (Dhruva Tara)!",
                "Polaris stays almost directly above Earth's North Pole, helping travelers find North at night."
            ),
            whatDidYouLearn = listOf(
                "Constellations are patterns of stars in the night sky.",
                "There are 88 official constellations, including Orion and Ursa Major (Saptarishi).",
                "The North Star (Polaris / Dhruva Tara) helps travelers find the North direction."
            ),
            sceneType = SceneAnimationType.STARFIELD_NEBULA,
            miniQuiz = LessonMiniQuiz(
                question = "Which famous star stays above Earth's North Pole and helps travelers find North?",
                hindiQuestion = "कौन सा प्रसिद्ध तारा हमेशा उत्तर दिशा में चमकता है और यात्रियों को दिशा बताता है?",
                options = listOf("Polaris (The North Star / Dhruva Tara)", "The Moon", "Mars", "Halley's Comet"),
                correctIndex = 0,
                explanation = "You got it! Polaris (the North Star, or Dhruva Tara) sits nearly directly above Earth's North Pole.",
                hindiExplanation = "बिल्कुल सही! ध्रुव तारा (Polaris / North Star) हमेशा उत्तर दिशा में स्थिर दिखाई देता है।"
            )
        ),
        Lesson(
            id = "m8_l5",
            moduleId = "mod_8",
            moduleName = "Module 8: Galaxies & Universe",
            lessonNumber = 5,
            title = "The Big Bang Explained Simply",
            hindiTitle = "बिग बैंग (ब्रह्मांड की शुरुआत) सरल शब्दों में",
            emoji = "💥",
            simpleExplanation = listOf(
                "How did our entire Universe begin? Scientists call the scientific story of the Universe's beginning the BIG BANG!",
                "About 13.8 billion years ago, everything in the Universe was packed into an unimaginably tiny, super-hot, super-bright point smaller than a grain of sand.",
                "Then — WHOOSH! — space itself began stretching and expanding in all directions! As the Universe grew bigger and cooled down, tiny particles formed atoms of hydrogen and helium, which later clumped together to light up the first stars, galaxies, and planets!"
            ),
            everydayExample = "Imagine drawing little galaxy dots on an uninflated balloon with a marker. When you blow air into the balloon, the rubber stretches and all the galaxy dots move farther apart from each other!",
            hindiExplanation = "'बिग बैंग' (Big Bang) कोई बम विस्फोट नहीं था, बल्कि अंतरिक्ष के फैलने की शुरुआत थी! लगभग 13.8 अरब साल पहले पूरा ब्रह्मांड एक सूक्ष्म और बेहद गर्म बिंदु से फैलना शुरू हुआ। ठंडा होने पर इसमें परमाणु, तारे, आकाशगंगाएँ और अंततः हमारी पृथ्वी बनी!",
            importantFacts = listOf(
                "The Big Bang happened approximately 13.8 billion years ago.",
                "Space telescopes can still detect the faint warm afterglow from the early Universe (called the Cosmic Microwave Background).",
                "Every atom of calcium in your bones and iron in your blood was forged inside ancient stars!"
            ),
            whatDidYouLearn = listOf(
                "The Big Bang explains how the Universe began expanding 13.8 billion years ago.",
                "As the early Universe expanded and cooled, atoms, stars, and galaxies formed.",
                "The Universe is still expanding today!"
            ),
            sceneType = SceneAnimationType.SPIRAL_GALAXY,
            miniQuiz = LessonMiniQuiz(
                question = "What happened during the Big Bang 13.8 billion years ago?",
                hindiQuestion = "13.8 अरब साल पहले 'बिग बैंग' के दौरान क्या हुआ था?",
                options = listOf(
                    "The Universe began rapidly expanding from a tiny, super-hot point",
                    "Two giant rocks bumped into each other",
                    "Dinosaurs built a rocket",
                    "The Moon fell into the Sun"
                ),
                correctIndex = 0,
                explanation = "Fantastic! The Big Bang is the rapid expansion of space from an extremely hot, dense beginning 13.8 billion years ago.",
                hindiExplanation = "शानदार! 13.8 अरब साल पहले एक अत्यंत गर्म और सूक्ष्म बिंदु से पूरे ब्रह्मांड का विस्तार शुरू हुआ।"
            )
        )
    )

    // Module 3 lessons are generated dynamically from PlanetsCatalog so kids can also complete them as lessons!
    val module3Lessons: List<Lesson> = PlanetsCatalog.allPlanets.map { planet ->
        Lesson(
            id = "m3_${planet.id}",
            moduleId = "mod_3",
            moduleName = "Module 3: Planet Explorer",
            lessonNumber = planet.orderFromSun,
            title = "Planet #${planet.orderFromSun}: ${planet.name} (${planet.nickname})",
            hindiTitle = "ग्रह #${planet.orderFromSun}: ${planet.hindiName} — ${planet.hindiNickname}",
            emoji = planet.emoji,
            simpleExplanation = listOf(
                planet.introduction,
                "Size Comparison: ${planet.sizeComparisonText} (Real diameter: ${planet.realDiameterKm}).",
                "Distance from Sun: ${planet.distanceFromSunKm} | Length of Year: ${planet.orbitalPeriod} | Moons: ${planet.moonsNotable}."
            ),
            everydayExample = planet.funFact,
            hindiExplanation = "${planet.hindiIntroduction}\n\n${planet.hindiFunFact}",
            importantFacts = planet.interestingFacts + listOf("Temperature: ${planet.temperatureInfo}"),
            whatDidYouLearn = listOf(
                "${planet.name} is planet #${planet.orderFromSun} from the Sun.",
                "Temperature on ${planet.name}: ${planet.temperatureInfo}.",
                "Moons of ${planet.name}: ${planet.moonsNotable}."
            ),
            sceneType = SceneAnimationType.ORBITING_PLANETS,
            miniQuiz = planet.miniQuiz
        )
    }

    val allModules: List<LearningModule> = listOf(
        LearningModule(
            id = "mod_1",
            number = 1,
            title = "Introduction to Space",
            hindiTitle = "अंतरिक्ष का परिचय",
            subtitle = "Space, the Universe, Stars, Galaxies & the Milky Way",
            emoji = "🌌",
            accentColor = ElectricPurple,
            targetPage = AcademyPage.EXPLORE_SPACE,
            lessons = LessonsCatalogPart1.module1Lessons
        ),
        LearningModule(
            id = "mod_2",
            number = 2,
            title = "Solar System",
            hindiTitle = "हमारा सौर मंडल",
            subtitle = "The Sun, 8 Planets, Asteroids, Comets & Stars vs Planets",
            emoji = "☀️",
            accentColor = StarGold,
            targetPage = AcademyPage.SOLAR_SYSTEM,
            lessons = LessonsCatalogPart1.module2Lessons
        ),
        LearningModule(
            id = "mod_3",
            number = 3,
            title = "Planet Explorer",
            hindiTitle = "सभी 8 ग्रहों की खोज",
            subtitle = "Deep-dive journeys to Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus & Neptune",
            emoji = "🪐",
            accentColor = CyanNebula,
            targetPage = AcademyPage.PLANET_EXPLORER,
            lessons = module3Lessons
        ),
        LearningModule(
            id = "mod_4",
            number = 4,
            title = "Our Moon",
            hindiTitle = "हमारा चंद्रमा (चंदा मामा)",
            subtitle = "Moon Phases, Why It Shines, Craters, Apollo 11 & Artemis Missions",
            emoji = "🌙",
            accentColor = CosmicBlue,
            targetPage = AcademyPage.MOON_EXPLORATION,
            lessons = LessonsCatalogPart1.module4Lessons
        ),
        LearningModule(
            id = "mod_5",
            number = 5,
            title = "Mars Exploration",
            hindiTitle = "मंगल ग्रह की खोज (Mars 2077)",
            subtitle = "The Red Planet, Ancient Water, NASA Rovers & Living on Mars in 2077",
            emoji = "🔴",
            accentColor = MarsOrange,
            targetPage = AcademyPage.MARS_EXPLORATION,
            lessons = LessonsCatalogPart1.module5Lessons
        ),
        LearningModule(
            id = "mod_6",
            number = 6,
            title = "Astronaut Life",
            hindiTitle = "अंतरिक्ष यात्री का जीवन",
            subtitle = "Training, Space Food, Sleeping in Zero-G, Space Suits & Breathing",
            emoji = "👨‍🚀",
            accentColor = AuroraGreen,
            targetPage = AcademyPage.ASTRONAUT_LIFE,
            lessons = module6Lessons
        ),
        LearningModule(
            id = "mod_7",
            number = 7,
            title = "Rockets & Space Tech",
            hindiTitle = "रॉकेट और अंतरिक्ष तकनीक",
            subtitle = "How Rockets Work, Satellites, ISS Space Station & James Webb Telescope",
            emoji = "🚀",
            accentColor = RocketAmber,
            targetPage = AcademyPage.ROCKETS_TECH,
            lessons = module7Lessons
        ),
        LearningModule(
            id = "mod_8",
            number = 8,
            title = "Galaxies & Universe",
            hindiTitle = "आकाशगंगा और ब्रह्मांड",
            subtitle = "Spiral Galaxies, Black Holes, Colorful Nebulas, Constellations & Big Bang",
            emoji = "🌀",
            accentColor = GalaxyPink,
            targetPage = AcademyPage.GALAXY_UNIVERSE,
            lessons = module8Lessons
        )
    )

    val allLessonsFlat: List<Lesson> = allModules.flatMap { it.lessons }

    val dailySpaceFacts: List<SpaceFact> = listOf(
        SpaceFact(
            id = 1,
            title = "King of the Planets",
            fact = "Jupiter is the largest planet in our Solar System — over 1,300 Earths could fit inside it!",
            hindiFact = "बृहस्पति हमारे सौर मंडल का सबसे बड़ा ग्रह है — इसके अंदर 1,300 से अधिक पृथ्वियाँ समा सकती हैं!",
            source = "NASA Solar System Exploration",
            emoji = "🟠"
        ),
        SpaceFact(
            id = 2,
            title = "Moons of the Red Planet",
            fact = "Mars has two small, potato-shaped moons named Phobos and Deimos!",
            hindiFact = "मंगल ग्रह के दो छोटे, आलू के आकार के चंद्रमा हैं जिनका नाम फोबोस और डीमोस है!",
            source = "NASA Mars Exploration Program",
            emoji = "🔴"
        ),
        SpaceFact(
            id = 3,
            title = "Jewel of the Solar System",
            fact = "Saturn is famous for its dazzling rings made of billions of chunks of ice and rock!",
            hindiFact = "शनि ग्रह बर्फ और चट्टानों के अरबों टुकड़ों से बने अपने सुंदर छल्लों (Rings) के लिए प्रसिद्ध है!",
            source = "NASA Cassini Mission Archive",
            emoji = "🪐"
        ),
        SpaceFact(
            id = 4,
            title = "Our Living Blue Marble",
            fact = "Earth is the only planet in the universe currently known to support life and liquid oceans on its surface.",
            hindiFact = "पृथ्वी ब्रह्मांड का एकमात्र ज्ञात ग्रह है जहाँ सतह पर तरल महासागर और जीवन मौजूद है।",
            source = "NASA Earth Observatory",
            emoji = "🌍"
        ),
        SpaceFact(
            id = 5,
            title = "Silent Cosmos",
            fact = "Outer space is completely silent because there is no air to carry sound waves!",
            hindiFact = "बाहरी अंतरिक्ष पूरी तरह शांत है क्योंकि वहाँ ध्वनि तरंगों को ले जाने के लिए हवा नहीं है!",
            source = "NASA Space Place",
            emoji = "🤫"
        ),
        SpaceFact(
            id = 6,
            title = "Towering Martian Volcano",
            fact = "Olympus Mons on Mars is the tallest volcano in the Solar System — 3 times higher than Mount Everest!",
            hindiFact = "मंगल ग्रह पर स्थित 'ओलंपस मॉन्स' सौर मंडल का सबसे ऊँचा ज्वालामुखी है — माउंट एवरेस्ट से तीन गुना ऊँचा!",
            source = "NASA Mars Reconnaissance Orbiter",
            emoji = "🌋"
        ),
        SpaceFact(
            id = 7,
            title = "Million-Year Footprints",
            fact = "Astronaut footprints on the Moon will last for millions of years because the Moon has no wind or rain!",
            hindiFact = "चंद्रमा पर अंतरिक्ष यात्रियों के पैरों के निशान लाखों वर्षों तक रहेंगे क्योंकि वहाँ हवा या बारिश नहीं होती!",
            source = "NASA Apollo Lunar Science",
            emoji = "👣"
        ),
        SpaceFact(
            id = 8,
            title = "Backward Spinning Planet",
            fact = "Venus spins backwards compared to Earth, so on Venus the Sun rises in the west and sets in the east!",
            hindiFact = "शुक्र ग्रह उल्टी दिशा में घूमता है, इसलिए वहाँ सूर्य पश्चिम में उगता है और पूर्व में अस्त होता है!",
            source = "NASA Space Place",
            emoji = "🌅"
        )
    )

    val achievementBadges: List<AchievementBadge> = listOf(
        AchievementBadge(
            id = "badge_cadet",
            title = "Space Cadet",
            hindiTitle = "स्पेस कैडेट",
            description = "Complete your very first space lesson!",
            emoji = "🎖️",
            requiredStars = 3,
            requiredLessons = 1
        ),
        AchievementBadge(
            id = "badge_planet_scout",
            title = "Solar System Scout",
            hindiTitle = "सौर मंडल स्काउट",
            description = "Earn 15 stars and complete 5 space lessons.",
            emoji = "🪐",
            requiredStars = 15,
            requiredLessons = 5
        ),
        AchievementBadge(
            id = "badge_lunar_pilot",
            title = "Lunar Walker",
            hindiTitle = "चंद्र यात्री",
            description = "Earn 30 stars and complete 10 lessons.",
            emoji = "🌕",
            requiredStars = 30,
            requiredLessons = 10
        ),
        AchievementBadge(
            id = "badge_mars_pioneer",
            title = "Mars 2077 Pioneer",
            hindiTitle = "मार्स 2077 पायनियर",
            description = "Earn 50 stars and complete 15 lessons.",
            emoji = "🔴",
            requiredStars = 50,
            requiredLessons = 15
        ),
        AchievementBadge(
            id = "badge_rocket_engineer",
            title = "Chief Rocket Engineer",
            hindiTitle = "मुख्य रॉकेट इंजीनियर",
            description = "Earn 75 stars and complete 25 lessons.",
            emoji = "🚀",
            requiredStars = 75,
            requiredLessons = 25
        ),
        AchievementBadge(
            id = "badge_galaxy_commander",
            title = "Junior Astronaut Commander",
            hindiTitle = "जूनियर एस्ट्रोनॉट कमांडर",
            description = "Master the cosmos with 100+ stars and 35+ lessons!",
            emoji = "👨‍🚀",
            requiredStars = 100,
            requiredLessons = 35
        )
    )

    val moonPhases: List<MoonPhaseInfo> = listOf(
        MoonPhaseInfo(
            index = 0,
            name = "New Moon",
            hindiName = "अमावस्या (New Moon)",
            emoji = "🌑",
            illuminationFraction = 0.0f,
            waxing = true,
            description = "The Moon is between Earth and the Sun. Its sunlit side faces away from us, so the Moon looks dark in the sky.",
            hindiDescription = "चंद्रमा पृथ्वी और सूर्य के बीच होता है। इसका प्रकाशित भाग हमारी तरफ नहीं होता, इसलिए यह आकाश में काला दिखता है।"
        ),
        MoonPhaseInfo(
            index = 1,
            name = "Waxing Crescent",
            hindiName = "बढ़ता हुआ दूज का चाँद (Waxing Crescent)",
            emoji = "🌒",
            illuminationFraction = 0.25f,
            waxing = true,
            description = "A thin, banana-shaped silver sliver of light appears on the right side after sunset!",
            hindiDescription = "सूर्यास्त के बाद चंद्रमा का एक पतला, केले जैसा चमकदार हिस्सा दिखाई देने लगता है।"
        ),
        MoonPhaseInfo(
            index = 2,
            name = "First Quarter (Half Moon)",
            hindiName = "प्रथम चतुर्थांश (आधा चाँद)",
            emoji = "🌓",
            illuminationFraction = 0.5f,
            waxing = true,
            description = "The Moon is one-quarter of the way around Earth. We see exactly the right half of the Moon lit up!",
            hindiDescription = "चंद्रमा ने अपनी यात्रा का एक-चौथाई हिस्सा पूरा कर लिया है और हमें आधा चाँद चमकता हुआ दिखता है।"
        ),
        MoonPhaseInfo(
            index = 3,
            name = "Waxing Gibbous",
            hindiName = "बढ़ता हुआ गिब्बस चाँद",
            emoji = "🌔",
            illuminationFraction = 0.78f,
            waxing = true,
            description = "More than half of the Moon's face is glowing brightly as it gets closer to a Full Moon.",
            hindiDescription = "पूर्णिमा के करीब आते हुए चंद्रमा का आधे से ज़्यादा हिस्सा रोशन दिखाई देता है।"
        ),
        MoonPhaseInfo(
            index = 4,
            name = "Full Moon",
            hindiName = "पूर्णिमा (Full Moon)",
            emoji = "🌕",
            illuminationFraction = 1.0f,
            waxing = false,
            description = "Earth is between the Sun and Moon. The entire face of the Moon facing us shines like a bright round silver coin!",
            hindiDescription = "पूर्णिमा की रात चंद्रमा का पूरा गोल चेहरा सूर्य के प्रकाश से चमकता हुआ बेहद सुंदर दिखता है!"
        ),
        MoonPhaseInfo(
            index = 5,
            name = "Waning Gibbous",
            hindiName = "घटता हुआ गिब्बस चाँद",
            emoji = "🌖",
            illuminationFraction = 0.75f,
            waxing = false,
            description = "After the Full Moon, the lit portion slowly starts shrinking from the right side.",
            hindiDescription = "पूर्णिमा के बाद चंद्रमा का चमकता हुआ हिस्सा धीरे-धीरे थोड़ा कम होने लगता है।"
        ),
        MoonPhaseInfo(
            index = 6,
            name = "Third Quarter (Last Quarter)",
            hindiName = "अंतिम चतुर्थांश (आधा चाँद)",
            emoji = "🌗",
            illuminationFraction = 0.5f,
            waxing = false,
            description = "Now the left half of the Moon is illuminated, visible late at night and in the early morning sky.",
            hindiDescription = "अब चंद्रमा का बायाँ आधा भाग रोशन दिखता है, जो देर रात और सुबह के समय भी नजर आता है।"
        ),
        MoonPhaseInfo(
            index = 7,
            name = "Waning Crescent",
            hindiName = "घटता हुआ अर्धचंद्र",
            emoji = "🌘",
            illuminationFraction = 0.2f,
            waxing = false,
            description = "Only a thin crescent of light remains in the morning sky before the cycle begins again at New Moon!",
            hindiDescription = "अमावस्या से ठीक पहले सुबह के आकाश में चाँद की केवल एक पतली सी रेखा बाकी रहती है।"
        )
    )

    val spaceVocabulary: List<SpaceVocabItem> = listOf(
        SpaceVocabItem(
            term = "Orbit",
            hindiTerm = "कक्षा (Orbit)",
            simpleMeaning = "The curved invisible path that a planet or moon follows around a larger object in space.",
            hindiMeaning = "वह निश्चित घुमावदार रास्ता जिस पर कोई ग्रह सूर्य के या चंद्रमा ग्रह के चारों ओर घूमता है।",
            exampleSentence = "Earth takes 365 days to complete one orbit around the Sun.",
            emoji = "🔄"
        ),
        SpaceVocabItem(
            term = "Gravity",
            hindiTerm = "गुरुत्वाकर्षण (Gravity)",
            simpleMeaning = "The invisible pulling force that keeps our feet on the ground and holds planets in orbit around the Sun.",
            hindiMeaning = "वह अदृश्य आकर्षण बल जो हमें जमीन पर टिकाए रखता है और ग्रहों को सूर्य से बाँधकर रखता है।",
            exampleSentence = "On the Moon, gravity is weaker, so you can jump 6 times higher!",
            emoji = "🍎"
        ),
        SpaceVocabItem(
            term = "Atmosphere",
            hindiTerm = "वायुमंडल (Atmosphere)",
            simpleMeaning = "The protective blanket of gases surrounding a planet.",
            hindiMeaning = "किसी ग्रह के चारों ओर लिपटी हुई गैसों (हवा) की सुरक्षात्मक चादर।",
            exampleSentence = "Earth's atmosphere gives us oxygen to breathe and blocks harmful rays.",
            emoji = "🌬️"
        ),
        SpaceVocabItem(
            term = "Light-Year",
            hindiTerm = "प्रकाश वर्ष (Light-Year)",
            simpleMeaning = "The distance that light travels in one full year — about 9.46 trillion kilometers!",
            hindiMeaning = "प्रकाश द्वारा एक पूरे वर्ष में तय की गई दूरी (समय नहीं, बल्कि दूरी मापने की इकाई)!",
            exampleSentence = "The closest star after the Sun, Proxima Centauri, is 4.2 light-years away.",
            emoji = "⚡"
        ),
        SpaceVocabItem(
            term = "Galaxy",
            hindiTerm = "आकाशगंगा (Galaxy)",
            simpleMeaning = "A giant family of billions of stars, planets, gas, and dust held together by gravity.",
            hindiMeaning = "गुरुत्वाकर्षण से बँधा अरबों तारों, ग्रहों, धूल और गैस का विशाल समूह।",
            exampleSentence = "Our Solar System lives inside the Milky Way galaxy.",
            emoji = "🌀"
        ),
        SpaceVocabItem(
            term = "Asteroid",
            hindiTerm = "क्षुद्रग्रह (Asteroid)",
            simpleMeaning = "A rocky or metallic space boulder that orbits the Sun, mostly between Mars and Jupiter.",
            hindiMeaning = "सूर्य की परिक्रमा करने वाले चट्टानी टुकड़े जो मुख्य रूप से मंगल और बृहस्पति के बीच पाए जाते हैं।",
            exampleSentence = "Millions of rocky asteroids travel inside the Asteroid Belt.",
            emoji = "🪨"
        ),
        SpaceVocabItem(
            term = "Comet",
            hindiTerm = "धूमकेतु / पुच्छल तारा (Comet)",
            simpleMeaning = "An icy cosmic snowball that grows a bright glowing tail when it flies close to the Sun.",
            hindiMeaning = "बर्फ और धूल से बना पिंड जो सूर्य के पास आने पर एक लंबी चमकदार पूँछ बनाता है।",
            exampleSentence = "Halley's Comet visits Earth's sky every 75 to 76 years.",
            emoji = "☄️"
        ),
        SpaceVocabItem(
            term = "Rover",
            hindiTerm = "रोवर (Rover)",
            simpleMeaning = "A smart robotic vehicle with wheels built to drive across another planet or moon.",
            hindiMeaning = "दूसरे ग्रह या चंद्रमा की सतह पर चलकर वैज्ञानिक खोज करने वाला पहियों वाला रोबोट।",
            exampleSentence = "NASA's Perseverance rover is exploring Jezero Crater on Mars.",
            emoji = "🤖"
        ),
        SpaceVocabItem(
            term = "Nebula",
            hindiTerm = "निहारिका (Nebula)",
            simpleMeaning = "A giant colorful cloud of gas and dust in space where new baby stars are born.",
            hindiMeaning = "अंतरिक्ष में गैस और धूल का विशाल बादल जहाँ नए तारों का जन्म होता है।",
            exampleSentence = "The Orion Nebula is a bright star nursery in our galaxy.",
            emoji = "🌈"
        ),
        SpaceVocabItem(
            term = "Constellation",
            hindiTerm = "तारामंडल (Constellation)",
            simpleMeaning = "A group of stars in the night sky that forms an imaginary picture or pattern.",
            hindiMeaning = "रात के आकाश में तारों का समूह जो कोई आकृति या पैटर्न बनाता है (जैसे सप्तर्षि)।",
            exampleSentence = "The Big Dipper (Saptarishi) helps us locate the North Star.",
            emoji = "✨"
        )
    )

    val nasaResources: List<NasaResource> = listOf(
        NasaResource(
            id = "nasa_solar_system",
            title = "NASA Solar System Exploration",
            category = "Planetary Science & Real-Time Data",
            description = "Official NASA interactive encyclopedia of all 8 planets, dwarf planets, over 290 moons, asteroids, and active spacecraft missions across our Solar System.",
            hindiDescription = "सौर मंडल के सभी 8 ग्रहों, उपग्रहों, क्षुद्रग्रहों और सक्रिय अंतरिक्ष मिशनों का आधिकारिक नासा विश्वकोश।",
            verifiedDataHighlight = "Verified NASA Data: 8 Planets | 5 Officially Recognized Dwarf Planets | 290+ Planetary Moons | 1.3+ Million Known Asteroids.",
            url = "https://science.nasa.gov/solar-system/",
            emoji = "🪐"
        ),
        NasaResource(
            id = "nasa_space_place",
            title = "NASA Space Place (For Kids)",
            category = "Child-Friendly Space Education",
            description = "Award-winning NASA science portal designed specifically for elementary and middle-school learners with simple explanations, hands-on crafts, and Earth & space facts.",
            hindiDescription = "बच्चों के लिए विशेष रूप से बनाया गया नासा का शैक्षिक पोर्टल जहाँ सरल भाषा में अंतरिक्ष और विज्ञान समझाया गया है।",
            verifiedDataHighlight = "Verified Fact: Sunlight takes 8 minutes and 20 seconds to travel 149.6 million km (1 AU) from the Sun to Earth.",
            url = "https://spaceplace.nasa.gov/",
            emoji = "🚀"
        ),
        NasaResource(
            id = "nasa_mars_exploration",
            title = "NASA Mars Exploration Program",
            category = "Mars Rovers & Red Planet Science",
            description = "Follow real discoveries from NASA's Curiosity rover, Perseverance rover, Ingenuity Mars Helicopter, and orbiters mapping ancient water on Mars.",
            hindiDescription = "नासा के क्यूरियोसिटी और पर्सिवरेंस रोवर द्वारा मंगल ग्रह से भेजी गई असली तस्वीरों और वैज्ञानिक खोजों का केंद्र।",
            verifiedDataHighlight = "Verified Rover Record: Ingenuity completed 72 powered flights on Mars; Perseverance landed in Jezero Crater on Feb 18, 2021.",
            url = "https://science.nasa.gov/mars/",
            emoji = "🔴"
        ),
        NasaResource(
            id = "nasa_image_library",
            title = "NASA Image and Video Library",
            category = "Authentic Space Photography",
            description = "Explore thousands of authentic public-domain photographs from Apollo Moon landings, the International Space Station, Hubble, and the James Webb Space Telescope.",
            hindiDescription = "अपोलो मिशन, अंतर्राष्ट्रीय अंतरिक्ष स्टेशन, हबल और जेम्स वेब टेलीस्कोप द्वारा ली गई असली अंतरिक्ष तस्वीरें।",
            verifiedDataHighlight = "Verified Archive: Over 140,000 authentic NASA mission photographs, audio recordings, and educational videos.",
            url = "https://images.nasa.gov/",
            emoji = "📸"
        ),
        NasaResource(
            id = "nasa_open_apis",
            title = "NASA Open Data & APIs",
            category = "Astronomy Picture of the Day & Telemetry",
            description = "NASA's open science initiative providing public access to Astronomy Picture of the Day (APOD), Mars Rover Photos, and Near-Earth Object tracking.",
            hindiDescription = "नासा का ओपन डेटा पोर्टल जो खगोल विज्ञान की दैनिक तस्वीरों और मंगल रोवर के वैज्ञानिक डेटा को साझा करता है।",
            verifiedDataHighlight = "Verified Mission Standard: All planetary diameters, orbital periods, and temperatures in Mars 2077 Academy follow NASA Planetary Fact Sheets.",
            url = "https://api.nasa.gov/",
            emoji = "📡"
        )
    )
}
