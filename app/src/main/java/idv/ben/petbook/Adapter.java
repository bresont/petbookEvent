package idv.ben.petbook;




import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class Adapter extends RecyclerView.Adapter <Adapter.MyViewHolder> {

    private Context context;
    private List<Activity> activityList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imvBread;
        TextView tvName, tvTime,tvPlace;

        public MyViewHolder(final View itemView){
            super(itemView);

            imvBread = itemView.findViewById(R.id.imvBread);
            tvName = itemView.findViewById(R.id.tvName);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvPlace = itemView.findViewById(R.id.tvPlace);
        }
    }
    public Adapter(Context context,List<Activity> activityList){
        this.context = context;
        this.activityList = activityList;
    }
   // @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item_view,parent,false);
        return new MyViewHolder(itemView);
    }

  //  @Override
    public void onBindViewHolder(final Adapter.MyViewHolder holder,int pos){
        final Activity Activity = activityList.get(pos);
        holder.tvName.setText(Activity.getName());
        holder.tvTime.setText(String.valueOf(Activity.getActivity_date()));
        holder.imvBread.setImageResource(Activity.getImgID());
        holder.tvPlace.setText(Activity.getLocation_address());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Activity.getName().toString();
                String time = String.valueOf(Activity.getActivity_date());
                String place = Activity.getLocation_address().toString();
                int picture = Activity.getImgID();
                Bundle bundle = new Bundle();
                bundle.putInt("picture",picture);
                bundle.putString("name",name);
                bundle.putString("time",time);
                bundle.putString("place",place);

                AppCompatActivity activity =(AppCompatActivity) holder.itemView.getContext();
                Fragment resultFragment = new ResultFragment();
                resultFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content,resultFragment).commit();

            }
        });
    }

   // @Override
    public int getItemCount(){
        return activityList.size();
    }

}

