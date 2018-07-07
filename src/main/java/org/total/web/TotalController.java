package org.total.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.total.dto.Exposer;
import org.total.dto.TestResult;
import org.total.entity.HotSale;
import org.total.service.TotalService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping(value = "/total")
public class TotalController {
    @Autowired
    private TotalService totalService;
    @RequestMapping(value = "/advice",method = RequestMethod.GET)
    public String getSomething(@RequestParam("msg") String msg){

        throw new RuntimeException();
    }
    @RequestMapping
    public String Index()
    {
        return "index";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String PageFirsr()
    {
        return "login";
    }
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public String dd(HttpSession session)
    {   String username="123";
        session.setAttribute("username",username);
        System.out.println("拦截器不能拦截的请求!!!username="+session.getAttribute("username"));
        return "redirect:/total/pagehelper";
    }
    @RequestMapping(value = "/pagehelper",method = RequestMethod.GET)
    public String fenye(@RequestParam(value = "page",defaultValue = "1",required = true) Integer page,
                        @RequestParam(value = "id",defaultValue = "0",required = true) int id,Model model)
    {   PageHelper.startPage(page, 3);
        List<HotSale> hotSale=totalService.queryById2(id);
        PageInfo<HotSale> p=new PageInfo<HotSale>(hotSale);
        model.addAttribute("page",p);
        model.addAttribute("hotsale",hotSale);
        return "list";
    }
    @RequestMapping(value = "/up",method = RequestMethod.GET)
    public String up(){return "upload";}
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile[] file, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("../../src/main/webapp/resources/uploadfile");
        for (int i = 0; i < file.length; i++) {
            String fileName = file[i].getOriginalFilename();
            System.out.println("fileName---------->" + file[i].getOriginalFilename());
            File dir = new File(path, fileName);
            if (!dir.exists()) {
                dir.mkdirs();
                file[i].transferTo(dir);
            }

            //MultipartFile自带的解析方法
        }
        System.out.println("上传成功!"+path);
        return "upload.jsp";
    }
    @RequestMapping("/down")
    public void down(@RequestParam("file") String file,HttpServletRequest request,HttpServletResponse response) throws Exception{
        //模拟文件，myfile.txt为需要下载的文件

        String fileName = request.getSession().getServletContext().getRealPath("../../src/main/webapp/resources/uploadfile")+"/"+file;
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //假如以中文名下载的话
        String filename = file;
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());

        int len = 0;

        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();

    }
    @RequestMapping(value = "/exposer")
    public TestResult<Exposer> exposer(){
        Exposer exposer=totalService.exposerUrl(1,"1","2");
        return new TestResult<Exposer>(false,exposer);
    }

}
