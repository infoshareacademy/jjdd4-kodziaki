<#--<div class="container">-->
    <#--<form method="post" action="/search">-->

        <#--<div class="form-row">-->
            <#--<div class="form-group col-md-6">-->
                <#--<label>Typ nieruchomości</label>-->
                <#--<select name="placeType" class="form-control form-control-lg">-->
                    <#--<option value="all" selected>Pokaż wszystkie</option>-->
                    <#--<option value="apartment">Mieszkanie</option>-->
                    <#--<option value="room">Pokój</option>-->
                    <#--<option value="bed">Miejsce w pokoju</option>-->
                <#--</select>-->
            <#--</div>-->
            <#--<div class="form-group col-md-6">-->
                <#--<label>Lokalizacja</label>-->
                <#--<select name="localization" class="form-control form-control-lg">-->
                    <#--<#list locations as key,values>-->
                        <#--<optgroup label="${key}">-->
                            <#--<option value="${key}">całe miasto ${key}</option>-->
                            <#--<#list values as value>-->
                                <#--<option value="${key},${value.district}">${value.district}</option>-->
                            <#--</#list>-->
                        <#--</optgroup>-->
                    <#--</#list>-->
                <#--</select>-->
            <#--</div>-->
        <#--</div>-->


        <#--<div class="form-row">-->
            <#--<div class="form-group col-md-6">-->
                <#--<label>Cena</label>-->
                <#--<div class="input-group mb-2">-->
                    <#--<input list="minPriceList" type="number" name="minPrice" placeholder="Od" min="0" step="0.01"-->
                           <#--class="form-control form-control-sm">-->
                    <#--<div class="input-group-prepend">-->
                        <#--<div class="input-group-text">zł</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<datalist id="minPriceList">-->
                    <#--<option value="500">-->
                    <#--<option value="600">-->
                    <#--<option value="700">-->
                    <#--<option value="800">-->
                    <#--<option value="900">-->
                    <#--<option value="1000">-->
                    <#--<option value="1500">-->
                    <#--<option value="2000">-->
                    <#--<option value="2500">-->
                <#--</datalist>-->
            <#--</div>-->
            <#--<div class="form-group col-md-6">-->
                <#--<label>&nbsp;</label>-->
                <#--<div class="input-group mb-2">-->
                    <#--<input list="maxPriceList" type="number" name="maxPrice" placeholder="Do" min="0" step="0.01"-->
                           <#--class="form-control form-control-sm">-->
                    <#--<div class="input-group-prepend">-->
                        <#--<div class="input-group-text">zł</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<datalist id="maxPriceList">-->
                    <#--<option value="500">-->
                    <#--<option value="600">-->
                    <#--<option value="700">-->
                    <#--<option value="800">-->
                    <#--<option value="900">-->
                    <#--<option value="1000">-->
                    <#--<option value="1500">-->
                    <#--<option value="2000">-->
                    <#--<option value="2500">-->
                <#--</datalist>-->
            <#--</div>-->
        <#--</div>-->


        <#--<div class="form-row">-->
            <#--<div class="form-group col-md-6">-->
                <#--<label>Powierzchnia</label>-->
                <#--<div class="input-group mb-2">-->
                    <#--<input type="number" name="minArea" placeholder="Od" min="0" step="0.01"-->
                           <#--class="form-control form-control-sm">-->
                    <#--<div class="input-group-prepend">-->
                        <#--<div class="input-group-text">m<sup>2</sup></div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="form-group col-md-6">-->
                <#--<label>&nbsp;</label>-->
                <#--<div class="input-group mb-2">-->
                    <#--<input type="number" name="maxArea" placeholder="Do" min="0" step="0.01"-->
                           <#--class="form-control form-control-sm">-->
                    <#--<div class="input-group-prepend">-->
                        <#--<div class="input-group-text">m<sup>2</sup></div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->

        <#--<div class="form-row">-->
            <#--<div class="form-group col-md-6">-->
                <#--<label>Piętro</label>-->
                <#--<input type="number" name="minFloor" placeholder="Od" min="0" class="form-control form-control-sm">-->
            <#--</div>-->
            <#--<div class="form-group col-md-6">-->
                <#--<label>&nbsp;</label>-->
                <#--<input type="number" name="maxFloor" placeholder="Do" min="0" class="form-control form-control-sm">-->
            <#--</div>-->
            <#--<div class="form-group col-md-6">-->
                <#--<label>Liczba pokoi</label>-->
                <#--<input type="number" name="minRooms" placeholder="Od" min="0" class="form-control form-control-sm">-->
            <#--</div>-->
            <#--<div class="form-group col-md-6">-->
                <#--<label>&nbsp;</label>-->
                <#--<input type="number" name="maxRooms" placeholder="Do" min="0" class="form-control form-control-sm">-->
            <#--</div>-->
        <#--</div>-->


        <#--<div class="form-row">-->
            <#--<div class="col-md-6 mb-3">-->
                <#--<div class="custom-control custom-radio">-->
                    <#--<input type="radio" id="customRadio1" name="animalsAllowed" value="false"-->
                           <#--class="custom-control-input">-->
                    <#--<label class="custom-control-label" for="customRadio1">Mam alergię na zwierzęta</label>-->
                <#--</div>-->
                <#--<div class="custom-control custom-radio">-->
                    <#--<input type="radio" id="customRadio2" name="animalsAllowed" value="true"-->
                           <#--class="custom-control-input">-->
                    <#--<label class="custom-control-label" for="customRadio2">Mam zwierzaka</label>-->
                <#--</div>-->
                <#--&lt;#&ndash;<div class="custom-control custom-radio">&ndash;&gt;-->
                    <#--&lt;#&ndash;<input type="radio" id="customRadio3" name="smokingAllowed" value="false"&ndash;&gt;-->
                           <#--&lt;#&ndash;class="custom-control-input">&ndash;&gt;-->
                    <#--&lt;#&ndash;<label class="custom-control-label" for="customRadio3">Tylko ogłoszenia dla niepalących</label>&ndash;&gt;-->
                <#--&lt;#&ndash;</div>&ndash;&gt;-->
                <#--<div class="custom-control custom-radio">-->
                    <#--<input type="radio" id="customRadio4" name="smokingAllowed" value="true"-->
                           <#--class="custom-control-input">-->
                    <#--<label class="custom-control-label" for="customRadio4">Tylko ogłoszenia dla palących</label>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->


        <#--<div class="form-row">-->
            <#--<div class="col-md-6 mb-3">-->
                <#--<div class="custom-control custom-checkbox">-->
                    <#--<input type="checkbox" name="isElevator" value="true" class="custom-control-input"-->
                           <#--id="customCheck1">-->
                    <#--<label class="custom-control-label" for="customCheck1">Winda obowiązkowo</label>-->
                <#--</div>-->
                <#--<div class="custom-control custom-checkbox">-->
                    <#--<input type="checkbox" name="onlyLongTerm" value="true" class="custom-control-input"-->
                           <#--id="customCheck2">-->
                    <#--<label class="custom-control-label" for="customCheck2">Interesuje mnie tylko wynajem-->
                        <#--długoterminowy</label>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->

        <#--<button class="btn btn-primary" type="submit" name="save">Szukaj</button>-->
        <#--<button class="btn btn-primary" type="reset" name="reset">Wyczyść dane</button>-->
        <#--<br>-->
        <#--<br>-->
    <#--</form>-->
<#--&lt;#&ndash;</div>&ndash;&gt;-->








<div class="container">
    <form method="post" action="/add">

        <div class="form-row">
            <div class="form-group col-md-12">
                <label>Tytuł ogłoszenia</label>
                <input type="text" name="title" class="form-control form-control-sm" required/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Lokalizacja</label>
                <select name="localization" class="form-control form-control-sm" required>
            <#list locations as key,values>
                <optgroup label="${key}">
                    <#list values as value>
                        <option value="${key},${value.district}">${value.district}</option>
                    </#list>
                </optgroup>
            </#list>
                </select>
            </div>

            <div class="form-group col-md-6">
                <label>Typ wynajmu</label>
                <select name="placeType" class="form-control form-control-sm" required>
                    <option value="" disabled selected hidden>Wybierz</option>
                    <option value="APARTMENT">Mieszkanie</option>
                    <option value="ROOM">Pokój</option>
                    <option value="BED">Miejsce w pokoju</option>
                </select>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <label>Powierzchnia</label>
                <input type="number" name="area" class="form-control form-control-sm" placeholder="Podaj powierzchnie w m2" min="0" step="0.01" required/>
            </div>


            <div class="form-group col-md-4">
                <label>Liczba pokoi</label>
                <select name="rooms" class="form-control form-control-sm" required>
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
                </select>
            </div>


            <div class="form-group col-md-4">
                <label>Piętro</label>
                <select name="floors" class="form-control form-control-sm" required>
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
                </select>
            </div>
        </div>

        <div class="form-row">
            <div class="col-md-6 mb-3">
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio1" name="hasElevator" value="True" class="custom-control-input" checked>
                    <label class="custom-control-label" for="customRadio1">W budynku jest winda</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio2" name="hasElevator" value="False" class="custom-control-input">
                    <label class="custom-control-label" for="customRadio2">W budynku nie ma windy</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio3" name="smokingAllowed" value="True" class="custom-control-input" checked>
                    <label class="custom-control-label" for="customRadio3">Palenie dozwolone</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio4" name="smokingAllowed" value="False" class="custom-control-input">
                    <label class="custom-control-label" for="customRadio4">Palenie niedozwolone</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio5" name="animalAllowed" value="True" class="custom-control-input" checked>
                    <label class="custom-control-label" for="customRadio5">Zwierzęta dozwolone</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio6" name="animalAllowed" value="False" class="custom-control-input">
                    <label class="custom-control-label" for="customRadio6">Zwierzęta nie dozwolone</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio7" name="onlyLongTerm" value="True" class="custom-control-input" checked>
                    <label class="custom-control-label" for="customRadio7">Tylko wynajem długoterminowy</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio8" name="onlyLongTerm" value="False" class="custom-control-input">
                    <label class="custom-control-label" for="customRadio8">Możliwy wynajem krótkoterminowy</label>
                </div>
            </div>
        </div>



        <div class="form-row">
            <div class="col-md-4">
                <label>Cena</label>
                <div class="input-group input-group-sm mb-2">
                    <input type="number" name="price" placeholder="Cena" min="0" step="0.01" class="form-control form-control-sm" required>
                    <div class="input-group-prepend input-group-sm">
                        <div class="input-group-text">  zł</div>
                    </div>
                </div>
            </div>
            <div class="form-group col-md-4">
                <label>Imię i Nazwisko</label>
                <input type="text" name="author" class="form-control form-control-sm" required/>
            </div>
            <div class="form-group col-md-4">
                <label>Numer telefonu</label>
                <input type="number" name="phoneNumber" class="form-control form-control-sm" required/>
            </div>
            <div class="col-md-12">
                 <textarea name="description" cols="50" rows="10" class="form-control" required></textarea>
            </div>
        </div>
        <br>

        <button class="btn btn-primary" type="submit" name="save">Dodaj</button>
        <button class="btn btn-primary" type="reset" name="reset">Wyczyść dane</button>
        <br>
        <br>

    </form>
</div>


















