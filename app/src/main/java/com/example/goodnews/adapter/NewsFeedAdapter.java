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

/**
 * The NewsFeedAdapter is the adapter for the News API and the news feed RecyclerView.
 * @author Kate Belson
 */
public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {
    private List<ArticleModel> articleArrayList;
    private Context context;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;
    /**
     * Constructor for the NewsFeedAdapter class.
     * @author Kate Belson
     * @param articleArrayList is the list of articles.
     */
    public NewsFeedAdapter(List<ArticleModel> articleArrayList) {
        this.articleArrayList = articleArrayList;
    }

    /**
     * Creates the activity and sets the content view, including the RecyclerView of news articles.
     * @author Kate Belson
     * @param viewGroup is the view group.
     * @param i is an integer.
     * @return the NewsFeedAdapter.
     */
    @Override
    public NewsFeedAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new NewsFeedAdapter.ViewHolder(view);
    }

    /**
     * Binds the articles to the view holder.
     * @author Kate Belson
     * @param viewHolder is the view holder.
     * @param position is the position in the RecyclerView.
     */
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
        if(!TextUtils.isEmpty((CharSequence) String.valueOf(articleModel.getUrlToImage()))) {
            viewHolder.img.setImageURI(articleModel.getUrlToImage());
        }
        viewHolder.articleAdapterParentLinear.setTag(articleModel);
    }
    @Override
    /**
     * Gets the number of articles.
     * @author Kate Belson
     * @return the number of articles in the list.
     */
    public int getItemCount() {
        return articleArrayList.size();
    }

    /**
     * The ViewHolder class is the class for the view holder.
     * @author Kate Belson
     */
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titleText;
        private TextView descriptionText;
        private TextView author;
        private TextView date;
        private ImageView img;
        private LinearLayout articleAdapterParentLinear;
        /**
         * Constructor for the ViewHolder class.
         * @author Kate Belson
         * @param view is the view.
         */
        ViewHolder(View view) {
            super(view);
            titleText = view.findViewById(R.id.title);
            descriptionText = view.findViewById(R.id.desc);
            author = view.findViewById(R.id.author);
            date = view.findViewById(R.id.publishedAt);
            img = view.findViewById(R.id.img);
            articleAdapterParentLinear = view.findViewById(R.id.lay);
            articleAdapterParentLinear.setOnClickListener(new View.OnClickListener() {
                /**
                 * Sets what happens when it is clicked on.
                 * @author Kate Belson
                 * @param view is the view.
                 */
                @Override
                public void onClick(View view) {
                    if (onRecyclerViewItemClickListener != null) {
                        onRecyclerViewItemClickListener.onItemClick(getAdapterPosition(), view);
                    }
                }
            });
        }
    }

    /**
     * Sets the click listener.
     * @author Kate Belson
     * @param onRecyclerViewItemClickListener is the click listener.
     */
    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}