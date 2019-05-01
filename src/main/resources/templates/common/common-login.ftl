<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Sign Out"/>
    </form>
</#macro>

<#macro log>
    <!DOCTYPE html>
    <html lang="en" xmlns="http://www.w3.org/1999/html">
    <head>
        <meta charset="UTF-8">
        <title>Journal</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body>
    <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
        <h1>CI-161 Journal</h1>
    </div>
    <#nested>
    </body>
    </html>
</#macro>