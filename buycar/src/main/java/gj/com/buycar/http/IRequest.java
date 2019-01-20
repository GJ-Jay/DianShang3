package gj.com.buycar.http;

import java.util.List;

import gj.com.buycar.bean.Result;
import gj.com.buycar.bean.Shop;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IRequest {

    @GET("product/getCarts?uid=71")
    Observable<Result<List<Shop>>> getShop();//购物车
}
