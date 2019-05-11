<#import "common/common.ftl" as c>
<#import "common/common-login.ftl" as l>
<#import "log.ftl" as login>
<@l.log>

<#--    <div align="center">-->
<#--        <h2>Registration</h2>-->
<#--    </div>-->

<#--    ${msg?if_exists}-->
<#--    <form class="a" method="post" action="/registration">-->

<#--        <div><label> First Name : <input-->
<#--                        class="form-control ${(firstNameError??)?string('is-invalid','')}" type="text"-->
<#--                        name="firstName"/> </label></div>-->
<#--        <#if firstNameError??>-->
<#--            <div class="invalid-feedback">-->
<#--                ${firstNameError}-->
<#--            </div>-->
<#--        </#if>-->
<#--        <div><label> Last Name : <input-->
<#--                        class="form-control ${(lastNameError??)?string('is-invalid','')}"-->
<#--                        type="text" name="lastName"/> </label></div>-->
<#--        <#if lastNameError??>-->
<#--            <div class="invalid-feedback">${lastNameError}</div>-->
<#--        </#if>-->
<#--        <div><label> Username : <input-->
<#--                        class="form-control ${(usernameError??)?string('is-invalid','')}" type="text" name="username"/>-->
<#--            </label></div>-->
<#--        <#if usernameError??>-->
<#--            <div class="invalid-feedback">${usernameError}</div>-->
<#--        </#if>-->
<#--        <div><label> Email : <input-->
<#--                        class="form-control ${(emailError??)?string('is-invalid','')}" type="email" name="email"/>-->
<#--            </label></div>-->
<#--        <#if emailError??>-->
<#--            <div class="invalid-feedback">${emailError}</div>-->
<#--        </#if>-->
<#--        &lt;#&ndash;            <div class="a"><label> Group : <input type="Group" name="group"/> </label></div>&ndash;&gt;-->
<#--        <div class="a"><label> Password: <input-->
<#--                        class="form-control ${(passwordError??)?string('is-invalid','')}" type="password"-->
<#--                        name="password"/> </label></div>-->
<#--&lt;#&ndash;        <#if passwordError??>&ndash;&gt;-->
<#--&lt;#&ndash;            <div class="invalid-feedback">${passwordError}</div>&ndash;&gt;-->
<#--&lt;#&ndash;        </#if>&ndash;&gt;-->
<#--&lt;#&ndash;        <div class="a"><label>Confirm password: <input&ndash;&gt;-->
<#--&lt;#&ndash;                        class="form-control ${(passwordError??)?string('is-invalid','')}" type="password"&ndash;&gt;-->
<#--&lt;#&ndash;                        name="passwordConfirmation"/> </label></div>&ndash;&gt;-->
<#--&lt;#&ndash;        <#if passwordError??>&ndash;&gt;-->
<#--&lt;#&ndash;            <div class="invalid-feedback">${passwordError}</div>&ndash;&gt;-->
<#--&lt;#&ndash;        </#if>&ndash;&gt;-->
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
<#--        <div class="btn"><input type="submit" value="Sign Up"/></div>-->
<#--    </form>-->
    <div align="center">
        <h2>Registration page</h2>
    </div>
    <@login.login "/registration" true/>
</@l.log>