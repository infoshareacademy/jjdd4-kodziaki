<div class="col-lg-3 col-md-6 mb-4">
    <div class="card">
                    <#if (ad.imageURL1)??>
                        <img width="254" height="200" src="http://kodziaki.jjdd4.is-academy.pl${ad.imageURL1}" alt="">
                    </#if>
        <div class="card-body">
                        <#if ad.isAnimalAllowed()>
                            <img class="star" src="http://kodziaki.jjdd4.is-academy.pl/images/star3.png"/>
                        </#if>
            <h5 class="card-title"><b>${ad.title}</b></h5>
            <p class="" city">${ad.city}, ${ad.district}</p>
            <p>wyświetleń: ${ad.visits}</p>
        </div>
        <div class="card-footer">
            <a href="/detailed?id=${ad.id}"
               class="btn btn-primary">Zobacz</a>
        </div>
    </div>
</div>