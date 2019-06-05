package com.yhtos.intelligentlighting;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetUser extends AppCompatActivity {

    private EditText host;
    private EditText user;
    private EditText pass;
    private Button baocun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_user);

        host = (EditText) findViewById(R.id.url);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        baocun = (Button) findViewById(R.id.baocun);





        baocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("setting",0);
                String hosts = host.getText().toString();
                String userNames = user.getText().toString();
                String passWords = pass.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (hosts.length()>7 && userNames.length()>1 && passWords.length()>2) {
                    editor.putString("url", hosts);
                    editor.putString("user", userNames);
                    editor.putString("pass", passWords);

                    editor.apply();
                }

                finish();
                //Intent intent = new Intent(SetUp.this, MainActivity.class);
                //startActivity(intent);
            }
        });
    }
}
