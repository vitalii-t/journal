<#import "common/common.ftl" as c>

<@c.page>
    <div>
        <h2 align="center">Registered users</h2>
    </div>
    <#if (user?size>0)>
        <table align="center" style="width: 40%" border="1" cellspacing="0">
            <th>First name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Group</th>
            <th>Role</th>
            <#list user as u>
                <#list u.getRoles() as r>
                <tr>
                    <td align="center">${u.getFirstName()}</td>
                    <td align="center">${u.getLastName()}</td>
                    <td align="center">${u.getUsername()}</td>
                    <td align="center">${u.getGroup().getIdentifier()}</td>
                    <td align="center">${r.getAuthority()}</td>
                </tr>
                </#list>
            </#list>
        </table>
    <#else >
        <p>No users yet</p>
    </#if>
</@c.page>