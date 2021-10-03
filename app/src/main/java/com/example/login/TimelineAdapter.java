package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.List;

import Dao.UserActivity;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder> {
    private final Context context;
    private final List<UserActivity> dataset;

    public TimelineAdapter(Context context, List<UserActivity> dataset){
        this.context = context;
        this.dataset = dataset;
    }


    @NonNull
    @Override
    public TimelineAdapter.TimelineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_timeline_post, parent, false);
        return new TimelineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimelineAdapter.TimelineViewHolder holder, int position) {
        int max = 100;
        int min = 0;
        int id = (int) (Math.random() * ((max - min) + 1) + min);
        holder.getTvPostUsername().setText(dataset.get(position).getUsername());
        holder.getTvPostContent().setText(dataset.get(position).getContent());
        Glide.with(context).load("https://picsum.photos/id/" + id + "/300/200").apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true)).into(holder.getIvPostImage());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class TimelineViewHolder extends RecyclerView.ViewHolder{
        private final ImageView ivPostImage;
        private final TextView tvPostUsername;
        private final TextView tvPostContent;

        public TimelineViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPostImage = (ImageView) itemView.findViewById(R.id.iv_post_image);
            tvPostUsername = (TextView) itemView.findViewById(R.id.tv_post_username);
            tvPostContent = (TextView) itemView.findViewById(R.id.tv_post_content);
        }

        public ImageView getIvPostImage(){
            return ivPostImage;
        }

        public TextView getTvPostUsername() {
            return tvPostUsername;
        }

        public TextView getTvPostContent() {
            return tvPostContent;
        }
    }
}
