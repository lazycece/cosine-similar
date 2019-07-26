package com.lazycece.cosinesimilar.apply;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.lazycece.cosinesimilar.algorithm.Similarity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lazycece
 * @date 2019/7/25
 */
public class TextSimilarity {

    /**
     * 原始文本
     */
    private String text;
    /**
     * 目标文本
     */
    private String target;

    public TextSimilarity(String text, String target) {
        this.text = text;
        this.target = target;
    }

    public double compute() {
        return Similarity.cosine(segment(text), segment(target));
    }

    private List<String> segment(String text) {
        List<String> words = new ArrayList<>();
        List<Term> list = HanLP.segment(text);
        list.forEach(term -> words.add(term.word));
        return words;
    }
}
