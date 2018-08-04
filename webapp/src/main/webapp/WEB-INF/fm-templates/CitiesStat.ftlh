<h4><b>Popularność ogłoszeń z danego miasta</b></h4>
<table>
    <tr>
        <td>Miasto</td>
        <td>Suma wyświetleń</td>
    </tr>
    <#list citiesStatistics as city>
        <tr>
            <td>${city[0]}</td>
            <td>${city[1]}</td>
        </tr>
    </#list>
</table>