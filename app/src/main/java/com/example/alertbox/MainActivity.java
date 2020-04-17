package com.example.alertbox;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1;
        b1=findViewById(R.id.b1);
        final AlertDialog.Builder d1=new AlertDialog.Builder(this);
        d1.setTitle("Testing");
       // d1.setIcon(R.drawable.ic_launcher_foreground);
        d1.setIcon(R.drawable.alert);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d1.setMessage("Do you want to quit").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        d1.setCancelable(true);
                        Toast.makeText(MainActivity.this, "Yes clicked", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // d1.setCancelable(true);
                        Toast.makeText(MainActivity.this, "No clicked", Toast.LENGTH_SHORT).show();
                       dialog.cancel();
                        //finish();
                    }
                });
                AlertDialog d2=d1.create();
                d2.show();
            }
        });
        Button b2;
        b2=findViewById(R.id.b2);
        final ProgressDialog progressDialog=new ProgressDialog(this);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.setCancelable(false);
                progressDialog.setMessage("Please wait");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setProgress(0);//initially progress is 0
                progressDialog.setMax(100);//sets the maximum value 100
                progressDialog.show();//displays the progress bar
            }
        });
    }
}
