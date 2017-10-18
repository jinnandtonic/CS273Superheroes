package edu.orangecoastcollege.cs273.rmillett.cs273superheroes;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class loads <code>Superhero</code> data from a formatted JSON (JavaScript Object Notation) file.
 * Populates data model (Superhero) with data.
 *
 * @author Ryan Millett.
 * @version 1.0
 */
class JSONLoader {
    public static List<Superhero> loadJSONFromAsset(Context context) throws IOException {
        List<Superhero> allSuperheroesList = new ArrayList<>();
        String json = null;
        InputStream is = context.getAssets().open("cs273superheroes.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer, "UTF-8");

        try {
            JSONObject jsonRootObject = new JSONObject(json);
            JSONArray allSuperheroesJSON = jsonRootObject.getJSONArray("Superheroes");

            int length = allSuperheroesJSON.length();
            for (int i = 0; i < length; ++i) {
                JSONObject superheroObject = allSuperheroesJSON.getJSONObject(i);
                String username = superheroObject.getString("Username");
                String name = superheroObject.getString("Name");
                String superpower = superheroObject.getString("Superpower");
                String oneThing = superheroObject.getString("OneThing");
                Superhero superhero = new Superhero(username, name, superpower, oneThing);
                allSuperheroesList.add(superhero);
            }
        }
        catch (JSONException e) {
            Log.e("Superhero Quiz", e.getMessage());
        }
        return allSuperheroesList;
    }
}
