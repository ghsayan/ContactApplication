package com.example.contactapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvApp,tvUsername;
    ImageView ivImage,ivPhone,ivMap,ivWebsite;
    Button btnContact;
    final int ACTIVITY1=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvApp=findViewById(R.id.tvApp);
        tvUsername=findViewById(R.id.tvUsername);
        ivImage=findViewById(R.id.ivImage);
        ivPhone=findViewById(R.id.ivPhone);
        ivMap=findViewById(R.id.ivMap);
        ivWebsite=findViewById(R.id.ivWebsite);
        btnContact=findViewById(R.id.btnContact);

        ivImage.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivMap.setVisibility(View.GONE);
        ivWebsite.setVisibility(View.GONE);
        tvUsername.setVisibility(View.GONE);

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,com.example.contactapp.Activity1.class);
                startActivityForResult(intent,ACTIVITY1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==ACTIVITY1)
        {
            if(resultCode==RESULT_OK)
            {
                tvUsername.setText(data.getStringExtra("name"));
                tvUsername.setVisibility(View.VISIBLE);
                if(data.getStringExtra("image").equals("adult"))
                    ivImage.setImageResource(R.drawable.adult);
                else if(data.getStringExtra("image").equals("kid"))
                    ivImage.setImageResource(R.drawable.kid);
                else
                    ivImage.setImageResource(R.drawable.face);
                ivImage.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivMap.setVisibility(View.VISIBLE);
                ivWebsite.setVisibility(View.VISIBLE);

                ivPhone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+data.getStringExtra("number")));
                        startActivity(intent);
                    }
                });
                ivWebsite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (data.getStringExtra("website").trim().isEmpty())
                            Toast.makeText(MainActivity.this, "No website provided", Toast.LENGTH_SHORT).show();
                        else
                        {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+data.getStringExtra("website")));
                            startActivity(intent);
                        }
                    }
                });
                ivMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (data.getStringExtra("map").trim().isEmpty())
                            Toast.makeText(MainActivity.this, "No location provided", Toast.LENGTH_SHORT).show();
                        else
                        {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + data.getStringExtra("map")));
                            startActivity(intent);
                        }
                    }
                });
            }
        }
        else
            Toast.makeText(this, "No data entered", Toast.LENGTH_SHORT).show();
    }
}
