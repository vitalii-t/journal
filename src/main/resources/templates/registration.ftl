<#import "common/common.ftl" as c>
<#import "common/common-login.ftl" as l>
<@l.log>

    <div align="center">
        <h2>Registration</h2>
    </div>

    ${msg?if_exists}
    <form method="post" action="/registration">
        <div class="left p">
            <div class="a"><label> First Name : <input type="text" name="fname"/> </label></div>
            <div class="a"><label> Last Name : <input type="text" name="lname"/> </label></div>
            <div class="a"><label> Username : <input type="text" name="username"/> </label></div>
            <div class="a"><label> Email : <input type="email" name="email"/> </label></div>
<#--            <div class="a"><label> Group : <input type="Group" name="group"/> </label></div>-->
            <div class="a"><label> Password: <input type="password" name="password"/> </label></div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="btn"><input type="submit" value="Sign Up"/></div>
        </div>
    </form>

</@l.log>