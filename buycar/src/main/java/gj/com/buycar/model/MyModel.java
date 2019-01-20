package gj.com.buycar.model;

import gj.com.buycar.http.IRequest;
import gj.com.buycar.http.NetworkManager;

public class MyModel {
    public static IRequest get(){
        IRequest iRequest = NetworkManager.instance().create(IRequest.class);
        return iRequest;
    }
}
