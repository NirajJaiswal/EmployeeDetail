package com.example.employeedetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.MultipleView.Movie;
import com.example.employeedetail.MultipleView.Scenery;
import com.example.employeedetail.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class MultipleViewAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List mList;

    public MultipleViewAdapter(Context mContext, List mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getItemViewType(int position) {
        if(Movie.class.isInstance(mList.get(position))){
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(this.getItemViewType(viewType)==0){
            View view= LayoutInflater.from(mContext).inflate(R.layout.layout_movie,parent,false);
            MovieHolder holder=new MovieHolder(view);
            return holder;
        }
        else{
            View view= LayoutInflater.from(mContext).inflate(R.layout.layout_scenery,parent,false);
            SceneryHolder holder=new SceneryHolder(view);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
if(this.getItemViewType(position)==0){
    Movie movie= (Movie) mList.get(position);
    MovieHolder movieHolder= (MovieHolder) holder;
    movieHolder.mMovieImageView.setImageResource(movie.getMovieImage());
    movieHolder.mNameTextView.setText(movie.getMovieName());
    movieHolder.mRatingTextView.setText(movie.getMovieRating());

}
else{
    Scenery scenery= (Scenery) mList.get(position);
    SceneryHolder sceneryHolder= (SceneryHolder) holder;
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
        private CircularImageView mMovieImageView;
        private TextView mNameTextView;
        private TextView mRatingTextView;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            mMovieImageView = itemView.findViewById(R.id.iv_multiple_view);
            mNameTextView = itemView.findViewById(R.id.tv_name_multiple_view);
            mRatingTextView = itemView.findViewById(R.id.tv_rating_multiple_view);
        }
    }
static class SceneryHolder extends RecyclerView.ViewHolder {
        private CircularImageView mSceneryImageView;
        private CircularImageView mSceneryOneImageView;
        private CircularImageView mSceneryTwoImageView;
    public SceneryHolder(@NonNull View itemView) {


        super(itemView);
        mSceneryImageView=itemView.findViewById(R.id.iv_scenery);
        mSceneryOneImageView=itemView.findViewById(R.id.iv_sceneryOne);
        mSceneryTwoImageView=itemView.findViewById(R.id.iv_sceneryTwo);

    }
}

}
