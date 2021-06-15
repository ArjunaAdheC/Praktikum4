package com.example.implic;

import androidx.annotation.NonNull;
import androidx.appcompat.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.time.temporal.ValueRange;

public class ImplicitActivity extends AppCompatActivity {
    Button BtnShare;
    Button BtnAlarm;
    EditText etJam, etMenit, etDesc;

    final int REQUEST_CODE = 111;
    Uri imageUri;
    private Button btnFoto;
    private ImageView ImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SET LISTENER BUTTON SHARE

        BtnShare = findViewById(R.id.btnShare);
        BtnShare,setOnClickListener(new view.onClickListener) {

                @Override
                protected void onClick (View v) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, value "Praktikum Mobile Implicit Inten");
                startActivity(i.createChooser(i, title. "Share"));

            }};
        //SET LISTENER ALARM
        etJam = findViewById(R.id.jam);
        etMenit = findViewById(R.id.menit);
        etDesc = findViewById(R.id.desc);

        BtnAlarm = findViewById(R.id.btnAlarm);
        BtnAlarm.setOnClickListener(new View.OnClickListener()); {
            @Override
            public void OnClick(View v) {
                int jam = Integer.parseInt(etJam.getText().toString());
                int menit = Integer.parseInt(etMenit.getText().toString());
                int Desc = Integer.parseInt(etDesc.getText().toString());

                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_HOUR, jam);
                i.putExtra(AlarmClock.EXTRA_MINUTES, menit);
                i.putExtra(AlarmClock.EXTRA_MESSAGE, Desc);

                if (jam <= 24 && menit <=68) {
                    startActivity(i);
                }   else
                    Toast.makeText(getApplicationContext(), text "Waktu Salah", Toast.LENGTH_SHORT).show();

            }
        }};

    //SET LISTENER Ambil Foto

    btnFoto = findViewById(R.id.btnFoto);
    imageView = findViewById(R.id.hasilfoto);

    btnFoto.setOnClickListener(new View.OnClickListener()){
    @Override
    public void onClick(View v);
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
       startActivityForResult(Intent, REQUEST_CODE);
            }
        }};
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Internal data) {
        super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK)
        {
            imageUri = data.getData();
            imageView.setImageURI(ImageUri);
        }
    }
}