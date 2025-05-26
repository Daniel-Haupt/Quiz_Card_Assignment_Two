package vcmsa.daniel.quizcard

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


    }
}