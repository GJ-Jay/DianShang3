package gj.com.buycar.presenter;

import gj.com.buycar.core.DataCall;
import gj.com.buycar.http.IRequest;
import gj.com.buycar.http.NetworkManager;
import io.reactivex.Observable;

public class ShopPresenter extends BasePresenter{

    public ShopPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    public Observable observable(Object... args) {
        IRequest iRequest = NetworkManager.instance().create(IRequest.class);
        return iRequest.getShop();
    }
}
