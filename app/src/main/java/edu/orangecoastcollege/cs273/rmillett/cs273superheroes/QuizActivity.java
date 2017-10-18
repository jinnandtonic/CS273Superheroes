package edu.orangecoastcollege.cs273.rmillett.cs273superheroes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private LinearLayout[] mLinearLayouts = new LinearLayout[2];

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

        // TODO: build mPreferenceChangeListener
        // Register the OnSharedPreferencesChangeListener
//        SharedPreferences mPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(this);
//        mPreferences.registerOnSharedPreferenceChangeListener(mPreferenceChangeListener);

        mQuizSuperheroesList = new ArrayList<>(QUESTIONS_IN_QUIZ);
        rng = new SecureRandom();
        handler = new Handler();

        // Connect GUI
        mQuestionNumberTextView = (TextView) findViewById(R.id.questionNumberTextView);
        mSuperheroImageView = (ImageView) findViewById(R.id.superHeroImageView);
        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);

        // Add buttons to mButtons array
        mButtons[0] = (Button) findViewById(R.id.button);
        mButtons[1] = (Button) findViewById(R.id.button2);
        mButtons[2] = (Button) findViewById(R.id.button3);
        mButtons[3] = (Button) findViewById(R.id.button4);

        // Initialize LinearLayouts
        mLinearLayouts[0] = (LinearLayout) findViewById(R.id.row1LinearLayout);
        mLinearLayouts[1] = (LinearLayout) findViewById(R.id.row2LinearLayout);

        // Set mQuestionNumberTextView's text
        mQuestionNumberTextView.setText(getString(R.string.question, 1, QUESTIONS_IN_QUIZ));

        // TODO: Load all superheroes from the JSON file using JSONLoader
//        try {
//            mAllSuperheroesList = JSONLoader.loadJSONFromAsset(this);
//        }
//        catch (IOException e) {
//            Log.e(TAG, "Error loading JSON file", e);
//        }

        // TODO: preferences
//        mMode = mPreferences.getString(MODES, "All");
        updateMode();

        // Reset quiz
        resetQuiz();
    }

    /**
     * Initializes random questions and starts a new quiz
     */
    public void resetQuiz() {
        // TODO: resetQuiz() method
    }

    /**
     * Initiates the process of loading the next image for the quiz, showing the
     * superhero's image along with 4 buttons, one of which contains the correct
     * answer.
     */
    public void loadNextImage() {
        // TODO: loadNextImage() method
    }

    /**
     * Handles the click event of one of the 4 buttons indicating the guess of a superhero's name
     * to match the superhero image displayed.  If the guess is correct, the superhero's name
     * (in GREEN) will be shown, followed by a slight delay of 2 seconds, then the next image will
     * be loaded. Otherwise, the word "Incorrect Guess" will be shown in RED and the button will be
     * disabled.
     * @param view
     */
    public void makeGuess(View view) {
        // TODO: makeGuess() method
    }

    /**
     * Override onCreateOptionsMenu to inflate the settings menu within QuizActivity
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Responds to user clicking the Settings menu icon
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Make a new Intent going to SettingsActivity
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);

        return super.onOptionsItemSelected(item);
    }

    SharedPreferences.OnSharedPreferenceChangeListener mPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            switch (key) {
                case MODES:
                    mMode = sharedPreferences.getString(MODES, "Superhero Name");
                    updateMode();
                    resetQuiz();
            }
        }
    };

    /**
     * Updates the mode of gameplay selected by the user in the <code>SettingsActivity</code>.
     */
    public void updateMode() {
        // TODO: updateMode() method
    }
}
