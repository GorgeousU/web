package org.example;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

public class HanLPExample {
    public static void main(String[] args) {
        HanLP.Config.enableDebug();
        String text = "自然语言处理课程";
        List<Term> term = HanLP.segment(text);
        for (Term t : term) {
            System.out.println(t.word);
        }
    }
}