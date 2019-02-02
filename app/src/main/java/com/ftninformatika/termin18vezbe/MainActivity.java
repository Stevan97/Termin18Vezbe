package com.ftninformatika.termin18vezbe;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnToast;
    Button btnSnack;
    Button btnObavestenje;
    Button btnSettings;

    public static final int NOTIFICATION_ID = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSnack = findViewById(R.id.snack);
        btnToast = findViewById(R.id.toast);
        btnObavestenje = findViewById(R.id.btnObavestenje);
        btnSettings = findViewById(R.id.btnPodesavanja);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Ovo je toast",Toast.LENGTH_SHORT).show();
            }
        });

        btnSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Snackbar.make(findViewById(R.id.snack),"Ovo je snackbar",Snackbar.LENGTH_SHORT).show();

            }
        });

        btnObavestenje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prikaziObavestenje();
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PrefActivity.class);
                startActivity(intent);
            }
        });


    }

    private void prikaziObavestenje() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setContentTitle("Ovo je naslov");
        builder.setContentText("Ovo je text obavestenja i moze biti proizvoljno dugacak");
        builder.setSmallIcon(R.drawable.ic_stat_buy);
        builder.setVibrate(new long[]{10000,10000,10000,10000,});
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID,builder.build());
    }
}
