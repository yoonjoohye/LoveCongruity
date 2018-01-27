package a67yjh00.com.example.lg.lovecongruity;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    EditText myname,yourname, yournum;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        myname=(EditText)findViewById(R.id.myname);
        yourname=(EditText)findViewById(R.id.yourname);
        yournum=(EditText)findViewById(R.id.yournum);
        go=(Button)findViewById(R.id.go);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text="안녕, "+yourname.getText().toString()+"!!!";
                String num=yournum.getText().toString();

                if(num.length()>0 && text.length()>0) {
                    sendSMS(num, text);
                    Toast.makeText(getBaseContext(), "전송완료!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(), "입력이 안됐어용~", Toast.LENGTH_SHORT).show();
                }
                Intent i=new Intent(getApplicationContext(),ResultActivity.class);
                i.putExtra("my",myname.getText().toString());
                i.putExtra("your",yourname.getText().toString());
                startActivity(i);
                finish();
            }
        });
    }
    private void sendSMS(String phoneNumber, String message)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
}
