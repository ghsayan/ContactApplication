package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity {
    EditText etName,etNumber,etWebsite,etMap;
    ImageView ivAdult,ivKid,ivFace;
    Button btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        etName=findViewById(R.id.etName);
        etNumber=findViewById(R.id.etNumber);
        etWebsite=findViewById(R.id.etWebsite);
        etMap=findViewById(R.id.etMap);
        ivAdult=findViewById(R.id.ivAdult);
        ivKid=findViewById(R.id.ivKid);
        ivFace=findViewById(R.id.ivFace);
        btnCancel=findViewById(R.id.btnCancel);

        ivAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().trim().isEmpty())
                    Toast.makeText(Activity1.this, "Please enter name", Toast.LENGTH_SHORT).show();
                if(etNumber.getText().toString().trim().isEmpty())
                    Toast.makeText(Activity1.this, "Please enter number", Toast.LENGTH_SHORT).show();
                else
                {
                    Intent intent=new Intent();
                    intent.putExtra("name",etName.getText().toString().trim());
                    intent.putExtra("number",etNumber.getText().toString().trim());
                    intent.putExtra("website",etWebsite.getText().toString().trim());
                    intent.putExtra("map",etMap.getText().toString().trim());
                    intent.putExtra("image","adult");
                    setResult(RESULT_OK,intent);
                    Activity1.this.finish();
                }
            }
        });
        ivKid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().trim().isEmpty())
                    Toast.makeText(Activity1.this, "Please enter name", Toast.LENGTH_SHORT).show();
                if(etNumber.getText().toString().trim().isEmpty())
                    Toast.makeText(Activity1.this, "Please enter number", Toast.LENGTH_SHORT).show();
                else
                {
                    Intent intent=new Intent();
                    intent.putExtra("name",etName.getText().toString().trim());
                    intent.putExtra("number",etNumber.getText().toString().trim());
                    intent.putExtra("website",etWebsite.getText().toString().trim());
                    intent.putExtra("map",etMap.getText().toString().trim());
                    intent.putExtra("image","kid");
                    setResult(RESULT_OK,intent);
                    Activity1.this.finish();
                }
            }
        });
        ivFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().trim().isEmpty())
                    Toast.makeText(Activity1.this, "Please enter name", Toast.LENGTH_SHORT).show();
                if(etNumber.getText().toString().trim().isEmpty())
                    Toast.makeText(Activity1.this, "Please enter number", Toast.LENGTH_SHORT).show();
                else
                {
                    Intent intent=new Intent();
                    intent.putExtra("name",etName.getText().toString().trim());
                    intent.putExtra("number",etNumber.getText().toString().trim());
                    intent.putExtra("website",etWebsite.getText().toString().trim());
                    intent.putExtra("map",etMap.getText().toString().trim());
                    intent.putExtra("image","face");
                    setResult(RESULT_OK,intent);
                    Activity1.this.finish();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                Activity1.this.finish();
            }
        });
    }
}
