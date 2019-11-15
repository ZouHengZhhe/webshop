<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    test页面

    <input type='text' id="goInput" class='form-control' style='display:inline;width:60px;' value='' />
    <a class='btn btn-info' href='javascript:void(0);' onclick="skip()">GO</a></div>
<script type="text/javascript">
    function skip()
    {
        alert("进入skip函数！")
        // console.log(this.previousSibling.value);
        console.log(document.getElementById("goInput").value);
    }
</script>
</body>
</html>