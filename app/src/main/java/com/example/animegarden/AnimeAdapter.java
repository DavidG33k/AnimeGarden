package com.example.animegarden;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import fragments.AnimeSchedeFragment;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.MyViewHolder> {

    Context context;
    ArrayList<HashMap<String, String>> animes;
    Activity activity;

    public AnimeAdapter(Context context, ArrayList<HashMap<String, String>> animes, Activity activity) {
        this.context = context;
        this.animes = animes;
        this.activity = activity;
    }

    public Activity getActivity(){
        return this.activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String s = animes.get(position).get("title");
        if(s.length() > 20){
            String c = s.substring(0, 14) + "."+"."+".";
            s = c;
        }
        String id = animes.get(position).get("id");
        holder.textView.setText(s);
        holder.imageView.setImageDrawable(LoadImageFromWebOperations(animes.get(position).get("image_url")));
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        private ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.item_tx);
            imageView = itemView.findViewById(R.id.item_img);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
        }

    }
}
