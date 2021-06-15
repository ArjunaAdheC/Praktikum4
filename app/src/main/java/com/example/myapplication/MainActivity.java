package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button BtnShare;
    Button BtnAlarm;
    EditText etJam, etMenit, etDesc;

    final int REQUEST_CODE = 111;
    Uri imgaeUri;
    private Button BtnFoto;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SET LISTENERBUTTON SHARE

        BtnFoto = findViewById(R.id.btnFoto);
        imageView = findViewById(R.id.hasilfoto);

        BtnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        @Override
                public Void onActivityResult (int requestCode,int resultCode,Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if(requestCode == RESULT_OK)
            {
                imgaeUri = data.getData();
                imageView.setImageURI(imgaeUri);
            }

        BtnShare = findViewById(R.id.btnShare);
        BtnShare.setOnClickListener(new View.OnClickListener());{

    @Override
    public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, value"Praktikum Mobile Implicit Intent");
                startActivity(i.createChooser(i, title"Share");
            }
        }};

    //SET LISTENER ALARM
    etJam= findViewById(R.id.Jam);
    etMenit= findViewById(R.id.Menit);
    etDesc= findViewById(R.id.desc);

    BtnAlarm = findViewById(R.id.btnAlarm);
    BtnAlarm.setOnClickListener(new View.OnClickListener);

        @Override
        public void onClick(View v); {
            int Jam = Integer.parseInt(etJam.getText().toString());
            int Menit = Integer.parseInt(etMenit.getText().toString());
            String Desc = String.valueOf(etDesc.getText());

            Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
            i.putExtra(AlarmClock.EXTRA_HOUR, Jam);
            i.putExtra(AlarmClock.EXTRA_MINUTES, Menit);
            i.putExtra(AlarmClock.EXTRA_MESSAGE, Desc);

            if (Jam <=24 && Menit <= 60) {
                startActivity(i);
            }  else
                Toast.makeText(getApplicationContext(), text "Waktu Salah", Toast.LENGTH_SHORT).show();

        }
    }};

}








