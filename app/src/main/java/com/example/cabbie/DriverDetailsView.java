package com.example.cabbie;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
public class DriverDetailsView extends LinearLayout {

    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    ImageView imageView;

    public DriverDetailsView(Context context) {
        super(context);
        init(context);
    }

    public DriverDetailsView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.driver_details,this,true);

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView5);
        textView4 = (TextView) findViewById(R.id.textView6);
        textView5 = (TextView) findViewById(R.id.textView7);
        imageView = (ImageView)findViewById(R.id.imageView);
    }

    public void setName(String name){
        textView.setText(name);
    }
    public void setFrom(String from){
        textView2.setText(from);
    }
    public void setTo(String to) { textView3.setText(to);}
    public void setDate(String date) {textView4.setText(date);}
    public void setTime(String time) {textView5.setText(time);}
    public void setImage(int resId){
        imageView.setImageResource(resId);
    }
}

