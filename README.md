# 不使用插件实现分页查询
1.首先复制本项目路径org/total/entity路径下的PageInfo自定义分页实现类。
2.参考org/total/service/impl/CustomerServiceImpl下的findAll方法实现分页，具体实现代码如下
  public PageInfo<Customer> findAll(int page) {
        int totalCount = customerMapper.count2();//总记录数，这里需要自己修改sql语句，本count2方法使用的sql语句:select count(*) from customer
        //实例化时传入第几页、每页显示数量、总记录数
        PageInfo<Customer> pageInfo=new PageInfo<Customer>(page,PageInfo.size,totalCount);
        //分页查询,这里需要自己修改sql语句,本findAll使用的sql语句 select *from customer limit #{start},#{end}
        List<Customer>  list = customerMapper.findAll(pageInfo);
        pageInfo.setList(list);
        return pageInfo;

    }
3.在控制层创建方法如下:
 @RequestMapping(value = "/pagehelper", method = RequestMethod.GET)
    public String fenye(@RequestParam(value = "page", defaultValue = "1", required = true) Integer page, Model model) {
        PageInfo<HotSale> p = new PageInfo<HotSale>(hotSale);
        model.addAttribute("page", p);//这里前端使用c:forEach遍历时中的items写${page.list}
        return "list";
    }
  //前端这样写
   <c:forEach var="" items="${page.list}">
                    <tr>
                      
                    </tr>
   </c:forEach>
 4.访问时/pageHelper?page=x访问第x页。
    

