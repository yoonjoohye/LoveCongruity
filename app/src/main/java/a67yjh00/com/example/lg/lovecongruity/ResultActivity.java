package a67yjh00.com.example.lg.lovecongruity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    TextView result;
    String my, your;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i=getIntent();
        my=i.getExtras().getString("my");
        your=i.getExtras().getString("your");

        result=(TextView)findViewById(R.id.result);

        result.setText(my+"님과 "+your+"님의 궁합결과");

    }
}
