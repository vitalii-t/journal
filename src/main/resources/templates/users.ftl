<#import "common/common.ftl" as c>

<@c.page>
    <div>
        <h2 align="center">Registered users</h2>
    </div>
    <table align="center" style="width: 40%" border="1" cellspacing="0">
        <th>First name</th>
        <th>Last Name</th>
        <th>Username</th>
        <#list users as user>
            <tr>
                <td align="center">${user.getFirstName()}</td>
                <td align="center">${user.getLastName()}</td>
                <td align="center">${user.getUsername()}</td>
            </tr>
        </#list>
    </table>
</@c.page>