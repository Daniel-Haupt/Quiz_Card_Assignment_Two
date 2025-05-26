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
        //  Variables for later use
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

        tvQuestionsAsked.text = question

        btTrueFlashCardScreen.setOnClickListener {
            if (answerArray[questionCounter] == "True") {
                score++
            }
            if (questionCounter == 4) {
                btFalseFlashCardScreen.isEnabled = false
                btTrueFlashCardScreen.isEnabled = false
            } else {

                questionCounter++
                question = questionArray[questionCounter]
                answer = answerArray[questionCounter]
                tvQuestionsAsked.text = question
            }
        }
        btFalseFlashCardScreen.setOnClickListener {
            if (answerArray[questionCounter] == "False") {
                score++
            }
            if (questionCounter == 4) {
                btFalseFlashCardScreen.isEnabled = false
                btTrueFlashCardScreen.isEnabled = false
            } else {

                questionCounter++
                question = questionArray[questionCounter]
                answer = answerArray[questionCounter]
                tvQuestionsAsked.text = question
            }
        }
        btNextFlashCardScreen.setOnClickListener {
            val intent = Intent(this, ScoreScreenActivity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
            finish()
        }
    }
}














