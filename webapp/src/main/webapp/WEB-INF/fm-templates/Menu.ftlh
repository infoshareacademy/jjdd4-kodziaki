        <a class="navbar-brand" href="main">appPARTMENTS</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="main">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="search">Szukaj ogłoszenia</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="add">Dodaj ogłoszenie</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="panel">Panel</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="random">Szczęśliwy traf</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about">O nas</a>
                </li>
                <li class="nav-item">
                    <#if isLoggedIn??>
                        <a class="nav-link" href="logout">Wyloguj się</a>
                    <#else>
                        <a class="nav-link" href="login">Zaloguj się</a>
                    </#if>
                </li>
            </ul>
        </div>