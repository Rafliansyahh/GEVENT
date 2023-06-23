package pab2.uas.rafliansyah.gevent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {
    @FormUrlEncoded
    @POST("auth/login")
    Call<ValueData<User>> login(@Field("username") String username,
                                @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/register")
    Call<ValueData<User>> register(@Field("username") String username,
                                   @Field("password") String password);

    @GET("Gevent")
    Call<ValueData<List<Unggah>>> getUnggah();

    @FormUrlEncoded
    @POST("Gevent")
    Call<ValueNoData> addUnggah(@Field("namaevent") String namaBarang,
                                 @Field("alamat") String alamat,
                                 @Field("deskripsi") String deskripsi,
                                 @Field("user_id") String user_id);

    @FormUrlEncoded
    @PUT("Gevent")
    Call<ValueNoData> updateUnggah(@Field("id") String id,
                                    @Field("namaBarang") String namaBarang,
                                    @Field("alamat") String alamat,
                                    @Field("deskripsi") String deskripsi);

    @DELETE("Gevent/{id}")
    Call<ValueNoData> deleteUnggah(@Path("id") String id);
}
