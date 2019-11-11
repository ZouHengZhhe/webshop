/**
 * 加入购物车
 */
function buy(goodsId) {
    $.post("/fore/goodsBuy", {goodsId: goodsId}, function (data) {
        if (data == "ok") {
            layer.msg("成功过将商品加入购物车!", {time: 800}, function () {
                location.reload();
            });
        }
        else if (data == "fail") {
            layer.msg("商品库存不足，请购买其他商品", {time: 800}, function () {});
        }
        // }else if(data=="login"){
        // 	alert("请登录后购买!");
        // 	location.href="login.jsp";
        // }else if(data=="empty"){
        // 	alert("库存不足!");
        // 	location.reload();
        // }else{
        // 	alert("请求失败!");
        // }
    });
}

/**
 * 购物车减去
 */
function lessen(goodsId) {
    $.post("/fore/goodsLesson", {goodsId: goodsId}, function (data) {
        if (data == "ok") {
            layer.msg("删除成功!", {time: 800}, function () {
                location.reload();
            });
        } else if (data == "login") {
            alert("请登录后操作!");
            location.href = "login.jsp";
        } else {
            alert("请求失败!");
        }
    });
}

/**
 * 购物车删除
 */
function deletes(goodsId) {
    $.post("/fore/goodsDel", {goodsId: goodsId}, function (data) {
        if (data == "ok") {
            layer.msg("删除成功!", {time: 800}, function () {
                location.reload();
            });
        } else if (data == "login") {
            alert("请登录后操作!");
            location.href = "login.jsp";
        } else {
            alert("请求失败!");
        }
    });
}