<div class="container">
    <form method="post" action="/search">

        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Typ wynajmu</label>
                <select name="placeType" class="form-control form-control-lg">
                    <option value="all" selected>Pokaż wszystkie</option>
                    <option value="apartment">Mieszkanie</option>
                    <option value="room">Pokój</option>
                    <option value="bed">Miejsce w pokoju</option>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label>Lokalizacja</label>
                <select name="localization" class="form-control form-control-lg">
                    <#list locations as key,values>
                        <optgroup label="${key}">
                            <option value="${key}">całe miasto ${key}</option>
                            <#list values as value>
                                <option value="${key},${value.district}">${value.district}</option>
                            </#list>
                        </optgroup>
                    </#list>
                </select>
            </div>
        </div>


        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Cena</label>
                <div class="input-group mb-2">
                    <input list="minPriceList" type="number" name="minPrice" placeholder="Od" min="0" step="0.01"
                           class="form-control form-control-sm">
                    <div class="input-group-prepend">
                        <div class="input-group-text">zł</div>
                    </div>
                </div>
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
                </datalist>
            </div>
            <div class="form-group col-md-6">
                <label>&nbsp;</label>
                <div class="input-group mb-2">
                    <input list="maxPriceList" type="number" name="maxPrice" placeholder="Do" min="0" step="0.01"
                           class="form-control form-control-sm">
                    <div class="input-group-prepend">
                        <div class="input-group-text">zł</div>
                    </div>
                </div>
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
                </datalist>
            </div>
        </div>


        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Powierzchnia</label>
                <div class="input-group mb-2">
                    <input type="number" name="minArea" placeholder="Od" min="0" step="0.01"
                           class="form-control form-control-sm">
                    <div class="input-group-prepend">
                        <div class="input-group-text">m<sup>2</sup></div>
                    </div>
                </div>
            </div>
            <div class="form-group col-md-6">
                <label>&nbsp;</label>
                <div class="input-group mb-2">
                    <input type="number" name="maxArea" placeholder="Do" min="0" step="0.01"
                           class="form-control form-control-sm">
                    <div class="input-group-prepend">
                        <div class="input-group-text">m<sup>2</sup></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Piętro</label>
                <input type="number" name="minFloor" placeholder="Od" min="0" class="form-control form-control-sm">
            </div>
            <div class="form-group col-md-6">
                <label>&nbsp;</label>
                <input type="number" name="maxFloor" placeholder="Do" min="0" class="form-control form-control-sm">
            </div>
            <div class="form-group col-md-6">
                <label>Liczba pokoi</label>
                <input type="number" name="minRooms" placeholder="Od" min="0" class="form-control form-control-sm">
            </div>
            <div class="form-group col-md-6">
                <label>&nbsp;</label>
                <input type="number" name="maxRooms" placeholder="Do" min="0" class="form-control form-control-sm">
            </div>
        </div>


        <div class="form-row">
            <div class="col-md-6 mb-3">
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio1" name="animalsAllowed" value="false"
                           class="custom-control-input">
                    <label class="custom-control-label" for="customRadio1">Mam alergię na zwierzęta</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio2" name="animalsAllowed" value="true"
                           class="custom-control-input">
                    <label class="custom-control-label" for="customRadio2">Mam zwierzaka</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio3" name="smokingAllowed" value="false"
                           class="custom-control-input">
                    <label class="custom-control-label" for="customRadio3">Tylko ogłoszenia dla niepalących</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio4" name="smokingAllowed" value="true"
                           class="custom-control-input">
                    <label class="custom-control-label" for="customRadio4">Tylko ogłoszenia dla palących</label>
                </div>
            </div>
        </div>


        <div class="form-row">
            <div class="col-md-6 mb-3">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" name="isElevator" value="true" class="custom-control-input"
                           id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Winda obowiązkowo</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" name="onlyLongTerm" value="true" class="custom-control-input"
                           id="customCheck2">
                    <label class="custom-control-label" for="customCheck2">Interesuje mnie tylko wynajem
                        długoterminowy</label>
                </div>
            </div>
        </div>

        <button class="btn btn-primary" type="submit" name="save">Szukaj</button>
        <button class="btn btn-primary" type="reset" name="reset">Wyczyść dane</button>

    </form>
</div>