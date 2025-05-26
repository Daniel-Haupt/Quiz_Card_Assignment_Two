package vcmsa.daniel.quizcard

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Review_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        Creating Variables for later use
        var tvanswerOutput = findViewById<TextView>(R.id.tvReviewAnswerOutput)

//        I make use of an Array for the Questions and Answers.
        val questionArray = arrayOf(
            "\nQuestion 1: The Titanic sank 1912\n",
            "\nQuestion 2: World war 2 ended in 1940\n",
            "\nQuestion 3: South Africa wsa the first country to land on the moon\n",
            "\nQuestion 4: Abraham Lincoln is the first president of the United States\n",
            "\nQuestion 5: The Great Depression in Germany started in 1925\n",
        )
        val answerArray = arrayOf(
            "True",
            "False",
            "False",
            "False",
            "False",
        )
//        I change the array to use the question counter to loop through the array and display the questions and answer in the textview.
        tvanswerOutput.text = questionArray[0] + " Correct Answer: \n" + answerArray[0]
        tvanswerOutput.append(questionArray[1] + " Correct Answer: \n" + answerArray[1])
        tvanswerOutput.append(questionArray[2] + " Correct Answer: \n" + answerArray[2])
        tvanswerOutput.append(questionArray[3] + " Correct Answer: \n" + answerArray[3])
        tvanswerOutput.append(questionArray[4] + " Correct Answer: \n" + answerArray[4])































































    }
}