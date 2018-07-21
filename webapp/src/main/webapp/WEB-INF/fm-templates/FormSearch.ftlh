<div class="container">
    <form method="post" action="http://127.0.0.1:8080/appPartments/search">
        <!-- place type -->
        <p>Typ nieruchomości</p>
        <select name="placeType">
            <option value="all" selected>Pokaż wszystkie</option>
            <option value="apartment">Mieszkanie</option>
            <option value="room">Pokój</option>
            <option value="bed">Miejsce w pokoju</option>
        </select>

        <!-- localization -->
        <p>Lokalizacja</p>
        <input type="text" name="city" placeholder="Miasto"/><br/>
        <input type="text" name="district" placeholder="Dzielnica"/><br/>

        <!-- basic parameters -->
        <p>Cena</p>
        <input list="minPriceList" type="number" name="minPrice" placeholder="Od" min="0" step="0.01"><span>zł</span>
        <datalist id="minPriceList">
            <option value="500">
            <option value="600">
            <option value="700">
            <option value="800">
            <option value="900">
            <option value="1000">
            <option value="1500">
            <option value="2000">
            <option value="2500">
        </datalist><br/>

        <input list="maxPriceList" type="number" name="maxPrice" placeholder="Do" min="0" step="0.01"><span>zł</span>
        <datalist id="maxPriceList">
            <option value="500">
            <option value="600">
            <option value="700">
            <option value="800">
            <option value="900">
            <option value="1000">
            <option value="1500">
            <option value="2000">
            <option value="2500">
        </datalist><br/>

        <p>Powierzchnia</p>
        <input type="number" name="minArea" placeholder="Od" min="0" step="0.01"/><br/>
        <input type="number" name="maxArea" placeholder="Do" min="0" step="0.01"/><br/>

        <p>Piętro</p>
        <input type="number" name="minFloor" placeholder="Od" min="0"/><br/>
        <input type="number" name="maxFloor" placeholder="Do" min="0"/><br/>

        <p>Liczba pokoi</p>
        <input type="number" name="minRooms" placeholder="Od" min="0"/><br/>
        <input type="number" name="maxRooms" placeholder="Do" min="0"/><br/>

        <!-- more parameters -->
        <input type="radio" name="animalsAllowed" value="false" />Mam alergię na zwierzęta<br/>
        <input type="radio" name="animalsAllowed" value="true" />Mam zwierzaka<br/><br/>

        <input type="radio" name="smokingAllowed" value="false" />Tylko ogłoszenia dla niepalących<br/>
        <input type="radio" name="smokingAllowed" value="true" />Tylko ogłoszenia dla palących<br/><br/>

        <input type="checkbox" name="isElevator" value="true"/>Winda obowiązkowo<br/>
        <input type="checkbox" name="onlyLongTerm" value="true"/>Interesuje mnie tylko wynajem długoterminowy<br/>

        <input type="submit" name="save" value="Szukaj"/> 
        <input type="reset" value="Wyczyść dane"/> <br/><br/>
    </form>
</div>