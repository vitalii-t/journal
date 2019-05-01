<#import "common/common-login.ftl" as l>
<@l.log>
    <h1 align="center">Welcome!</h1>
<div class="left">
    <p>${message?if_exists}</p>

    <p>You can navigate to login page by  clicking link below</p>

    <a href="/login">Login</a>
</div>
</@l.log>