package idv.ben.petbook;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment {
    MyTask myTask;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL));
        List<Activity> activityList = getActivityList();
        recyclerView.setAdapter(new Adapter(getContext(), activityList));
        return view;
    }

    public List<Activity> getActivityList() {
        List<Activity> activityList = new ArrayList<>();
        if (networkConnected()) {
            String url = Common.URL + "/ActivityServlet";
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("action", "getAll");
            myTask = new MyTask(url, jsonObject.toString());
            try {
                String jsonIn = myTask.execute().get();
                Type listType = new TypeToken<List<Activity>>() {
                }.getType();
                Log.d("我在這", jsonIn);
                activityList = new Gson().fromJson(jsonIn, listType);
            } catch (Exception e) {
                Log.e("abc", e.toString());
            }

        }

        return activityList;
    }

//    public void onSearchClick(View v) {
////        Object item = spCategory.getSelectedItem();
////        String category = item.toString().trim();
//        if (networkConnected()) {
//            String url = Common.URL + "/ActivityServlet";
//            List<android.app.Activity> activities = null;
//            JsonObject jsonObject = new JsonObject();
//            jsonObject.addProperty("param", "activity");
//            myTask = new MyTask(url, jsonObject.toString());
//            try {
//                String jsonIn = myTask.execute().get();
//                Type listType = new TypeToken<List<android.app.Activity>>() {
//                }.getType();
//                Log.d("我在這", jsonIn);
//                activities = new Gson().fromJson(jsonIn, listType);
//            } catch (Exception e) {
//                Log.e("abc", e.toString());
//            }
//
//        }
//    }

    private boolean networkConnected() {
        ConnectivityManager conManager =
                (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conManager != null ? conManager.getActiveNetworkInfo() : null;
        return networkInfo != null && networkInfo.isConnected();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (myTask != null) {
            myTask.cancel(true);
        }
    }
}
