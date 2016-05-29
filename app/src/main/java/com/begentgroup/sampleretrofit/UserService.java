package com.begentgroup.sampleretrofit;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by dongja94 on 2016-05-28.
 */
public interface UserService {
    @Headers("Cache-Control: max-age=640000")
    @GET("/{user}/friend")
    Call<List<User>> listFriend(@Path("user") String user);

    @GET("/profile")
    Call<User> profile(@Query("user") String user, @Query("names") String... names);

    @Streaming
    @GET
    Call<ResponseBody> profileImage(@Url String url);

    @GET("/modify")
    Call<User> modify(@QueryMap Map<String,String> options);

    @Headers({ "Accept: application/vnd.github.v3.full+json", "User-Agent: Retrofit-Sample-App" })
    @GET("/user")
    Call<User> getUser(@Header("Authorization") String authorization);

    @POST("/user/new")
    Call<User> createUser(@Body User user);

    @FormUrlEncoded
    @POST("/user/update")
    Call<User> updateUser(@Field("name") String name,@Field("email") String email, @Field("favorites") List<String> favorites);

    @FormUrlEncoded
    @POST("/user/update")
    Call<User> updateUser(@FieldMap Map<String,String> options);

    @Multipart
    @POST("/user/photo")
    Call<User> uploadFile(@Part("name") String name, @Part("email") String email, @Part MultipartBody.Part photo);
}
