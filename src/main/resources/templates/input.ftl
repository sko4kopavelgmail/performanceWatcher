<#import "parts/common.ftl" as common>
<@common.page>
<form action="/input" method="post">
    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home"
               aria-selected="true">Образовательная деятельность</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile"
               aria-selected="false">Научно-исследовательская деятельность</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact"
               aria-selected="false">Международная деятельность</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="contact-tab" data-toggle="tab" href="#other" role="tab" aria-controls="contact"
               aria-selected="false">Прочее</a>
        </li>
    </ul>
    <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
            <div class="card">
                <div class="card-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Наименование показателя</th>
                            <th scope="col">Значение</th>
                        </tr>
                        </thead>
                        <tr>
                            <th scope="row">1.1</th>
                            <td>
                                <label for="24118b">
                                    Принято на обучение по результатам ЕГЭ
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (Б) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24118b" name="24118b"></td>
                        </tr>
                        <tr>
                            <th scope="row">1.2</th>
                            <td><label for="24118s">
                                Принято на обучение по результатам ЕГЭ
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (C) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24118s" name="24118s"></td>
                        </tr>
                        <tr>
                            <th scope="row">2.1</th>
                            <td>
                                <label for="24119b">
                                    Принято на обучение по договорам об оказании платных образовательных услуг
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (Б) *
                                    </div>
                                </label></td>
                            <td><input type="text" id="24119b" name="24119b"></td>
                        </tr>
                        <tr>
                            <th scope="row">2.2</th>
                            <td><label for="24119s">
                                Принято на обучение по договорам об оказании платных образовательных услуг
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (C) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24119s" name="24119s"></td>
                        </tr>
                        <tr>
                            <th scope="row">3.1</th>
                            <td><label for="24129b">
                                Средний балл ЕГЭ студентов, принятых на обучение за счет бюджетов
                                бюджетной системы Российской Федерации, поступивших по результатам ЕГЭ
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24129b" name="24129b"></td>
                        </tr>
                        <tr>
                            <th scope="row">3.2</th>
                            <td>
                                <label for="24129s">Средний балл ЕГЭ студентов, принятых на обучение за счет бюджетов
                                    бюджетной системы Российской Федерации, поступивших по результатам ЕГЭ
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24129s" name="24129s"></td>
                        </tr>
                        <tr>
                            <th scope="row">4.1</th>
                            <td><label for="24131b">
                                Средний балл ЕГЭ студентов, принятых на места по договорам об оказании платных
                                образовательных услуг
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24131b" name="24131b"></td>
                        </tr>
                        <tr>
                            <th scope="row">4.2</th>
                            <td>
                                <label for="24131s">
                                    Средний балл ЕГЭ студентов, принятых на обучение за счет бюджетов
                                    бюджетной системы Российской Федерации, поступивших по результатам ЕГЭ
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24131s" name="24131s"></td>
                        </tr>
                        <tr>
                            <th scope="row">5.1</th>
                            <td><label for="24122b">
                                Принято на обучение для получения первого высшего образования лиц, имеющих
                                право на прием без вступительных испытаний
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24122b" name="24122b"></td>
                        </tr>
                        <tr>
                            <th scope="row">5.2</th>
                            <td>
                                <label for="24122s">
                                    Принято на обучение для получения первого высшего образования лиц, имеющих
                                    право на прием без вступительных испытаний
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24122s" name="24122s"></td>
                        </tr>
                        <tr>
                            <th scope="row">6.1</th>
                            <td><label for="24130b">
                                Средний балл ЕГЭ студентов, принятых на обучение за счет бюджетов бюджетной
                                системы Российской Федерации с учетом вступительных испытаний
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24130b" name="24130b"></td>
                        </tr>
                        <tr>
                            <th scope="row">6.2</th>
                            <td>
                                <label for="24130s">
                                    Средний балл ЕГЭ студентов, принятых на обучение за счет бюджетов бюджетной
                                    системы Российской Федерации с учетом вступительных испытаний
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24130s" name="24130s"></td>
                        </tr>
                        <tr>
                            <th scope="row">7.1</th>
                            <td><label for="24120b">
                                Принято на обучение для получения первого высшего образования по результатам ЕГЭ и
                                дополнительных испытаний
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24120b" name="24120b"></td>
                        </tr>
                        <tr>
                            <th scope="row">7.2</th>
                            <td>
                                <label for="24120s">
                                    Принято на обучение для получения первого высшего образования по результатам ЕГЭ и
                                    дополнительных испытаний
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24120s" name="24120s"></td>
                        </tr>
                        <tr>
                            <th scope="row">8.1</th>
                            <td><label for="24121b">
                                Принято на обучение для получения первого высшего образования по результатам ЕГЭ и
                                дополнительных испытаний по договорам об оказании платных образовательных услуг
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24121b" name="24121b"></td>
                        </tr>
                        <tr>
                            <th scope="row">8.2</th>
                            <td>
                                <label for="24121s">
                                    Принято на обучение для получения первого высшего образования по результатам ЕГЭ и
                                    дополнительных испытаний по договорам об оказании платных образовательных услуг
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24121s" name="24121s"></td>
                        </tr>
                        <tr>
                            <th scope="row">9.1</th>
                            <td><label for="24132b">
                                Средний балл ЕГЭ студентов, принятых на места по договорам об оказании платных
                                образовательных услуг, учтенных в 8.1
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24132b" name="24132b"></td>
                        </tr>
                        <tr>
                            <th scope="row">9.2</th>
                            <td>
                                <label for="24132s">
                                    Средний балл ЕГЭ студентов, принятых на места по договорам об оказании платных
                                    образовательных услуг, учтенных в 8.2
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24132s" name="24132s"></td>
                        </tr>
                        <tr>
                            <th scope="row">10.1</th>
                            <td><label for="24125b">
                                Средний минимальный балл ЕГЭ студентов, принятых на обучение за счет бюджетов бюджетной
                                системы Российской Федерации по результатам ЕГЭ
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24125b" name="24125b"></td>
                        </tr>
                        <tr>
                            <th scope="row">10.2</th>
                            <td>
                                <label for="24125s">
                                    Средний минимальный балл ЕГЭ студентов, принятых на обучение за счет бюджетов
                                    бюджетной
                                    системы Российской Федерации по результатам ЕГЭ
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24125s" name="24125s"></td>
                        </tr>
                        <tr>
                            <th scope="row">11.1</th>
                            <td><label for="24126b">
                                Средний минимальный балл ЕГЭ студентов, принятых на обучение на счет бюджетов бюджетной
                                системы Российской Федерации по результатам вступительных испытаний
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24126b" name="24126b"></td>
                        </tr>
                        <tr>
                            <th scope="row">11.2</th>
                            <td>
                                <label for="24126s">
                                    Средний минимальный балл ЕГЭ студентов, принятых на обучение за счет бюджетов
                                    бюджетной
                                    системы Российской Федерации по результатам вступительных испытаний
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24126s" name="24126s"></td>
                        </tr>
                        <tr>
                            <th scope="row">12.1</th>
                            <td><label for="24127b">
                                Средний минимальный балл ЕГЭ студентов, принятых на обучение на места по договорам
                                об оказании платных образовательных услуг по результатам ЕГЭ
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24127b" name="24127b"></td>
                        </tr>
                        <tr>
                            <th scope="row">12.2</th>
                            <td>
                                <label for="24127s">
                                    Средний минимальный балл ЕГЭ студентов, принятых на обучение на места по договорам
                                    об оказании платных образовательных услуг по результатам ЕГЭ
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24127s" name="24127s"></td>
                        </tr>
                        <tr>
                            <th scope="row">13.1</th>
                            <td><label for="24128b">
                                Средний минимальный балл ЕГЭ студентов, принятых на обучение на места по договорам
                                об оказании платных образовательных услуг по результатам вступительных экзаменов
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24128b" name="24128b"></td>
                        </tr>
                        <tr>
                            <th scope="row">13.2</th>
                            <td>
                                <label for="24128s">
                                    Средний минимальный балл ЕГЭ студентов, принятых на обучение на места по договорам
                                    об оказании платных образовательных услуг по результатам вступительных экзаменов
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24128s" name="24128s"></td>
                        </tr>
                        <tr>
                            <th scope="row">14.1</th>
                            <td><label for="24123b">
                                Численность студентов, победителей и призеров заключительного этапа всероссийской
                                олимпиады школьников, членов сборных команд Российской Федерации, участвовавших в
                                международных олимпиадах по общеобразовательным предметам по специальностям и (или)
                                направлениям подготовки, соответствующим профилю всероссийской олимпиады школьников или
                                международной олимпиады, принятых без вступительных испытаний
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24123b" name="24123b"></td>
                        </tr>
                        <tr>
                            <th scope="row">14.2</th>
                            <td>
                                <label for="24123s">
                                    Численность студентов, победителей и призеров заключительного этапа всероссийской
                                    олимпиады школьников, членов сборных команд Российской Федерации, участвовавших в
                                    международных олимпиадах по общеобразовательным предметам по специальностям и (или)
                                    направлениям подготовки, соответствующим профилю всероссийской олимпиады школьников
                                    или международной олимпиады, принятых без вступительных испытаний
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24123s" name="24123s"></td>
                        </tr>
                        <tr>
                            <th scope="row">15.1</th>
                            <td><label for="24124b">
                                Численность студентов, победителей и призеров олимпиад школьников, принятых на очную
                                форму обучения на первый курс без вступительных испытаний
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24124b" name="24124b"></td>
                        </tr>
                        <tr>
                            <th scope="row">15.2</th>
                            <td>
                                <label for="24124s">
                                    Численность студентов, победителей и призеров олимпиад школьников, принятых на очную
                                    форму обучения на первый курс без вступительных испытаний
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24124s" name="24124s"></td>
                        </tr>
                        <tr>
                            <th scope="row">16.1</th>
                            <td><label for="24110b">
                                Численность студентов, принятых на обучение в рамках квоты целевого приема
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="24110b" name="24110b"></td>
                        </tr>
                        <tr>
                            <th scope="row">16.2</th>
                            <td>
                                <label for="24110s">
                                    Численность студентов, принятых на обучение в рамках квоты целевого приема
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="24110s" name="24110s"></td>
                        </tr>
                        <tr>
                            <th scope="row">17.1</th>
                            <td><label for="2415b">
                                Общая численность принятых на обучение студентов
                                <div class="help" data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                    (Б) *
                                </div>
                            </label></td>
                            <td><input type="text" id="2415b" name="2415b"></td>
                        </tr>
                        <tr>
                            <th scope="row">17.2</th>
                            <td>
                                <label for="2415s">
                                    Общая численность принятых на обучение студентов
                                    <div class="help"
                                         data-title="Б - Программа бакалавриата, С - Программа специалитета">
                                        (C) *
                                    </div>
                                </label>
                            </td>
                            <td><input type="text" id="2415s" name="2415s"></td>
                        </tr>
                        <tr>
                            <th scope="row">18</th>
                            <td>
                                <label for="241035">
                                    Общая численность принятых на обучение студентов по программе магистратуры
                                </label>
                            </td>
                            <td><input type="text" id="241035" name="241035"></td>
                        </tr>
                        <tr>
                            <th scope="row">19</th>
                            <td>
                                <label for="2410312">
                                    Общая численность принятых на обучение студентов по программе магистратуры, ранее
                                    обучавшихся в данной организации
                                </label>
                            </td>
                            <td><input type="text" id="2410312" name="2410312"></td>
                        </tr>


                    </table>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
            <div class="card">
                <div class="card-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Наименование показателя</th>
                            <th scope="col">Значение</th>
                        </tr>
                        </thead>
                        <tr>
                            <th scope="row">1</th>
                            <td>
                                <label for="32102">
                                    Объем средств, поступивших (за отчетный год) от выполнения работ,
                                    услуг, связанных с научными, научно-техническими, творческими
                                    услугами и разработками (без НДС, акцизов и других аналогичных
                                    платежей) в том числе научные исследования и разработки (Всего выполнено работ)
                                </label>
                            </td>
                            <td><input type="text" id="32102" name="32102"></td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>
                                <label for="32108">
                                    Объем средств, поступивших (за отчетный год) от выполнения работ,
                                    услуг, связанных с научными, научно-техническими, творческими
                                    услугами и разработками (без НДС, акцизов и других аналогичных
                                    платежей) услуги в области художественного, литературного и
                                    исполнительского творчества и их организации (творческие
                                    проекты) (Всего выполнено работ)
                                </label>
                            </td>
                            <td><input type="text" id="32108" name="32108"></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
            <div class="card">
                <div class="card-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Наименование показателя</th>
                            <th scope="col">Значение</th>
                        </tr>
                        </thead>
                        <tr>
                            <th scope="row">1</th>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" id="other" role="tabpanel" aria-labelledby="contact-tab">
            <div class="card">
                <div class="card-body">

                    <h4 class="mt-4">Сведения об ученых степенях профессорско-преподавательского состава и научных
                        работников</h4>
                    <table class="table table-striped mt-2">
                        <thead>
                        <tr>
                            <th scope="col">
                                Ставка
                            </th>
                            <th scope="col">
                                <div class="help" data-title="(без учета внешних и внутренних совместителей)">
                                    Численность работников профессорско-преподавательского состава *
                                </div>
                            </th>
                            <th scope="col">
                                <div class="help" data-title="(внешние совместители)">
                                    Численность работников профессорско-преподавательского состава *
                                </div>
                            </th>
                            <th scope="col">
                                Профессорско-преподавательский состав
                            </th>
                            <th scope="col">
                                <div class="help" data-title=" (без учета внешних и
                            внутренних совместителей)">
                                    Численность научных работников *
                                </div>
                            </th>
                            <th scope="col">
                                <div class="help" data-title="(внешние совместители)">
                                    Численность научных работников *
                                </div>
                            </th>
                            <th scope="col">
                                Научные работники
                            </th>
                        </tr>
                        </thead>
                        <tr>
                            <th scope="row">0.1</th>
                            <th><input size="2" type="text" name="0101"></th>
                            <th><input size="2" type="text" name="0104"></th>
                            <th><input size="2" type="text" name="0113"></th>
                            <th><input size="2" type="text" name="0107"></th>
                            <th><input size="2" type="text" name="0110"></th>
                            <th><input size="2" type="text" name="0116"></th>
                        </tr>
                        <tr>
                            <th scope="row">0.2</th>
                            <th><input size="2" type="text" name="0201"></th>
                            <th><input size="2" type="text" name="0204"></th>
                            <th><input size="2" type="text" name="0213"></th>
                            <th><input size="2" type="text" name="0207"></th>
                            <th><input size="2" type="text" name="0210"></th>
                            <th><input size="2" type="text" name="0216"></th>
                        </tr>
                        <tr>
                            <th scope="row">0.25</th>
                            <th><input size="2" type="text" name="02501"></th>
                            <th><input size="2" type="text" name="02504"></th>
                            <th><input size="2" type="text" name="02513"></th>
                            <th><input size="2" type="text" name="02507"></th>
                            <th><input size="2" type="text" name="02510"></th>
                            <th><input size="2" type="text" name="02516"></th>
                        </tr>
                        <tr>
                            <th scope="row">0.3</th>
                            <th><input size="2" type="text" name="0301"></th>
                            <th><input size="2" type="text" name="0304"></th>
                            <th><input size="2" type="text" name="0313"></th>
                            <th><input size="2" type="text" name="0307"></th>
                            <th><input size="2" type="text" name="0310"></th>
                            <th><input size="2" type="text" name="0316"></th>

                        </tr>
                        <tr>
                            <th scope="row">0.4</th>
                            <th><input size="2" type="text" name="0401"></th>
                            <th><input size="2" type="text" name="0404"></th>
                            <th><input size="2" type="text" name="0413"></th>
                            <th><input size="2" type="text" name="0407"></th>
                            <th><input size="2" type="text" name="0410"></th>
                            <th><input size="2" type="text" name="0416"></th>

                        </tr>
                        <tr>
                            <th scope="row">0.5</th>
                            <th><input size="2" type="text" name="0501"></th>
                            <th><input size="2" type="text" name="0504"></th>
                            <th><input size="2" type="text" name="0513"></th>
                            <th><input size="2" type="text" name="0507"></th>
                            <th><input size="2" type="text" name="0510"></th>
                            <th><input size="2" type="text" name="0516"></th>

                        </tr>
                        <tr>
                            <th scope="row">0.6</th>
                            <th><input size="2" type="text" name="0601"></th>
                            <th><input size="2" type="text" name="0604"></th>
                            <th><input size="2" type="text" name="0613"></th>
                            <th><input size="2" type="text" name="0607"></th>
                            <th><input size="2" type="text" name="0610"></th>
                            <th><input size="2" type="text" name="0616"></th>

                        </tr>
                        <tr>
                            <th scope="row">0.7</th>
                            <th><input size="2" type="text" name="0701"></th>
                            <th><input size="2" type="text" name="0704"></th>
                            <th><input size="2" type="text" name="0713"></th>
                            <th><input size="2" type="text" name="0707"></th>
                            <th><input size="2" type="text" name="0710"></th>
                            <th><input size="2" type="text" name="0716"></th>
                        </tr>
                        <tr>
                            <th scope="row">0.75</th>
                            <th><input size="2" type="text" name="07501"></th>
                            <th><input size="2" type="text" name="07504"></th>
                            <th><input size="2" type="text" name="07513"></th>
                            <th><input size="2" type="text" name="07507"></th>
                            <th><input size="2" type="text" name="07510"></th>
                            <th><input size="2" type="text" name="07516"></th>

                        </tr>
                        <tr>
                            <th scope="row">0.8</th>
                            <th><input size="2" type="text" name="0801"></th>
                            <th><input size="2" type="text" name="0804"></th>
                            <th><input size="2" type="text" name="0813"></th>
                            <th><input size="2" type="text" name="0807"></th>
                            <th><input size="2" type="text" name="0810"></th>
                            <th><input size="2" type="text" name="0816"></th>

                        </tr>
                        <tr>
                            <th scope="row">0.9</th>
                            <th><input size="2" type="text" name="0901"></th>
                            <th><input size="2" type="text" name="0904"></th>
                            <th><input size="2" type="text" name="0913"></th>
                            <th><input size="2" type="text" name="0907"></th>
                            <th><input size="2" type="text" name="0910"></th>
                            <th><input size="2" type="text" name="0916"></th>
                        </tr>
                        <tr>
                            <th scope="row">1</th>
                            <th><input size="2" type="text" name="101"></th>
                            <th><input size="2" type="text" name="104"></th>
                            <th><input size="2" type="text" name="113"></th>
                            <th><input size="2" type="text" name="107"></th>
                            <th><input size="2" type="text" name="110"></th>
                            <th><input size="2" type="text" name="116"></th>
                        </tr>
                    </table>


                    <h4 class="mt-4">Общая численность студентов</h4>
                    <table class="table table-striped mt-2">
                        <thead>
                        <tr>
                            <th scope="col">

                            </th>
                            <th scope="col">
                                Очная форма обучения
                            </th>
                            <th scope="col">
                                Очно-заочная форма обучения
                            </th>
                            <th scope="col">
                                Заочная форма обучения
                            </th>
                        </tr>
                        </thead>
                        <tr>
                            <th scope="row">Всего студентов</th>
                            <th><input type="text" name="242O"></th>
                            <th><input type="text" name="242V"></th>
                            <th><input type="text" name="242Z"></th>
                        </tr>
                        <tr>
                            <th scope="row">
                                <div class="help"
                                     data-title="Обучающихся по направлениям/специальностям, на которые предусмотрен прием иностранных граждан">
                                    Всего студентов *
                                </div>
                            </th>
                            <th><input type="text" name="242OF"></th>
                            <th><input type="text" name="242VF"></th>
                            <th><input type="text" name="242ZF"></th>
                        </tr>
                    </table>

                    <h4 class="mt-4">
                        Распределение численности студентов из числа граждан иностранных государств, обучающихся в
                        соответствии с международными договорами Российской
                        Федерации, федеральными законами или установленной Правительством Российской Федерации квотой на
                        образование иностранных граждан и лиц без
                        гражданства в Российской Федерации, по направлениям подготовки и специальностям
                    </h4>
                    <table class="table table-striped mt-2">
                        <thead>
                        <tr>
                            <th scope="col">

                            </th>
                            <th scope="col">
                                Очная форма обучения
                            </th>
                            <th scope="col">
                                Очно-заочная форма обучения
                            </th>
                            <th scope="col">
                                Заочная форма обучения
                            </th>
                        </tr>
                        </thead>
                        <tr>
                            <th scope="row">Всего студентов</th>
                            <th><input type="text" name="245O"></th>
                            <th><input type="text" name="245V"></th>
                            <th><input type="text" name="245Z"></th>
                        </tr>
                        <tr>
                            <th scope="row">
                                <div class="help"
                                     data-title="Обучающихся по направлениям/специальностям, на которые предусмотрен прием иностранных граждан">
                                    Всего студентов *
                                </div>
                            </th>
                            <th><input type="text" name="245OF"></th>
                            <th><input type="text" name="245VF"></th>
                            <th><input type="text" name="245ZF"></th>
                        </tr>

                    </table>

                    <h4 class="mt-4">Распределение выпуска по направлениям подготовки и специальностям</h4>
                    <table class="table table-striped mt-2">
                        <thead>
                        <tr>
                            <th scope="col">

                            </th>
                            <th scope="col">
                                Численность выпускников очной формы обучения
                            </th>
                            <th scope="col">
                                Численность выпускников вечерней формы обучения
                            </th>
                            <th scope="col">
                                Численность выпускников заочная форма обучения
                            </th>
                        </tr>
                        </thead>
                        <tr>
                            <th scope="row">
                                <div class="help"
                                     data-title="Обучающихся по направлениям/специальностям, на которые предусмотрен прием иностранных граждан">
                                    Выпуск студентов по программам высшего образования *
                                </div>
                            </th>
                            <th><input type="text" name="243045O"></th>
                            <th><input type="text" name="243045V"></th>
                            <th><input type="text" name="243045Z"></th>
                        </tr>
                    </table>

                    <h4 class="mt-4">
                        Распределение выпуска граждан иностранных государств, обучавшихся в соответствии с
                        международными договорами Российской Федерации, федеральными
                        законами или установленной Правительством Российской Федерации квотой на образование иностранных
                        граждан и лиц без гражданства в Российской Федерации,
                        по направлениям подготовки и специальностям</h4>
                    <table class="table table-striped mt-2">
                        <thead>
                        <tr>
                            <th scope="col">

                            </th>
                            <th scope="col">
                                Численность выпускников очной формы обучения
                            </th>
                            <th scope="col">
                                Численность выпускников вечерней формы обучения
                            </th>
                            <th scope="col">
                                Численность выпускников заочная форма обучения
                            </th>
                        </tr>
                        </thead>
                        <tr>
                            <th scope="row">
                                <div class="help"
                                     data-title="Обучающихся по направлениям/специальностям, на которые предусмотрен прием иностранных граждан">
                                    Выпуск студентов по программам высшего образования *
                                </div>
                            </th>
                            <th><input type="text" name="246045O"></th>
                            <th><input type="text" name="246045V"></th>
                            <th><input type="text" name="246045Z"></th>
                        </tr>
                    </table>


                </div>
            </div>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Отправить">
</form>
</@common.page>
