<#import "common/common.ftl" as c>

<@c.page>
    <h2>Edit a user</h2>

    <form action="/users" method="post">
        <div class="a"><label>Username: <input type="text" name="username" value="${user.getUsername()}"></label></div>
        <br/>
        <div class="a"><label>Email: <input type="email" name="email" value="${user.getEmail()}"></label></div>
        <br/>
        <div class="a"><label>Group: <input type="text" name="group" value="CI-161"></label></div>
        <#list roles as role>
            <div>
                <label><input type="checkbox"
                              name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <div class="btn"><input type="submit" value="Save"/></div>
    </form>


</@c.page>