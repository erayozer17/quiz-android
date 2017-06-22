package com.staj.eray.denemesiparis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //static List<Sorular> sorular = new ArrayList<>();
    List<Boolean> cevaplar = new ArrayList<>();
    Sorular soru;

    Button buton1,buton2,buton3,buton4,buton5,reset;

    TextView textView2,textView4;

    String[] seceneklerTekTek;

    int sayac = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soru = yeni_soru();
        textView2 = (TextView) findViewById(R.id.textView2);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView2.setText(sayac + "-) " + soru.getSoru());
        buton1 = (Button) findViewById(R.id.button6);
        buton2 = (Button) findViewById(R.id.button7);
        buton3 = (Button) findViewById(R.id.button8);
        buton4 = (Button) findViewById(R.id.button9);
        buton5 = (Button) findViewById(R.id.button10);
        reset = (Button) findViewById(R.id.reset);

        reset.setEnabled(false);
        reset.setVisibility(View.INVISIBLE);

        seceneklerTekTek = soru.getSecenekler().split("-");

        buton1.setText(seceneklerTekTek[0]);
        buton2.setText(seceneklerTekTek[1]);
        buton3.setText(seceneklerTekTek[2]);
        buton4.setText(seceneklerTekTek[3]);
        buton5.setText(seceneklerTekTek[4]);

        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buton1.getText().equals(soru.getCevap())){
                    cevaplar.add(true);
                    biseyler();
                } else {
                    biseyler();
                }
            }
        });

        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buton2.getText().equals(soru.getCevap())){
                    cevaplar.add(true);
                    biseyler();
                } else {
                    biseyler();
                }
            }
        });

        buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buton3.getText().equals(soru.getCevap())){
                    cevaplar.add(true);
                    biseyler();
                } else {
                    biseyler();
                }
            }
        });

        buton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buton4.getText().equals(soru.getCevap())){
                    cevaplar.add(true);
                    biseyler();
                } else {
                    biseyler();
                }
            }
        });

        buton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buton5.getText().equals(soru.getCevap())){
                    cevaplar.add(true);
                    biseyler();
                } else {
                    biseyler();
                }
            }
        });


    }

    private void biseyler(){
        sayac++;
        yenile();
    }

    private Sorular yeni_soru(){
        soru = new Sorular();
        return soru;
    }

    private void yenile(){
        if (sayac == 11){
            String sonuc;
            int sayi = 0;
            for (boolean bool:cevaplar) {
                if (bool)
                    sayi++;
            }
            sonuc = "Sonuc: " + sayi;
            textView4.setText(sonuc);

            reset.setVisibility(View.VISIBLE);
            reset.setEnabled(true);
            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sayac = 1;
                    yenile();
                    textView4.setText("");
                    reset.setEnabled(false);
                    reset.setVisibility(View.INVISIBLE);
                }
            });

        } else {
            soru = yeni_soru();
            textView2.setText(sayac + "-) " + soru.getSoru());
            seceneklerTekTek = soru.getSecenekler().split("-");
            buton1.setText(seceneklerTekTek[0]);
            buton2.setText(seceneklerTekTek[1]);
            buton3.setText(seceneklerTekTek[2]);
            buton4.setText(seceneklerTekTek[3]);
            buton5.setText(seceneklerTekTek[4]);
        }

    }
}
