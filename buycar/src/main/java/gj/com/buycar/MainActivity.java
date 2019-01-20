package gj.com.buycar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gj.com.buycar.adapter.CartAdapter;
import gj.com.buycar.bean.Result;
import gj.com.buycar.bean.Shop;
import gj.com.buycar.core.DataCall;
import gj.com.buycar.presenter.ShopPresenter;

public class MainActivity extends AppCompatActivity implements CartAdapter.TotalPriceListener {

    @BindView(R.id.list_car)
    ExpandableListView mGoodsList ;
    @BindView(R.id.check_all)
    CheckBox mCheckAll ;
    @BindView(R.id.goods_sum_price)
    TextView mSumPrice ;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mCheckAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cartAdapter.checkAll(isChecked);
            }
        });

        cartAdapter = new CartAdapter();
        mGoodsList.setAdapter(cartAdapter);
        mGoodsList.setGroupIndicator(null);
        cartAdapter.setTotalPriceListener(this);
        mGoodsList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
        ShopPresenter shopPresenter = new ShopPresenter(new ShopCall());
        shopPresenter.request();
    }

    @Override
    public void totalPrice(double totalPrice) {
        mSumPrice.setText(String.valueOf(totalPrice));//实现接口  设置总价
    }

    private class ShopCall implements DataCall<Result> {
        @Override
        public void success(Result result) {
            if(result.getCode()==0){
                List<Shop> shops = (List<Shop>) result.getData();
                cartAdapter.addAll(shops);
                for (int i = 0; i < shops.size(); i++) {
                    mGoodsList.expandGroup(i);//所有项都展开
                }
            }

            cartAdapter.notifyDataSetChanged();
        }

        @Override
        public void fail(Result result) {
            Toast.makeText(MainActivity.this, result.getCode() + "   " + result.getMsg(), Toast.LENGTH_LONG).show();
        }
    }
}
