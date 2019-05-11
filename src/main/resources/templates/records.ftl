<#import "common/common.ftl" as c>

<@c.page>
    <table align="center" style="width: 70%" cellspacing="0" border="1">

        <th>Subject</th>
        <th>Student id</th>
        <th>Is student present</th>
        <th>Date</th>

        <#list registry as reg>
            <tr>
                <td align="center">${reg.subject}</td>
                <td align="center">${reg.studentId}</td>
                <td align="center">${reg.present?string('yes', 'no')}</td>
                <td align="center">${reg.date}</td>
            </tr>
        </#list>
    </table>
</@c.page>