package edu.orangecoastcollege.cs273.rmillett.cs273superheroes;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * <code>QuizActivity</code> is an interactive quiz that displays random images of CS273 students
 * drawn from a database and prompts the user to match the correct name, super power, or piece of
 * trivia depending on which mode of play has been selected
 */
public class QuizActivity extends AppCompatActivity {

    public static final String TAG = "Superhero Quiz";
    public static final int QUESTIONS_IN_QUIZ = 10;

    private Button[] mButtons = new Button[4];
    private LinearLayout[] mLinearLayout = new LinearLayout[2];

    // TODO: create Superhero model class
    private List<Superhero> mAllSuperheroesList;
    private List<Superhero> mQuizSuperheroesList;
    private List<Superhero> mFilteredSuperheroesList;

    private Superhero mCorrectSuperhero;

    private int mTotalGuesses;
    private int mCorrectGuesses;

    private SecureRandom rng;

    private Handler handler;

    private TextView mQuestionNumberTextView;
    private ImageView mSuperheroImageView;
    private TextView mAnswerTextView;

    private String mMode;

    public static final String MODES = "modes";

    /**
     * Creates an instance of <code>QuizActivity</code> in the view
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // TODO: build mPreferenceChangeListener class
        // Register the OnSharedPreferencesChangeListener
//        SharedPreferences mPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(this);
//        mPreferences.registerOnSharedPreferenceChangeListener(mPreferenceChangeListener);

        mQuizSuperheroesList = new ArrayList<>(QUESTIONS_IN_QUIZ);
        rng = new SecureRandom();
        handler = new Handler();


    }
}
