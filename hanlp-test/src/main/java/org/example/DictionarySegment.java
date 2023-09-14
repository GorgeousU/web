package org.example;

import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.io.IOException;
import java.util.*;

public class DictionarySegment {
    public static void main(String[] args) throws IOException {
        TreeMap<String, CoreDictionary.Attribute> dictionary = IOUtil.loadDictionary("D:\\IntelliJ IDEA 2023.1.4\\projects\\hanlp-test\\src\\main\\java\\org\\example\\CoreNatureDictionary.mini.txt");
        System.out.println("正向匹配结果：");
        System.out.println(segmentForward("就读北京大学", dictionary));
        System.out.println(segmentForward("研究生命起源", dictionary));
        System.out.println(segmentForward("项目的研究", dictionary));
        System.out.println("逆向匹配结果：");
        System.out.println(segmentBackward("就读北京大学", dictionary));
        System.out.println(segmentBackward("研究生命起源", dictionary));
        System.out.println(segmentBackward("项目的研究", dictionary));
        System.out.println("双向匹配结果：");
        System.out.println(segmentBidirectional("就读北京大学", dictionary));
        System.out.println(segmentBidirectional("研究生命起源", dictionary));
        System.out.println(segmentBidirectional("项目的研究", dictionary));

        evaluateSpeed(dictionary);

    }

    /**
     * 速度测试
     */
    public static void evaluateSpeed(Map<String, CoreDictionary.Attribute> dictionary) {
        String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";
        long start;
        double costTime;
        final int pressure = 10000;

        System.out.println("正向最长");
        start = System.currentTimeMillis();
        for (int i = 0; i < pressure; ++i)
        {
            segmentForward(text, dictionary);
        }
        costTime = (System.currentTimeMillis() - start) / (double) 1000;
        System.out.printf("%.2f万字/秒\n", text.length() * pressure / 10000 / costTime);

        System.out.println("逆向最长");
        start = System.currentTimeMillis();
        for (int i = 0; i < pressure; ++i)
        {
            segmentBackward(text, dictionary);
        }
        costTime = (System.currentTimeMillis() - start) / (double) 1000;
        System.out.printf("%.2f万字/秒\n", text.length() * pressure / 10000 / costTime);

        System.out.println("双向最长");
        start = System.currentTimeMillis();
        for (int i = 0; i < pressure; ++i)
        {
            segmentBidirectional(text, dictionary);
        }
        costTime = (System.currentTimeMillis() - start) / (double) 1000;
        System.out.printf("%.2f万字/秒\n", text.length() * pressure / 10000 / costTime);
    }

    /**
     * 正向最长匹配算法
     */
    public static List<String> segmentForward(String text, Map<String, CoreDictionary.Attribute> dictionary) {
        List<String> wordList = new LinkedList<>();
        for (int i = 0; i < text.length(); ) {
            String longestWord = text.substring(i, i + 1);
            for (int j = i + 1; j <= text.length(); j++) {
                String word = text.substring(i, j);
                if (dictionary.containsKey(word)) {
                    if ( word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }
            wordList.add(longestWord);
            i += longestWord.length();
        }
        return wordList;
    }

    /**
     * 逆向最长匹配算法
     */
    public static List<String> segmentBackward(String text, Map<String, CoreDictionary.Attribute> dictionary) {
        List<String> wordList = new LinkedList<String>();
        for (int i = text.length() - 1; i >= 0; )
        {
            String longestWord = text.substring(i, i + 1);
            for (int j = 0; j <= i; ++j)
            {
                String word = text.substring(j, i + 1);
                if (dictionary.containsKey(word))
                {
                    if (word.length() > longestWord.length())
                    {
                        longestWord = word;
                        break;
                    }
                }
            }
            wordList.add(0, longestWord);
            i -= longestWord.length();
        }
        return wordList;
    }

    /**
     * 统计分词中的单字数量
     */
    public static int countSingleChar(List<String> wordList)
    {
        int size = 0;
        for (String word : wordList)
        {
            if (word.length() == 1)
                ++size;
        }
        return size;
    }

    /**
     * 双向最长匹配算法
     */
    public static List<String> segmentBidirectional(String text, Map<String, CoreDictionary.Attribute> dictionary)
    {
        List<String> forwardLongest = segmentForward(text, dictionary);
        List<String> backwardLongest = segmentBackward(text, dictionary);
        if (forwardLongest.size() < backwardLongest.size())
            return forwardLongest;
        else if (forwardLongest.size() > backwardLongest.size())
            return backwardLongest;
        else
        {
            if (countSingleChar(forwardLongest) < countSingleChar(backwardLongest))
                return forwardLongest;
            else
                return backwardLongest;
        }
    }

}
