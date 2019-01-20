package gj.com.buycar.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import gj.com.buycar.R;

public class AddSubLayout extends LinearLayout implements View.OnClickListener {
    @BindView(R.id.btn_add)
    TextView mAddBtn ;
    @BindView(R.id.text_number)
    TextView mNumText ;
    @BindView(R.id.btn_sub)
    TextView mSubBtn ;

    public AddSubLayout(Context context) {
        super(context);
        initView();
    }

    public AddSubLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public AddSubLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View view = View.inflate(getContext(), R.layout.layout_addsub, this);
        ButterKnife.bind(this);
        //初始化组件后设置点击事件
        mAddBtn.setOnClickListener(this);
        mSubBtn.setOnClickListener(this);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        int width = r-l;
        int height = b-t;
    }

    @Override
    public void onClick(View v) {
        //得到数量值
        int number = Integer.parseInt(mNumText.getText().toString());

        switch (v.getId()){
            case R.id.btn_add:
                number++;
                mNumText.setText(number+"");
                break;
            case R.id.btn_sub:
                if(number==0){
                    Toast.makeText(getContext(),"数量不能小于0",Toast.LENGTH_LONG).show();
                    return;
                }
                number--;
                mNumText.setText(number+"");
                break;
        }
        if(addSubLinstener!=null){
            addSubLinstener.addSub(number);
        }
    }

   public void setCount(int count){
        mNumText.setText(count+"");
   }

    AddSubLinstener addSubLinstener;

    public void setAddSubLinstener(AddSubLinstener addSubLinstener){
        this.addSubLinstener = addSubLinstener;
    }

    public interface AddSubLinstener{
        void addSub(int count);
    }
}
