import com.hankcs.hanlp.HanLP;

import java.util.List;

/**
 * @Author:za-xuzhiping
 * @Date :2017/10/17
 * @Time :17:22
 * @Copyright @2017 Zhongan.com All right reserved
 */
public class Hanks {

    public static void main(String[] args) {
//       System.out.println( HanLP.segment("而且，小胖胖把我的电脑锁在北师图书馆柜子里了。我工作没有电脑可用，于是使用小胖的电脑，也就是说，所有的基本变量都需要我自己来配来下，因此也相当于是从一张白纸到使用hanlp的过程。"));

//        List<Term> termList = StandardTokenizer.segment("商品和服务");
//        System.out.println(termList);

//        List<Term> termList = NLPTokenizer.segment("中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程");
//        System.out.println(termList);


//        List<Term> termList = IndexTokenizer.segment("主副食品");
//        for (Term term : termList)
//        {
//            System.out.println(term + " [" + term.offset + ":" + (term.offset + term.word.length()) + "]");
//        }

//        Segment nShortSegment = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
//        Segment shortestSegment = new DijkstraSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
//        String[] testCase = new String[]{
//                "今天，刘志军案的关键人物,山西女商人丁书苗在市二中院出庭受审。",
//                "刘喜杰石国祥会见吴亚琴先进事迹报告团成员",
//        };
//        for (String sentence : testCase)
//        {
//            System.out.println("N-最短分词：" + nShortSegment.seg(sentence) + "\n最短路分词：" + shortestSegment.seg(sentence));
//        }


//        HanLP.Config.ShowTermNature = false;    // 关闭词性显示
//        Segment segment = new CRFSegment();
//        String[] sentenceArray = new String[]
//                {
//                        "HanLP是由一系列模型与算法组成的Java工具包，目标是普及自然语言处理在生产环境中的应用。",
//                        "鐵桿部隊憤怒情緒集結 馬英九腹背受敵",           // 繁体无压力
//                        "馬英九回應連勝文“丐幫說”：稱黨內同志談話應謹慎",
//                        "高锰酸钾，强氧化剂，紫红色晶体，可溶于水，遇乙醇即被还原。常用作消毒剂、水净化剂、氧化剂、漂白剂、毒气吸收剂、二氧化碳精制剂等。", // 专业名词有一定辨识能力
//                        "《夜晚的骰子》通过描述浅草的舞女在暗夜中扔骰子的情景,寄托了作者对庶民生活区的情感",    // 非新闻语料
//                        "这个像是真的[委屈]前面那个打扮太江户了，一点不上品...@hankcs",                       // 微博
//                        "鼎泰丰的小笼一点味道也没有...每样都淡淡的...淡淡的，哪有食堂2A的好次",
//                        "克里斯蒂娜·克罗尔说：不，我不是虎妈。我全家都热爱音乐，我也鼓励他们这么做。",
//                        "今日APPS：Sago Mini Toolbox培养孩子动手能力",
//                        "财政部副部长王保安调任国家统计局党组书记",
//                        "2.34米男子娶1.53米女粉丝 称夫妻生活没问题",
//                        "你看过穆赫兰道吗",
//                        "乐视超级手机能否承载贾布斯的生态梦"
//                };
//        for (String sentence : sentenceArray)
//        {
//            List<Term> termList = segment.seg(sentence);
//            System.out.println(termList);
//        }


//        String[] testCase = new String[]{
//                "签约仪式前，秦光荣、李纪恒、仇和等一同会见了参加签约的企业家。",
//                "王国强、高峰、汪洋、张朝阳光着头、韩寒、小四",
//                "张浩和胡健康复员回家了",
//                "王总和小丽结婚了",
//                "编剧邵钧林和稽道青说",
//                "这里有关天培的有关事迹",
//                "龚学平等领导,邓颖超生前",
//        };
//        Segment segment = HanLP.newSegment().enableNameRecognize(true);
//        for (String sentence : testCase)
//        {
//            List<Term> termList = segment.seg(sentence);
//            System.out.println(termList);
//        }


//        String[] testCase = new String[]{
//                "一桶冰水当头倒下，微软的比尔盖茨、Facebook的扎克伯格跟桑德博格、亚马逊的贝索斯、苹果的库克全都不惜湿身入镜，这些硅谷的科技人，飞蛾扑火似地牺牲演出，其实全为了慈善。",
//                "世界上最长的姓名是简森·乔伊·亚历山大·比基·卡利斯勒·达夫·埃利奥特·福克斯·伊维鲁莫·马尔尼·梅尔斯·帕特森·汤普森·华莱士·普雷斯顿。",
//        };
//        Segment segment = HanLP.newSegment().enableTranslatedNameRecognize(true);
//        for (String sentence : testCase)
//        {
//            List<Term> termList = segment.seg(sentence);
//            System.out.println(termList);
//        }


//        String[] testCase = new String[]{
//                "北川景子参演了林诣彬导演的《速度与激情3》",
//                "林志玲亮相网友:确定不是波多野结衣？",
//        };
//        Segment segment = HanLP.newSegment().enableJapaneseNameRecognize(true);
//        for (String sentence : testCase)
//        {
//            List<Term> termList = segment.seg(sentence);
//            System.out.println(termList);
//        }


//        String[] testCase = new String[]{
//                "武胜县新学乡政府大楼门前锣鼓喧天",
//                "蓝翔给宁夏固原市彭阳县红河镇黑牛沟村捐赠了挖掘机",
//        };
//        Segment segment = HanLP.newSegment().enablePlaceRecognize(true);
//        for (String sentence : testCase)
//        {
//            List<Term> termList = segment.seg(sentence);
//            System.out.println(termList);
//        }


//        String[] testCase = new String[]{
//                "我在上海林原科技有限公司兼职工作，",
//                "我经常在台川喜宴餐厅吃饭，",
//                "偶尔去地中海影城看电影。",
//        };
//        Segment segment = HanLP.newSegment().enableOrganizationRecognize(true);
//        for (String sentence : testCase)
//        {
//            List<Term> termList = segment.seg(sentence);
//            System.out.println(termList);
//        }


//        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
//        List<String> keywordList = HanLP.extractKeyword(content, 5);
//        System.out.println(keywordList);

//        String document = "算法可大致分为基本算法、数据结构的算法、数论算法、计算几何的算法、图的算法、动态规划以及数值分析、加密算法、排序算法、检索算法、随机化算法、并行算法、厄米变形模型、随机森林算法。\n" +
//                "算法可以宽泛的分为三类，\n" +
//                "一，有限的确定性算法，这类算法在有限的一段时间内终止。他们可能要花很长时间来执行指定的任务，但仍将在一定的时间内终止。这类算法得出的结果常取决于输入值。\n" +
//                "二，有限的非确定算法，这类算法在有限的时间内终止。然而，对于一个（或一些）给定的数值，算法的结果并不是唯一的或确定的。\n" +
//                "三，无限的算法，是那些由于没有定义终止定义条件，或定义的条件无法由输入的数据满足而不终止运行的算法。通常，无限算法的产生是由于未能确定的定义终止条件。";
//        List<String> sentenceList = HanLP.extractSummary(document, 3);
//        System.out.println(sentenceList);



        String text = "算法工程师\n" +
                "算法（Algorithm）是一系列解决问题的清晰指令，也就是说，能够对一定规范的输入，在有限时间内获得所要求的输出。" +
                "如果一个算法有缺陷，或不适合于某个问题，执行这个算法将不会解决这个问题。不同的算法可能用不同的时间、" +
                "空间或效率来完成同样的任务。一个算法的优劣可以用空间复杂度与时间复杂度来衡量。算法工程师就是利用算法处理事物的人。\n" +
                "\n" +
                "1职位简介\n" +
                "算法工程师是一个非常高端的职位；\n" +
                "专业要求：计算机、电子、通信、数学等相关专业；\n" +
                "学历要求：本科及其以上的学历，大多数是硕士学历及其以上；\n" +
                "语言要求：英语要求是熟练，基本上能阅读国外专业书刊；\n" +
                "必须掌握计算机相关知识，熟练使用仿真工具MATLAB等，必须会一门编程语言。\n" +
                "\n" +
                "2研究方向\n" +
                "视频算法工程师、图像处理算法工程师、音频算法工程师 通信基带算法工程师\n" +
                "\n" +
                "3目前国内外状况\n" +
                "目前国内从事算法研究的工程师不少，但是高级算法工程师却很少，是一个非常紧缺的专业工程师。" +
                "算法工程师根据研究领域来分主要有音频/视频算法处理、图像技术方面的二维信息算法处理和通信物理层、" +
                "雷达信号处理、生物医学信号处理等领域的一维信息算法处理。\n" +
                "在计算机音视频和图形图像技术等二维信息算法处理方面目前比较先进的视频处理算法：机器视觉成为此类算法研究的核心；" +
                "另外还有2D转3D算法(2D-to-3D conversion)，去隔行算法(de-interlacing)，运动估计运动补偿算法" +
                "(Motion estimation/Motion Compensation)，去噪算法(Noise Reduction)，缩放算法(scaling)，" +
                "锐化处理算法(Sharpness)，超分辨率算法(Super Resolution),手势识别(gesture recognition),人脸识别(face recognition)。\n" +
                "在通信物理层等一维信息领域目前常用的算法：无线领域的RRM、RTT，传送领域的调制解调、信道均衡、信号检测、网络优化、信号分解等。\n" +
                "另外数据挖掘、互联网搜索算法也成为当今的热门方向。\n" +
                "算法工程师逐渐往人工智能方向发展。";
        List<String> phraseList = HanLP.extractPhrase(text, 5);
        System.out.println(phraseList);
    }

}
