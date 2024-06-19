package com.example.cribadeeratostenes;

import java.util.ArrayList;
import java.util.List;

public class CribaEratostenes {

    private List<String> numeros = new ArrayList<>();

    public List<String> generaNumerosPrimos(int n){
        for(int i =1; i<=n; i++)
            if(isPrime(i))
                numeros.add(String.valueOf(i));
            else numeros.add("");
        return numeros;
    }

    private boolean isPrime(int n) {
        boolean isPrime = true;
        if (n%2==0) isPrime = false;
        else
            for(int i=3;i*i<=n;i+=2)
                if(n%i==0) isPrime = false;
        if(n==2) isPrime = true;
        return isPrime;
    }
}
