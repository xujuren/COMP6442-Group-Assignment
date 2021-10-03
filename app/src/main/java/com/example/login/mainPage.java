package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;

import java.util.List;

import Dao.UserActivity;
import Dao.UserActivityDao;

public class mainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        int time = 5000;

        Handler handler = new Handler();



        RecyclerView rvTimeline = (RecyclerView) findViewById(R.id.timeline);

        //DATA
        UserActivityDao.getInstance().createPost("@Juren", "This is my post fdafdsafasdfsafsdafsda");
        UserActivityDao.getInstance().createPost("@Kevin", "This is Kevin's post fdafdsafasdfsafsdafsda");
        UserActivityDao.getInstance().createPost("@Kyle", "This is Kyle's post fdafdsafasdfsafsdafsda");
        UserActivityDao.getInstance().createPost("@Cathy", "This is Cathy's post fdafdsafasdfsafsdafsda");
        List<UserActivity> allPosts = UserActivityDao.getInstance().findAllPosts();
        //ADAPTER
        TimelineAdapter timelineAdapter = new TimelineAdapter(getApplicationContext(), allPosts);
        rvTimeline.setAdapter(timelineAdapter);

        rvTimeline.setLayoutManager(new LinearLayoutManager(this));


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, time);

                allPosts.add(UserActivityDao.getInstance().createPost("@Admin", "This is my post fdafdsafasdfsafsdafsda"));
                timelineAdapter.notifyDataSetChanged();
            }
        };
        handler.postDelayed(runnable, time);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void createPost(TimelineAdapter timelineAdapter){
        UserActivityDao.getInstance().createPost("@Admin", "This is my post fdafdsafasdfsafsdafsda");
        timelineAdapter.notifyDataSetChanged();
    }

}