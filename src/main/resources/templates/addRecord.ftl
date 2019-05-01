<#import "common/common.ftl" as c>

<@c.page>
    <div align="center">
        <h2>Add new record</h2>
    </div>

    ${msg?if_exists}
    <form method="post" action="/registry/insert">
        <div class="left p">
            <div class="a"><label> Student id: <input type="number" name="id"/> </label></div>
            <div class="a"><label> Subject: <input type="text" name="subj"/> </label></div>
            <div class="a"><label> Is student present: <input type="text" name="present"/> </label></div>
            <div class="a"><label> Date : <input type="text" name="date"/> </label></div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="btn"><input type="submit" value="Add"/></div>
        </div>
    </form>


</@c.page>