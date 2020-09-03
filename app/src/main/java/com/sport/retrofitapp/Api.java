package com.sport.retrofitapp;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Api
{
    private static final String key="AIzaSyCGbdpDPESTXHj3pNj2304IpPX0fASjm1E";
    private static Postlist postlist=null;
    private static String url="https://www.googleapis.com/blogger/v3/blogs/9145127371123978481/";



    public interface Postlist
    {
        @GET("posts?key="+key)
        Call<PostList> getpost();
    }


    public static Postlist getPostserivice() {
        if (postlist== null) {
            postlist = (Postlist) new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build().create(Postlist.class);
        }
        return postlist;
    }
}
