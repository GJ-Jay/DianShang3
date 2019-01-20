package gj.com.buycar.presenter;

import gj.com.buycar.bean.Result;
import gj.com.buycar.core.DataCall;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class BasePresenter {
    public DataCall dataCall;

    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

    public abstract Observable observable(Object...args);

    public void request(Object...args){
        observable(args).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        dataCall.success(result);
                    }
                }, new Consumer<Result>() {
                    @Override
                    public void accept(Result throwable) throws Exception {
                        dataCall.fail(throwable);
                    }
                });
    }
}
