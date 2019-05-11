<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    usr = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = usr.getUsername()
    isAdmin = usr.isAdmin()
    isMonitor = usr.isMonitor()
    isStudent = usr.isStudent()
    isApproved = usr.isApproved()
    isAnon = usr.isAnon()
    >
<#else>
    <#assign
    name="unknown"
    isAdmin = false
    isMonitor = false
    isStudent = false
    isApproved = false
    isAnon = false
    >
</#if>