/**
 * Created by bdqn on 2016/5/3.
 */
//登录的方法
function login(){
    var loginName=$("#loginName").val();
    var password=$("#password").val();
    $.ajax({
        url:contextPath+"/checkLogin.html",
        method:"post",
        data:{loginName:loginName,password:password},
        success:function(jsonStr){
            var result=eval("("+jsonStr+")");
            console.log(result)
            console.log(result.status)
            if(result.status){
                window.location.href=contextPath+"/admin/index.html";
            }else{
                showMessage(result.msg)
            }
        }
    })
}