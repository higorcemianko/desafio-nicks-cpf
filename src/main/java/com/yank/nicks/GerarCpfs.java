package com.yank.nicks;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerarCpfs {

    public Map<String, String> getCpfs(List<String> nicks, String url){
        WebClient web = new WebClient();
        Map<String, String> nickCpf = new HashMap<>();
        try{
            for (String nick : nicks){
                HtmlPage page = web.getPage(url);
                HtmlRadioButtonInput pontuacaoSim = (HtmlRadioButtonInput)page.getElementById("pontuacao_sim");
                pontuacaoSim.click();
                HtmlSelect estadoOrigem = (HtmlSelect)page.getElementById("cpf_estado");
                HtmlOption indiferente = (HtmlOption)estadoOrigem.getOptionByValue("");
                estadoOrigem.setSelectedAttribute(indiferente, true);
                HtmlButtonInput gerarCpf = (HtmlButtonInput)page.getElementById("bt_gerar_cpf");
                HtmlPage newPage = gerarCpf.click();
                HtmlDivision divCpfGerado = (HtmlDivision)newPage.getElementById("texto_cpf");
                String cpf = divCpfGerado.getTextContent();
                while(cpf.equals("Gerando...") || cpf.isEmpty()){
                    cpf = divCpfGerado.getTextContent();
                }
                nickCpf.put(nick, cpf);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return nickCpf;

    }
}
