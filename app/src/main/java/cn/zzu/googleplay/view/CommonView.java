package cn.zzu.googleplay.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import cn.zzu.googleplay.R;

/**
 * Created by yangg on 2017/7/8.
 */

public class CommonView extends View {

    private TextView tvTitle;

    public CommonView(Context context) {
        super(context);
    }

    public CommonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CommonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.common_view, null, false);
        tvTitle = view.findViewById(R.id.tv);
    }

    public void updataTitle(String title){
        tvTitle.setText(title);
    }
}
