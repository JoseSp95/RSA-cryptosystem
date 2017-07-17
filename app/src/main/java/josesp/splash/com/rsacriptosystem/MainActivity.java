package josesp.splash.com.rsacriptosystem;import android.content.Intent;import android.support.v7.app.AppCompatActivity;import android.os.Bundle;import android.view.View;import java.util.ArrayList;import java.util.Arrays;import java.util.Random;import josesp.splash.com.rsacriptosystem.model.ExtendedEuclideanAlgorithm;import josesp.splash.com.rsacriptosystem.model.InverseMultiplication;import josesp.splash.com.rsacriptosystem.model.Nodo;public class MainActivity extends AppCompatActivity {    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);    }    public void btnManual_onclick(View view){        Intent intent = new Intent(this,ManualActivity.class);        startActivity(intent);        finish();    }    public void btnAutomatic_onclick(View view){        int p = generateNumber();        int q = generateNumber();        int n = p * q;        int phi = (p - 1) * (q - 1);        int e = generateE(phi);        int d = InverseMultiplication.getInverse(phi, e);        System.out.println("P : " + p + " Q : "+ q + " E : " + e + " D : "+ d + " PHI : "+ phi+ " N : "+ n);        Intent intent = new Intent(this, KeysActivity.class);        intent.putExtra("n",n);        intent.putExtra("e",e);        intent.putExtra("d",d);        startActivity(intent);    }    public int generateNumber(){        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(                41,	43,	47,	53,	59,	61,	67,                71,	73,	79,	83,	89,	97,                101,	103,	107,	109,	113,	127,	131,	137,	139,	149,	151,                157,	163,    167,	173,	179,	181,	191,	193,	197,	199,	211,                223,	227,	229,	233,	239,	241,	251,	257,	263,	269                /*271,	277,	281,	283,	293,	307,	311,	313,	317,	331,	337,                347,	349,	353,	359,	367,	373,	379,	383,    389,    397,	401,                409,	419,	421,	431,	433,	439,	443,	449                457, 461, 463, 467,	479, 487, 491, 499, 503, 509, 521, 523,	541, 547, 557, 563,                569,	571,	577,	587,	593,	599,	601,	607,	613,	617,	619,                631,	641,	643,	647,	653,	659,	661,	673,	677,	683,	691,                701,	709,	719,	727,	733,	739,	743,	751,    757,	761,	769,                773,	787,	797,	809,	811,	821,	823,	827,	829,	839,	853,                857,	859,	863,	877,	881,    883,	887,	907,	911,	919,	929,                937,	941,	947,	953,	967,	971,	977,	983,	991,	997*/                ));        int random = (int)(Math.random()*list.size());        return list.get(random);    }    public int generateE(int phi){        Nodo nodo;        int i;        for(i = 11; i < phi ; i++){            nodo = ExtendedEuclideanAlgorithm.applyExtendedEuclideanAlgorithm(phi, i);            if(nodo.getD() == 1){                return i;            }        }        return -1;    }}