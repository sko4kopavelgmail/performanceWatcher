<#import "parts/common.ftl" as common>
<@common.page>
<form>
    <div class="card">
        <div class="card-body">
            <#if noData??>
                <h4>Нет данных о статистике факультетов</h4>
            <#else>
                <h4 class="mt-4 mb-4 text-center">Сведения по показателям мониторинга эффективности
                            деятельности ВГТУ</h4>
                <table class="table table-sm table-striped mt-2">
                <thead>
                <tr>
                    <th scope="col">
                        №
                    </th>
                    <th scope="col">
                        Наименование показателя
                    </th>
                    <th scope="col">
                        Значение
                        показателя
                    </th>
                    <th scope="col">
                        Пороговое
                        значение
                    </th>
                </tr>
                </thead>
                <tr>
                    <td>
                        ${uni.getEducationActivity().getShortName()}
                    </td>
                    <td>
                        ${uni.getEducationActivity().getName()}
                    </td>
                    <td>
                        ${uni.getEducationActivity().getMean()}
                    </td>
                    <td>
                        ${uni.getEducationActivity().getMinMean()}
                    </td>
                </tr>
                <tr>
                    <td>
                        ${uni.getResearchActivity().getShortName()}
                    </td>
                    <td>
                        ${uni.getResearchActivity().getName()}
                    </td>
                    <td>
                        ${uni.getResearchActivity().getMean()}
                    </td>
                    <td>
                        ${uni.getResearchActivity().getMinMean()}
                    </td>
                </tr>
                <tr>
                    <td>
                        ${uni.getInternationalActivity().getShortName()}
                    </td>
                    <td>
                        ${uni.getInternationalActivity().getName()}
                    </td>
                    <td>
                        ${uni.getInternationalActivity().getMean()}
                    </td>
                    <td>
                        ${uni.getInternationalActivity().getMinMean()}
                    </td>
                </tr>
            </table>
            <a href="faculties">Показать расширенную статистику</a>
            </#if>
        </div>
    </div>
</form>
</@common.page>
