package com.xuzp.ksql;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLWord;
import com.xuzp.fw.MainProcessor;
import com.xuzp.graph.DirectedGraph;
import com.xuzp.graph.GraphInterface;
import com.xuzp.object.Unit;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


@Slf4j
public class Main {


    private JedisPool pool;
    private Jedis jedis;

    public static void main(String[] args) {
        MainProcessor processor = new MainProcessor();
//        processor.setUp();
        processor.parse("查询李明的帽子价格");

    }

    public void setUp() {
        pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1");
        jedis = pool.getResource();
//   jedis.auth("password");
    }

    public void parse(String sentenceStr) {
        CoNLLSentence sentence = HanLP.parseDependency(sentenceStr);
        GraphInterface<Unit> graph = new DirectedGraph<>();
        for (CoNLLWord word : sentence) {
            log.info("{} --({})--> {}\n", word.LEMMA, word.DEPREL, word.HEAD.LEMMA);
            graph.addVertex(new Unit(word.LEMMA));
        }
    }

}
