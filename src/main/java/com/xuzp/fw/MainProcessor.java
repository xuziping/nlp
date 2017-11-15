package com.xuzp.fw;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLWord;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainProcessor {


    public static void main(String[] args) {

        CoNLLSentence sentence = HanLP.parseDependency("明天李明去上海");
        for (CoNLLWord word : sentence)
        {
            log.info("{} --({})--> {}\n", word.LEMMA, word.DEPREL, word.HEAD.LEMMA);
        }
    }
}
