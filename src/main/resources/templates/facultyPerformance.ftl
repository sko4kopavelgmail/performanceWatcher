<#import "parts/common.ftl" as common>
<@common.page>
<div class="card">
    <div class="card-body">
        <#if noData??>
            <h4>По выбранному факультету нет данных</h4>
        <#else>
            <h4 class="mt-4 mb-4 text-center">Сведения по показателям мониторинга эффективности
                 деятельности ${faculty.getName()}</h4>
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
                    <#if facultyEfficiency.getEducationActivity().getShortName()??>
                        ${facultyEfficiency.getEducationActivity().getShortName()}
                    </#if>
                    </td>
                    <td>
                    <#if facultyEfficiency.getEducationActivity().getName()??>
                        ${facultyEfficiency.getEducationActivity().getName()}
                    </#if>
                    </td>
                    <td>
                    <#if facultyEfficiency.getEducationActivity().getMean()??>
                        ${facultyEfficiency.getEducationActivity().getMean()}
                    </#if>
                    </td>
                    <td>
                    <#if facultyEfficiency.getEducationActivity().getMinMean()??>
                        ${facultyEfficiency.getEducationActivity().getMinMean()}
                    </#if>
                    </td>
                </tr>
                <tr>
                    <td>
                    <#if facultyEfficiency.getResearchActivity().getShortName()??>
                        ${facultyEfficiency.getResearchActivity().getShortName()}
                    </#if>
                    </td>
                    <td>
                    <#if facultyEfficiency.getResearchActivity().getName()??>
                        ${facultyEfficiency.getResearchActivity().getName()}
                    </#if>
                    </td>
                    <td>
                    <#if facultyEfficiency.getResearchActivity().getMean()??>
                        ${facultyEfficiency.getResearchActivity().getMean()}
                    </#if>
                    </td>
                    <td>
                    <#if facultyEfficiency.getResearchActivity().getMinMean()??>
                        ${facultyEfficiency.getResearchActivity().getMinMean()}
                    </#if>
                    </td>
                </tr>
                <tr>
                    <td>
                    <#if facultyEfficiency.getInternationalActivity().getShortName()??>
                        ${facultyEfficiency.getInternationalActivity().getShortName()}
                    </#if>
                    </td>
                    <td>
                    <#if facultyEfficiency.getInternationalActivity().getName()??>
                        ${facultyEfficiency.getInternationalActivity().getName()}
                    </#if>
                    </td>
                    <td>
                    <#if facultyEfficiency.getInternationalActivity().getMean()??>
                        ${facultyEfficiency.getInternationalActivity().getMean()}
                    </#if>
                    </td>
                    <td>
                    <#if facultyEfficiency.getInternationalActivity().getMinMean()??>
                        ${facultyEfficiency.getInternationalActivity().getMinMean()}
                    </#if>
                    </td>
                </tr>
            </table>
            <br/>
            <div class="row">
            <#list departments as department>
                <div class="form-group mt-3 ml-4">
                    <a class="btn btn-secondary btn-sm" data-toggle="collapse" href="#${department.name}" role="button"
                       aria-expanded="false"
                       aria-controls="collapseExample">
                        Статистика кафедры ${department.name}
                    </a>
                </div>
                <div class="collapse" id="${department.name}">
                    <h5 class="mt-4 mb-4">Сведения по показателям мониторинга эффективности деятельности
                        кафедры ${department.getName()}</h5>
                    <div class="mb-3 mt-3">
                <#list department.reports as report>
                    <table class="table-sm table table-striped mt-2">
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
                                ${report.efficiency.educationActivity.shortName}
                            </td>
                            <td>
                                ${report.efficiency.educationActivity.name}
                            </td>
                            <td>
                                ${report.efficiency.educationActivity.mean}
                            </td>
                            <td>
                                ${report.efficiency.educationActivity.minMean}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                ${report.efficiency.researchActivity.shortName}
                            </td>
                            <td>
                                ${report.efficiency.researchActivity.name}
                            </td>
                            <td>
                                ${report.efficiency.researchActivity.mean}
                            </td>
                            <td>
                                ${report.efficiency.researchActivity.minMean}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                ${report.efficiency.internationalActivity.shortName}
                            </td>
                            <td>
                                ${report.efficiency.internationalActivity.name}
                            </td>
                            <td>
                                ${report.efficiency.internationalActivity.mean}
                            </td>
                            <td>
                                ${report.efficiency.internationalActivity.minMean}
                            </td>
                        </tr>
                    </table>
                </#list>
                    </div>
                    <br/>
                    <div class="mt-3">
                <#list department.reports as report>
                    <h6 class="mt-4">${report.efficiency.educationActivity.name}</h6>
                    <table class="table-sm table table-striped mt-2">
                        <thead>
                        <tr>
                            <th scope="col">№ п/п</th>
                            <th scope="col">Наименование показателя</th>
                            <th scope="col">Единица измерения</th>
                            <th scope="col">Значение показателя</th>
                        </tr>
                        </thead>
                        <#list report.efficiency.educationActivity.indices as index>
                        <tr>
                            <td>${index.shortName}</td>
                            <td>${index.name}</td>
                            <td>${index.unit}</td>
                            <td>${index.mean}</td>
                        </tr>
                        </#list>
                    </table>
                </#list>
                    </div>
                    <br/>
                    <div class="mt-3">
                <#list department.reports as report>
                    <h6 class="mt-4">${report.efficiency.researchActivity.name}</h6>
                    <table class=" table-sm table table-striped mt-2">
                        <thead>
                        <tr>
                            <th scope="col">№ п/п</th>
                            <th scope="col">Наименование показателя</th>
                            <th scope="col">Единица измерения</th>
                            <th scope="col">Значение показателя</th>
                        </tr>
                        </thead>
                        <#list report.efficiency.researchActivity.indices as index>
                        <tr>
                            <td>${index.shortName}</td>
                            <td>${index.name}</td>
                            <td>${index.unit}</td>
                            <td>${index.mean}</td>
                        </tr>
                        </#list>
                    </table>
                </#list>
                    </div>
                    <br/>
                    <div class="mt-3">
                <#list department.reports as report>
                    <h6 class="mt-4">${report.efficiency.internationalActivity.name}</h6>
                    <table class="table-sm table table-striped mt-2">
                        <thead>
                        <tr>
                            <th scope="col">№ п/п</th>
                            <th scope="col">Наименование показателя</th>
                            <th scope="col">Единица измерения</th>
                            <th scope="col">Значение показателя</th>
                        </tr>
                        </thead>
                        <#list report.efficiency.internationalActivity.indices as index>
                        <tr>
                            <td>${index.shortName}</td>
                            <td>${index.name}</td>
                            <td>${index.unit}</td>
                            <td>${index.mean}</td>
                        </tr>
                        </#list>
                    </table>
                </#list>
                    </div>
                </div>
            </#list>
            </div>
        </#if>
    </div>
</div>
</@common.page>