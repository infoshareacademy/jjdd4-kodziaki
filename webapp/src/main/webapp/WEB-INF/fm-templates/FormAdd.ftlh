<form method="post" action="http://127.0.0.1:8080/appPartments/add">
    Tytuł ogłoszenia: <input type="text" name="title" required/><br/><br/>
    Miasto: <input type="text" name="city" required/><br/><br/>
    Dzielnica: <input type="text" name="district" required/><br/><br/>
    Typ nieruchomości :
    <select name="placeType" required>
        <option value="" disabled selected hidden>Wybierz</option>
        <option value="APARTMENT">Mieszkanie</option>
        <option value="ROOM">Pokój</option>
        <option value="BED">Miejsce w pokoju</option>
    </select> <br/><br/>
    Powierzchnia: <input type="number" name="area" placeholder="Podaj powierzchnie w m2" min="0" step="0.01" required/><br/><br/>
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
    Zostaw swoj numer telefonu: <input type="number" name="phoneNumber" required/> <br/><br/>
    <input type="submit" name="save" value="Dodaj"/> <input type="reset" value="Wyczyść dane"/> <br/><br/>
</form>http://127.0.0.1:8080/appPartments/search