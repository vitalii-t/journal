<#import "common/common.ftl" as c>

<@c.page>
        <div>
            <h2 align="center">Time schedule</h2>
        </div>
        <table align="center" style="width: 50%" border="1" cellspacing="0">
            <th>Index</th>
            <th>Begin</th>
            <th>End</th>
            <#list schedules as schedule>
                <tr>
                    <td align="center">${schedule.id}</td>
                    <td align="center">${schedule.beginning}</td>
                    <td align="center">${schedule.end}</td>
                </tr>
            </#list>
        </table>
</@c.page>