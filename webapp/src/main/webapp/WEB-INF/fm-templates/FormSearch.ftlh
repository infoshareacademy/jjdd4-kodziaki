<div class="container">
    <div data-role="type-select">
            <label for="type">Typ:</label>
            <select id="types" name="type">
                <option value='wartosc_1'>Mieszkanie</option>
                <option value='wartosc_2'>Pokój</option>
                <option value='wartosc_3'>Miejsce w stajence</option>
            <#--<#list types as type>-->
            <#--<option value="type">rodzaj lokum</option>-->
            <#--</#list>-->
            </select>
        </div>
        <div data-role="cities-select">
            <label for="city">Miasto:</label>
            <select id="cities" name="cities">
                <option value='wartosc_1'>miasto 1</option>
                <option value='wartosc_2'>miasto 2</option>
                <option value='wartosc_3'>miasto 3</option>
            <#--<#list cities as city>-->
            <#--<option value="city">miasto</option>-->
            <#--</#list>-->
            </select>
        </div>
        <div data-role="district-select">
            <label for="district">Dzielnica:</label>
            <select id="districts" name="district">
                <option value='wartosc_1'>Orunia</option>
                <option value='wartosc_2'>dzielnica czerwonych latarni</option>
                <option value='wartosc_3'>district 9</option>
            <#--<#list districts as district>-->
            <#--<option value="district">dzielnica</option>-->
            <#--</#list>-->
            </select>
        </div>
        <div data-role="range-slider">
            <label for="price-min">Cena min:</label>
            <input type="range" name="price-min" id="price-min" value="100" min="0" max="5000" step="10" data-show-value="true">
            <label for="price-max">Cena max:</label>
            <input type="range" name="price-max" id="price-max" value="800" min="0" max="5000" step="10" data-show-value="true">
        </div>
        <div data-role="range-slider">
            <label for="area-min">Powierzchnia od:</label>
            <input type="range" name="area-min" id="area-min" value="10" min="0" max="300" step="0.1" data-show-value="true">
            <label for="area-max">Powierzchnia do:</label>
            <input type="range" name="area-max" id="area-max" value="70" min="0" max="300" step="0.1" data-show-value="true">
        </div>
        <div data-role="range-slider">
            <label for="rooms-min">Pokoje od:</label>
            <input type="range" name="rooms-min" id="rooms-min" value="1" min="1" max="6" step="1" data-show-value="true">
            <label for="rooms-max">Pokoje do:</label>
            <input type="range" name="rooms-max" id="rooms-max" value="3" min="1" max="6" step="1" data-show-value="true">
        </div>
        <div data-role="range-slider">
            <label for="floor-min">Piętro od:</label>
            <input type="range" name="floor-min" id="floor-min" value="1" min="0" max="20" step="1" data-show-value="true">
            <label for="floor-max">Piętro do:</label>
            <input type="range" name="floor-max" id="floor-max" value="10" min="0" max="20" step="1" data-show-value="true">
        </div>
        <div data-role="checkbox">
            <label><input type="checkbox"> Winda</label>
        </div>
        <div data-role="checkbox">
            <label><input type="checkbox"> Zwierzęta dozwolone</label>
        </div>
        <div data-role="checkbox">
            <label><input type="checkbox"> Dla niepalących</label>
        </div>
        <div data-role="checkbox">
            <label><input type="checkbox"> Długoterminowo</label>
        </div>
        <div>
            <button type="submit" class="search-button" href="filtered"> Zobacz ogłoszenia</button>
        </div>
</div>