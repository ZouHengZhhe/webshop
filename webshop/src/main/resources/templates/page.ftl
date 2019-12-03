<div>
    <div style='text-align:center;'>
    <#--<a class='btn btn-info' <#if page.pageNumber==1>disabled
    <#else>href="/fore/goodsList?pageNo=1&id=${id}</#if>disabled >首页</a>-->
    <#if page.pageNumber==1>
    <a class='btn btn-info' disabled>首页</a>
    <#else>
    <a class='btn btn-info' href="${url}?pageNo=1${param}">首页</a></#if>
<#if page.pageNumber==1>
<a class='btn btn-info' disabled>上一页</a>
<#else>
<a class='btn btn-info' href="${url}?pageNo=${page.pageNumber-1}${param}">上一页</a></#if>
        <h3 style='display:inline;'>[${page.pageNumber}/${page.totalPage}]</h3>
        <h3 style='display:inline;'>[${page.totalCount}]</h3>
<#if page.pageNumber==page.totalPage>
<a class='btn btn-info' disabled>下一页</a>
<#else>
<a class='btn btn-info' href="${url}?pageNo=${page.pageNumber+1}${param}">下一页</a></#if>
<#if page.pageNumber==page.totalPage>
<a class='btn btn-info' disabled>尾页</a>
<#else>
<a class='btn btn-info' href="${url}?pageNo=${page.totalPage}${param}">尾页</a></#if>
        <input id="goInput" type='text' class='form-control' style='display:inline;width:60px;' value=''/>
        <a class='btn btn-info' href='javascript:void(0);'
           onclick='location.href="${url}?pageNo="+(document.getElementById("goInput").value)+"${param}"'>GO</a></div>
</div>