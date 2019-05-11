<#import "common/common.ftl" as c>
<#import "common/common-login.ftl" as l>
<#import "log.ftl" as login>
<#--<@c.page>-->

<#--    <div class="left p">-->
<#--    Login page-->
<#--    <@l.login "/login"/><br/>-->
<#--        <p>If you are not have account, you can register it</p><br/>-->
<#--    <button class="w3-btn w3-hover-blue w3-round-large" onclick="location.href='/registration'">Registration</button>-->
<#--        &lt;#&ndash; TODO сделать кнопочку не такой (более красивой)  &ndash;&gt;-->
<#--    </div>-->
<#--</@c.page>-->

<@l.log>
    <div align="center">
        <h2>Login page</h2>
    </div>

<h1>${message?if_exists}</h1>
<#--    <form class="a" action="/login" method="post">-->
<#--        <div ><label> Username: <input type="text" name="username"/> </label></div>-->
<#--        <div ><label> Password: <input type="password" name="password"/> </label></div>-->
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
<#--        <div class="btn"><input type="submit" value="Sign In"/></div>-->
<#--    </form><br/>-->
<#--    <div class="left">-->
<#--    <p>If you are not have account, you can register it</p><br/>-->
<#--    <button class="w3-hover-blue w3-round-large" onclick="location.href='/registration'">Registration</button>-->
<#--&lt;#&ndash;     TODO сделать кнопочку не такой (более красивой)  &ndash;&gt;-->
<#--    </div>-->
    <@login.login "/login" false/>
</@l.log>