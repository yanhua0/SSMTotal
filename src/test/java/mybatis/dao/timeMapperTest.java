package mybatis.dao;

import mybatis.entity.Time;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class timeMapperTest {
@Autowired
private TimeMapper timeMapper;
@Autowired
private YibenMapper yibenMapper;
    @Test
    public void findAll() {

      List<String>  s=yibenMapper.findAll();
        String[] arr= new String[s.size()];
        for(int i = 0; i < s.size();i++){
            arr[i] =s.get(i);

        }
        System.out.println(timeMapper.findAll());
        List<Time> list=timeMapper.findAll();
        for(int i=0;i<list.size();i++){
            Time t=list.get(i);

            if(t.getYear().equals("2019")){
                t.setMark("大四");
            }else if(t.getYear().equals("2020")){
                t.setMark("大三");
            }else if(t.getYear().equals("2021")){
                t.setMark("大二");
            }
            else if(t.getYear().equals("2022")){
                t.setMark("大一");
            }
            if(!t.getYear().equals("")){
                Pattern p = Pattern.compile("[a-zA-z]");
                if(!p.matcher(t.getYear()).find()){
                    int year=Integer.parseInt(t.getYear());
                    if(year<2019){
                        t.setMark("已经毕业");
                    }
                }


            }
           String uni=t.getName();
            for(int j = 0; j < s.size();j++){
               if(uni.equals(arr[j])){
                   t.setJiben("一本");
                   break;
               }else{
//                   Pattern p = Pattern.compile("[a-zA-z]");
//                   if(!p.matcher(uni).find()){
//                       t.setJiben("二本");
//                   }
               }

            }
            timeMapper.updateByPrimaryKey(t);
        }
    }
}