package com.example.goodnews.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_main_article_adapter, viewGroup, false);
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
        viewHolder.articleAdapterParentLinear.setTag(articleModel);
    }
    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titleText;
        private TextView descriptionText;
        private LinearLayout articleAdapterParentLinear;
        ViewHolder(View view) {
            super(view);
            titleText = view.findViewById(R.id.title);
            descriptionText = view.findViewById(R.id.desc);
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
    public static void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}