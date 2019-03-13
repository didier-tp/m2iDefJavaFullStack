package com.m2i.tp;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * classe utilitaire pour effectuer un appel HTTP en mode GET
 *
 * utilisation:
 *  MySpecificFetchTask extends SimpleGetFetchTask{
 *         @Override
 *         protected void onPostExecute(String s) {
 *             //faire quelquechose du résultat s
 *         }
 * }
 *
 * et appel / déclenchement via (new MySpecificFetchTask()).execute(urlToCall);
 */
public class SimpleGetFetchTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        String strResHttp = null;
        String stringUrl = strings[0];//EN ENTREE : URL à DECLENCHER
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            URL url = new URL(stringUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            int response = conn.getResponseCode();
            if (response != 200) {
                return null;
            }

            inputStream = conn.getInputStream();
            if (inputStream == null) {
                return null;
            }

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
                buffer.append("\n");
            }

            return new String(buffer);//EN RETOUR : TEXTE DE LA REPONSE
        } catch (Exception e) {
            return null;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception ignored) {
                }
            }
        }
    }
}