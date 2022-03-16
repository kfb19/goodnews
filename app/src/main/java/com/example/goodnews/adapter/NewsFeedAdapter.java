package com.example.goodnews.adapter;

import android.content.Context;
import android.media.Image;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.goodnews.model.ArticleModel;
import com.example.goodnews.utils.OnRecyclerViewItemClickListener;
import com.example.goodnews.R;
import java.util.List;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {
    private List<ArticleModel> articleArrayList;
    private Context context;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;
    public NewsFeedAdapter(List<ArticleModel> articleArrayList) {
        this.articleArrayList = articleArrayList;
    }
    @Override
    public NewsFeedAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new NewsFeedAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(NewsFeedAdapter.ViewHolder viewHolder, int position) {
        final ArticleModel articleModel = articleArrayList.get(position);
        if(!TextUtils.isEmpty(articleModel.getTitle())) {
            viewHolder.titleText.setText(articleModel.getTitle());
        }
        if(!TextUtils.isEmpty(articleModel.getDescription())) {
            viewHolder.descriptionText.setText(articleModel.getDescription());
        }
        if(!TextUtils.isEmpty(articleModel.getAuthor())) {
            viewHolder.author.setText(articleModel.getAuthor());
        }
        if(!TextUtils.isEmpty(articleModel.getPublishedAt())) {
            viewHolder.date.setText(articleModel.getPublishedAt());
        }
        if(!TextUtils.isEmpty((CharSequence) articleModel.getSource())) {
            viewHolder.source.setText((CharSequence) articleModel.getSource());
        }
        if(!TextUtils.isEmpty((CharSequence) articleModel.getUrlToImage())) {
            viewHolder.img.setImageURI(articleModel.getUrlToImage());
        }
        viewHolder.articleAdapterParentLinear.setTag(articleModel);
    }
    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titleText;
        private TextView descriptionText;
        private TextView author;
        private TextView source;
        private TextView date;
        private ImageView img;
        private LinearLayout articleAdapterParentLinear;
        ViewHolder(View view) {
            super(view);
            titleText = view.findViewById(R.id.title);
            descriptionText = view.findViewById(R.id.desc);
            author = view.findViewById(R.id.author);
            source = view.findViewById(R.id.source);
            date = view.findViewById(R.id.publishedAt);
            img = view.findViewById(R.id.img);
            articleAdapterParentLinear = view.findViewById(R.id.lay);
            articleAdapterParentLinear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onRecyclerViewItemClickListener != null) {
                        onRecyclerViewItemClickListener.onItemClick(getAdapterPosition(), view);
                    }
                }
            });
        }
    }
    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}