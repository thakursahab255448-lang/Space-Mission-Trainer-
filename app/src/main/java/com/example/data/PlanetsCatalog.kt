package com.example.data

import androidx.compose.ui.graphics.Color
import com.example.model.LessonMiniQuiz
import com.example.model.PlanetData
import com.example.ui.theme.EarthColor
import com.example.ui.theme.JupiterColor
import com.example.ui.theme.MarsColor
import com.example.ui.theme.MercuryColor
import com.example.ui.theme.NeptuneColor
import com.example.ui.theme.SaturnColor
import com.example.ui.theme.UranusColor
import com.example.ui.theme.VenusColor

object PlanetsCatalog {
    val allPlanets: List<PlanetData> = listOf(
        PlanetData(
            id = "mercury",
            orderFromSun = 1,
            name = "Mercury",
            hindiName = "बुध (Budh)",
            nickname = "The Swift Planet",
            hindiNickname = "सबसे तेज़ और सबसे छोटा ग्रह",
            emoji = "🪨",
            primaryColor = MercuryColor,
            secondaryColor = Color(0xFF78909C),
            hasRings = false,
            relativeSizeRatio = 0.38f,
            realDiameterKm = "4,879 km",
            sizeComparisonText = "Mercury is only slightly larger than Earth's Moon! About 18 Mercurys could fit inside Earth.",
            temperatureInfo = "430°C (800°F) during the day, dropping to -180°C (-290°F) at night",
            distanceFromSunKm = "57.9 million km (0.39 AU)",
            orbitalPeriod = "88 Earth days",
            moonsCount = 0,
            moonsNotable = "None (0 moons)",
            introduction = "Mercury is the closest planet to the Sun and the smallest planet in our Solar System. Because it is so close to the Sun's strong gravity, it zooms around the Sun faster than any other planet — completing one full year in just 88 Earth days!",
            hindiIntroduction = "बुध (Mercury) सूर्य के सबसे पास और हमारे सौर मंडल का सबसे छोटा ग्रह है। यह सूर्य का एक चक्कर केवल 88 पृथ्वी दिनों में पूरा कर लेता है! यहाँ हवा (वायुमंडल) बहुत कम है, इसलिए दिन में यह बहुत गर्म और रात में बहुत ठंडा हो जाता है।",
            interestingFacts = listOf(
                "Mercury has no moons and no rings around it.",
                "Even though it is closest to the Sun, Mercury is NOT the hottest planet (Venus is!).",
                "Its surface is covered with thousands of impact craters, looking very much like our Moon.",
                "NASA's MESSENGER spacecraft mapped all of Mercury from orbit between 2011 and 2015."
            ),
            funFact = "One solar day on Mercury (sunrise to sunrise) lasts 176 Earth days — which is twice as long as a Mercury year (88 Earth days)!",
            hindiFunFact = "रोचक तथ्य: बुध ग्रह पर एक सूर्योदय से अगले सूर्योदय तक का समय (176 पृथ्वी दिन) उसके एक साल (88 दिन) से भी दोगुना लंबा होता है!",
            miniQuiz = LessonMiniQuiz(
                question = "How many days does Mercury take to orbit the Sun once?",
                hindiQuestion = "बुध ग्रह को सूर्य का एक चक्कर लगाने में कितने दिन लगते हैं?",
                options = listOf("88 Earth days", "365 Earth days", "24 Earth days", "687 Earth days"),
                correctIndex = 0,
                explanation = "Correct! Mercury is the fastest planet and completes its orbit around the Sun in just 88 Earth days.",
                hindiExplanation = "सही जवाब! बुध सबसे तेज़ ग्रह है और केवल 88 पृथ्वी दिनों में सूर्य की परिक्रमा पूरी करता है।"
            )
        ),
        PlanetData(
            id = "venus",
            orderFromSun = 2,
            name = "Venus",
            hindiName = "शुक्र (Shukra)",
            nickname = "Earth's Hot Twin & Morning Star",
            hindiNickname = "भोर का तारा और सबसे गर्म ग्रह",
            emoji = "🌕",
            primaryColor = VenusColor,
            secondaryColor = Color(0xFFF57C00),
            hasRings = false,
            relativeSizeRatio = 0.95f,
            realDiameterKm = "12,104 km",
            sizeComparisonText = "Venus is almost the exact same size as Earth (about 95% of Earth's width), which is why scientists call it Earth's twin!",
            temperatureInfo = "475°C (900°F) day and night — hot enough to melt lead!",
            distanceFromSunKm = "108.2 million km (0.72 AU)",
            orbitalPeriod = "225 Earth days",
            moonsCount = 0,
            moonsNotable = "None (0 moons)",
            introduction = "Venus is the second planet from the Sun and our closest planetary neighbor. Thick yellow clouds of carbon dioxide and sulfuric acid trap the Sun's heat like a giant greenhouse blanket, making Venus the hottest planet in our entire Solar System!",
            hindiIntroduction = "शुक्र (Venus) सूर्य से दूसरा ग्रह है और आकार में पृथ्वी के लगभग बराबर है, इसलिए इसे 'पृथ्वी की जुड़वां बहन' भी कहते हैं। इसके घने बादल गर्मी को बाहर नहीं जाने देते, जिससे यह सौर मंडल का सबसे गर्म ग्रह बन जाता है।",
            interestingFacts = listOf(
                "Venus spins backwards (retrograde rotation) compared to most other planets — on Venus, the Sun rises in the west and sets in the east!",
                "After the Moon, Venus is the brightest natural object in Earth's night sky.",
                "Venus has more than 1,600 major volcanoes on its rocky surface.",
                "It spins so slowly that one rotation on its axis takes 243 Earth days."
            ),
            funFact = "A single day on Venus (243 Earth days to spin once) is longer than a whole year on Venus (225 Earth days to orbit the Sun)!",
            hindiFunFact = "रोचक तथ्य: शुक्र ग्रह अपनी धुरी पर इतना धीरे घूमता है कि वहाँ का एक दिन (243 पृथ्वी दिन) उसके एक साल (225 दिन) से भी बड़ा होता है!",
            miniQuiz = LessonMiniQuiz(
                question = "Why is Venus hotter than Mercury even though Venus is farther from the Sun?",
                hindiQuestion = "सूर्य से दूर होने के बावजूद शुक्र ग्रह बुध से अधिक गर्म क्यों है?",
                options = listOf(
                    "Its thick carbon dioxide atmosphere traps heat like a blanket",
                    "It has 100 moons reflecting sunlight",
                    "It is made of fire",
                    "It spins super fast"
                ),
                correctIndex = 0,
                explanation = "Spot on! Venus's thick carbon dioxide atmosphere creates a runaway greenhouse effect that traps heat inside.",
                hindiExplanation = "बिल्कुल सही! शुक्र का घना कार्बन डाइऑक्साइड वायुमंडल कंबल की तरह गर्मी को कैद कर लेता है।"
            )
        ),
        PlanetData(
            id = "earth",
            orderFromSun = 3,
            name = "Earth",
            hindiName = "पृथ्वी (Prithvi)",
            nickname = "The Blue Marble",
            hindiNickname = "नीला ग्रह — हमारा प्यारा घर",
            emoji = "🌍",
            primaryColor = EarthColor,
            secondaryColor = Color(0xFF4CAF50),
            hasRings = false,
            relativeSizeRatio = 1.0f,
            realDiameterKm = "12,742 km",
            sizeComparisonText = "Earth is the largest of the four rocky inner planets and our baseline (1.0x) for comparing other worlds!",
            temperatureInfo = "Average 15°C (59°F), ranging from -89°C to 56°C",
            distanceFromSunKm = "149.6 million km (1.0 AU)",
            orbitalPeriod = "365.25 days (1 Year)",
            moonsCount = 1,
            moonsNotable = "1 Moon (The Moon / Luna)",
            introduction = "Earth is the third planet from the Sun and the only place in the universe currently known to harbor life! About 71% of Earth's surface is covered with liquid water oceans, and our oxygen-rich atmosphere protects us from meteoroids and harmful solar radiation.",
            hindiIntroduction = "पृथ्वी (Earth) सूर्य से तीसरा ग्रह है और पूरे ब्रह्मांड में एकमात्र ज्ञात जगह है जहाँ जीवन है! इसकी सतह का 71% हिस्सा पानी से ढका है, इसलिए अंतरिक्ष से यह एक सुंदर नीले कंचे (Blue Marble) जैसी दिखती है।",
            interestingFacts = listOf(
                "Earth is at the 'Goldilocks Distance' from the Sun — neither too hot nor too cold for liquid water.",
                "Sunlight takes about 8 minutes and 20 seconds to travel from the Sun to Earth.",
                "Earth's invisible magnetic field acts like a superhero shield against solar wind.",
                "Earth is the only planet in our Solar System not named after a Greek or Roman god."
            ),
            funFact = "Even though you feel still right now, Earth is zooming around the Sun at about 107,000 kilometers per hour (67,000 mph)!",
            hindiFunFact = "रोचक तथ्य: भले ही हमें महसूस न हो, लेकिन हमारी पृथ्वी 1,07,000 किलोमीटर प्रति घंटे की रफ़्तार से सूर्य के चारों ओर घूम रही है!",
            miniQuiz = LessonMiniQuiz(
                question = "About how much of Earth's surface is covered by water?",
                hindiQuestion = "पृथ्वी की सतह का लगभग कितना प्रतिशत भाग पानी से ढका है?",
                options = listOf("About 71%", "About 10%", "About 100%", "About 30%"),
                correctIndex = 0,
                explanation = "Awesome! Roughly 71% of Earth's surface is covered by liquid water oceans, giving it the nickname 'The Blue Planet'.",
                hindiExplanation = "शाबाश! पृथ्वी का लगभग 71% हिस्सा महासागरों और पानी से ढका हुआ है।"
            )
        ),
        PlanetData(
            id = "mars",
            orderFromSun = 4,
            name = "Mars",
            hindiName = "मंगल (Mangal)",
            nickname = "The Red Planet",
            hindiNickname = "लाल ग्रह (भविष्य का मानव मिशन)",
            emoji = "🔴",
            primaryColor = MarsColor,
            secondaryColor = Color(0xFFD84315),
            hasRings = false,
            relativeSizeRatio = 0.53f,
            realDiameterKm = "6,779 km",
            sizeComparisonText = "Mars is about half the width of Earth! If Earth were the size of a nickel coin, Mars would be the size of a raspberry.",
            temperatureInfo = "Average -65°C (-85°F), from -153°C at the poles to 20°C at noon on the equator",
            distanceFromSunKm = "227.9 million km (1.52 AU)",
            orbitalPeriod = "687 Earth days",
            moonsCount = 2,
            moonsNotable = "2 small potato-shaped moons: Phobos and Deimos",
            introduction = "Mars is the fourth planet from the Sun and a cold, dusty desert world. Its soil is rich in iron oxide (rust), which makes the ground and sky glow reddish-orange! NASA has sent robotic rovers like Curiosity and Perseverance to search for signs of ancient water and microbial life.",
            hindiIntroduction = "मंगल (Mars) सूर्य से चौथा ग्रह है और इसे 'लाल ग्रह' कहा जाता है क्योंकि इसकी मिट्टी में आयरन ऑक्साइड (जंग) मौजूद है। यहाँ सौर मंडल का सबसे बड़ा ज्वालामुखी 'ओलंपस मॉन्स' है और इसके दो छोटे चंद्रमा हैं: फोबोस और डीमोस।",
            interestingFacts = listOf(
                "Mars is home to Olympus Mons, the largest volcano in the Solar System — three times taller than Mount Everest!",
                "Valles Marineris on Mars is a giant canyon system long enough to stretch across the entire United States.",
                "A day on Mars (called a 'Sol') is 24 hours and 37 minutes — almost identical to Earth's day!",
                "Mars has polar ice caps made of frozen water and frozen carbon dioxide (dry ice)."
            ),
            funFact = "Mars is the only known planet inhabited entirely by robots — including NASA's Curiosity and Perseverance rovers!",
            hindiFunFact = "रोचक तथ्य: मंगल अभी ब्रह्मांड का एकमात्र ऐसा ग्रह है जहाँ केवल रोबोट (नासा के क्यूरियोसिटी और पर्सिवरेंस रोवर) रहते और काम करते हैं!",
            miniQuiz = LessonMiniQuiz(
                question = "What are the names of the two small moons of Mars?",
                hindiQuestion = "मंगल ग्रह के दो छोटे चंद्रमाओं के नाम क्या हैं?",
                options = listOf("Phobos and Deimos", "Titan and Europa", "Io and Ganymede", "Triton and Charon"),
                correctIndex = 0,
                explanation = "Great job! Mars has two small, asteroid-like moons named Phobos ('Fear') and Deimos ('Panic').",
                hindiExplanation = "बिल्कुल सही! मंगल के दो छोटे चंद्रमाओं के नाम फोबोस और डीमोस हैं।"
            )
        ),
        PlanetData(
            id = "jupiter",
            orderFromSun = 5,
            name = "Jupiter",
            hindiName = "बृहस्पति (Brihaspati)",
            nickname = "The King of Planets (Gas Giant)",
            hindiNickname = "सौर मंडल का सबसे बड़ा ग्रह",
            emoji = "🟠",
            primaryColor = JupiterColor,
            secondaryColor = Color(0xFFE65100),
            hasRings = true,
            relativeSizeRatio = 2.4f, // Visually scaled (Real is 11x Earth width)
            realDiameterKm = "139,820 km (11x wider than Earth!)",
            sizeComparisonText = "Jupiter is so gigantic that more than 1,300 Earths could fit inside it! It is 11 times wider than Earth.",
            temperatureInfo = "-110°C (-166°F) in the upper cloud tops",
            distanceFromSunKm = "778.5 million km (5.2 AU)",
            orbitalPeriod = "11.86 Earth years",
            moonsCount = 95,
            moonsNotable = "95 confirmed moons, including Io, Europa, Ganymede & Callisto",
            introduction = "Jupiter is the fifth planet from the Sun and by far the largest planet in our Solar System. It is a 'Gas Giant' made mostly of hydrogen and helium gas, meaning it has no solid ground to stand on! Its colorful stripes are swirling clouds of ammonia and water.",
            hindiIntroduction = "बृहस्पति (Jupiter) हमारे सौर मंडल का सबसे बड़ा ग्रह है। यह इतना विशाल है कि इसमें 1,300 से ज़्यादा पृथ्वियाँ समा सकती हैं! यह मुख्य रूप से हाइड्रोजन और हीलियम गैस से बना एक 'गैस दानव' (Gas Giant) है।",
            interestingFacts = listOf(
                "Jupiter's Great Red Spot is a giant spinning storm bigger than Earth that has raged for over 300 years!",
                "Jupiter has the shortest day of all planets — it spins once every 9 hours and 55 minutes.",
                "Its moon Ganymede is the largest moon in the Solar System — even bigger than planet Mercury!",
                "Its moon Europa has a huge salty liquid water ocean hidden underneath an icy crust."
            ),
            funFact = "If you combined all the other planets in our Solar System into one giant ball, Jupiter would STILL be more than twice as massive!",
            hindiFunFact = "रोचक तथ्य: बृहस्पति पर एक दिन मात्र 10 घंटे का होता है क्योंकि यह सभी ग्रहों में सबसे तेज़ अपनी धुरी पर घूमता है!",
            miniQuiz = LessonMiniQuiz(
                question = "What is the famous 'Great Red Spot' on Jupiter?",
                hindiQuestion = "बृहस्पति ग्रह पर प्रसिद्ध 'ग्रेट रेड स्पॉट' क्या है?",
                options = listOf(
                    "A giant storm bigger than Earth",
                    "A red volcano",
                    "A giant red lake",
                    "A desert of red sand"
                ),
                correctIndex = 0,
                explanation = "Correct! The Great Red Spot is a colossal swirling storm larger than our entire planet Earth.",
                hindiExplanation = "सही उत्तर! ग्रेट रेड स्पॉट पृथ्वी से भी बड़ा एक विशालकाय चक्रवाती तूफ़ान है जो सैकड़ों सालों से चल रहा है।"
            )
        ),
        PlanetData(
            id = "saturn",
            orderFromSun = 6,
            name = "Saturn",
            hindiName = "शनि (Shani)",
            nickname = "The Ringed Jewel of the Solar System",
            hindiNickname = "सुंदर छल्लों (Rings) वाला ग्रह",
            emoji = "🪐",
            primaryColor = SaturnColor,
            secondaryColor = Color(0xFFFFB300),
            hasRings = true,
            relativeSizeRatio = 2.0f, // Visually scaled (Real is 9.5x Earth width)
            realDiameterKm = "116,460 km (9.5x wider than Earth)",
            sizeComparisonText = "Saturn is the second-largest planet — about 764 Earths could fit inside Saturn!",
            temperatureInfo = "-140°C (-220°F) average cloud temperature",
            distanceFromSunKm = "1.43 billion km (9.5 AU)",
            orbitalPeriod = "29.45 Earth years",
            moonsCount = 146,
            moonsNotable = "146 confirmed moons, including giant Titan and icy Enceladus",
            introduction = "Saturn is the sixth planet from the Sun and famous across the universe for its breathtaking system of bright rings! Like Jupiter, Saturn is a gas giant made of hydrogen and helium. Its rings are made of billions of chunks of glistening water ice and rock.",
            hindiIntroduction = "शनि (Saturn) सूर्य से छठा और दूसरा सबसे बड़ा ग्रह है। यह अपने बेहद खूबसूरत और चमकदार छल्लों (Rings) के लिए प्रसिद्ध है, जो अरबों बर्फ के टुकड़ों और चट्टानों से बने हैं।",
            interestingFacts = listOf(
                "Saturn's rings stretch 282,000 km across, yet in most places they are only about 10 meters (30 feet) thick!",
                "Saturn has 146 officially recognized moons — the most moons of any planet in our Solar System.",
                "Saturn's largest moon, Titan, is the only moon in the Solar System with a thick atmosphere and liquid methane lakes.",
                "Its icy moon Enceladus shoots giant geysers of water vapor into space from an underground ocean."
            ),
            funFact = "Saturn is the only planet in our Solar System that is less dense than water — if you had a bathtub big enough, Saturn would float!",
            hindiFunFact = "रोचक तथ्य: शनि ग्रह का घनत्व पानी से भी कम है — अगर कोई इतना बड़ा पानी का टब होता, तो शनि ग्रह पानी में तैरने लगता!",
            miniQuiz = LessonMiniQuiz(
                question = "What are Saturn's famous rings mostly made of?",
                hindiQuestion = "शनि ग्रह के प्रसिद्ध छल्ले (Rings) मुख्य रूप से किससे बने हैं?",
                options = listOf(
                    "Billions of chunks of ice and rock",
                    "Solid gold metal",
                    "Colorful rainbow paint",
                    "Liquid lava"
                ),
                correctIndex = 0,
                explanation = "You got it! Saturn's rings are made of billions of pieces of water ice and rock, ranging from tiny dust grains to house-sized boulders.",
                hindiExplanation = "शाबाश! शनि के छल्ले बर्फ और चट्टानों के अरबों छोटे-बड़े टुकड़ों से मिलकर बने हैं।"
            )
        ),
        PlanetData(
            id = "uranus",
            orderFromSun = 7,
            name = "Uranus",
            hindiName = "अरुण (Arun)",
            nickname = "The Sideways Ice Giant",
            hindiNickname = "तिरछा घूमने वाला बर्फीला ग्रह",
            emoji = "🧊",
            primaryColor = UranusColor,
            secondaryColor = Color(0xFF00ACC1),
            hasRings = true,
            relativeSizeRatio = 1.45f, // Visually scaled (Real is 4x Earth width)
            realDiameterKm = "50,724 km (4x wider than Earth)",
            sizeComparisonText = "Uranus is 4 times wider than Earth. About 63 Earths could fit inside Uranus!",
            temperatureInfo = "-195°C (-320°F) — with the coldest planetary temperature of -224°C!",
            distanceFromSunKm = "2.87 billion km (19.2 AU)",
            orbitalPeriod = "84 Earth years",
            moonsCount = 28,
            moonsNotable = "28 moons named after characters from Shakespeare and Alexander Pope (Miranda, Titania, Oberon)",
            introduction = "Uranus is the seventh planet from the Sun and an 'Ice Giant'. Methane gas in its upper atmosphere absorbs red light and reflects blue-green light, giving Uranus its calm aquamarine color. Uniquely, Uranus spins completely on its side like a rolling ball!",
            hindiIntroduction = "अरुण (Uranus) सूर्य से सातवाँ ग्रह है और इसे 'बर्फीला दानव' (Ice Giant) कहा जाता है। मीथेन गैस के कारण इसका रंग हल्का नीला-हरा दिखाई देता है। यह अपनी धुरी पर लगभग 98 डिग्री झुका हुआ है, इसलिए यह लुढ़कती हुई गेंद की तरह घूमता है!",
            interestingFacts = listOf(
                "Uranus is tilted at nearly 98 degrees, likely because an Earth-sized object crashed into it billions of years ago.",
                "Uranus has 13 faint rings that circle it vertically because of its sideways tilt!",
                "It was the first planet discovered with the help of a telescope (by William Herschel in 1781).",
                "One season on Uranus lasts 21 Earth years!"
            ),
            funFact = "Because Uranus rolls on its side, its poles get 42 years of non-stop sunlight followed by 42 years of continuous darkness!",
            hindiFunFact = "रोचक तथ्य: अरुण ग्रह को सूर्य का एक चक्कर लगाने में पूरे 84 पृथ्वी वर्ष लगते हैं!",
            miniQuiz = LessonMiniQuiz(
                question = "What makes the way Uranus spins unique among all planets?",
                hindiQuestion = "अरुण (Uranus) ग्रह के घूमने का तरीका अन्य सभी ग्रहों से अलग क्यों है?",
                options = listOf(
                    "It is tilted 98 degrees and rolls on its side",
                    "It never spins at all",
                    "It jumps up and down",
                    "It spins in a square path"
                ),
                correctIndex = 0,
                explanation = "Exact match! Uranus is tilted almost 98 degrees on its axis, making it look like it is rolling on its side around the Sun.",
                hindiExplanation = "बिल्कुल सही! अरुण ग्रह अपनी धुरी पर 98 डिग्री झुका हुआ है और एक लुढ़कती गेंद की तरह सूर्य की परिक्रमा करता है।"
            )
        ),
        PlanetData(
            id = "neptune",
            orderFromSun = 8,
            name = "Neptune",
            hindiName = "वरुण (Varun)",
            nickname = "The Windy Blue Ice Giant",
            hindiNickname = "सूर्य से सबसे दूर और सबसे तेज़ हवाओं वाला ग्रह",
            emoji = "🔵",
            primaryColor = NeptuneColor,
            secondaryColor = Color(0xFF1E88E5),
            hasRings = true,
            relativeSizeRatio = 1.4f, // Visually scaled (Real is 3.9x Earth width)
            realDiameterKm = "49,244 km (3.9x wider than Earth)",
            sizeComparisonText = "Neptune is almost the twin of Uranus in size — about 57 Earths could fit inside Neptune!",
            temperatureInfo = "-200°C (-330°F) average temperature",
            distanceFromSunKm = "4.5 billion km (30.1 AU)",
            orbitalPeriod = "165 Earth years",
            moonsCount = 16,
            moonsNotable = "16 moons, led by icy Triton (which orbits backwards and shoots nitrogen geysers)",
            introduction = "Neptune is the eighth and farthest known planet from the Sun in our Solar System. It is more than 30 times farther from the Sun than Earth! Neptune is a dark, cold Ice Giant whipped by supersonic winds that blow faster than the speed of sound.",
            hindiIntroduction = "वरुण (Neptune) हमारे सौर मंडल का आठवाँ और सूर्य से सबसे दूर स्थित ग्रह है। यह पृथ्वी की तुलना में सूर्य से 30 गुना अधिक दूर है! यहाँ सौर मंडल की सबसे तेज़ और बर्फीली हवाएँ चलती हैं।",
            interestingFacts = listOf(
                "Neptune has the strongest winds in the Solar System, reaching speeds over 2,000 km/h (1,200 mph)!",
                "Neptune was predicted using mathematics before anyone ever saw it through a telescope in 1846.",
                "Because its orbit is 165 Earth years long, Neptune completed its very first full orbit since its 1846 discovery in the year 2011!",
                "NASA's Voyager 2 is the only spacecraft that has ever visited Neptune (in 1989)."
            ),
            funFact = "Sunlight takes more than 4 hours to travel all the way from the Sun to Neptune (compared to just 8 minutes to reach Earth)!",
            hindiFunFact = "रोचक तथ्य: सूर्य के प्रकाश को पृथ्वी तक आने में 8 मिनट लगते हैं, लेकिन वरुण (Neptune) तक पहुँचने में 4 घंटे से भी ज़्यादा समय लगता है!",
            miniQuiz = LessonMiniQuiz(
                question = "Which planet is the 8th and farthest planet from the Sun with the fastest winds?",
                hindiQuestion = "सूर्य से आठवाँ और सबसे दूर का ग्रह कौन सा है जहाँ सबसे तेज़ हवाएँ चलती हैं?",
                options = listOf("Neptune", "Mars", "Venus", "Mercury"),
                correctIndex = 0,
                explanation = "Bravo! Neptune is the 8th planet from the Sun and has supersonic winds reaching 2,000 km/h.",
                hindiExplanation = "शानदार! वरुण (Neptune) सूर्य से आठवाँ ग्रह है जहाँ 2,000 किमी/घंटा की रफ़्तार से हवाएँ चलती हैं।"
            )
        )
    )
}
