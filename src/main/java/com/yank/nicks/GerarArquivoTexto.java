package com.yank.nicks;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;

public class GerarArquivoTexto {
    public void gravarNickCpf(Map<String, String> nickCpf){
        try{
            FileWriter arqNickCpf = new FileWriter("./NickCpf.txt");
            PrintWriter gravarDados = new PrintWriter(arqNickCpf);
            for(String nick : nickCpf.keySet()){
                gravarDados.println(nick.concat(";").concat(nickCpf.get(nick)));
            }
            arqNickCpf.close();

        } catch(Exception e){
            e.getMessage();
        }



    }

}
