package com.begentgroup.sampleretrofit;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    UserService userService;

    public static final String TEST_SERVER = "http://192.168.1.14:3000";
    public static final String REAL_SERVER = "https://dongjanodejs.appspot.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = new Retrofit.Builder()
                .baseUrl(TEST_SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userService = retrofit.create(UserService.class);

        Button btn = (Button)findViewById(R.id.btn_call);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Call<List<User>> friendListCall = userService.listFriend("me");
//                new MyTask<List<User>>().execute(friendListCall);

//                Call<User> profile = userService.profile("ysi");
//                new MyTask<User>().execute(profile);

//                Map<String,String> options = new HashMap<String, String>();
//                options.put("name","ysi");
//                options.put("email", "email");
//                Call<User> modify = userService.modify(options);
//                new MyTask<User>().execute(modify);

//                User user = new User();
//                user.setName("ysi");
//                user.setEmail("email");
//                Call<User> createUser = userService.createUser(user);
//                new MyTask<User>().execute(createUser);

//                Call<User> updateUser = userService.updateUser("ysi","email", Arrays.asList("shopping", "game"));
//                new MyTask<User>().execute(updateUser);
//                updateUser.enqueue(new Callback<User>() {
//                    @Override
//                    public void onResponse(Call<User> call, Response<User> response) {
//                        if (response.isSuccessful()) {
//                            User user = response.body();
//                        } else {
//                            // .. error
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<User> call, Throwable t) {
//                        // error
//                    }
//                });
//                Map<String,String> options = new HashMap<String, String>();
//                options.put("name","ysi");
//                options.put("email", "email");
//                Call<User> updateUser = userService.updateUser(options);
//                new MyTask<User>().execute(updateUser);

//                Cursor c = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] {MediaStore.Images.Media.DATA},
//                        null, null, null);
//                if (c.moveToNext()) {
//                    String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
//                    File file = new File(path);
//
//                    Call<User> photo = userService.uploadFile("ysi", "email",
//                            MultipartBody.Part.createFormData("photo",file.getName(),
//                                    RequestBody.create(MediaType.parse("image/jpeg"), file))
//                            );
//                    new MyTask<User>().execute(photo);
//                }
//                c.close();

            }
        });
    }

    class MyTask<T> extends AsyncTask<Call<T>, Integer, T> {
        @Override
        protected T doInBackground(Call<T>... params) {
            Call<T> call = params[0];
            try {
                Response<T> response = call.execute();
                if (response.isSuccessful()) {
                    return response.body();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(T t) {
            super.onPostExecute(t);
            if (t != null) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
