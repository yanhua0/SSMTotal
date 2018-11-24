<%--
  Created by IntelliJ IDEA.
  User: OUER
  Date: 2018/8/17
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function browseFolder(path) {
            try {
                var Message = "\u8bf7\u9009\u62e9\u6587\u4ef6\u5939"; //选择框提示信息
                var Shell = new ActiveXObject("Shell.Application");
                var Folder = Shell.BrowseForFolder(0, Message, 64, 17); //起始目录为：我的电脑
                //var Folder = Shell.BrowseForFolder(0, Message, 0); //起始目录为：桌面
                if (Folder != null) {
                    Folder = Folder.items(); // 返回 FolderItems 对象
                    Folder = Folder.item(); // 返回 Folderitem 对象
                    Folder = Folder.Path; // 返回路径
                    if (Folder.charAt(Folder.length - 1) != "\\") {
                        Folder = Folder + "\\";
                    }
                    document.getElementById(path).value = Folder;
                    return Folder;
                }
            }
            catch (e) {
                alert(e.message);
            }
        }
    </script>
</head>
<body>
<a href="da">点击</a>
<td><input id="path" type="text" name="path" size="30"></td>
<td><input type=button value="选择" onclick="browseFolder('path')"></td>
</body>
</html>
