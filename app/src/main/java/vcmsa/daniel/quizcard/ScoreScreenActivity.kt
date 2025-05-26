package vcmsa.daniel.quizcard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Creating Variables for the Buttons
        var btReviewScoreScreen = findViewById<Button>(R.id.btReviewScoreScreen)
        var btExitScoreScreen = findViewById<Button>(R.id.btExitScoreScreen)
        var tvUserScore = findViewById<TextView>(R.id.tvUserScore)

        // This retrieves the score we got from the FlashCardQuestionActivity
        val score = intent.getIntExtra("score", 0)
        tvUserScore.text = "Your score is :$score/5"
        if (score == 5) {
            tvUserScore.text = "You got all the questions correct!"
        }
        else if (score == 4) {
            tvUserScore.text = "You got 4/5 correct. Almost all of them!"
        }
        else if (score == 3) {
            tvUserScore.text = "You got 3/5 correct. You can do better!"
            }
        else if (score == 2) {
            tvUserScore.text = "You got 2/5 correct. You can easily fix this score!"
        }
        else if (score == 1) {
            tvUserScore.text = "You got 1/5 correct. Keep Trying!"
        }



        btReviewScoreScreen.setOnClickListener {
            val intent = Intent(this, Review_screen::class.java)

            startActivity(intent)
            finish()

        }
        btExitScoreScreen.setOnClickListener {
            finish()
        }
    }
}