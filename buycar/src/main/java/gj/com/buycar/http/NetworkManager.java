package gj.com.buycar.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    public static NetworkManager instance ;
    private Retrofit retrofit;
    public static NetworkManager instance(){
        if (instance ==null){
            instance = new NetworkManager();
        }
        return  instance;
    }
    public NetworkManager(){
        init();
    }

    private void init() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newBuilder().addInterceptor(httpLoggingInterceptor)
                .writeTimeout(4000,TimeUnit.SECONDS)
                .readTimeout(4000,TimeUnit.SECONDS)
                .connectTimeout(4000,TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.zhaoapi.cn/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public <T> T create(final Class<T> service){
        return retrofit.create(service);
    }

}
