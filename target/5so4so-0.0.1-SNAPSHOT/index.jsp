<%--
  Created by IntelliJ IDEA.
  User: namhyeop
  Date: 2022/07/20
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
</head>
  <body>
  <button type="button">버튼</button>
  <script type="text/javascript">
    $(function () {

      let getMemberInfo = [
        { memberNo: 1, name: "홍길동1", phone: "010-1111-1111", birth: "2020-01-01" },
        { memberNo: 2, name: "홍길동2", phone: "010-2222-2222", birth: "2020-02-02" },
        { memberNo: 3, name: "홍길동3", phone: "010-3333-3333", birth: "2020-03-03" },
        { memberNo: 4, name: "홍길동4", phone: "010-4444-4444", birth: "2020-04-04" },
        { memberNo: 5, name: "홍길동5", phone: "010-5555-5555", birth: "2020-05-05" },
      ];

      $("button").click(function() {
        $.ajax({
          url:"orderProduct.do",
          method:"post",
          //	data:"id=abc&pwd=123",
          data: {
            data: JSON.stringify(getMemberInfo)
          },
          dataType: 'json',
          success:function(res){
            if(res.result){
              alert("완료")
            }
          },
          error:function(){
            alert('error');
          }
        });
      });
    });
  </script>
  </body>
</html>
