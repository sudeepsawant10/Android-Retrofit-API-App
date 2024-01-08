package com.example.retrofitapiapp;

import java.util.List;

public interface OnPostsFetchedListener {
    void onPostsFetched(List<Post> posts);
    void onPostsFetchError(String error);
}
