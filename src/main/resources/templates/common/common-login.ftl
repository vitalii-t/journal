<#macro login path>
    <form action="${path}" method="post">
        <div class="a"><label> User Name: <input type="text" name="username"/> </label></div>
        <div class="a"><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="btn"><input type="submit" value="Sign In"/></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Sign Out"/>
    </form>
</#macro>