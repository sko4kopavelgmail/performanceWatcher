<#import "parts/common.ftl" as common>
<@common.page>
<form>
    <div class="card">
        <div class="card-body">
            <h4 class="mt-4">Сведения по показателям мониторинга эффективности деятельности</h4>
            <table class="table table-striped mt-2">
                <thead>
                <tr>
                    <th scope="col">
                        Факультет
                    </th>
                    <th scope="col">
                        Действие
                    </th>
                </tr>
                </thead>
                <#list faculties as faculty>
                    <tr>
                        <th scope="row">${faculty.getName()}</th>
                        <th><a href="/performance/${faculty.id}">Показать статистику</a></th>
                    </tr>
                </#list>
            </table>
        </div>
    </div>
</form>
</@common.page>
