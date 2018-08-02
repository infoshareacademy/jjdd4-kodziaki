<div class="container">
    <form method="post" action="/add" enctype="multipart/form-data">
        Tytuł ogłoszenia: <input type="text" name="title" required/><br/><br/>

        Lokalizacja:
        <select name="localization" required>
            <#list locations as key,values>
                <optgroup label="${key}">
                    <#list values as value>
                        <option value="${key},${value.district}">${value.district}</option>
                    </#list>
                </optgroup>
            </#list>
        </select>
        </br></br>

        Typ nieruchomości :
        <select name="placeType" required>
            <option value="" disabled selected hidden>Wybierz</option>
            <option value="APARTMENT">Mieszkanie</option>
            <option value="ROOM">Pokój</option>
            <option value="BED">Miejsce w pokoju</option>
        </select> <br/><br/>
        Powierzchnia: <input type="number" name="area" placeholder="Podaj powierzchnie w m2" min="0" step="0.01"
                             required/><br/><br/>
        Liczba pokoi:
        <select name="rooms" required>
            <option value="" disabled selected hidden>Wybierz</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select> <br/><br/>
        Piętro:
        <select name="floor" required>
            <option value="" disabled selected hidden>Wybierz</option>
            <option value="0">Parter</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
        </select> <br/><br/>
        Czy w budynku jest winda?
        <input type="radio" name="hasElevator" value="True" checked/> Tak
        <input type="radio" name="hasElevator" value="False"/> Nie <br/><br/>
        Czy palenie w budynku jest dozwolone?
        <input type="radio" name="smokingAllowed" value="True" checked/> Tak
        <input type="radio" name="smokingAllowed" value="False"/> Nie <br/><br/>
        Czy zwierzęta w budynku są dozwolone?
        <input type="radio" name="animalAllowed" value="True" checked/> Tak
        <input type="radio" name="animalAllowed" value="False"/> Nie <br/><br/>
        Czy preferujesz wynajem długoterminowy?
        <input type="radio" name="onlyLongTerm" value="True" checked/> Tak
        <input type="radio" name="onlyLongTerm" value="False"/> Nie <br/><br/>
        Cena: <input type="number" name="price" placeholder="Cena w PLN" min="0" step="0.01" required/><br/><br/>
        Dodatkowy opis: <br/><br/>
        <textarea name="description" required cols="50"
                  rows="10"></textarea> <br/><br/>
        Podaj swoje imie i nazwisko: <input type="text" name="author" required/> <br/><br/>
        Zostaw swoj numer telefonu: <input type="number" name="phoneNumber" min="0" required/> <br/><br/>

        Dodaj zdjecia: <br/><br/>
        <input style=" width: 0.1px;weight: 0.1px;opacity: 0;overflow: hidden;position: absolute;z-index: -1;" type="file" name="image" id="file" multiple="" required/>
        <label style="border-style: groove; font-weight: 900; cursor: pointer;" for="file">Dodaj</label><br/><br/>

        <input type="submit" name="save" value="Dodaj ogłoszenie"/> <input type="reset" value="Wyczyść dane"/> <br/><br/>
    </form>
</div>