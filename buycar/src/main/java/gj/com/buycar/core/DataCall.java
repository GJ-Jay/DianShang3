package gj.com.buycar.core;

import gj.com.buycar.bean.Result;

public interface DataCall<T> {
    void success(T result);
    void fail(Result result);
}
