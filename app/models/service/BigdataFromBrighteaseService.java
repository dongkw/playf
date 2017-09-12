package models.service;

import models.dao.BigdataFromBrighteaseDao;
import models.model.BigdataFromBrightease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class BigdataFromBrighteaseService {


    @Autowired
    private BigdataFromBrighteaseDao bigDataDao;

    public Map<String, Object> getAllData(String startTime,int pageSize) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> params = new HashMap<>();

        params.put("pageSize", pageSize);
        params.put("startTime", startTime);
        List list = bigDataDao.findList(params);
        map.put("list", list);
        return map;
    }
    public Map<String, Object> getCount() {
        Map<String, Object> map = new HashMap<>();
        return bigDataDao.findCount(null);

    }
    public Map<String, Object> save() {

        String[] code2 = {"3", "5", "8"};
        String[] str = {"预约了2017年8月21日下午三点，预约了2017年8月21日下午三点，王大大的面对面咨询内部产品学习，搜索“自杀”",
                "预约了2017年8月21日下午三点，王大大的面对面咨询",
                "预约了2017年8月21日下午三点，王大大的面对面咨询内部产品学习，搜索“自杀”",
        };
        for (int i = 0; i < 24*3600; i++) {
            BigdataFromBrightease b = new BigdataFromBrightease();
            String code = "1" + code2[getRandom(0, 3)] +
                    getRandom(0, 10) + getRandom(0, 10) +
                    getRandom(0, 10) + getRandom(0, 10) +
                    getRandom(0, 10) + getRandom(0, 10) +
                    getRandom(0, 10) + getRandom(0, 10) + getRandom(0, 10);
            b.setCode(code);
            System.out.println(code);
            b.setCreatetime(new Date(i*1000));
           b.setSource(getRandom(1, 31) + "");


           b.setData(getStr());
           bigDataDao.save(b);
        }
        return null;
    }

    private int getRandom(int min, int max) {
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;

        return s;
    }

    public String getStr(){
        String str="";
        int num=getRandom(0,182);
        if(num<40){
        str=getStr1();

        }else if(num>=40&&num<50){
            str=getStr2();
        }else if(num>=50&&num<113){
            str=getStr3();
        }else if(num>=113&&num<176){
            str=getStr4();
        }else if(num>=176&&num<182){
            str=getStr5();
        }
        return str;

    }
    public String getStr1(){
        String str1 []={"预约了","取消了"};
        String str2 []={"挫败感","适应不良","恐惧","注意力不集中"	,"记忆力减退","紧张焦虑","职业倦怠","强迫症","空虚","无端烦恼","长期高压"	,"暴躁","人际关系紧张","失眠","安全感、归属感缺失","过度敏感","抑郁","性心理问题","偏执","PTSD"};
        return str1[getRandom(0,2)]+"关于"+str2[getRandom(0,20)]+"的心理咨询服务";
    }
    public String getStr2(){
        String str[]={"修改了个人信息","创建了测评任务","关注了某某咨询师","编辑了个人资料","对内容做出评论：","对咨询师做出评论：","情绪预警 ","发布了一张图片","发出了一段语音"};
        return  str[getRandom(0,9)];
    }
    public String getStr3(){
       String str[]= {"压力水平","抑郁指数","症状自评心理健康","睡眠","亲子融洽性","婚姻质量","焦虑自评","艾森克人格","职业倦怠","应对方式测验","考试焦虑测验","学业成就责任测评","青少年个性测评","同学关系测评","网络成瘾","价值观","气质类型","交流恐惧","卡特尔16种人格因素测验报告","生活满意度指数A问卷","Russell吸烟原因问卷","人际关系综合诊断","情商","饮酒问卷","情绪调节测验","情绪稳定性","DISC个性测验","心理资本","领悟社会支持","MBTI","工作满意度","社交回避及苦恼","团队角色","家庭沟通测验","成就动机测评","工作控制源","组织激励机制调查问卷","管理行为风格","主观幸福感","A型行为类型问卷","五大人格问卷","中小学生适应能力测验","防御方式问卷","家庭环境","总体幸福感","自卑测验","心理健康筛选","家庭沟通测验(子女版)","明尼苏达多相人格调查表","UCLA孤独","老年抑郁","生活质量综合评定问卷","家庭环境（子女版）","记忆障碍自评量表","艾森克人格问卷（儿童版）","心理健康（学生版）","阿尔茨海默病生命质","日常生活能力","中小学生心理健康测评","压力反应海航版","PDP性格测验","抑郁症状筛查测验","心理健康障碍筛查","焦虑GAD7"};
        return str[getRandom(0,63)]+"量表预警";
    }
    public String getStr4(){
        String str[]= {"压力水平","抑郁指数","症状自评心理健康","睡眠","亲子融洽性","婚姻质量","焦虑自评","艾森克人格","职业倦怠","应对方式测验","考试焦虑测验","学业成就责任测评","青少年个性测评","同学关系测评","网络成瘾","价值观","气质类型","交流恐惧","卡特尔16种人格因素测验报告","生活满意度指数A问卷","Russell吸烟原因问卷","人际关系综合诊断","情商","饮酒问卷","情绪调节测验","情绪稳定性","DISC个性测验","心理资本","领悟社会支持","MBTI","工作满意度","社交回避及苦恼","团队角色","家庭沟通测验","成就动机测评","工作控制源","组织激励机制调查问卷","管理行为风格","主观幸福感","A型行为类型问卷","五大人格问卷","中小学生适应能力测验","防御方式问卷","家庭环境","总体幸福感","自卑测验","心理健康筛选","家庭沟通测验(子女版)","明尼苏达多相人格调查表","UCLA孤独","老年抑郁","生活质量综合评定问卷","家庭环境（子女版）","记忆障碍自评量表","艾森克人格问卷（儿童版）","心理健康（学生版）","阿尔茨海默病生命质","日常生活能力","中小学生心理健康测评","压力反应海航版","PDP性格测验","抑郁症状筛查测验","心理健康障碍筛查","焦虑GAD7"};
        return "做了"+str[getRandom(0,63)]+"量表";
    }
    public String getStr5(){
        String str[]= {"快乐","惊讶","厌恶","悲伤","恐惧","愤怒"};
        return "识别情绪("+str[getRandom(0,6)]+")";
    }
}
