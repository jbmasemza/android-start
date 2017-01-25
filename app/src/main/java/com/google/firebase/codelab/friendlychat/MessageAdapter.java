package com.google.firebase.codelab.friendlychat;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import static com.google.firebase.codelab.friendlychat.R.*;

/**
 * Created by CodeTribe on 2017/01/25.
 */

public class MessageAdapter  extends ArrayAdapter<FriendlyMessage>{
    public MessageAdapter(Context context, int resource, List<FriendlyMessage> object) {
        super(context, resource, object);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message,parent);
        }
        ImageView photoImageView = (ImageView) convertView.findViewById(id.photoImageView);
        TextView massageTextView = (TextView) convertView.findViewById(id.messageTextView);
      TextView  authorTextView = (TextView) convertView.findViewById(id.messengerImageView);

        FriendlyMessage message = getItem(position);

        boolean isPhoto = message.getPhotoUrl() != null;

        if (isPhoto) {
            massageTextView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);
            Glide.with(photoImageView.getContext())
                    .load(message.getPhotoUrl())
                    .into(photoImageView);

        } else {
            massageTextView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            massageTextView.setText(message.getText());
        }
        authorTextView.setText(message.getName());
        return convertView;
    }
    }




