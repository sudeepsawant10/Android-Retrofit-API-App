package com.example.retrofitapiapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {
    private JsonPlaceholderApi jsonPlaceholderApi;

    public PostRepository() {
        jsonPlaceholderApi = RetrofitClient.getRetrofitInstance().create(JsonPlaceholderApi.class);
    }

    public void getPosts(final OnPostsFetchedListener listener) {
        Call<List<Post>> call = jsonPlaceholderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    List<Post> posts = response.body();
                    listener.onPostsFetched(posts);
                } else {
                    listener.onPostsFetchError("Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                listener.onPostsFetchError("Failure: " + t.getMessage());
            }
        });
    }
}
