<#import "common-login.ftl" as l>
<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Journal</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/margins.css">
    </head>
    <body>
    <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
        <h1>CI-161 Journal</h1>
        <@l.logout></@l.logout>
    </div>
    <div class="w3-container w3-center">
        <div class="w3-bar w3-padding-large w3-padding-24">
            <button class="w3-btn w3-hover-yellow w3-round-large" onclick="location.href='/'">Main Page</button>
            <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/even'">Even week</button>
            <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/odd'">Odd week</button>
            <button class="w3-btn w3-hover-red w3-round-large" onclick="location.href='/schedule'">Schedule</button>
            <button class="w3-btn w3-hover-gray w3-round-large" onclick="location.href='/users'">Users</button>
        </div>
    </div>
    <#nested>
    </body>
    </html>
</#macro>