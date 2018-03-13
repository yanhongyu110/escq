package com.jero.esc.common;


import org.apache.commons.io.Charsets;
import org.apache.http.client.fluent.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Parser;
import org.junit.Test;

import java.io.IOException;

public class CathT {



    @Test
    public  void  vv() throws IOException {
        String s = Request.Get("https://www.itslaw.com/search?searchMode=judgements&sortType=1&conditions=region%2BM%2B6%2B重庆市")
                .socketTimeout(20000)
                .connectTimeout(20000)
                .execute().returnContent().asString(Charsets.UTF_8);

        Parser parser = Parser.htmlParser();
        parser.settings(ParseSettings.preserveCase);

        Document document =   parser.parseInput(s,"");  //转为jsoup对象


        System.out.println(document.html());
    }


}
