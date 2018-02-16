package info.androidhive.recyclerview;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.images);

        }
    }


    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Movie movie = moviesList.get(position);
        holder.image.setImageResource(movie.getImg());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                MediaPlayer     m1 = MediaPlayer.create(view.getContext() , R.raw.alex);
                MediaPlayer     m2 = MediaPlayer.create(view.getContext() , R.raw.peeter);
                MediaPlayer     m3 = MediaPlayer.create(view.getContext() , R.raw.kaiton);
                MediaPlayer     m4 = MediaPlayer.create(view.getContext() , R.raw.meril);
                MediaPlayer     m5 = MediaPlayer.create(view.getContext() , R.raw.jack);

              switch (position) {

                  case 0: {

                     m2.stop();

                  break;}
                  case 1:{

                      m2.start();
                      break;}
                  case 2:{
                      m2.stop();
                      m1.stop();
                      m4.stop();
                      m5.stop();
                      m3.start();
                      break;}
                  case 3:{
                      m2.stop();
                      m3.stop();
                      m1.stop();
                      m5.stop();
                      m4.start();
                      break;}
                  case 4:{
                      m2.stop();
                      m3.stop();
                      m4.stop();
                      m1.stop();
                      m5.start();
                      break;}

              }



            }
        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
