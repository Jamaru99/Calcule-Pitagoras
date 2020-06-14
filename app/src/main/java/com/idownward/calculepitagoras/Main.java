package com.idownward.calculepitagoras;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.content.Intent;
import android.graphics.Typeface;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.editable;

public class Main extends AppCompatActivity {

    EditText txtHip;
    EditText txtCat1;
    EditText txtCat2;
    AdView adView;

    boolean hip;
    boolean cat1;
    boolean cat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        txtHip = (EditText) findViewById(R.id.txtHip);
        txtCat1 = (EditText) findViewById(R.id.txtCat1);
        txtCat2 = (EditText) findViewById(R.id.txtCat2);


        txtHip.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!txtHip.getText().toString().equals("") &&
                        !txtHip.getText().toString().equals("Na") &&
                        !txtHip.getText().toString().equals("N") &&
                        !txtHip.getText().toString().equals("NN")) {
                    if (cat1) {
                        double cat2 = Double.parseDouble(txtCat2.getText().toString());
                        double hip = Double.parseDouble(txtHip.getText().toString());
                        double res = Math.sqrt((hip * hip) - (cat2 * cat2));
                        txtCat1.setText(Double.toString(res));
                    }
                    if (cat2) {
                        double cat1 = Double.parseDouble(txtCat1.getText().toString());
                        double hip = Double.parseDouble(txtHip.getText().toString());
                        double res = Math.sqrt((hip * hip) - (cat1 * cat1));
                        txtCat2.setText(Double.toString(res));
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });

        txtCat1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!txtCat1.getText().toString().equals("") &&
                        !txtCat1.getText().toString().equals("Na") &&
                        !txtCat1.getText().toString().equals("N") &&
                        !txtCat1.getText().toString().equals("NN")) {
                    if (hip) {
                        double cat2 = Double.parseDouble(txtCat2.getText().toString());
                        double cat1 = Double.parseDouble(txtCat1.getText().toString());
                        double res = Math.sqrt((cat1 * cat1) + (cat2 * cat2));
                        txtHip.setText(Double.toString(res));
                    }
                    if (cat2) {
                        double cat1 = Double.parseDouble(txtCat1.getText().toString());
                        double hip = Double.parseDouble(txtHip.getText().toString());
                        double res = Math.sqrt((hip * hip) - (cat1 * cat1));
                        txtCat2.setText(Double.toString(res));
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });

        txtCat2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!txtCat2.getText().toString().equals("") &&
                        !txtCat2.getText().toString().equals("Na") &&
                        !txtCat2.getText().toString().equals("N") &&
                        !txtCat2.getText().toString().equals("NN")){
                    if (hip) {
                        double cat2 = Double.parseDouble(txtCat2.getText().toString());
                        double cat1 = Double.parseDouble(txtCat1.getText().toString());
                        double res = Math.sqrt((cat1 * cat1) + (cat2 * cat2));
                        txtHip.setText(Double.toString(res));
                    }
                    if (cat1) {
                        double cat2 = Double.parseDouble(txtCat2.getText().toString());
                        double hip = Double.parseDouble(txtHip.getText().toString());
                        double res = Math.sqrt((hip * hip) - (cat2 * cat2));
                        txtCat1.setText(Double.toString(res));
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });

        txtHip.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if (hasFocus){

                    if(txtCat1.getText().toString().equals("") && !txtCat2.getText().toString().equals("")){
                        cat1 = true;
                        txtCat1.setTypeface(Typeface.DEFAULT_BOLD);
                        hip = false;
                        txtHip.setTypeface(Typeface.DEFAULT);
                        cat2 = false;
                        txtCat2.setTypeface(Typeface.DEFAULT);
                    }
                    if(txtCat2.getText().toString().equals("") && !txtCat1.getText().toString().equals("")){
                        cat2 = true;
                        txtCat2.setTypeface(Typeface.DEFAULT_BOLD);
                        hip = false;
                        txtHip.setTypeface(Typeface.DEFAULT);
                        cat1 = false;
                        txtCat1.setTypeface(Typeface.DEFAULT);
                    }
                }
            }
        });

        txtCat1.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View v, boolean hasFocus){

                if (hasFocus){

                    if(txtHip.getText().toString().equals("") && !txtCat2.getText().toString().equals("")){
                        cat1 = false;
                        txtCat1.setTypeface(Typeface.DEFAULT);
                        hip = true;
                        txtHip.setTypeface(Typeface.DEFAULT_BOLD);
                        cat2 = false;
                        txtCat2.setTypeface(Typeface.DEFAULT);
                    }
                    if(txtCat2.getText().toString().equals("") && !txtHip.getText().toString().equals("")){
                        cat2 = true;
                        txtCat2.setTypeface(Typeface.DEFAULT_BOLD);
                        hip = false;
                        txtHip.setTypeface(Typeface.DEFAULT);
                        cat1 = false;
                        txtCat1.setTypeface(Typeface.DEFAULT);
                    }
                }
            }
        });
        txtCat2.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if (hasFocus){

                    if(txtHip.getText().toString().equals("") && !txtCat1.getText().toString().equals("")){
                        cat1 = false;
                        txtCat1.setTypeface(Typeface.DEFAULT);
                        hip = true;
                        txtHip.setTypeface(Typeface.DEFAULT_BOLD);
                        cat2 = false;
                        txtCat2.setTypeface(Typeface.DEFAULT);
                    }
                    if(txtCat1.getText().toString().equals("") && !txtHip.getText().toString().equals("")){
                        cat2 = false;
                        txtCat2.setTypeface(Typeface.DEFAULT);
                        hip = false;
                        txtHip.setTypeface(Typeface.DEFAULT);
                        cat1 = true;
                        txtCat1.setTypeface(Typeface.DEFAULT_BOLD);
                    }
                }
            }
        });
    }



    public void limpar(View v){
        txtHip.setText("");
        txtCat1.setText("");
        txtCat2.setText("");
        hip = false;
        cat1 = false;
        cat2 = false;
    }

    public void verCalculo(View v){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        if(txtHip.getText().toString().equals("") || txtCat1.getText().toString().equals("") || txtCat2.getText().toString().equals("")) {
            alert.setTitle("Erro");
            alert.setMessage("Preencha duas caixas de textos (resultado da incógnita é calculado automaticamente)");
            alert.setNeutralButton("Beleza", null);
            alert.show();
        }
        else if(txtCat1.getText().toString().equals("N") || txtCat1.getText().toString().equals("Na") || txtCat1.getText().toString().equals("NaN")
                || txtCat2.getText().toString().equals("N") || txtCat2.getText().toString().equals("Na") || txtCat2.getText().toString().equals("NaN")){
            alert.setTitle("Resolução");
            alert.setMessage("Impossível resolução dentro do conjunto dos reais positivos.");
            alert.setNeutralButton("Ah ta", null);
            alert.show();
        }
        else {
            double h = Double.parseDouble(txtHip.getText().toString());
            double c1 = Double.parseDouble(txtCat1.getText().toString());
            double c2 = Double.parseDouble(txtCat2.getText().toString());
            alert.setTitle("Resolução");
            alert.setMessage("" + c1 + "² + " + c2 + "² = " + h + "²" + "\n" +
                    (c1 * c1) + " + " + (c2 * c2) + " = " + (h * h) + "\n" +
                    (c1 * c1 + c2 * c2) + " = " + (h * h));
            alert.setNeutralButton("Entendi", null);
            alert.show();
        }
    }


}
