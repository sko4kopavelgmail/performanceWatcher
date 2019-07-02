<#import "parts/common.ftl" as common>
<@common.page>
<#assign number = 1>
<div class="card">
    <div class="card-body">
        <h4 class="mt-4">Сведения по показателям мониторинга эффективности деятельности</h4>
        <table class="table table-striped mt-2">
            <thead>
            <tr>
                <th scope="col">
                    Место
                </th>
                <th scope="col">
                    Факультет
                </th>
            </tr>
            </thead>
            <#list faculties as faculty>
                <tr>
                    <th>${number}</th>
                    <th scope="row"><a href="/performance/${faculty.id}">${faculty.getName()}</a></th>
                </tr>
                <#assign number = number +1>
            </#list>
        </table>
    </div>
</div>
</@common.page>