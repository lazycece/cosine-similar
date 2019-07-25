package com.lazycece.cosinesimilar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lazycece
 * @date 2019/7/19
 */
public class NLPUtils {

    public static double cosineSimilar(List<String> originWord, List<String> desWord) {

        Map<String, int[]> all = new HashMap<>();
        originWord.forEach(word -> {
            if (!all.containsKey(word)) {
                int[] value = new int[2];
                value[0] = 1;
                all.put(word, value);
            } else {
                all.get(word)[0] += 1;
            }
        });
        desWord.forEach(word -> {
            if (!all.containsKey(word)) {
                int[] value = new int[2];
                value[1] = 1;
                all.put(word, value);
            } else {
                all.get(word)[1] += 1;

            }
        });
        double allNum = 0, originNum = 0, desNum = 0;
        for (Map.Entry<String, int[]> entry : all.entrySet()) {
            int origin = entry.getValue()[0];
            int des = entry.getValue()[1];
            originNum += origin * origin;
            desNum += des * des;
            allNum += origin * des;
        }
        return allNum / Math.sqrt(originNum * desNum);
    }
}
