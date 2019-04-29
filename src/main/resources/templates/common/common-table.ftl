<#import "common.ftl" as c>
<#macro table <#--type--> spec collection filt>


    <@c.page>
        <div>
            <h2 align="center">Schedule for ${spec} week</h2>
        </div>
<div align="center">
        <div align="center">Find subject by name</div>
        <form method="get" action="/${spec}">
            <input type="text" name="filter" value="${filt}"/>
            <button type="submit">Find</button>
        </form>
    <p></p>
</div>
<div>
        <table align="center" style="width: 70%" cellspacing="0" border="1">
            <th>Week day</th>
            <th>Index number</th>
            <th>Subject</th>
            <#list collection as subj>
                <tr>
                    <td align="center">${subj.dayOfTheWeek}</td>
                    <td align="center">${subj.indexNumber}</td>
                    <td align="center">${subj.subjectName}</td>
                </tr>
            </#list>
        </table>
    <p></p>
</div>
<#--        <table align="center" style="width: 70%" border="1" cellspacing="0">-->
<#--            <th>Week day</th>-->
<#--            <th>Index number</th>-->
<#--            <th>Subject</th>-->
<#--            <#list type as week>-->
<#--                <tr>-->
<#--                    <td align="center">${week.dayOfTheWeek}</td>-->
<#--                    <td align="center">${week.indexNumber}</td>-->
<#--                    <td align="center">${week.subjectName}</td>-->
<#--                </tr>-->
<#--            </#list>-->
<#--        </table>-->
    </@c.page>
</#macro>