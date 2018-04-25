package idv.ben.petbook;


import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

public class ResultFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_result,container,false);
        TextView tvResult = view.findViewById(R.id.tvResult);
        Button btnBack = view.findViewById(R.id.btnBack);
        ImageView imageView = view.findViewById(R.id.picture);
        Bundle bundle = getArguments();
        if (bundle != null){
            int picture = bundle.getInt("picture");
            String name = bundle.getString("name");
            String time = bundle.getString("time");
            String text = "name: " + name + "\ntime:" + time;
            imageView.setImageResource(picture);
            tvResult.setText(text);
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {getFragmentManager().popBackStack();}
        });
        return view;
    }
}
