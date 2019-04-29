<#import "common/common.ftl" as c>
<#import "common/common-login.ftl" as l>

<@c.page>

    <div class="left p">
    Login page
    <@l.login "/login"/><br/>
        <p>If you are not have account, you can register it</p><br/>
    <button class="w3-btn w3-hover-blue w3-round-large" onclick="location.href='/registration'">Registration</button>
        <#-- TODO сделать кнопочку не такой (более красивой)  -->
    </div>
</@c.page>