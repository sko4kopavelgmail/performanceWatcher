<#import "parts/common.ftl" as common>
<@common.page>
    <form action="/login" method="post">
        <div><label> Логин : <input type="text" name="username"/> </label></div>
        <div><label> Пароль: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div><input type="submit" value="Войти"/></div>
    </form>
</@common.page>