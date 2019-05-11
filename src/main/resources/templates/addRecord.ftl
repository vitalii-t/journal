<#import "common/common.ftl" as c>

<@c.page>
    <div align="center">
        <h2>Add new record</h2>
    </div>

    ${msg?if_exists}
    <form class="a" method="post" action="/registry/insert">
            <div><label> Student id: <input type="number" name="studentId"/> </label></div>
            <div><label> Subject: <input type="text" name="subject"/> </label></div>
            <div><label> Is student present: <input type="text" name="present"/> </label></div>
<#--            <div><label> Date : <input type="text" name="date"/> </label></div>-->
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="btn"><input type="submit" value="Add"/></div>
    </form>


</@c.page>