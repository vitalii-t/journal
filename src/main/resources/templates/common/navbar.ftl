<#include "security.ftl">
<#import "common-login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <a class="navbar-brand" href="/main">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <#if isAdmin||isMonitor||isStudent ||isApproved>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Schedule
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/even">Even week</a>
                    <a class="dropdown-item" href="/odd">Odd week</a>
                    <a class="dropdown-item" href="/schedule">Time schedule</a>
                </div>
            </li>
            <#if isAdmin||isStudent||isMonitor>
            <li class="nav-item">
                <a class="nav-link" href="/users">Users</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/registry">Registry</a>
            </li>
        </ul>
        </#if>
        </#if>

        <div class="navbar-text ra">Logged In as ${name}<br/>
            <@l.logout/>
        </div>
    </div>
</nav>