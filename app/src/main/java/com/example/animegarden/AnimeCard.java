package com.example.animegarden;

import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

public class AnimeCard {
    private ImageView imageView;
    private TextView textView;

    public AnimeCard(ImageView imageView, TextView textView){
        this.imageView = imageView;
        this.textView = textView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
