package com.learning.quizapp

object constants{
    const val SCORE= "score"
    const val TOTAL_QUESTIONS = "total_questions"
    var userName = "user_name"

    fun getQuestions(): ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()


        val qt1 = Questions(
            id = 1,
            question = "What country does this flag belongs to?",
            image = R.drawable.fi,
            optionOne = "England",
            optionTwo = "Argentina",
            optionThree = "Finland",
            optionFour = "Honduras",
            correntAnswer = 3
        )
        questionsList.add(qt1)

        val qt2 = Questions(
            id = 2,
            question = "What country does this flag belongs to?",
            image = R.drawable.cn,
            optionOne = "England",
            optionTwo = "Turkey",
            optionThree = "China",
            optionFour = "Honduras",
            correntAnswer = 3
        )
        questionsList.add(qt2)
        val qt3 = Questions(
            id = 3,
            question = "What country does this flag belongs to?",
            image = R.drawable.bd,
            optionOne = "England",
            optionTwo = "Bangladesh",
            optionThree = "Japan",
            optionFour = "Bhutan",
            correntAnswer = 2
        )
        questionsList.add(qt3)

        val qt4 = Questions(
            id = 4,
            question = "What country does this flag belongs to?",
            image = R.drawable.tr,
            optionOne = "Turkey",
            optionTwo = "China",
            optionThree = "France",
            optionFour = "Chili",
            correntAnswer = 1
        )
        questionsList.add(qt4)

        val qt5 = Questions(
                id = 5,
                question = "What country does this flag belongs to?",
                image = R.drawable.mv,
                optionOne = "Bhutan",
                optionTwo = "Chad",
                optionThree = "Myanmar",
                optionFour = "Maldive",
                correntAnswer = 4
        )
        questionsList.add(qt5)

        val qt6 = Questions(
                id = 6,
                question = "What country does this flag belongs to?",
                image = R.drawable.jp,
                optionOne = "Chili",
                optionTwo = "Japan",
                optionThree = "Myanmar",
                optionFour = "England",
                correntAnswer = 2
        )
        questionsList.add(qt6)

        val qt7 = Questions(
                id = 7,
                question = "What country does this flag belongs to?",
                image = R.drawable.ar,
                optionOne = "Brazil",
                optionTwo = "Australia",
                optionThree = "Argentina",
                optionFour = "Austria",
                correntAnswer = 3
        )
        questionsList.add(qt7)

        val qt8 = Questions(
                id = 8,
                question = "What country does this flag belongs to?",
                image = R.drawable.ir,
                optionOne = "Iraq",
                optionTwo = "Iran",
                optionThree = "India",
                optionFour = "Italy",
                correntAnswer = 2
        )
        questionsList.add(qt8)

        val qt9 = Questions(
                id = 9,
                question = "What country does this flag belongs to?",
                image = R.drawable.ps,
                optionOne = "Lebanon",
                optionTwo = "South Africa",
                optionThree = "Palestine",
                optionFour = "Maldive",
                correntAnswer = 3
        )
        questionsList.add(qt9)

        val qt10 = Questions(
                id = 10,
                question = "What country does this flag belongs to?",
                image = R.drawable.ru,
                optionOne = "Austria",
                optionTwo = "France",
                optionThree = "Russia",
                optionFour = "Italy",
                correntAnswer = 3
        )
        questionsList.add(qt10)



        return questionsList
    }
}