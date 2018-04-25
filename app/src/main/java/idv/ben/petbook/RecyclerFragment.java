package idv.ben.petbook;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL));
        List<Bread> breadList=getBreadList();
        recyclerView.setAdapter(new Adapter(getContext(),breadList));

        return view;

    }
    public List<Bread> getBreadList(){
        List<Bread> breadList = new ArrayList<>();
        breadList.add(new Bread("狗狗照護講座","2018/04/21",R.drawable.bread1,"台北市信義區"));
        breadList.add(new Bread("假日毛毛泳池派對","2018/4/23",R.drawable.bread2,"桃園市中壢區"));
        breadList.add(new Bread("領養活動-寵物認養","2018/5/1",R.drawable.bread3,"新竹市東門"));
        breadList.add(new Bread("毛小孩美食季","2018/5/2",R.drawable.bread4,"台中縣"));
        breadList.add(new Bread("狗狗運動會","2018/5/4",R.drawable.bread5,"台中市北屯區"));
        breadList.add(new Bread("寵物美容教學","2018/5/5",R.drawable.bread6,"高雄市鹽埕區"));
        return breadList;
    }
}
