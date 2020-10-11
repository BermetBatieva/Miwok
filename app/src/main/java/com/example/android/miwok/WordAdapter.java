package com.example.android.miwok;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;
    public WordAdapter(Activity context, ArrayList<Word> wordList, int background_color) {

        super(context, 0, wordList);

        mColorResourceId = background_color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        View textContainer = listItemView.findViewById(R.id.text_container);


        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);

        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.english_word);


        defaultTranslation.setText(currentWord.getmDefaultTranslation());

        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.miwok_word);
        miwokTranslation.setText(currentWord.getmMiwokTranslation());


        ImageView wordImage = (ImageView) listItemView.findViewById(R.id.list_image);
        if (currentWord.getImageResourceId() == 0)
            wordImage.setVisibility(View.GONE);
        else
            wordImage.setImageResource(currentWord.getImageResourceId());
        return listItemView;
    }
}
