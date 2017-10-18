package edu.orangecoastcollege.cs273.rmillett.cs273superheroes;

/**
 * Represents a Superhero for the purposes of <code>QuizActivity</code>, including the superhero's
 * name, superpower, piece of trivia, and file name
 *
 * @author Ryan Millett.
 * @version 1.0
 */
public class Superhero {

    private String mUsername;
    private String mName;
    private String mSuperpower;
    private String mOneThing;
    private String mFileName;

    /**
     * Instantiates a new <code>Superhero</code> given its username, name, superpower, and one thing.
     * @param username The username of the <code>Superhero</code>
     * @param name The name of the <code>Superhero</code>
     * @param superpower The superpower of the <code>Superhero</code>
     * @param oneThing One piece of trivia about the <code>Superhero</code>
     */
    public Superhero(String username, String name, String superpower, String oneThing) {
        mUsername = username;
        mName = name;
        mSuperpower = superpower;
        mOneThing = oneThing;
//        name = name.replaceAll(" ", "_");
//        superpower = superpower.replaceAll(" ", "_");
//        oneThing = oneThing.replaceAll(" ", "_");
        mFileName = "superheroes/" + username + ".png";
    }

    /**
     * Gets the username of the <code>Superhero</code>
     * @return The username of the <code>Superhero</code>
     */
    public String getUsername() {
        return mUsername;
    }

    /**
     * Gets the name of the <code>Superhero</code>
     * @return The name of the <code>Superhero</code>
     */
    public String getName() {
        return mName;
    }

    /**
     * Gets the superpower of the <code>Superhero</code>
     * @return The superpower of the <code>Superhero</code>
     */
    public String getSuperpower() {
        return mSuperpower;
    }

    /**
     * Gets the one thing of the <code>Superhero</code>
     * @return The one thing of the <code>Superhero</code>
     */
    public String getOneThing() {
        return mOneThing;
    }

    /**
     * Gets the file name of the <code>Superhero</code>
     * @return The file name of the <code>Superhero</code>
     */
    public String getFileName() {
        return mFileName;
    }

    /**
     * Compares two <code>Superhero</code> objects for equality based on username, name, superpower,
     * one thing, and file name.
     * @param o The other <code>Superhero</code>
     * @return True if the <code>Superhero</code> objects are the same, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Superhero superhero = (Superhero) o;

        if (mUsername != null ? !mUsername.equals(superhero.mUsername) : superhero.mUsername != null)
            return false;
        if (mName != null ? !mName.equals(superhero.mName) : superhero.mName != null) return false;
        if (mSuperpower != null ? !mSuperpower.equals(superhero.mSuperpower) : superhero.mSuperpower != null)
            return false;
        if (mOneThing != null ? !mOneThing.equals(superhero.mOneThing) : superhero.mOneThing != null)
            return false;
        return mFileName != null ? mFileName.equals(superhero.mFileName) : superhero.mFileName == null;

    }

    /**
     * Generates an integer based hash code to uniquely represent this <code>Superhero</code>.
     * @return An integer based hash code to represent this <code>Superhero</code>.
     */
    @Override
    public int hashCode() {
        int result = mUsername != null ? mUsername.hashCode() : 0;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (mSuperpower != null ? mSuperpower.hashCode() : 0);
        result = 31 * result + (mOneThing != null ? mOneThing.hashCode() : 0);
        result = 31 * result + (mFileName != null ? mFileName.hashCode() : 0);
        return result;
    }

    /**
     * Generates a text based representation of this <code>Superhero</code>.
     * @return A text based representation of this <code>Superhero</code>.
     */
    @Override
    public String toString() {
        return "Superhero{" +
                "mUsername='" + mUsername + '\'' +
                ", mName='" + mName + '\'' +
                ", mSuperpower='" + mSuperpower + '\'' +
                ", mOneThing='" + mOneThing + '\'' +
                ", mFileName='" + mFileName + '\'' +
                '}';
    }
}
