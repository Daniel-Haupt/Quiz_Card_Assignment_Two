package vcmsa.daniel.quizcard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlashCardQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flash_card_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var tvQuestionsAsked = findViewById<TextView>(R.id.tvQuestionsAsked)
        var btNextFlashCardScreen = findViewById<Button>(R.id.btNextFlashCardScreen)
        var btTrueFlashCardScreen = findViewById<Button>(R.id.btTrueFlashCardScreen)
        var btFalseFlashCardScreen = findViewById<Button>(R.id.btFalseFlashCardScreen)

        // I make use of an Array for the Questions and Answers
        val questionArray = arrayOf(
                "Did the Titanic sink 1912?",
                "Did world war 2 end in 1940?",
                "Was South Africa the first country to lad on the moon?",
                "Abraham Lincoln is the first president of the United States?",
                "The Great Depression in Germany started in 1925?",
        )
        val answerArray = arrayOf(
                "True",
                "False",
                "False",
                "False",
                "False",
        )
        // I declare the questionCounter and score variables, setting them both to 0
        var questionCounter = 0
        var score = 0

        // I change the array to use the question counter to loop through the array
        var question = questionArray[questionCounter]
        var answer = answerArray[questionCounter]

        // I print the question to the screen
        tvQuestionsAsked.text = question


        // I make use of a While Loop to loop through the questionArray and answerArray
        while (questionCounter < questionArray.size) {
        // I use the button to check if the answer is correct by checking the answer in the answerArray and if correct user gets +1 score and questionCounter goes up. If user answer is incorrect only the questionCounter goes up.
            btTrueFlashCardScreen.setOnClickListener {
                if (answer == answerArray[0]) {
                    score++
                    questionCounter++
                    answerArray[0+1]
                } else {
                    questionCounter++
                    answerArray[0+1]
                }
            }
        // I use the button to check if the answer is correct by checking the answer in the answerArray and if correct user gets +1 score and questionCounter goes up. If user answer is incorrect only the questionCounter goes up.
            btFalseFlashCardScreen.setOnClickListener {
                if (answer == answerArray[0]) {
                    score++
                    questionCounter++
                    answerArray[0+1]
                } else {
                    questionCounter++
                    answerArray[0+1]
                }
            }
            btNextFlashCardScreen.setOnClickListener {
                val intent = Intent(this, ScoreScreenActivity::class.java)
                startActivity(intent)
            }
        }
























    }
}