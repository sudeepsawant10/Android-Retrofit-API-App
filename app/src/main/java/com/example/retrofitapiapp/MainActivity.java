package com.example.retrofitapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Post> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();


        PostRepository postRepository = new PostRepository();
        postRepository.getPosts(new OnPostsFetchedListener() {
            @Override
            public void onPostsFetched(List<Post> posts) {
                // Handle the fetched posts
                Log.d("API", "API onPostsFetched: post list = " + posts);

                // Add the fetched posts to the arrayList
                arrayList.addAll(posts);

//                // Now you can use the arrayList for further processing or displaying in your UI
//                for (int i = 0; i < arrayList.size(); i++) {
//                    Post myPost = arrayList.get(i);
//                    Log.d("api", "onCreate: post id = " + myPost.getId() + " Title = " + myPost.getTitle());
//                }
            }

            @Override
            public void onPostsFetchError(String error) {
                // Handle the error
                Log.d("API", "onPostsFetchError: ");
            }
        });

//        for (int i = 0; i<10; i++) {
//            arrayList.add(postList.get(i));
//        }

        Log.d("API", "API onPostsFetched: post list = " + arrayList);


//        for (int i=0; i<5; i++){
//            Post myPost = arrayList.get(i);
//            Log.d("api", "onCreate: post id = " + myPost.getId() + " Title = " + myPost.getTitle());
//        }



    }
}