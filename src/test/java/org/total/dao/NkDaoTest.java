package org.total.dao;

import jxl.read.biff.BiffException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.total.entity.Nk;
import org.total.util.ReadExcel;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class NkDaoTest {
    @Autowired
    private NkDao nkDao;

    @Test
    public void insert() throws IOException, BiffException {
        ReadExcel re = new ReadExcel();
        List<Nk> list = re.test("E:\\2.xlsx");
        for (Nk nk : list) {
            nkDao.insert(nk);
        }


    }

    @Test
    public void findAll() {
        List<Nk> nkList = nkDao.findAll();
        int count = 0;
        int key = 0;
        StringBuffer sb = null;
        for (int i = 0; i < nkList.size(); i++) {
            if (nkList.get(i).ids.length() > 7) {
                continue;
            }
            sb = new StringBuffer();
            sb.append(nkList.get(i).ids);
            //执行到最后一行没有修改，最后一行不能添加ids，
            for (int j = i + 1; j < nkList.size()+1; j++) {
                if (j<nkList.size()&&nkList.get(i).zjName.equals(nkList.get(j).zjName) && nkList.get(i).zj.equals(nkList.get(j).zj)) {
                    sb.append(nkList.get(j).ids);
                    count++;
                    nkDao.delete(nkList.get(j).id);
                    continue;
                }
                nkList.get(i).ids = sb.toString();
                System.out.println(sb.toString());
                nkDao.update(nkList.get(i));
                key = count;
                count = 0;
                i = i + key;
                break;
            }
        }
        //System.out.println(sb.toString());
    }



    @Test
    public void del() {
        List<Nk> n = nkDao.findAll();
        for (Nk nk : n) {
            nkDao.delete(nk.id);
        }

    }
}
