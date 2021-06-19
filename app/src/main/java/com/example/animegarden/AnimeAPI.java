package com.example.animegarden;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class AnimeAPI {

    private static HttpURLConnection connection;
    private static URL url;

    // per gli episodi https://api.jikan.moe/v3/anime/1535/episodes

    public static ArrayList<HashMap<String, String>> searchAnime(String title){

        ArrayList<HashMap<String, String>> searchResult = new ArrayList<HashMap<String, String>>();

        try {
            url = new URL("https://api.jikan.moe/v3/search/anime?q=" + title + "&page=1");
            connection = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            JSONObject JSONresponse = new JSONObject(response.toString());
            JSONArray results_array = new JSONArray(JSONresponse.getJSONArray("results").toString());

            for(int i = 0; i < results_array.length(); i++) {
                HashMap<String, String> anime = new HashMap<String, String>();

                anime.put("id", results_array.getJSONObject(i).getString("mal_id"));
                anime.put("synopsis", results_array.getJSONObject(i).getString("synopsis"));
                anime.put("title", results_array.getJSONObject(i).getString("title"));
                anime.put("url", results_array.getJSONObject(i).getString("url"));
                anime.put("image_url", results_array.getJSONObject(i).getString("image_url"));
                anime.put("episodes", results_array.getJSONObject(i).getString("episodes"));
                anime.put("start_date", results_array.getJSONObject(i).getString("start_date"));
                anime.put("end_date", results_array.getJSONObject(i).getString("end_date"));
                anime.put("score", results_array.getJSONObject(i).getString("score"));

                searchResult.add(anime);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return searchResult;
    }

    public static ArrayList<HashMap<String, String>> getAnimeByPopularity(){

        ArrayList<HashMap<String, String>> AnimeByPopolarity = new ArrayList<HashMap<String, String>>();

        try {
            url = new URL("https://api.jikan.moe/v3/top/anime/1/bypopularity");
            connection = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            JSONObject JSONresponse = new JSONObject(response.toString());
            JSONArray top_array = new JSONArray(JSONresponse.getJSONArray("top").toString());

            for(int i = 0; i < top_array.length() && i < 10; i++) {
                HashMap<String, String> anime = new HashMap<String, String>();

                anime.put("id", top_array.getJSONObject(i).getString("mal_id"));
                anime.put("rank", top_array.getJSONObject(i).getString("rank"));
                anime.put("title", top_array.getJSONObject(i).getString("title"));
                anime.put("url", top_array.getJSONObject(i).getString("url"));
                anime.put("image_url", top_array.getJSONObject(i).getString("image_url"));
                anime.put("episodes", top_array.getJSONObject(i).getString("episodes"));
                anime.put("start_date", top_array.getJSONObject(i).getString("start_date"));
                anime.put("end_date", top_array.getJSONObject(i).getString("end_date"));
                anime.put("score", top_array.getJSONObject(i).getString("score"));

                AnimeByPopolarity.add(anime);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return AnimeByPopolarity;
    }

    public static ArrayList<HashMap<String, String>> getUpComingAnime(){

        ArrayList<HashMap<String, String>> upComingAnime = new ArrayList<HashMap<String, String>>();

        try {
            url = new URL("https://api.jikan.moe/v3/top/anime/1/upcoming");
            connection = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            JSONObject JSONresponse = new JSONObject(response.toString());
            JSONArray top_array = new JSONArray(JSONresponse.getJSONArray("top").toString());

            for(int i = 0; i < top_array.length() && i < 10; i++) {
                HashMap<String, String> anime = new HashMap<String, String>();

                anime.put("id", top_array.getJSONObject(i).getString("mal_id"));
                anime.put("rank", top_array.getJSONObject(i).getString("rank"));
                anime.put("title", top_array.getJSONObject(i).getString("title"));
                anime.put("url", top_array.getJSONObject(i).getString("url"));
                anime.put("image_url", top_array.getJSONObject(i).getString("image_url"));
                anime.put("start_date", top_array.getJSONObject(i).getString("start_date"));

                upComingAnime.add(anime);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return upComingAnime;
    }

    public static ArrayList<HashMap<String, String>> getEpisodeAnime(int id){

        ArrayList<HashMap<String, String>> episodesAnime = new ArrayList<HashMap<String, String>>();

        try {
            url = new URL("https://api.jikan.moe/v3/anime/"+id+"/episodes");
            connection = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            JSONObject JSONresponse = new JSONObject(response.toString());
            JSONArray episodes_array = new JSONArray(JSONresponse.getJSONArray("episodes").toString());

            for(int i = 0; i < episodes_array.length(); i++) {
                HashMap<String, String> anime = new HashMap<String, String>();

                anime.put("episode id", episodes_array.getJSONObject(i).getString("episode_id"));
                anime.put("title", episodes_array.getJSONObject(i).getString("title"));
                anime.put("title romanji", episodes_array.getJSONObject(i).getString("title_romanji"));
                anime.put("filler", episodes_array.getJSONObject(i).getString("filler"));
                anime.put("recap", episodes_array.getJSONObject(i).getString("recap"));

                episodesAnime.add(anime);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return episodesAnime;
    }

    public static HashMap<String, String> getElementsSchede(String id){
        HashMap<String, String> list = new HashMap<>();
        try {
            url = new URL("https://api.jikan.moe/v3/anime/"+id);
            connection = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            JSONObject JSONresponse = new JSONObject(response.toString());

            list.put("description", JSONresponse.getString("synopsis"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static ArrayList<HashMap<String, String>> getAnimeByGenre(int genre){
        ArrayList<HashMap<String, String>> animeResult = new ArrayList<HashMap<String, String>>();
        try {
            url = new URL("https://api.jikan.moe/v3/top/anime/"+genre+"/bypopularity");
            connection = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            JSONObject JSONresponse = new JSONObject(response.toString());
            JSONArray results_array = new JSONArray(JSONresponse.getJSONArray("anime").toString());

            for(int i = 0; i < results_array.length(); i++) {
                HashMap<String, String> anime = new HashMap<String, String>();

                anime.put("id", results_array.getJSONObject(i).getString("mal_id"));
                anime.put("title", results_array.getJSONObject(i).getString("title"));
                anime.put("image_url", results_array.getJSONObject(i).getString("image_url"));


                animeResult.add(anime);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }





        return  animeResult;
    }
}
