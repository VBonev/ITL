package com.league.interactive.itl.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.league.interactive.itl.R;
import com.league.interactive.itl.interfaces.OnListItemInteractionListener;
import com.league.interactive.itl.models.Message;

import java.util.List;

/**
 * Created on 6/26/2017.
 */

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {

    private List<Message> messages;
    private OnListItemInteractionListener mListener;

    public MessagesAdapter() {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Message message = messages.get(position);
        holder.name.setText(message.getSenderName());
        holder.message.setText(message.getMessageValue());
        holder.date.setText(message.getMessageTime());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView name, message, date;
        final ImageView avatar;

        ViewHolder(View view) {
            super(view);
            mView = view;
            name = (TextView) view.findViewById(R.id.message_sender);
            message = (TextView) view.findViewById(R.id.message_value);
            date = (TextView) view.findViewById(R.id.message_time);
            avatar= (ImageView) view.findViewById(R.id.message_avatar);
        }

    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    public void setListener(OnListItemInteractionListener mListener) {
        this.mListener = mListener;
    }
}
