package cn.edu.gdmec.chaos07150844.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class IntentDemo extends AppCompatActivity {
    private EditText et1,et2;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_demo1);

        et1 = (EditText) findViewById(R.id.url);
        et2 = (EditText) findViewById(R.id.phone);
        tv1 = (TextView) findViewById(R.id.textView);
    }

    public void componentname(View v){
        ComponentName componentName = new ComponentName(this,IntentDemo2.class);
        Intent in1 = new Intent();
        in1.setComponent(componentName);
        startActivity(in1);


    }

    public void intentfilter(View v){
        String action = "cn.edu.gdmec.chaosme";
        Intent in2 = new Intent();
        in2.setAction(action);
        startActivity(in2);

    }

    public void view(View v){
        Intent in3 = new Intent();
        in3.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(et1.getText().toString());
        in3.setData(uri);
        startActivity(in3);

    }

    public void dial(View v){
        Intent in3 = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:"+et2.getText().toString());
        in3.setData(uri);
        startActivity(in3);

    }

    public void startactivityforresult(View v){
        Bundle bundle = new Bundle();
        bundle.putString("value",et1.getText().toString());
        Intent intent = new Intent(IntentDemo.this,IntentDemo2.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 10:
                Bundle bundle = data.getExtras();
                tv1.setText(bundle.getString("result"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
