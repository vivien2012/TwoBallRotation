package com.example.twoballrotation.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.widget.TextView;

import com.example.twoballrotation.R;
import com.example.twoballrotation.utils.ScreenUtil;
import com.example.twoballrotation.view.TwoBallRotationProgressBar;

/**
 * Created by yaolingyun on 15/10/30.
 */
public class TwoBallRotationDialog extends Dialog {

    private final TwoBallRotationProgressBar twoBall;
    private TextView tvMsg;
    private String text;
    public TwoBallRotationDialog(Context context, String strMessage) {
        this(context, R.style.TwoBallProgressDialog, strMessage);
    }

    public TwoBallRotationDialog(Context context, int theme, String strMessage) {
        super(context, theme);
        this.setContentView(R.layout.view_progress_dialog);
        this.getWindow().getAttributes().gravity = Gravity.CENTER;
        this.text = strMessage;
        tvMsg = (TextView) this.findViewById(R.id.progress_tip_tv);
        twoBall= (TwoBallRotationProgressBar) this.findViewById(R.id.progress_twoball);
        if (ScreenUtil.getScreenWidthPix(context) <= 720) {
            twoBall.setMaxRadius(20);
            twoBall.setDistance(40);
        } else {
            twoBall.setMaxRadius(30);
            twoBall.setDistance(60);
        }
        if (tvMsg != null) {
            tvMsg.setText(strMessage);
        }

        this.setCanceledOnTouchOutside(false);
        this.setCancelable(false);

    }

    @Override
    public void onStart() {
        super.onStart();
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        if (!hasFocus) {
            dismiss();
        }
    }


    public void upDateProgress(int progress){
        if(tvMsg!=null){
            tvMsg.setText(text+""+progress+"%");
        }
    }
}
