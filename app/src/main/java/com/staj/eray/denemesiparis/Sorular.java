package com.staj.eray.denemesiparis;

import java.util.Random;

class Sorular {

    private String soru;
    private String secenekler;
    private String cevap;

    private Random r;

    Sorular(){
        soru_uret();
        secenekleri_belirle();
    }

    public String getSoru() {
        return soru;
    }

    private void setSoru(String soru) {
        this.soru = soru;
    }

    public String getSecenekler() {
        return secenekler;
    }

    private void setSecenekler(String secenekler) {
        this.secenekler = secenekler;
    }

    public String getCevap() {
        return cevap;
    }

    private void setCevap(String cevap) {
        this.cevap = cevap;
    }

    private void soru_uret(){
        r = new Random();
        int sayi1 = r.nextInt(11);
        int sayi2 = r.nextInt(11);
        setSoru(sayi1 + " + " + sayi2 + " = ?");
        setCevap(String.valueOf(sayi1 + sayi2));
    }

    private void secenekleri_belirle(){
        String scnklr = "";
        r = new Random();
        int dogruSecenek = r.nextInt(4);
        for (int i = 0 ; i < 4 ; i++){
            if (i == dogruSecenek)
                scnklr += getCevap()+ "-";
            scnklr += r.nextInt(21) + "-";
        }
        setSecenekler(scnklr);
    }

}
