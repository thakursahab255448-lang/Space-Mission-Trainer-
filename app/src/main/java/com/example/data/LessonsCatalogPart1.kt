package com.example.data

import com.example.model.Lesson
import com.example.model.LessonMiniQuiz
import com.example.model.SceneAnimationType

object LessonsCatalogPart1 {

    val module1Lessons = listOf(
        Lesson(
            id = "m1_l1",
            moduleId = "mod_1",
            moduleName = "Module 1: Introduction to Space",
            lessonNumber = 1,
            title = "What is Space?",
            hindiTitle = "अंतरिक्ष (Space) क्या है?",
            emoji = "🌌",
            simpleExplanation = listOf(
                "Right now, you are surrounded by air that you can breathe. This blanket of air around Earth is called our atmosphere.",
                "As you travel higher and higher up into the sky — about 100 kilometers (62 miles) above the ground — the air becomes thinner and thinner until it disappears completely! That is where Outer Space begins.",
                "In space, there is no air to breathe and no air to carry sound waves, so space is completely silent and dark, filled with stars, planets, moons, and galaxies."
            ),
            everydayExample = "Imagine Earth is an apple. The thin skin of the apple is like our air blanket (atmosphere). Everything outside that apple skin is Outer Space!",
            hindiExplanation = "हमारी पृथ्वी के चारों ओर हवा की एक चादर है जिसे वायुमंडल (Atmosphere) कहते हैं। जब हम जमीन से लगभग 100 किलोमीटर ऊपर जाते हैं, तो हवा खत्म हो जाती है और वहीं से 'अंतरिक्ष' (Space) शुरू होता है। अंतरिक्ष में हवा नहीं है, इसलिए वहाँ कोई आवाज़ नहीं सुनाई देती।",
            importantFacts = listOf(
                "The boundary where space begins (100 km above Earth) is called the Kármán Line.",
                "Sound cannot travel in space because there are no air molecules to vibrate.",
                "The sky looks blue on Earth because air scatters sunlight, but in space the sky is always pitch black!"
            ),
            whatDidYouLearn = listOf(
                "Space starts about 100 km above Earth at the Kármán Line.",
                "There is no air or sound in outer space.",
                "Earth's atmosphere protects us like a warm blanket."
            ),
            sceneType = SceneAnimationType.STARFIELD_NEBULA,
            miniQuiz = LessonMiniQuiz(
                question = "Why can you NOT hear sounds in outer space?",
                hindiQuestion = "बाहरी अंतरिक्ष में हमें आवाज़ क्यों नहीं सुनाई देती?",
                options = listOf(
                    "Because there is no air to carry sound waves",
                    "Because everyone whispers in space",
                    "Because stars are too bright",
                    "Because rockets turn off sound"
                ),
                correctIndex = 0,
                explanation = "Correct! Sound needs air, water, or solid material to travel. Since space is a vacuum with no air, it is silent!",
                hindiExplanation = "बिल्कुल सही! आवाज़ को चलने के लिए हवा की ज़रूरत होती है। अंतरिक्ष में हवा नहीं है, इसलिए वहाँ सन्नाटा होता है।"
            )
        ),
        Lesson(
            id = "m1_l2",
            moduleId = "mod_1",
            moduleName = "Module 1: Introduction to Space",
            lessonNumber = 2,
            title = "What is the Universe?",
            hindiTitle = "ब्रह्मांड (Universe) क्या है?",
            emoji = "✨",
            simpleExplanation = listOf(
                "The Universe is EVERYTHING that exists! It includes you, your school, Earth, the Sun, all the planets, billions of stars, galaxies, light, and even time itself.",
                "Scientists have discovered that the Universe is about 13.8 billion years old and is still growing bigger every single second!",
                "Nobody knows where the edge of the Universe is because it stretches farther than even our most powerful space telescopes can see."
            ),
            everydayExample = "Think of your bedroom inside your house, your house inside your city, and your city on planet Earth. The Universe is the giant cosmic home that holds everything!",
            hindiExplanation = "ब्रह्मांड (Universe) में वह सब कुछ शामिल है जो मौजूद है — आप, हमारा घर, पृथ्वी, सूर्य, सभी ग्रह, अरबों तारे और आकाशगंगाएँ! वैज्ञानिकों के अनुसार ब्रह्मांड लगभग 13.8 अरब साल पुराना है और लगातार फैल रहा है।",
            importantFacts = listOf(
                "The Universe is approximately 13.8 billion years old.",
                "There are more than 2 trillion galaxies in the observable Universe!",
                "Most of the Universe is empty space between galaxies."
            ),
            whatDidYouLearn = listOf(
                "The Universe includes all space, time, matter, planets, and stars.",
                "It is 13.8 billion years old and still expanding.",
                "Earth is a tiny but very special part of this giant Universe."
            ),
            sceneType = SceneAnimationType.SPIRAL_GALAXY,
            miniQuiz = LessonMiniQuiz(
                question = "About how old do scientists estimate the Universe is?",
                hindiQuestion = "वैज्ञानिकों के अनुसार हमारा ब्रह्मांड लगभग कितना पुराना है?",
                options = listOf("13.8 billion years old", "1,000 years old", "1 million years old", "100 years old"),
                correctIndex = 0,
                explanation = "Great job! NASA spacecraft measurements show the Universe is about 13.8 billion years old.",
                hindiExplanation = "सही जवाब! नासा के वैज्ञानिकों के अनुसार ब्रह्मांड लगभग 13.8 अरब वर्ष पुराना है।"
            )
        ),
        Lesson(
            id = "m1_l3",
            moduleId = "mod_1",
            moduleName = "Module 1: Introduction to Space",
            lessonNumber = 3,
            title = "What are Stars?",
            hindiTitle = "तारे (Stars) क्या होते हैं?",
            emoji = "⭐",
            simpleExplanation = listOf(
                "Stars are giant, glowing balls of super-hot gas (mostly hydrogen and helium) held together by their own gravity.",
                "Inside a star's core, hydrogen atoms squeeze together to make helium, releasing huge amounts of light and heat! Our Sun is the closest star to Earth.",
                "Stars come in different colors depending on their temperature: the hottest stars glow blue-white, medium stars like our Sun glow yellow, and cooler stars glow red!"
            ),
            everydayExample = "A star is like a giant cosmic campfire that never runs out of wood for billions of years — warming up the planets around it!",
            hindiExplanation = "तारे (Stars) बेहद गर्म गैसों (हाइड्रोजन और हीलियम) से बने विशाल चमकते गोले हैं। हमारा सूर्य भी एक तारा है! जो तारे सबसे गर्म होते हैं वे नीले दिखते हैं, मध्यम तारे पीले और कम गर्म तारे लाल रंग के दिखते हैं।",
            importantFacts = listOf(
                "Our Sun is an average-sized yellow dwarf star.",
                "Blue stars are the hottest, while red stars are the coolest.",
                "After our Sun, the closest star to Earth is Proxima Centauri (4.2 light-years away)."
            ),
            whatDidYouLearn = listOf(
                "Stars are giant spheres of hot glowing gas that make their own light.",
                "Our Sun is a star.",
                "A star's color tells us how hot it is (blue is hottest, red is coolest)."
            ),
            sceneType = SceneAnimationType.STARFIELD_NEBULA,
            miniQuiz = LessonMiniQuiz(
                question = "Which color of star is the HOTTEST in the universe?",
                hindiQuestion = "ब्रह्मांड में किस रंग का तारा सबसे अधिक गर्म होता है?",
                options = listOf("Blue stars", "Red stars", "Yellow stars", "Brown stars"),
                correctIndex = 0,
                explanation = "Just like the blue part of a candle flame is the hottest, blue stars are the hottest stars in space!",
                hindiExplanation = "बिल्कुल सही! मोमबत्ती की नीली लौ की तरह ही नीले तारे अंतरिक्ष में सबसे गर्म तारे होते हैं।"
            )
        ),
        Lesson(
            id = "m1_l4",
            moduleId = "mod_1",
            moduleName = "Module 1: Introduction to Space",
            lessonNumber = 4,
            title = "What are Galaxies?",
            hindiTitle = "आकाशगंगा (Galaxy) क्या है?",
            emoji = "🌀",
            simpleExplanation = listOf(
                "A galaxy is a gigantic family of billions of stars, planets, gas, and cosmic dust, all held together by gravity and spinning around a bright center.",
                "Some galaxies look like giant spinning pinwheels (Spiral Galaxies), some look like smooth glowing footballs (Elliptical Galaxies), and others have wild shapes (Irregular Galaxies).",
                "Every single star you see with your eyes in the night sky belongs to our own home galaxy!"
            ),
            everydayExample = "If a single star with its planets is like one house, then a galaxy is a giant sparkling city made of billions of star-houses!",
            hindiExplanation = "आकाशगंगा (Galaxy) अरबों तारों, ग्रहों, गैस और धूल का एक विशाल परिवार है जो गुरुत्वाकर्षण (Gravity) से एक साथ बँधा होता है। ये कई आकार की होती हैं — जैसे चक्र जैसी (Spiral) या अंडाकार (Elliptical)।",
            importantFacts = listOf(
                "A typical galaxy contains between 10 billion and 400 billion stars.",
                "The closest large spiral galaxy to us is the Andromeda Galaxy.",
                "Galaxies are categorized into Spiral, Elliptical, and Irregular shapes."
            ),
            whatDidYouLearn = listOf(
                "A galaxy is a massive system of stars, planets, gas, and dust bound by gravity.",
                "Spiral galaxies have beautiful curved arms like a pinwheel.",
                "There are trillions of galaxies across the universe."
            ),
            sceneType = SceneAnimationType.SPIRAL_GALAXY,
            miniQuiz = LessonMiniQuiz(
                question = "What holds all the billions of stars inside a galaxy together?",
                hindiQuestion = "एक आकाशगंगा के अरबों तारों को कौन सी शक्ति एक साथ बाँधकर रखती है?",
                options = listOf("Gravity", "Giant ropes", "Wind", "Clouds"),
                correctIndex = 0,
                explanation = "Correct! Gravity is the invisible cosmic glue that holds stars, planets, and entire galaxies together.",
                hindiExplanation = "सही उत्तर! गुरुत्वाकर्षण (Gravity) ही वह अदृश्य शक्ति है जो पूरी आकाशगंगा को जोड़कर रखती है।"
            )
        ),
        Lesson(
            id = "m1_l5",
            moduleId = "mod_1",
            moduleName = "Module 1: Introduction to Space",
            lessonNumber = 5,
            title = "What is the Milky Way?",
            hindiTitle = "मिल्की वे (दुग्ध मेखला) क्या है?",
            emoji = "🥛",
            simpleExplanation = listOf(
                "The Milky Way is the name of OUR home galaxy! Our Sun, Earth, and the entire Solar System live inside one of its spiral arms.",
                "On a very dark, clear night away from city lights, you can see a glowing, cloudy band of light stretching across the sky. Ancient people thought it looked like spilled milk, so they named it the Milky Way!",
                "In Hindi and Sanskrit, our galaxy is called 'Akashganga' (River of the Sky). It has between 100 billion and 400 billion stars!"
            ),
            everydayExample = "Imagine a giant blueberry pancake with swirling arms of blueberries. Our Solar System is just one tiny sugar crystal sitting halfway out from the center of that pancake!",
            hindiExplanation = "'मिल्की वे' (Milky Way) या 'दुग्ध मेखला' हमारी अपनी आकाशगंगा का नाम है जिसमें हमारा सौर मंडल और पृथ्वी स्थित हैं। यह एक सर्पिल (Spiral) आकाशगंगा है जिसमें 100 से 400 अरब तारे हैं!",
            importantFacts = listOf(
                "The Milky Way is a barred spiral galaxy about 100,000 light-years wide.",
                "Our Solar System takes about 230 million years to orbit the center of the Milky Way once!",
                "At the very center of the Milky Way sits a supermassive black hole called Sagittarius A*."
            ),
            whatDidYouLearn = listOf(
                "The Milky Way (Akashganga) is our home spiral galaxy.",
                "It contains 100 to 400 billion stars and at least as many planets.",
                "Our entire Solar System orbits the center of the Milky Way."
            ),
            sceneType = SceneAnimationType.SPIRAL_GALAXY,
            miniQuiz = LessonMiniQuiz(
                question = "What shape is our home galaxy, the Milky Way?",
                hindiQuestion = "हमारी आकाशगंगा 'मिल्की वे' का आकार कैसा है?",
                options = listOf("A Spiral galaxy with curved arms", "A flat square", "A triangle", "A straight line"),
                correctIndex = 0,
                explanation = "Spot on! The Milky Way is a barred spiral galaxy with giant pinwheel arms of stars.",
                hindiExplanation = "शाबाश! मिल्की वे एक सर्पिल (Spiral) आकाशगंगा है जिसकी घूमती हुई भुजाएँ हैं।"
            )
        )
    )

    val module2Lessons = listOf(
        Lesson(
            id = "m2_l1",
            moduleId = "mod_2",
            moduleName = "Module 2: Solar System",
            lessonNumber = 1,
            title = "What is the Solar System?",
            hindiTitle = "सौर मंडल (Solar System) क्या है?",
            emoji = "☀️",
            simpleExplanation = listOf(
                "Our Solar System is our cosmic neighborhood! It consists of our star, the Sun, and everything that travels around it in curved paths called orbits.",
                "This includes 8 major planets, 5 official dwarf planets (like Pluto and Ceres), more than 290 moons, and millions of rocky asteroids and icy comets.",
                "The word 'Solar' comes from 'Sol', the ancient Roman name for the Sun, because the Sun is the boss at the very center!"
            ),
            everydayExample = "Think of a merry-go-round in a park. The Sun is the bright lamp in the middle, and the 8 planets are riders spinning around it in their own lanes!",
            hindiExplanation = "सूर्य और उसके चारों ओर चक्कर लगाने वाले 8 ग्रहों, उपग्रहों (चंद्रमाओं), क्षुद्रग्रहों (Asteroids) और धूमकेतुओं (Comets) के परिवार को 'सौर मंडल' (Solar System) कहते हैं। सूर्य इसके केंद्र में स्थित है।",
            importantFacts = listOf(
                "Our Solar System formed about 4.6 billion years ago from a giant cloud of gas and dust.",
                "The Sun contains 99.86% of all the mass in the entire Solar System!",
                "All 8 planets orbit the Sun in the same direction along a flat disc."
            ),
            whatDidYouLearn = listOf(
                "The Solar System has the Sun at the center and 8 planets orbiting it.",
                "Gravity from the Sun keeps all the planets in their orbital lanes.",
                "It also includes moons, dwarf planets, asteroids, and comets."
            ),
            sceneType = SceneAnimationType.ORBITING_PLANETS,
            miniQuiz = LessonMiniQuiz(
                question = "What sits at the very center of our Solar System?",
                hindiQuestion = "हमारे सौर मंडल के बिल्कुल केंद्र में क्या स्थित है?",
                options = listOf("The Sun", "Earth", "The Moon", "Jupiter"),
                correctIndex = 0,
                explanation = "Correct! The Sun is at the center of our Solar System, and all 8 planets orbit around it.",
                hindiExplanation = "बिल्कुल सही! सूर्य हमारे सौर मंडल के केंद्र में है और सभी ग्रह इसकी परिक्रमा करते हैं।"
            )
        ),
        Lesson(
            id = "m2_l2",
            moduleId = "mod_2",
            moduleName = "Module 2: Solar System",
            lessonNumber = 2,
            title = "Learn About All 8 Planets",
            hindiTitle = "सभी 8 ग्रहों को जानें",
            emoji = "🪐",
            simpleExplanation = listOf(
                "In order from closest to the Sun to farthest, our 8 planets are: Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, and Neptune!",
                "The first 4 planets (Mercury, Venus, Earth, Mars) are called the Rocky Inner Planets because they have solid rock and metal surfaces you could walk on.",
                "The outer 4 planets are giant worlds: Jupiter and Saturn are Gas Giants, while Uranus and Neptune are icy blue Ice Giants!"
            ),
            everydayExample = "Use this fun sentence to remember the order from the Sun: 'My Very Educated Mother Just Served Us Noodles!' (Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune).",
            hindiExplanation = "सूर्य से दूरी के क्रम में 8 ग्रह हैं: बुध (Mercury), शुक्र (Venus), पृथ्वी (Earth), मंगल (Mars), बृहस्पति (Jupiter), शनि (Saturn), अरुण (Uranus) और वरुण (Neptune)। पहले 4 ग्रह चट्टानी हैं और बाद के 4 विशाल गैस व बर्फ के बने हैं।",
            importantFacts = listOf(
                "Smallest planet: Mercury. Largest planet: Jupiter.",
                "Hottest planet: Venus. Coldest/windy outer planets: Uranus and Neptune.",
                "Only Earth has liquid water oceans on its surface and living creatures!"
            ),
            whatDidYouLearn = listOf(
                "There are 4 rocky inner planets and 4 giant outer planets.",
                "The memory trick 'My Very Educated Mother Just Served Us Noodles' helps us remember their order.",
                "Each planet has unique weather, moons, and temperatures."
            ),
            sceneType = SceneAnimationType.ORBITING_PLANETS,
            miniQuiz = LessonMiniQuiz(
                question = "Which 4 planets are the rocky inner planets closest to the Sun?",
                hindiQuestion = "सूर्य के सबसे पास स्थित 4 चट्टानी ग्रह कौन से हैं?",
                options = listOf(
                    "Mercury, Venus, Earth, Mars",
                    "Jupiter, Saturn, Uranus, Neptune",
                    "Earth, Moon, Sun, Pluto",
                    "Mars, Jupiter, Saturn, Venus"
                ),
                correctIndex = 0,
                explanation = "Awesome! Mercury, Venus, Earth, and Mars are the four rocky terrestrial planets closest to the Sun.",
                hindiExplanation = "शाबाश! बुध, शुक्र, पृथ्वी और मंगल सूर्य के सबसे पास के चार चट्टानी ग्रह हैं।"
            )
        ),
        Lesson(
            id = "m2_l3",
            moduleId = "mod_2",
            moduleName = "Module 2: Solar System",
            lessonNumber = 3,
            title = "The Sun: Our Daytime Star",
            hindiTitle = "सूर्य: हमारा जीवनदाता तारा",
            emoji = "🌞",
            simpleExplanation = listOf(
                "The Sun is a giant, glowing yellow star at the heart of our Solar System. Without the Sun's warmth and light, Earth would be a frozen, lifeless rock!",
                "The Sun gives energy to plants to grow, drives our weather and ocean currents, and gives us daylight.",
                "The Sun is so huge that about 1.3 million Earths could fit inside it! Its surface is 5,500°C, and its center reaches an unbelievable 15 million degrees Celsius."
            ),
            everydayExample = "Even though the Sun is 150 million km away, you can feel its warmth on your face like standing near a warm fireplace on a winter day!",
            hindiExplanation = "सूर्य (The Sun) हमारे सौर मंडल का एकमात्र तारा है। यह इतना विशाल है कि इसमें 13 लाख पृथ्वियाँ समा सकती हैं! सूर्य की रोशनी और गर्मी से ही पृथ्वी पर पेड़-पौधे, मौसम और जीवन संभव है।",
            importantFacts = listOf(
                "Never look directly at the Sun with your eyes — its ultraviolet light is super bright and powerful!",
                "Sunlight takes 8 minutes and 20 seconds to travel 149.6 million km to Earth.",
                "NASA's Parker Solar Probe is the fastest spacecraft ever built, flying close to study the Sun's outer atmosphere."
            ),
            whatDidYouLearn = listOf(
                "The Sun is a star made of hot hydrogen and helium gas.",
                "1.3 million Earths could fit inside the Sun.",
                "All life on Earth depends on the Sun's heat and light."
            ),
            sceneType = SceneAnimationType.ORBITING_PLANETS,
            miniQuiz = LessonMiniQuiz(
                question = "How long does it take for light from the Sun to reach Earth?",
                hindiQuestion = "सूर्य के प्रकाश को पृथ्वी तक पहुँचने में कितना समय लगता है?",
                options = listOf("About 8 minutes and 20 seconds", "1 second", "24 hours", "100 years"),
                correctIndex = 0,
                explanation = "Spot on! Even traveling at 300,000 km per second, sunlight takes about 8 minutes and 20 seconds to reach us.",
                hindiExplanation = "बिल्कुल सही! प्रकाश की तेज़ गति के बावजूद सूर्य की किरणों को पृथ्वी तक आने में 8 मिनट 20 सेकंड लगते हैं।"
            )
        ),
        Lesson(
            id = "m2_l4",
            moduleId = "mod_2",
            moduleName = "Module 2: Solar System",
            lessonNumber = 4,
            title = "Asteroids and Comets",
            hindiTitle = "क्षुद्रग्रह (Asteroids) और धूमकेतु (Comets)",
            emoji = "☄️",
            simpleExplanation = listOf(
                "When the planets were built 4.6 billion years ago, lots of leftover pieces of rock, metal, and ice remained floating around the Sun.",
                "ASTEROIDS are rocky and metallic boulders that orbit the Sun. Most of them live in a giant ring called the 'Asteroid Belt' between Mars and Jupiter.",
                "COMETS are 'cosmic snowballs' made of frozen ice, dust, and rock. When a comet flies close to the Sun, the heat melts some ice into a glowing gas tail that stretches for millions of kilometers!"
            ),
            everydayExample = "When you bake cookies, little crumbs of dough are left on the tray. Asteroids and comets are the cosmic crumbs left over from building the planets!",
            hindiExplanation = "क्षुद्रग्रह (Asteroids) चट्टान और धातु के टुकड़े हैं जो मुख्य रूप से मंगल और बृहस्पति ग्रह के बीच 'एस्टेरॉयड बेल्ट' में घूमते हैं। धूमकेतु (Comets) बर्फ और धूल के गोले हैं, जो सूर्य के पास आने पर एक लंबी चमकदार पूँछ बनाते हैं!",
            importantFacts = listOf(
                "The main Asteroid Belt is located between the orbits of Mars and Jupiter.",
                "A comet's glowing tail always points AWAY from the Sun because of the solar wind.",
                "Halley's Comet visits Earth's sky every 75 to 76 years (it will return in 2061!)."
            ),
            whatDidYouLearn = listOf(
                "Asteroids are rocky objects mostly found between Mars and Jupiter.",
                "Comets are icy snowballs that grow glowing tails near the Sun.",
                "Both are ancient building blocks from the early Solar System."
            ),
            sceneType = SceneAnimationType.STARFIELD_NEBULA,
            miniQuiz = LessonMiniQuiz(
                question = "Where do most asteroids in our Solar System orbit?",
                hindiQuestion = "हमारे सौर मंडल में अधिकांश क्षुद्रग्रह (Asteroids) कहाँ चक्कर लगाते हैं?",
                options = listOf(
                    "In the Asteroid Belt between Mars and Jupiter",
                    "Between Earth and the Moon",
                    "Inside Saturn's rings",
                    "Right next to the Sun"
                ),
                correctIndex = 0,
                explanation = "Correct! Millions of rocky asteroids orbit in the main Asteroid Belt between Mars and Jupiter.",
                hindiExplanation = "सही जवाब! अधिकांश क्षुद्रग्रह मंगल और बृहस्पति की कक्षाओं के बीच 'एस्टेरॉयड बेल्ट' में घूमते हैं।"
            )
        ),
        Lesson(
            id = "m2_l5",
            moduleId = "mod_2",
            moduleName = "Module 2: Solar System",
            lessonNumber = 5,
            title = "Difference Between Planets and Stars",
            hindiTitle = "ग्रह और तारे में क्या अंतर है?",
            emoji = "🔭",
            simpleExplanation = listOf(
                "When you look up at the night sky, both planets and stars look like bright dots of light. So how can you tell them apart?",
                "STARS are giant nuclear furnaces that produce their own dazzling light and heat. Because they are super far away, their light twinkles as it passes through Earth's moving air!",
                "PLANETS do NOT make their own light. They are cooler worlds made of rock, gas, or ice that orbit a star and shine steadily by reflecting sunlight — just like a mirror!"
            ),
            everydayExample = "A Star is like a switched-on flashlight that makes its own beam of light. A Planet is like a bicycle reflector that shines when the flashlight beam hits it!",
            hindiExplanation = "तारे (Stars) स्वयं अपना प्रकाश और गर्मी पैदा करते हैं और रात में टिमटिमाते (Twinkle) हुए दिखते हैं। जबकि ग्रह (Planets) का अपना प्रकाश नहीं होता — वे सूर्य के प्रकाश से चमकते हैं और तारों के चारों ओर चक्कर लगाते हैं।",
            importantFacts = listOf(
                "Rule of thumb: 'Stars twinkle, planets shine steadily!'",
                "Stars are much bigger and hotter than planets.",
                "Planets slowly change their position against the background stars from week to week."
            ),
            whatDidYouLearn = listOf(
                "Stars create their own light and heat; planets reflect light from their star.",
                "Planets orbit around stars.",
                "Stars twinkle in the night sky, while planets glow with a steady light."
            ),
            sceneType = SceneAnimationType.ORBITING_PLANETS,
            miniQuiz = LessonMiniQuiz(
                question = "How do planets shine in the night sky if they don't make their own light?",
                hindiQuestion = "यदि ग्रहों का अपना प्रकाश नहीं होता, तो वे रात के आकाश में कैसे चमकते हैं?",
                options = listOf(
                    "They reflect light from the Sun",
                    "Astronauts put giant lamps on them",
                    "They burn coal",
                    "Lightning storms make them glow"
                ),
                correctIndex = 0,
                explanation = "Exactly! Planets act like giant mirrors in space, reflecting sunlight back to our eyes on Earth.",
                hindiExplanation = "बिल्कुल सही! ग्रह अंतरिक्ष में आईने की तरह सूर्य के प्रकाश को परावर्तित (Reflect) करके चमकते हैं।"
            )
        )
    )

    val module4Lessons = listOf(
        Lesson(
            id = "m4_l1",
            moduleId = "mod_4",
            moduleName = "Module 4: Our Moon",
            lessonNumber = 1,
            title = "What is the Moon?",
            hindiTitle = "चंद्रमा (चंदा मामा) क्या है?",
            emoji = "🌕",
            simpleExplanation = listOf(
                "The Moon is Earth's only natural satellite and our closest neighbor in space! A natural satellite is any space object that orbits around a planet.",
                "The Moon is a rocky world about one-quarter the width of Earth, located an average of 384,400 kilometers (238,855 miles) away.",
                "The Moon's gravity pulls on Earth's oceans to create our high and low ocean tides every day, and it helps keep Earth's tilt steady so our seasons stay gentle!"
            ),
            everydayExample = "If Earth were the size of a basketball, the Moon would be the size of a tennis ball orbiting about 7 meters away!",
            hindiExplanation = "चंद्रमा (Moon) पृथ्वी का एकमात्र प्राकृतिक उपग्रह (Natural Satellite) है। यह पृथ्वी से लगभग 3,84,400 किलोमीटर दूर है और पृथ्वी के चारों ओर चक्कर लगाता है। इसके गुरुत्वाकर्षण से समुद्र में ज्वार-भाटा (Tides) आते हैं।",
            importantFacts = listOf(
                "The Moon is 384,400 km away from Earth — about 30 Earths could fit in that gap!",
                "Gravity on the Moon is 1/6th of Earth's gravity — if you weigh 36 kg on Earth, you'd feel like 6 kg on the Moon!",
                "The Moon has no air or liquid water on its surface, only frozen water ice in dark polar craters."
            ),
            whatDidYouLearn = listOf(
                "The Moon is Earth's natural rocky satellite.",
                "It is 384,400 km away and has 1/6th of Earth's gravity.",
                "Its gravity creates ocean tides on Earth."
            ),
            sceneType = SceneAnimationType.MOON_ORBIT,
            miniQuiz = LessonMiniQuiz(
                question = "How strong is gravity on the Moon compared to Earth?",
                hindiQuestion = "पृथ्वी की तुलना में चंद्रमा पर गुरुत्वाकर्षण कितना है?",
                options = listOf("One-sixth (1/6) as strong — you can jump 6 times higher!", "10 times stronger", "Exactly the same", "Zero gravity"),
                correctIndex = 0,
                explanation = "Correct! Because the Moon is smaller than Earth, its gravity is 1/6th as strong, letting astronauts hop high like kangaroos!",
                hindiExplanation = "सही उत्तर! चंद्रमा का गुरुत्वाकर्षण पृथ्वी का 1/6 भाग है, इसलिए वहाँ आप 6 गुना ऊँची छलांग लगा सकते हैं!"
            )
        ),
        Lesson(
            id = "m4_l2",
            moduleId = "mod_4",
            moduleName = "Module 4: Our Moon",
            lessonNumber = 2,
            title = "Why Does the Moon Shine?",
            hindiTitle = "चंद्रमा क्यों चमकता है?",
            emoji = "✨",
            simpleExplanation = listOf(
                "At night, the Full Moon looks so bright that it can light up your whole backyard. It's easy to think the Moon is glowing like a lightbulb — but it isn't!",
                "The Moon is made of dark gray rock and dust. It does NOT produce any light of its own.",
                "Instead, the Moon shines because the Sun's bright rays hit the Moon's surface and bounce (reflect) down to Earth!"
            ),
            everydayExample = "When a car's headlights shine on a street sign at night, the sign glows brightly even though it has no battery. TheSun is the headlight and the Moon is the sign!",
            hindiExplanation = "चंद्रमा के पास अपना खुद का प्रकाश नहीं है! चंद्रमा चट्टानों और धूल से बना है। जब सूर्य की तेज़ किरणें चंद्रमा पर पड़ती हैं, तो चंद्रमा उन्हें पृथ्वी की ओर परावर्तित (Reflect) करता है, जिससे वह रात में चमकता हुआ दिखता है।",
            importantFacts = listOf(
                "Moonlight is actually reflected sunlight!",
                "It takes just 1.3 seconds for light reflected off the Moon to reach your eyes on Earth.",
                "Despite looking bright white in the dark sky, Moon rock is actually as dark as gray asphalt pavement."
            ),
            whatDidYouLearn = listOf(
                "The Moon does not make its own light.",
                "Moonlight is sunlight bouncing off the Moon's rocky surface.",
                "Light travels from the Moon to Earth in just 1.3 seconds."
            ),
            sceneType = SceneAnimationType.MOON_ORBIT,
            miniQuiz = LessonMiniQuiz(
                question = "Where does moonlight actually come from?",
                hindiQuestion = "चंद्रमा की चाँदनी वास्तव में कहाँ से आती है?",
                options = listOf("Sunlight reflecting off the Moon's surface", "Glowing fire inside the Moon", "Stars behind the Moon", "Earth's city lights"),
                correctIndex = 0,
                explanation = "Spot on! The Moon shines because it reflects light from the Sun.",
                hindiExplanation = "बिल्कुल सही! सूर्य का प्रकाश चंद्रमा की सतह से टकराकर हम तक पहुँचता है।"
            )
        ),
        Lesson(
            id = "m4_l3",
            moduleId = "mod_4",
            moduleName = "Module 4: Our Moon",
            lessonNumber = 3,
            title = "Moon Phases Explained",
            hindiTitle = "चंद्रमा की कलाएँ (Moon Phases)",
            emoji = "🌓",
            simpleExplanation = listOf(
                "Have you noticed how the Moon seems to change shape from a thin banana-shaped crescent to a half circle, to a bright round Full Moon? The Moon isn't actually changing shape!",
                "The Sun always lights up half of the Moon. As the Moon orbits Earth every 29.5 days, we see different angles of its sunlit side.",
                "These changing views are called MOON PHASES: New Moon, Waxing Crescent, First Quarter, Waxing Gibbous, Full Moon, Waning Gibbous, Third Quarter, and Waning Crescent."
            ),
            everydayExample = "Shine a flashlight at a ball in a dark room and walk in a circle around the ball. From the front you see the whole lit side (Full Moon); from the side you see half lit and half shadow!",
            hindiExplanation = "चंद्रमा लगभग 29.5 दिनों में पृथ्वी का एक चक्कर लगाता है। इस दौरान पृथ्वी से हमें चंद्रमा के सूर्य से प्रकाशित हिस्से के अलग-अलग कोण दिखाई देते हैं। इन्हें 'चंद्रमा की कलाएँ' (अमावस्या से पूर्णिमा तक) कहते हैं।",
            importantFacts = listOf(
                "'Waxing' means the lit part we see is growing bigger each night.",
                "'Waning' means the lit part we see is shrinking smaller each night.",
                "A full cycle of Moon phases (New Moon to New Moon) takes 29.5 days — about one month!"
            ),
            whatDidYouLearn = listOf(
                "The Moon's shape doesn't change; our view of its sunlit half changes as it orbits Earth.",
                "There are 8 main phases over a 29.5-day cycle.",
                "Waxing means growing brighter; waning means getting smaller."
            ),
            sceneType = SceneAnimationType.MOON_ORBIT,
            miniQuiz = LessonMiniQuiz(
                question = "How long does it take the Moon to go through all of its phases?",
                hindiQuestion = "चंद्रमा को अपनी सभी कलाओं का एक चक्र पूरा करने में कितने दिन लगते हैं?",
                options = listOf("About 29.5 days (one month)", "24 hours", "365 days", "7 days"),
                correctIndex = 0,
                explanation = "Correct! A complete lunar cycle from one New Moon to the next takes about 29.5 days.",
                hindiExplanation = "शाबाश! चंद्रमा की कलाओं का एक पूरा चक्र लगभग 29.5 दिनों (एक महीने) में पूरा होता है।"
            )
        ),
        Lesson(
            id = "m4_l4",
            moduleId = "mod_4",
            moduleName = "Module 4: Our Moon",
            lessonNumber = 4,
            title = "Lunar Exploration & Surface",
            hindiTitle = "चंद्रमा की सतह और खोज",
            emoji = "🛰️",
            simpleExplanation = listOf(
                "When you look at the Moon, you can see light areas and dark patches. Early astronomers thought the dark patches were oceans, so they called them 'Maria' (Latin for seas)!",
                "Today we know the dark Maria are actually ancient flat plains of hardened volcanic lava, and the bright areas are rugged mountains and craters created by asteroid impacts.",
                "Before humans ever flew to the Moon, robotic spacecraft like Luna, Ranger, and Surveyor took close-up photos and tested the powdery Moon soil (called Regolith)."
            ),
            everydayExample = "Dropping pebbles into a bowl of flour makes round bowl-shaped dents. That's exactly how space rocks created the Moon's craters!",
            hindiExplanation = "चंद्रमा की सतह पर लाखों गड्ढे (Craters) हैं जो उल्कापिंडों के टकराने से बने हैं। चंद्रमा की मिट्टी को 'रेगोलिथ' (Regolith) कहा जाता है। चूँकि वहाँ हवा या बारिश नहीं है, इसलिए वहाँ के निशान करोड़ों वर्षों तक मिटते नहीं हैं।",
            importantFacts = listOf(
                "The powdery gray dust covering the Moon is called 'Lunar Regolith'.",
                "Because the Moon spins once in the exact same time it orbits Earth, we always see the same side (the Near Side) from Earth!",
                "India's Chandrayaan missions and NASA's Lunar Reconnaissance Orbiter discovered frozen water ice in craters near the Moon's South Pole."
            ),
            whatDidYouLearn = listOf(
                "Moon craters were formed by asteroids and meteoroids crashing into the surface.",
                "Moon soil is called Lunar Regolith.",
                "Frozen water ice exists inside permanently shadowed craters at the Lunar South Pole."
            ),
            sceneType = SceneAnimationType.MOON_ORBIT,
            miniQuiz = LessonMiniQuiz(
                question = "Why do footprints left by astronauts on the Moon stay there for millions of years?",
                hindiQuestion = "चंद्रमा पर अंतरिक्ष यात्रियों के पैरों के निशान लाखों सालों तक क्यों नहीं मिटते?",
                options = listOf(
                    "Because there is no wind or rain on the Moon to wash them away",
                    "Because astronauts glued their boots",
                    "Because the Moon is made of wet cement",
                    "Because robots repaint them"
                ),
                correctIndex = 0,
                explanation = "You nailed it! With no atmosphere, wind, or rain on the Moon, footprints in the lunar dust remain untouched for millions of years.",
                hindiExplanation = "बिल्कुल सही! चंद्रमा पर हवा या बारिश नहीं होती, इसलिए वहाँ बने पैरों के निशान कभी नहीं मिटते।"
            )
        ),
        Lesson(
            id = "m4_l5",
            moduleId = "mod_4",
            moduleName = "Module 4: Our Moon",
            lessonNumber = 5,
            title = "NASA's Historic Apollo Missions",
            hindiTitle = "नासा के ऐतिहासिक अपोलो मिशन",
            emoji = "👨‍🚀",
            simpleExplanation = listOf(
                "In the 1960s and 1970s, NASA created the Apollo program to land human beings on the Moon and bring them safely back to Earth.",
                "On July 20, 1969, NASA's Apollo 11 Lunar Module 'Eagle' landed on the Moon! Astronaut Neil Armstrong became the first human to walk on the Moon, followed by Buzz Aldrin, while Michael Collins piloted the command ship in orbit.",
                "Between 1969 and 1972, six Apollo missions (Apollo 11, 12, 14, 15, 16, and 17) landed on the Moon, allowing 12 astronauts to walk, drive a Moon buggy (Lunar Roving Vehicle), and bring back 382 kg of Moon rocks!"
            ),
            everydayExample = "Imagine packing everything you need — air, water, food, and a folding electric car — inside a rocket taller than a 36-story building (the Saturn V rocket)!",
            hindiExplanation = "20 जुलाई 1969 को नासा के 'अपोलो 11' मिशन ने इतिहास रच दिया! नील आर्मस्ट्रांग चंद्रमा पर कदम रखने वाले पहले इंसान बने, और उनके साथ बज़ एल्ड्रिन भी उतरे। 1969 से 1972 के बीच कुल 12 अंतरिक्ष यात्रियों ने चंद्रमा पर चहलकदमी की।",
            importantFacts = listOf(
                "Neil Armstrong's famous first words on the Moon: 'That's one small step for [a] man, one giant leap for mankind.'",
                "The giant Saturn V rocket used by Apollo remains one of the tallest and most powerful rockets ever flown.",
                "Apollo 15, 16, and 17 astronauts drove an electric 'Moon Buggy' across the lunar hills!"
            ),
            whatDidYouLearn = listOf(
                "Apollo 11 landed the first humans on the Moon on July 20, 1969.",
                "Neil Armstrong and Buzz Aldrin were the first two Moonwalkers.",
                "In total, 12 astronauts walked on the Moon during the Apollo program."
            ),
            sceneType = SceneAnimationType.ROCKET_BLASTOFF,
            miniQuiz = LessonMiniQuiz(
                question = "Which NASA mission landed the first humans on the Moon in July 1969?",
                hindiQuestion = "जुलाई 1969 में किस नासा मिशन ने पहली बार इंसानों को चंद्रमा पर उतारा?",
                options = listOf("Apollo 11", "Voyager 1", "Apollo 1", "Viking 1"),
                correctIndex = 0,
                explanation = "Correct! NASA's Apollo 11 landed Neil Armstrong and Buzz Aldrin on the Moon on July 20, 1969.",
                hindiExplanation = "सही उत्तर! अपोलो 11 मिशन ने 20 जुलाई 1969 को पहली बार इंसानों को चंद्रमा पर उतारा था।"
            )
        ),
        Lesson(
            id = "m4_l6",
            moduleId = "mod_4",
            moduleName = "Module 4: Our Moon",
            lessonNumber = 6,
            title = "Future Moon Missions (Artemis)",
            hindiTitle = "भविष्य के चंद्र मिशन (आर्टेमिस)",
            emoji = "🚀",
            simpleExplanation = listOf(
                "Humanity is going back to the Moon — and this time, to stay! NASA's new lunar exploration program is named ARTEMIS (after the twin sister of Apollo in Greek mythology).",
                "Using the powerful Space Launch System (SLS) rocket and the Orion spacecraft, Artemis will land the next astronauts near the Moon's South Pole, where frozen water ice hides in dark craters.",
                "Scientists plan to build the 'Lunar Gateway' space station orbiting the Moon and a permanent Moon base camp to practice living on another world before flying all the way to Mars!"
            ),
            everydayExample = "Exploring the Moon is like camping in your backyard to test your tent and gear before going on a giant wilderness expedition to Mars!",
            hindiExplanation = "नासा का 'आर्टेमिस' (Artemis) प्रोग्राम इंसानों को फिर से चंद्रमा पर ले जा रहा है! इस बार अंतरिक्ष यात्री चंद्रमा के दक्षिणी ध्रुव (South Pole) पर उतरेंगे जहाँ बर्फ के रूप में पानी मौजूद है। यहाँ भविष्य में एक स्थायी बेस कैंप बनाया जाएगा।",
            importantFacts = listOf(
                "Artemis I successfully flew an uncrewed Orion spacecraft around the Moon and back in late 2022.",
                "Water ice at the Moon's South Pole can be melted for drinking water, breathable oxygen, and even rocket fuel!",
                "What astronauts learn at the Moon base will directly prepare us for Mars 2077 missions."
            ),
            whatDidYouLearn = listOf(
                "NASA's Artemis program is returning astronauts to the Moon.",
                "The Lunar South Pole is a key target because its craters hold frozen water ice.",
                "The Moon will serve as a training ground for human journeys to Mars."
            ),
            sceneType = SceneAnimationType.MOON_ORBIT,
            miniQuiz = LessonMiniQuiz(
                question = "Why do future Artemis missions want to land near the Moon's South Pole?",
                hindiQuestion = "भविष्य के आर्टेमिस मिशन चंद्रमा के दक्षिणी ध्रुव (South Pole) पर क्यों उतरना चाहते हैं?",
                options = listOf(
                    "Because craters there contain frozen water ice",
                    "Because there are trees growing there",
                    "Because it is hot like a beach",
                    "Because it is closer to the Sun"
                ),
                correctIndex = 0,
                explanation = "Awesome! Shadowed craters at the Moon's South Pole contain frozen water ice that astronauts can use for water and oxygen.",
                hindiExplanation = "शाबाश! चंद्रमा के दक्षिणी ध्रुव के गड्ढों में बर्फ के रूप में पानी मौजूद है जो अंतरिक्ष यात्रियों के बहुत काम आएगा।"
            )
        )
    )

    val module5Lessons = listOf(
        Lesson(
            id = "m5_l1",
            moduleId = "mod_5",
            moduleName = "Module 5: Mars Exploration",
            lessonNumber = 1,
            title = "What is Mars?",
            hindiTitle = "मंगल ग्रह (Mars) क्या है?",
            emoji = "🔴",
            simpleExplanation = listOf(
                "Mars is the fourth planet from the Sun and Earth's outer neighbor. It is a rocky world with towering volcanoes, deep canyons, polar ice caps, and swirling dust devils!",
                "A day on Mars (called a 'Sol') lasts 24 hours and 37 minutes — just 37 minutes longer than a day on Earth! Mars also has four seasons (spring, summer, autumn, winter) because it is tilted on its axis like Earth.",
                "However, because Mars is farther from the Sun, one full year on Mars lasts 687 Earth days — almost two Earth years!"
            ),
            everydayExample = "If you lived on Mars, your school day would feel almost identical in length to Earth's, but you would only celebrate your birthday once every 687 days!",
            hindiExplanation = "मंगल (Mars) सूर्य से चौथा ग्रह है। यहाँ का एक दिन पृथ्वी के लगभग बराबर (24 घंटे 37 मिनट) होता है जिसे 'सोल' (Sol) कहते हैं। लेकिन मंगल का एक साल 687 पृथ्वी दिनों का होता है!",
            importantFacts = listOf(
                "Mars is about half the diameter of Earth (6,779 km wide).",
                "Gravity on Mars is 38% of Earth's gravity — you could jump nearly 3 times higher on Mars!",
                "Mars has two tiny, lumpy moons named Phobos and Deimos."
            ),
            whatDidYouLearn = listOf(
                "Mars is the 4th planet from the Sun and our rocky neighbor.",
                "A Martian day (Sol) is 24 hours 37 minutes, and a Martian year is 687 Earth days.",
                "Mars has seasons, polar ice caps, giant volcanoes, and 2 moons."
            ),
            sceneType = SceneAnimationType.MARS_ROVER_DRIVE,
            miniQuiz = LessonMiniQuiz(
                question = "What do scientists call a single day on Mars (24 hours 37 minutes)?",
                hindiQuestion = "वैज्ञानिक मंगल ग्रह के एक दिन (24 घंटे 37 मिनट) को क्या कहते हैं?",
                options = listOf("A Sol", "A Lunar", "A Jiffy", "A Light-year"),
                correctIndex = 0,
                explanation = "Correct! NASA scientists and Mars rover teams measure Martian days in 'Sols'.",
                hindiExplanation = "बिल्कुल सही! मंगल ग्रह के एक दिन को वैज्ञानिक भाषा में 'सोल' (Sol) कहा जाता है।"
            )
        ),
        Lesson(
            id = "m5_l2",
            moduleId = "mod_5",
            moduleName = "Module 5: Mars Exploration",
            lessonNumber = 2,
            title = "Why is Mars Called the Red Planet?",
            hindiTitle = "मंगल को 'लाल ग्रह' क्यों कहते हैं?",
            emoji = "🧱",
            simpleExplanation = listOf(
                "Even when you look at Mars from your backyard without a telescope, it glows like a bright orange-red star in the night sky.",
                "Is Mars hot because it is red? No! Mars is actually freezing cold (averaging -65°C). It looks red because its rocks and soil are covered in IRON OXIDE — the exact same material as reddish rust on an old bicycle left in the rain!",
                "Fine rusty dust gets kicked up into the Martian air by winds, making even the Martian sky look butterscotch-pink during the day!"
            ),
            everydayExample = "Think of an old iron garden shovel that turns rusty orange after sitting outside. The whole surface of Mars is covered in that same rusty iron mineral!",
            hindiExplanation = "मंगल ग्रह गर्म नहीं बल्कि बहुत ठंडा है (-65°C)! इसका लाल रंग इसकी मिट्टी में मौजूद 'आयरन ऑक्साइड' (लोहे के जंग) के कारण है। हवा में उड़ती लाल धूल के कारण मंगल का आसमान भी हल्का गुलाबी-नारंगी दिखता है।",
            importantFacts = listOf(
                "Iron oxide (rust) in Martian dust gives the planet its famous red color.",
                "During daytime on Mars, the sky is pinkish-tan, and sunsets around the Sun actually glow BLUE!",
                "Giant dust storms on Mars can sometimes cover the entire planet for weeks."
            ),
            whatDidYouLearn = listOf(
                "Mars is red because its soil is rich in iron oxide (rust).",
                "Red does not mean hot — Mars is a very cold desert planet.",
                "Martian sunsets look blue because of how fine red dust scatters sunlight."
            ),
            sceneType = SceneAnimationType.MARS_ROVER_DRIVE,
            miniQuiz = LessonMiniQuiz(
                question = "What gives Mars its famous reddish-orange color?",
                hindiQuestion = "मंगल ग्रह को उसका प्रसिद्ध लाल-नारंगी रंग किससे मिलता है?",
                options = listOf(
                    "Iron oxide (rust) in its rocks and soil",
                    "Hot red lava covering the planet",
                    "Red flowers growing everywhere",
                    "Red clouds of strawberry gas"
                ),
                correctIndex = 0,
                explanation = "Spot on! Iron minerals in the Martian dirt oxidized (rusted), turning the soil and dust reddish-orange.",
                hindiExplanation = "शाबाश! मंगल की मिट्टी और चट्टानों में मौजूद आयरन ऑक्साइड (जंग) के कारण यह लाल दिखता है।"
            )
        ),
        Lesson(
            id = "m5_l3",
            moduleId = "mod_5",
            moduleName = "Module 5: Mars Exploration",
            lessonNumber = 3,
            title = "Mars Atmosphere & Weather",
            hindiTitle = "मंगल का वायुमंडल और मौसम",
            emoji = "🌬️",
            simpleExplanation = listOf(
                "Mars has an atmosphere (blanket of air), but it is very, very thin — about 100 times thinner than Earth's air!",
                "While Earth's air is mostly nitrogen (78%) and breathable oxygen (21%), Mars's air is 95% CARBON DIOXIDE — the gas that makes fizzy bubbles in soda and that humans breathe out!",
                "Because there is almost no oxygen and very low air pressure, humans cannot breathe Martian air directly and must wear pressurized space suits outside."
            ),
            everydayExample = "Earth's atmosphere is like a thick, cozy winter quilt that keeps us warm. Mars's atmosphere is like a thin tissue paper that lets the heat escape into space!",
            hindiExplanation = "मंगल ग्रह का वायुमंडल पृथ्वी की तुलना में 100 गुना पतला है। इसमें 95% कार्बन डाइऑक्साइड गैस है और ऑक्सीजन नाममात्र (0.16%) है। इसलिए इंसान वहाँ बिना स्पेस सूट के साँस नहीं ले सकते।",
            importantFacts = listOf(
                "Mars's atmosphere is 95% Carbon Dioxide, 2.6% Nitrogen, 1.9% Argon, and only 0.16% Oxygen.",
                "NASA's Perseverance rover carried an instrument called MOXIE that successfully turned Martian carbon dioxide into breathable oxygen!",
                "Whirlwinds called 'dust devils' spin across the Martian plains on sunny afternoons."
            ),
            whatDidYouLearn = listOf(
                "Mars has a very thin atmosphere made of 95% carbon dioxide.",
                "Astronauts need pressurized suits and oxygen tanks to walk on Mars.",
                "NASA technology (MOXIE) has already proven we can make oxygen from Martian air!"
            ),
            sceneType = SceneAnimationType.MARS_ROVER_DRIVE,
            miniQuiz = LessonMiniQuiz(
                question = "What gas makes up 95% of the thin atmosphere on Mars?",
                hindiQuestion = "मंगल ग्रह के पतले वायुमंडल में 95% कौन सी गैस है?",
                options = listOf("Carbon Dioxide", "Oxygen", "Helium", "Water Vapor"),
                correctIndex = 0,
                explanation = "Correct! Mars's atmosphere is 95% carbon dioxide — which plants love and machines like NASA's MOXIE can convert into oxygen.",
                hindiExplanation = "सही जवाब! मंगल के वायुमंडल में 95% कार्बन डाइऑक्साइड गैस पाई जाती है।"
            )
        ),
        Lesson(
            id = "m5_l4",
            moduleId = "mod_5",
            moduleName = "Module 5: Mars Exploration",
            lessonNumber = 4,
            title = "Water on Mars: Ancient Rivers & Ice",
            hindiTitle = "मंगल पर पानी: प्राचीन नदियाँ और बर्फ",
            emoji = "💧",
            simpleExplanation = listOf(
                "Today, Mars looks like a dry desert because its air is too thin and cold for liquid water to stay on the surface for long.",
                "But billions of years ago, Mars was much warmer and wetter! NASA orbiters and rovers have discovered dried-up river valleys, ancient lake beds, smooth river pebbles, and ocean shorelines!",
                "Where did the water go? Huge amounts of water are still locked away today as solid WATER ICE in Mars's North and South Polar Ice Caps and buried beneath the red soil!"
            ),
            everydayExample = "Even when a creek dries up in summer, you can still see the curvy riverbed and smooth round stones left behind. NASA rovers found those exact clues on Mars!",
            hindiExplanation = "अरबों साल पहले मंगल ग्रह पर बड़ी-बड़ी नदियाँ और झीलें बहती थीं! आज भी मंगल पर पानी खत्म नहीं हुआ है — वह इसके उत्तरी और दक्षिणी ध्रुवों (Poles) तथा जमीन के नीचे विशाल बर्फ (Water Ice) के रूप में जमा हुआ है।",
            importantFacts = listOf(
                "NASA's Perseverance rover landed in Jezero Crater — an ancient Martian lake fed by a river delta 3.5 billion years ago!",
                "If all the water ice at Mars's South Pole melted, it could cover the entire planet in an ocean 11 meters deep.",
                "Future astronauts will mine underground Martian ice to melt for drinking water and growing plants."
            ),
            whatDidYouLearn = listOf(
                "Billions of years ago, Mars had flowing liquid rivers and deep lakes.",
                "Today, water on Mars exists mostly as frozen ice at the poles and underground.",
                "Ancient lake beds like Jezero Crater are the best places to look for clues of past tiny life."
            ),
            sceneType = SceneAnimationType.MARS_ROVER_DRIVE,
            miniQuiz = LessonMiniQuiz(
                question = "In what form does most water exist on Mars today?",
                hindiQuestion = "आज मंगल ग्रह पर अधिकांश पानी किस रूप में मौजूद है?",
                options = listOf(
                    "Frozen water ice at the poles and underground",
                    "Warm tropical oceans",
                    "Heavy rainstorms every day",
                    "Hot geysers of steam"
                ),
                correctIndex = 0,
                explanation = "Great job! Most of Mars's water today is frozen solid in the polar ice caps and in glaciers beneath the dusty surface.",
                hindiExplanation = "बिल्कुल सही! आज मंगल का अधिकांश पानी ध्रुवों और जमीन के नीचे बर्फ के रूप में जमा है।"
            )
        ),
        Lesson(
            id = "m5_l5",
            moduleId = "mod_5",
            moduleName = "Module 5: Mars Exploration",
            lessonNumber = 5,
            title = "Mars Rovers: Robotic Explorers",
            hindiTitle = "मार्स रोवर: हमारे रोबोटिक खोजकर्ता",
            emoji = "🤖",
            simpleExplanation = listOf(
                "Before sending humans to Mars, NASA sent smart wheeled robots called ROVERS to explore the surface, zap rocks with lasers, drill samples, and take thousands of high-definition photos!",
                "NASA's famous Mars rovers grew from the microwave-sized Sojourner (1997), to the golf-cart-sized Spirit & Opportunity (2004), to the car-sized Curiosity (2012) and Perseverance (2021)!",
                "Perseverance even brought a tiny robotic helicopter friend named INGENUITY, which made the very first powered flights in the sky of another planet!"
            ),
            everydayExample = "A Mars rover is like a remote-controlled science laboratory on 6 wheels with cameras for eyes, a robotic arm for hands, and a nuclear battery for a heart!",
            hindiExplanation = "मंगल की सतह की जाँच करने के लिए नासा ने पहियों वाले स्मार्ट रोबोट भेजे हैं जिन्हें 'रोवर' (Rover) कहते हैं — जैसे सोजर्नर, स्पिरिट, अपॉर्चुनिटी, क्यूरियोसिटी और पर्सिवरेंस! पर्सिवरेंस के साथ 'इनजेनिटी' (Ingenuity) नाम का छोटा हेलीकॉप्टर भी गया जिसने दूसरे ग्रह पर पहली उड़ान भरी।",
            importantFacts = listOf(
                "NASA has successfully operated 5 rovers on Mars: Sojourner, Spirit, Opportunity, Curiosity, and Perseverance.",
                "The Ingenuity Mars Helicopter completed an amazing 72 flights on Mars!",
                "Perseverance is collecting tubes of Martian rock and soil to be brought back to Earth for study."
            ),
            whatDidYouLearn = listOf(
                "Rovers are robotic mobile laboratories that drive across Mars.",
                "Curiosity and Perseverance are car-sized rovers currently exploring Mars.",
                "Ingenuity was the first helicopter to fly on another planet."
            ),
            sceneType = SceneAnimationType.MARS_ROVER_DRIVE,
            miniQuiz = LessonMiniQuiz(
                question = "What was the name of the small NASA helicopter that flew with the Perseverance rover on Mars?",
                hindiQuestion = "मंगल ग्रह पर पर्सिवरेंस रोवर के साथ उड़ान भरने वाले छोटे नासा हेलीकॉप्टर का नाम क्या था?",
                options = listOf("Ingenuity", "Eagle", "Apollo", "Hubble"),
                correctIndex = 0,
                explanation = "Awesome! The Ingenuity Mars Helicopter proved that powered flight is possible even in Mars's thin atmosphere.",
                hindiExplanation = "शानदार! 'इनजेनिटी' (Ingenuity) हेलीकॉप्टर ने मंगल के पतले वायुमंडल में 72 बार उड़ान भरकर इतिहास रचा।"
            )
        ),
        Lesson(
            id = "m5_l6",
            moduleId = "mod_5",
            moduleName = "Module 5: Mars Exploration",
            lessonNumber = 6,
            title = "Future Human Missions to Mars",
            hindiTitle = "मंगल पर भविष्य के मानव मिशन",
            emoji = "🚀",
            simpleExplanation = listOf(
                "After robots map Mars and astronauts practice living on the Moon, the next giant leap is sending human explorers to walk on the Red Planet!",
                "Traveling to Mars is a big journey: when Earth and Mars line up closely every 26 months, a spacecraft takes about 6 to 9 months just to fly one way!",
                "Engineers are designing giant reusable rockets, radiation shields, and inflatable landing heat shields so astronauts can land heavy habitats and rovers safely on Mars."
            ),
            everydayExample = "Flying to the Moon is like a 3-day weekend road trip. Flying to Mars is like a 7-month ocean voyage across the globe!",
            hindiExplanation = "चंद्रमा के बाद इंसानों का अगला बड़ा लक्ष्य मंगल ग्रह पर कदम रखना है! पृथ्वी से मंगल तक अंतरिक्ष यान से जाने में लगभग 6 से 9 महीने का समय लगता है। आज के बच्चे ही भविष्य के वे अंतरिक्ष यात्री बनेंगे जो मंगल पर चलेंगे!",
            importantFacts = listOf(
                "A one-way trip from Earth to Mars with current rockets takes 6 to 9 months.",
                "Radio messages between Earth and Mars take anywhere from 4 minutes to 22 minutes to travel at the speed of light!",
                "Children who are 7–12 years old today are the exact generation training to lead the Mars missions of the future!"
            ),
            whatDidYouLearn = listOf(
                "A journey from Earth to Mars takes about 6 to 9 months.",
                "Launch windows open every 26 months when Earth and Mars are aligned.",
                "Robotic missions and Artemis Moon bases are preparing the technology for Mars."
            ),
            sceneType = SceneAnimationType.ROCKET_BLASTOFF,
            miniQuiz = LessonMiniQuiz(
                question = "About how long does it take a spacecraft to travel from Earth to Mars?",
                hindiQuestion = "पृथ्वी से मंगल ग्रह तक अंतरिक्ष यान को पहुँचने में लगभग कितना समय लगता है?",
                options = listOf("About 6 to 9 months", "About 10 minutes", "About 3 days", "About 50 years"),
                correctIndex = 0,
                explanation = "Correct! With modern rocket propulsion, flying from Earth to Mars takes roughly 6 to 9 months.",
                hindiExplanation = "सही उत्तर! पृथ्वी से मंगल तक की यात्रा में अंतरिक्ष यान को लगभग 6 से 9 महीने लगते हैं।"
            )
        ),
        Lesson(
            id = "m5_l7",
            moduleId = "mod_5",
            moduleName = "Module 5: Mars Exploration",
            lessonNumber = 7,
            title = "How Astronauts Could Live on Mars (Mars 2077)",
            hindiTitle = "मंगल पर इंसान कैसे रहेंगे? (मिशन 2077)",
            emoji = "🏠",
            simpleExplanation = listOf(
                "By the year 2077, how could astronauts live, work, and thrive on Mars? They will live inside pressurized, heated habitats — including 3D-printed domes made from Martian soil to block cosmic radiation!",
                "Inside brightly lit hydroponic greenhouses, astronauts will grow fresh vegetables like potatoes, lettuce, tomatoes, and strawberries using recycled water and LED grow lights.",
                "Solar panels and compact nuclear power systems will supply electricity, while machines extract water from underground ice and turn Martian carbon dioxide into fresh oxygen and rocket fuel!"
            ),
            everydayExample = "A Mars habitat is like a self-sustaining eco-house that recycles every drop of water, makes its own oxygen, and grows its own indoor garden!",
            hindiExplanation = "सन् 2077 तक अंतरिक्ष यात्री मंगल पर विशेष सुरक्षित गुंबदों (Habitats) में रहेंगे, जो मंगल की मिट्टी से 3D-प्रिंट किए जाएंगे। वे ग्रीनहाउस में सब्जियाँ उगाएंगे, बर्फ से पानी निकालेंगे और मशीनों की मदद से कार्बन डाइऑक्साइड से ऑक्सीजन बनाएंगे!",
            importantFacts = listOf(
                "Using local Martian resources for water and oxygen is called 'In-Situ Resource Utilization' (ISRU).",
                "Scientists on Earth have already grown vegetables in simulated Martian soil and aboard the International Space Station!",
                "Pressurized Mars rovers will work like campers so astronauts can explore far from base for weeks."
            ),
            whatDidYouLearn = listOf(
                "Martian habitats must provide warm air, oxygen, radiation protection, and normal air pressure.",
                "Astronauts will grow food in indoor greenhouses and melt Martian ice for water.",
                "Making oxygen and fuel on Mars lets astronauts live safely and fly back to Earth."
            ),
            sceneType = SceneAnimationType.MARS_ROVER_DRIVE,
            miniQuiz = LessonMiniQuiz(
                question = "How will astronauts on Mars get fresh vegetables to eat?",
                hindiQuestion = "मंगल ग्रह पर रहने वाले अंतरिक्ष यात्रियों को ताज़ी सब्जियाँ कैसे मिलेंगी?",
                options = listOf(
                    "By growing them inside indoor pressurized greenhouses",
                    "By picking them from wild Martian forests",
                    "By ordering fast-food delivery bikes",
                    "Astronauts never eat vegetables"
                ),
                correctIndex = 0,
                explanation = "You got it! Astronauts will grow fresh leafy greens, potatoes, and vegetables inside indoor hydroponic greenhouses.",
                hindiExplanation = "बिल्कुल सही! अंतरिक्ष यात्री सुरक्षित इनडोर ग्रीनहाउस (Greenhouses) के अंदर ताज़ी सब्जियाँ और पौधे उगाएंगे।"
            )
        )
    )
}
