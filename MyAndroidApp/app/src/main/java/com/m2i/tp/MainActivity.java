package com.m2i.tp;

import android.os.Bundle;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etMontantEuro ;
    private EditText etUrl;
    private Button btnEuroToFranc;
    private Button btnAppelHttp;
    private TextView tvResultat;
    private TextView tvResHttp;

    private View.OnClickListener clickListenerBtnEuroToFranc = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
              String montantEuroSaisi = etMontantEuro.getText().toString();
              double montantEuro = Double.parseDouble(montantEuroSaisi);
              double montantFranc = montantEuro * 6.55957 ;
              tvResultat.setText( String.valueOf(montantFranc));
        }
    };

    private View.OnClickListener clickListenerBtnAppelHttp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String urlSaisie = etUrl.getText().toString();
            tvResHttp.setText( "temp:" + urlSaisie);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnEuroToFranc = findViewById(R.id.buttonConvert);
        btnEuroToFranc.setOnClickListener(clickListenerBtnEuroToFranc);
        this.etMontantEuro =  findViewById(R.id.txtMontantEuro);
        this.tvResultat = findViewById(R.id.textViewResultat);

        this.btnAppelHttp = findViewById(R.id.buttonAppelHttp);
        btnAppelHttp.setOnClickListener(clickListenerBtnAppelHttp);
        this.etUrl =  findViewById(R.id.txtUrl);
        this.tvResHttp = findViewById(R.id.textResHttp);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private class FetchTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
