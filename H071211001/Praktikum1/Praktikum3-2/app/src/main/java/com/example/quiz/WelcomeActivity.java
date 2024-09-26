package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class WelcomeActivity extends AppCompatActivity {

    private CircleImageView image2;
    private TextView text1, text2, text3;
    private String st1, st2;
    private Button btn;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        image2 = findViewById(R.id.imagecircle1);
        btn = findViewById(R.id.button2);
        st1 = getIntent().getExtras().getString("text1");
        st2 = getIntent().getExtras().getString("text2");
        bundle = getIntent().getExtras();

        if (bundle != null) {
            String imageUriString = bundle.getString("image1");
            Uri imageUri = Uri.parse(imageUriString);
            image2.setImageURI(imageUri);

            text1.setText(st1);
            text3.setText(st2);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent iv = new Intent(WelcomeActivity.this,MainActivity.class);
                    iv.putExtra("text1",st1);
                    iv.putExtra("text2",st2);
                    iv.putExtra("image",bundle);
                    startActivity(iv);
                    finish();
                }
            });
        }
    }
}
