package com.lazycece.cosinesimilar;

import com.lazycece.cosinesimilar.apply.TextSimilarity;

/**
 * @author lazycece
 * @date 2019/7/26
 */
public class Main {

    public static void main(String[] args) {

        // 高度相似文本
        String text = "天气预报说，明天会下雨，你明天早上去上班的时候记得带上伞。";
        String target = "你明天早上去上班的时候记得带上伞，天气预报说的可能会下雨。";

        // 完全相似
//        String text = "天气预报说，明天会下雨，你明天早上去上班的时候记得带上伞。";
//        String target = "天气预报说，明天会下雨，你明天早上去上班的时候记得带上伞。";

        //低相似
//        String text = "天气预报说，明天会下雨，你明天早上去上班的时候记得带上伞。";
//        String target = "夏天下雨很凉爽。";

        //不相似
//        String text = "冬天出太阳让人感觉暖洋洋";
//        String target = "夏天下雨很凉爽。";

        TextSimilarity textSimilarity = new TextSimilarity(text, target);
        double similarity = textSimilarity.compute();

        System.out.println(similarity);
    }
}
