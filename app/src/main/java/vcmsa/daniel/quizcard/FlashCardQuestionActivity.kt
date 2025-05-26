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
        var btToScoreScreen = findViewById<Button>(R.id.btToScoreScreen)
        var tvCorrectOrIncorrect = findViewById<TextView>(R.id.tvCorrectOrIncorrect)

        // I make use of an Array for the Questions and Answers
        val questionArray = arrayOf(
            "Question 1: The Titanic sank 1912",
            "Question 2: World war 2 ended in 1940",
            "Question 3: South Africa wsa the first country to land on the moon",
            "Question 4: Abraham Lincoln is the first president of the United States",
            "Question 5: The Great Depression in Germany started in 1925",
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
        questionArray[questionCounter]
        answerArray[questionCounter]
        // Changing the textview to display the question
        tvQuestionsAsked.text = questionArray[questionCounter]
        // On Click Listeners for the True and False Buttons. Inside the Click Listener I check if the answer is correct or not, disable the buttons, change the textview to display the answer and score.
        btTrueFlashCardScreen.setOnClickListener {
            if (answerArray[questionCounter] == "True") {
                score++
                btFalseFlashCardScreen.isEnabled = false
                btTrueFlashCardScreen.isEnabled = false
                tvCorrectOrIncorrect.text = "Correct"

            } else {
                btFalseFlashCardScreen.isEnabled = false
                btTrueFlashCardScreen.isEnabled = false
                tvCorrectOrIncorrect.text = "Incorrect"
            }
        }
        btFalseFlashCardScreen.setOnClickListener {
            if (answerArray[questionCounter] == "False") {
                score++
                btFalseFlashCardScreen.isEnabled = false
                btTrueFlashCardScreen.isEnabled = false
                tvCorrectOrIncorrect.text = "Correct"
            } else {
                btFalseFlashCardScreen.isEnabled = false
                btTrueFlashCardScreen.isEnabled = false
                tvCorrectOrIncorrect.text = "Incorrect"
            }
        }
        // On Click Listener for the Next Button. This loop to the next question in the array and disables the buttons.
        btNextFlashCardScreen.setOnClickListener {
            questionCounter++
            questionArray[questionCounter]
            answerArray[questionCounter]
            tvQuestionsAsked.text = questionArray[questionCounter]
            btFalseFlashCardScreen.isEnabled = true
            btTrueFlashCardScreen.isEnabled = true
            tvCorrectOrIncorrect.text = ""
            if (questionCounter == 4) {
                btNextFlashCardScreen.isEnabled = false
            }
        }
        // On Click Listener for the Score Screen Button. It takes the user to the Score Screen and sends the score to the Score Screen.
        btToScoreScreen.setOnClickListener {
            val intent = Intent(this, ScoreScreenActivity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
            finish()
        }
    }
}














