package com.example.employeedetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.R;
import com.example.employeedetail.multiple_view.Movie;
import com.example.employeedetail.multiple_view.Scenery;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class MultipleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Object> mList;

    public MultipleViewAdapter(Context context, List<Object> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position) instanceof Movie) {
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (this.getItemViewType(viewType) == 0) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_movie, parent, false);
            return new MovieHolder(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_scenery, parent, false);
            return new SceneryHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (this.getItemViewType(position) == 0) {
            Movie movie = (Movie) mList.get(position);
            MovieHolder movieHolder = (MovieHolder) holder;
            movieHolder.mMovieImageView.setImageResource(movie.getMovieImage());
            movieHolder.mNameTextView.setText(movie.getMovieName());
            movieHolder.mRatingTextView.setText(String.valueOf(movie.getMovieRating()));
        } else {
            Scenery scenery = (Scenery) mList.get(position);
            SceneryHolder sceneryHolder = (SceneryHolder) holder;
            sceneryHolder.mSceneryImageView.setImageResource(scenery.getSceneryImage());
            sceneryHolder.mSceneryOneImageView.setImageResource(scenery.getSceneryOneImage());
            sceneryHolder.mSceneryTwoImageView.setImageResource(scenery.getSceneryTwoImage());

        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class MovieHolder extends RecyclerView.ViewHolder {
        public CircularImageView mMovieImageView;
        public TextView mNameTextView;
        public TextView mRatingTextView;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            mMovieImageView = itemView.findViewById(R.id.iv_multiple_view);
            mNameTextView = itemView.findViewById(R.id.tv_name_multiple_view);
            mRatingTextView = itemView.findViewById(R.id.tv_rating_multiple_view);
        }
    }

    static class SceneryHolder extends RecyclerView.ViewHolder {
        public CircularImageView mSceneryImageView;
        public CircularImageView mSceneryOneImageView;
        public CircularImageView mSceneryTwoImageView;

        public SceneryHolder(@NonNull View itemView) {
            super(itemView);
            mSceneryImageView = itemView.findViewById(R.id.iv_scenery);
            mSceneryOneImageView = itemView.findViewById(R.id.iv_sceneryOne);
            mSceneryTwoImageView = itemView.findViewById(R.id.iv_sceneryTwo);

        }
    }

}
